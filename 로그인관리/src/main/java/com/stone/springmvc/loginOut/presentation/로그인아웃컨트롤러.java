package com.stone.springmvc.loginOut.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stone.springmvc.loginOut.service.로그인아웃업무자;
import com.stone.springmvc.member.model.Member;

@Controller
public class 로그인아웃컨트롤러 {

	@Autowired
	로그인아웃업무자 로그인아웃업무자;

	@GetMapping(value = "/login")
	public String 로그인준비하다() {
		if (로그인아웃업무자.로그인준비가능한가()) {
			return "로그인창";
		}
		return null;
	}

	@PostMapping(value = "/login")
	public String 로그인하다(String id, String password, HttpSession session) {
		if(로그인아웃업무자.로그인이가능한가(id, password)) {
			Member 로그인유저 = 로그인아웃업무자.찾는다byId(id);
			session.setAttribute("loginUser", 로그인유저);
			return "redirect:/contents/main";
		}
		return "에러로그인창";
	}
	
	@GetMapping(value = "/logout")
	public String 로그아웃하다(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
