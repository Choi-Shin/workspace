package com.stone.simple.member.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.service.회원관리자;

@Controller
public class 프로필 {
	@Autowired 회원관리자 회원관리자;
	
	@GetMapping("/profile/{회원번호}")
	public ModelAndView 프로필사진을주다(@PathVariable("회원번호") int no) {
		ModelAndView mv = new ModelAndView();
		Member member = 회원관리자.찾는다by번호(no);
		mv.setViewName("profile");
		mv.addObject("profile",member.getProfile());
		return mv;
	}
}
