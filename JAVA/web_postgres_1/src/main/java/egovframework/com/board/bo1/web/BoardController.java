package egovframework.com.board.bo1.web;
//package egovframework.com.board.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.board.bo1.service.BoardVO;
import egovframework.com.board.bo1.service.EgovBoardService;
import egovframework.com.cmm.SessionVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {

	@Resource(name="propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name="EgovBoardService")
	private EgovBoardService boardService;
	
	@Resource(name="EgovFileMngService")
	private EgovFileMngService fileMngService;
	
	@Resource(name="EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;	
	
	
	@RequestMapping(value = "/mainList.do")
	public String list(ModelMap model, @ModelAttribute("boardVO") BoardVO boardVO) throws Exception {	
	
		boardVO.setPageUnit(propertiesService.getInt("pageUnit"));
		boardVO.setPageSize(propertiesService.getInt("pageSize"));
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		paginationInfo.setPageSize(boardVO.getPageSize());
		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<?> list = boardService.selectBoardList(boardVO);
		boardVO.setFilename(boardService.selectAttach(boardVO).getFilename());
		model.addAttribute("resultList", list);
		model.addAttribute("boardVO", boardVO);
		
		int totCnt = boardService.selectBoardListTotCnt(boardVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "egovframework/com/board/bo1/mainList";
	}
	@RequestMapping(value = "/mgmt.do", method=RequestMethod.GET)
	public String mgmt(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model, HttpServletRequest request) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
	
		if(request.getParameter("idx") == null) {
			boardVO.setWriter(request.getSession().getAttribute("userId").toString());
			boardVO.setWriterNm(request.getSession().getAttribute("userName").toString());
		} else {
			boardVO.setIdx(request.getParameter("idx"));
			boardVO = boardService.selectBoard(boardVO);
		}
		boardVO.setIndate(strToday);
	
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("idx", request.getParameter("idx"));
	
		return "egovframework/com/board/bo1/mgmt";
	}
	@RequestMapping(value = "/mgmt.do", method=RequestMethod.POST)
	public String mgmt2(ModelMap model, @ModelAttribute("boardVO") BoardVO boardVO, final MultipartHttpServletRequest multiRequest, SessionVO sessionVO, HttpServletRequest request, SessionStatus status) throws Exception {
		List<FileVO> result = null;
		String attachField = "";
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		String mode = request.getParameter("mode");
	
		if("add".equals(mode)) {
			String idx = boardService.insertBoard(boardVO);
	
		if(!files.isEmpty()) {
			result = fileUtil.parseFileInf(files, "BBS_", 0, "", "");
			attachField = fileMngService.insertFileInfs(result);
			boardVO.setFilename(attachField);
			boardVO.setIdx(idx);
			boardService.insertAttach(boardVO);
		}
	
		} else if("modify".equals(mode)) {
			boardService.updateBoard(boardVO);
			if(!files.isEmpty()) {
				result = fileUtil.parseFileInf(files, "BBS_", 0, "", "");
				attachField = fileMngService.insertFileInfs(result);
				boardVO.setFilename(attachField);
				boardService.insertAttach(boardVO);
			}
	
		} else if("del".equals(mode)) {
			System.out.println(mode);
			boardService.deleteBoard(boardVO);
		}
	
		return "redirect:mainList.do";
	}
	@RequestMapping(value = "/view.do")
	public String view(ModelMap model, @ModelAttribute("boardVO") BoardVO boardVO) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
	
		boardService.updateBoardCount(boardVO);
	
		boardVO = boardService.selectBoard(boardVO);
		boardVO.setFilename(boardService.selectAttach(boardVO).getFilename());
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("strToday", strToday);
	
		List<?> list = boardService.selectReplyList(boardVO);
		model.addAttribute("resultList", list);
	
	
		return "egovframework/com/board/bo1/view";
	}
	@RequestMapping(value = "/login.do")
	public String login(@RequestParam("user_id") String user_id, @RequestParam("password") String password, ModelMap model, HttpServletRequest request) throws Exception {
		// String aa = request.getParameter("user_id");
		System.out.println("userid:"+user_id);
		System.out.println("password:"+password);
		HttpSession session = request.getSession();
	
		BoardVO boardVO = new BoardVO();
		boardVO.setUserId(user_id);
		boardVO.setPassword(password);
		String user_name = boardService.selectLoginCheck(boardVO);

		if(user_name != null && !"".equals(user_name)) {
			session.setAttribute("userId", user_id);
			session.setAttribute("userName", user_name);
		} else {
			session.setAttribute("userId", "");
			session.setAttribute("userName", "");
			model.addAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}
	
		return "redirect:mainList.do";
	}
	@RequestMapping(value = "/logout.do")
	public String logout(ModelMap model, HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "redirect:mainList.do";
	}

	@RequestMapping(value = "/reply.do")
	public String reply(ModelMap model, @ModelAttribute("boardVO") BoardVO boardVO) throws Exception {
		boardService.insertReply(boardVO);
		return "redirect:/view.do?idx="+boardVO.getIdx();
	}

}

