package com.namuuniv.vo;

import java.sql.Date;

public class NoticeVO {
	private int id;
	private int staffId;
	private String title;
	private String content;
	private int views;
	private Date created;
	private String staffName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [id=" + id + ", staffId=" + staffId + ", title=" + title + ", content=" + content + ", views="
				+ views + ", created=" + created + ", staffName=" + staffName + "]";
	}
}
