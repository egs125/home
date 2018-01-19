package com.blog.home.admin.ctr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.home.admin.svc.AdminSvc;
import com.blog.home.admin.vo.AdminVO;

@RequestMapping("/admin")
@Controller("adminCtr")
public class AdminCtr {

	@Autowired 
	private AdminSvc svc;
	
	@RequestMapping("/loginView")
	public String adminLoginView(Model model, HttpSession session) {
		return "/admin/adminLogin";
	}
	
	@RequestMapping("/login")
	public String adminLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session, Model model) {
		System.out.println("########################");
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("########################");
		
		String admin = svc.adminLogin(new AdminVO(id, pw));
		if(admin != null) {
			session.setAttribute("admin", admin);
			return "home";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request ){
		session = request.getSession(false);		
		if(session != null) {
			session.invalidate();
			System.out.println("로그아웃 처리 완료");
		}
		return "home";
	}
}
