package com.stone.springmvc.contents.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.member.model.Member;

@Controller
@RequestMapping("/contents/*")
public class 내용컨트롤러 {
	
	@GetMapping(value = ("/main"))
	public ModelAndView 메인페이지를주다(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Member loginUser = null;
		boolean isLogin = false;
		if(session != null) {
			loginUser = (Member) session.getAttribute("loginUser");			
			mv.addObject("loginUser", loginUser);
		}
		if(loginUser != null) {
			isLogin = true;
		}
		mv.addObject("isLogin", isLogin);
		mv.setViewName("/contents/main");
		return mv;
	}
}
