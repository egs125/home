package com.blog.home.note.svc;

import java.util.List;

import com.blog.home.note.vo.NoteVO;

import common.vo.PagingVO;

public interface NoteSvc {

	List<NoteVO> getNoteList();

	List<NoteVO> getNoteList(PagingVO vo);
	
	int getTotalCount();

	NoteVO retrieveNote(String sn);

	int writeNote(NoteVO vo);

	int deleteNote(String sn);

	int updateNote(NoteVO vo);




}
