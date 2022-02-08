package com.stone.springmvc.member.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.member.model.Member;
import com.stone.springmvc.member.service.회원업무자;

@Controller
public class Test회원컨트롤러 {
	@Autowired 회원업무자 회원업무자;
	
	@GetMapping(value = "/member")
	public ModelAndView 자기정보를보다(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Member 회원 = (Member)session.getAttribute("loginUser");
		mv.addObject("userInfo", 회원);
		mv.setViewName("/member/회원정보창");
		return mv;
	}
}
