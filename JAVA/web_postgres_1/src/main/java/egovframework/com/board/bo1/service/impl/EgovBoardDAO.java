package egovframework.com.board.bo1.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.board.bo1.service.BoardVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("EgovBoardDAO")
public class EgovBoardDAO extends EgovComAbstractDAO {
	
	
	
	public void insertBoard(BoardVO vo) {
		insert("Board.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		update("Board.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) { 
		delete("Board.deleteBoard", vo);
	};
	
	public BoardVO selectBoard(BoardVO vo) {
		return (BoardVO) selectOne("Board.selectBoard", vo);
	}
	
	public List<?> selectBoardList(BoardVO vo){
		return list("Board.selectBoardList", vo);
	}
	
	public int selectBoardListTotCnt(BoardVO vo) {
		return (Integer) selectOne("Board.selectBoardListTotCnt",vo);
	}
	
	public String selectLoginCheck(BoardVO vo) throws Exception{
		return selectOne("Board.selectLoginCheck", vo);
	}
	
	public void insertReply(BoardVO vo) {
		insert("Board.insertReply",vo);
	}
	
	public List<?> selectReplyList(BoardVO vo){
		return list("Board.selectReplyList",vo);
	}
	
	public void updateBoardCount(BoardVO vo) {
		update("Board.updateBoardCount",vo);
	}
	
	public void insertAttach(BoardVO vo) {
		insert("Board.insertAttach", vo);
	}
	
	public void deleteAttach(BoardVO vo) {
		delete("Board.deleteAttach", vo);
	}
	
	public BoardVO selectAttach(BoardVO vo) {
		return (BoardVO) selectOne("Board.selectAttach", vo);
	}
	
	public String selectLastIdx(BoardVO vo) {
		return selectOne("Board.selectLastIdx",vo);
	}
}
