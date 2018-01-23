package com.blog.home.note.vo;

import java.io.Serializable;

public class NoteVO implements Serializable {
	
	private String sn;
	private String title;
	private String contents;
	private String insert_dt;
	private String update_dt;
	private String delete_at;
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
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
	public String getInsert_dt() {
		return insert_dt;
	}
	public void setInsert_dt(String insert_dt) {
		this.insert_dt = insert_dt;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public String getDelete_at() {
		return delete_at;
	}
	public void setDelete_at(String delete_at) {
		this.delete_at = delete_at;
	}
	
	public NoteVO() {}
	
	public NoteVO(String sn, String title, String contents, String insert_dt, String update_dt, String delete_at) {
		super();
		this.sn = sn;
		this.title = title;
		this.contents = contents;
		this.insert_dt = insert_dt;
		this.update_dt = update_dt;
		this.delete_at = delete_at;
	}

	
	
}
