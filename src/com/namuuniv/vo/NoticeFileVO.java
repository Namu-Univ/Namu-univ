package com.namuuniv.vo;

public class NoticeFileVO {
	private int id; // 파일ID
	private int noticeId; // 공지사항ID
	private String originFilename; // 기본파일명
	private String filename; //현재파일명
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getOriginFilename() {
		return originFilename;
	}
	public void setOriginFilename(String originFilename) {
		this.originFilename = originFilename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return "NoticeFileVO [id=" + id + ", noticeId=" + noticeId + ", originFilename=" + originFilename
				+ ", filename=" + filename + "]";
	}
}
