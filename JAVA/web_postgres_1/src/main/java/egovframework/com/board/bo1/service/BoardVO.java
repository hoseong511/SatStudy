package egovframework.com.board.bo1.service;

import egovframework.com.cmm.ComDefaultVO;

public class BoardVO extends ComDefaultVO {
	private static final long serialVersionUID = 1L;
	private String idx;
	private String title;
	private String contents;
	private String count;
	private String writer;
	private String writerNm;
	private String indate;
	private String replyCount;
	
	private String seq;
	private String reply;
	
	private String filename;
	
	private String userId;
	private String password;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriterNm() {
		return writerNm;
	}
	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(String replyCount) {
		this.replyCount = replyCount;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
