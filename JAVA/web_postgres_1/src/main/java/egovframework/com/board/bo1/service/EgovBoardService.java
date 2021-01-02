package egovframework.com.board.bo1.service;

import java.util.List;

public interface EgovBoardService {
	String insertBoard(BoardVO vo) throws Exception;

	void updateBoard(BoardVO vo) throws Exception;

	void deleteBoard(BoardVO vo) throws Exception;

	BoardVO selectBoard(BoardVO vo) throws Exception;

	List<?> selectBoardList(BoardVO vo) throws Exception;
	
	int selectBoardListTotCnt(BoardVO vo) throws Exception;
	
	String selectLoginCheck(BoardVO vo) throws Exception;
	
	void insertReply(BoardVO vo) throws Exception;
	
	List<?> selectReplyList(BoardVO vo) throws Exception;

	void updateBoardCount(BoardVO vo) throws Exception;
	
	void insertAttach(BoardVO vo) throws Exception;
	
	void deleteAttach(BoardVO vo) throws Exception;
	
	BoardVO selectAttach(BoardVO vo) throws Exception;
	
	String selectLastIdx(BoardVO vo) throws Exception;

}
