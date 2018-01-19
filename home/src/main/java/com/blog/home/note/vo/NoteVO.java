package com.blog.home.note.vo;

import java.io.Serializable;

public class NoteVO implements Serializable {
	
	private String sn;
	private String title;
	private String contents;
	private String insert_dt;
	private String update_dt;
	private String delete_at;
	
	public NoteVO(String sn, String title, String contents, String insertDt, String updateDt, String deleteAt) {
		super();
		this.sn = sn;
		this.title = title;
		this.contents = contents;
		this.insert_dt = insertDt;
		this.update_dt = updateDt;
		this.delete_at = deleteAt;
	}

	public NoteVO() {
		// TODO Auto-generated constructor stub
	}

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

	public String getInsertDt() {
		return insert_dt;
	}

	public void setInsertDt(String insertDt) {
		this.insert_dt = insertDt;
	}

	public String getUpdateDt() {
		return update_dt;
	}

	public void setUpdateDt(String updateDt) {
		this.update_dt = updateDt;
	}

	public String getDeleteAt() {
		return delete_at;
	}

	public void setDeleteAt(String deleteAt) {
		this.delete_at = deleteAt;
	}
	
	@Override
	public String toString() {
		return "sn : " + sn + ", title : " + title;
	}


	
}
