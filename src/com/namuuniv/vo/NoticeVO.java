package com.namuuniv.vo;

import java.sql.Date;

public class NoticeVO {
	private int id;
	private int staff_id;
	private String title;
	private String content;
	private int views;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
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
	
	@Override
	public String toString() {
		return "NoticeVO [id=" + id + ", staff_id=" + staff_id + ", title=" + title + ", content=" + content
				+ ", views=" + views + ", created=" + created + "]";
	}
	
}
