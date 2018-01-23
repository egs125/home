package com.blog.home.note.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.home.note.dao.NoteDao;
import com.blog.home.note.vo.NoteVO;

import common.vo.PagingVO;

@Service("noteSvc")
public class NoteSvcImpl implements NoteSvc{

	@Autowired
	private NoteDao dao;
	
	@Override
	public List<NoteVO> getNoteList() {
		return dao.getNoteList();
	}
	
	@Override
	public List<NoteVO> getNoteList(PagingVO vo) {
		return dao.getNoteList(vo);
	}

	@Override
	public int getTotalCount() {
		return dao.getTotalCount();
	}

	@Override
	public NoteVO retrieveNote(String sn) {
		return dao.retrieveNote(sn);
	}

	@Override
	public int writeNote(NoteVO vo) {
		return dao.writeNote(vo);
	}

	@Override
	public int deleteNote(String sn) {
		return dao.deleteNote(sn);
	}

	@Override
	public int updateNote(NoteVO vo) {
		return dao.updateNote(vo);
	}

	
}
