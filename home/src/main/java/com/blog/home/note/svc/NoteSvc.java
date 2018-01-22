package com.blog.home.note.svc;

import java.util.List;

import com.blog.home.note.vo.NoteVO;

public interface NoteSvc {

	List<NoteVO> getNoteList();

	int getTotalCount();

	NoteVO retrieveNote(String sn);

	int writeNote(NoteVO vo);

	int deleteNote(String sn);

	int updateNote(NoteVO vo);



}
