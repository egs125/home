package com.blog.home.admin.vo;

import java.io.Serializable;

public class AdminVO implements Serializable{
		
	private String id;
	private String pw;
	private String nm;
	
	public AdminVO() {}

	public AdminVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public AdminVO(String id, String pw, String nm) {
		super();
		this.id = id;
		this.pw = pw;
		this.nm = nm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	};
	
	
	
}
