package com.blog.home.admin.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.home.admin.dao.AdminDao;
import com.blog.home.admin.vo.AdminVO;

@Service
public class AdminSvcImpl implements AdminSvc{

	@Autowired 
	private AdminDao dao;

	@Override
	public String adminLogin(AdminVO adminVO) {
		return dao.adminLogin(adminVO);
	}
}
