package com.blog.home.note.ctr;

import java.util.List;
import java.util.Map;

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
	public String noteListView(Model model) {
		return "/note/noteList";
	}
	
	//페이징
	@RequestMapping("/setPaging")
	public @ResponseBody PagingVO setPagingVO(@RequestParam Map<String, Integer> param) {
		Object obj = param.get("curPage");
		int page = Integer.valueOf((String) obj);
		int totalCount = svc.getTotalCount();
		PagingVO vo = new PagingVO(totalCount, page);
		return vo;
	} 
	
	//게시물 목록 
	@RequestMapping("/getNoteList")
	public @ResponseBody List<NoteVO> getNoteList(Model model, @RequestParam Map<String, Integer> param) throws Exception {		
		PagingVO vo = this.setPagingVO(param);
		List<NoteVO> list = svc.getNoteList(vo);
		return list;
	}
	
	//게시물 상세 데이터 조회
	@RequestMapping("/readNote")
	public String readNoteView(Model model, @RequestParam(value="sn") String sn) throws Exception {
		NoteVO vo = svc.retrieveNote(sn);
		model.addAttribute("vo", vo);
		return "/note/readNote";
	}
	
	//게시물 수정 화면으로 이동
	@RequestMapping("/updateNoteView")
	public String updateNoteView(HttpSession session, Model model, @RequestParam(value="sn") String sn) throws Exception {
		NoteVO vo = svc.retrieveNote(sn);
		model.addAttribute("vo", vo);
		return "/note/updateNote";
	}
	
	//게시물 수정
	@RequestMapping("/updateNote")
	public @ResponseBody String updateNote(Model model, NoteVO vo) throws Exception {			
		String rtn = "";
		int result = svc.updateNote(vo);
		
		if(result > 0) rtn = "Your note is updated!";
		else 		   rtn = "Your note cannot be updated";
		
		return rtn;
	}
	
	@RequestMapping("/deleteNote")
	public String deleteNote(@RequestParam(value="sn") String sn) throws Exception {
		String rtn = "";
		int result = svc.deleteNote(sn);
		
		if(result > 0) rtn =  "/note/noteList";
		else 		   rtn = "fail";
		
		return rtn;
	}
	
	//게시물 작성 화면
	@RequestMapping("/writeNoteView")
	public String writeNoteView(HttpSession session, Model model) throws Exception {
		return "/note/writeNote";
	}
	
	//게시물 입력
	@RequestMapping("/writeNote")
	public @ResponseBody String writeNote(HttpSession session, Model model, NoteVO vo) throws Exception {
		String rtn = "";
		int result = svc.writeNote(vo);
		
		if(result > 0) rtn = "New Note is saved!";
		else  		   rtn = "New Note cannot be saved";
		
		return rtn;
	}
	
}
