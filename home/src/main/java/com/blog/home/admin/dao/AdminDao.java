package com.blog.home.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.home.admin.vo.AdminVO;

import common.dao.AbstractDAO;

@Repository
public class AdminDao extends AbstractDAO {

	@Autowired private SqlSession sql;
	private static final String NAMESPACE = "AdminMapper.";
	
	
	public String adminLogin(AdminVO adminVO) {
		return sql.selectOne(NAMESPACE + "adminLogin", adminVO);
	}
}
