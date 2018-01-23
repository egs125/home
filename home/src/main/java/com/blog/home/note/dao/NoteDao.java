package com.blog.home.note.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.home.note.vo.NoteVO;

import common.vo.PagingVO;

@Repository("noteDao")
public class NoteDao {
	private static final String NAMESPACE = "noteMapper.";
	
	@Autowired
	private SqlSession sql;

	public List<NoteVO> getNoteList() {
		return sql.selectList(NAMESPACE + "getNoteList");
	}
	
	public List<NoteVO> getNoteList(PagingVO vo) {
		return sql.selectList(NAMESPACE + "getNoteList", vo);
	}

	public int getTotalCount() {
		return sql.selectOne(NAMESPACE + "getTotalCount");
	}

	public NoteVO retrieveNote(String sn) {
		return sql.selectOne(NAMESPACE + "retrieveNote", sn);
	}

	public int writeNote(NoteVO vo) {
		return sql.insert(NAMESPACE + "writeNote", vo);
	}

	public int deleteNote(String sn) {
		return sql.update(NAMESPACE + "deleteNote", sn);
	}

	public int updateNote(NoteVO vo) {
		return sql.update(NAMESPACE + "updateNote", vo);
	}
}
