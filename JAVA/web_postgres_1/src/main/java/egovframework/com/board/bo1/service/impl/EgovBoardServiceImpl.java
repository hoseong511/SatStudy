package egovframework.com.board.bo1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import egovframework.com.board.bo1.service.BoardVO;
import egovframework.com.board.bo1.service.EgovBoardService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovBoardService")
public class EgovBoardServiceImpl extends EgovAbstractServiceImpl implements EgovBoardService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovBoardServiceImpl.class);
	
   
    
    @Resource(name="EgovBoardDAO")
   	private EgovBoardDAO boardDAO1;

    public String insertBoard(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		boardDAO1.insertBoard(vo);
		return boardDAO1.selectLastIdx(vo);
	}

	public void updateBoard(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		boardDAO1.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		boardDAO1.deleteBoard(vo);
	}

	public BoardVO selectBoard(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		BoardVO resultVO = boardDAO1.selectBoard(vo);
		if(resultVO==null) {
//			throw processException("info.nodata.msg");
			resultVO = new BoardVO();
		}
		return resultVO;
	}

	public List<?> selectBoardList(BoardVO searchVO) throws Exception {
		return boardDAO1.selectBoardList(searchVO);
	}

	public int selectBoardListTotCnt(BoardVO searchVO) throws Exception {
		return boardDAO1.selectBoardListTotCnt(searchVO);
	}

	public String selectLoginCheck(BoardVO searchVO) throws Exception {
		return boardDAO1.selectLoginCheck(searchVO);
	}

	public void insertReply(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		boardDAO1.insertReply(vo);
	}
	
	public List<?> selectReplyList(BoardVO searchVO) throws Exception {
		return boardDAO1.selectReplyList(searchVO);
	}
	
	public void updateBoardCount(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		boardDAO1.updateBoardCount(vo);
	}

	public void insertAttach(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		boardDAO1.insertAttach(vo);
	}

	public void deleteAttach(BoardVO vo) throws Exception {
		boardDAO1.deleteAttach(vo);
	}

	public BoardVO selectAttach(BoardVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		BoardVO resultVO = boardDAO1.selectAttach(vo);
		if(resultVO==null) {
			resultVO = new BoardVO();
		}
		return resultVO;
	}
	
	public String selectLastIdx(BoardVO vo) throws Exception {
		return boardDAO1.selectLastIdx(vo);
	}

}
