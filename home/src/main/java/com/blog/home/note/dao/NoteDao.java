package com.blog.home.note.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.home.note.vo.NoteVO;

@Repository("noteDao")
public class NoteDao {
	private static final String NAMESPACE = "noteMapper.";
	
	@Autowired
	private SqlSession sql;

	public List<NoteVO> getNoteList() {
		return sql.selectList(NAMESPACE + "getNoteList");
	}

	public int getTotalCount() {
		return sql.selectOne(NAMESPACE + "getTotalCount");
	}

	public NoteVO retrieveNote(String sn) {
		return sql.selectOne(NAMESPACE + "retrieveNote", sn);
	}
}
