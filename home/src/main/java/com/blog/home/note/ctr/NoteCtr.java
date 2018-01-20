package com.blog.home.note.ctr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.home.note.svc.NoteSvc;
import com.blog.home.note.vo.NoteVO;
import com.mysql.jdbc.StringUtils;

import common.vo.PagingVO;

@RequestMapping("/note")
@Controller("noteCtr")
public class NoteCtr {

	@Autowired
	private NoteSvc svc;
	
	@RequestMapping("/noteListView")
	public String noteListView(Model model, HttpSession session) {
		return "/note/noteList";
	}
	
	//페이징 네비게이션 바 
	@RequestMapping("/getPaging")
	public @ResponseBody PagingVO getPagingNav(HttpSession session,
											   @RequestParam(value="page", defaultValue="1") int page) throws Exception {
		PagingVO vo = new PagingVO();
		vo.setTotalCount(svc.getTotalCount());
		vo.setPageSize(10);
		vo.setPageNo(page);
		vo.setBlockSize(10);
	
		return vo;
	}
	
	//게시물 목록 
	@RequestMapping("/getNoteList")
	public @ResponseBody List<NoteVO> getNoteList(HttpSession session/*, int page*/) throws Exception {
		List<NoteVO> list = svc.getNoteList();
		return list;
	}
	
	//게시물 상세 데이터 조회
	@RequestMapping("/readNote")
	public String readNoteView(HttpSession session, Model model, @RequestParam(value="sn") String sn) throws Exception {
		NoteVO vo = svc.retrieveNote(sn);
		model.addAttribute("vo", vo);
		return "/note/readNote";
	}
	
	//게시물 작성 화면
	@RequestMapping("/writeNoteView")
	public String writeNoteView(HttpSession session, Model model, @RequestParam(value="sn", defaultValue="null") String sn) throws Exception {
		if(null != sn) {
			NoteVO vo = svc.retrieveNote(sn);
			model.addAttribute("vo", vo);
		}
		return "note/writeNote";
	}
	/*public String writeNoteView(Model model, @RequestParam(value="sn") String sn) throws Exception {
		System.out.println("###########");
		System.out.println("writeNoteView");
		System.out.println("###########");

		if(null != sn) {
			NoteVO vo = svc.retrieveNote(sn);
			model.addAttribute("vo", vo);
		}
		return "note/writeNote";
	}*/
	
	//게시물 입력
	@RequestMapping("/writeNote")
	public String writeNote(HttpSession session, Model model, NoteVO vo) throws Exception {
		int result = svc.writeNote(vo);
		return "/note/readNote";
	}
	
}
