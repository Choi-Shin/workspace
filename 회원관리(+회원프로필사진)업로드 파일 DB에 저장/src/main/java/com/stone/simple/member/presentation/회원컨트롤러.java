package com.stone.simple.member.presentation;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.service.*;

@Controller
public class 회원컨트롤러 {
	@Autowired 회원관리자 회원관리자;

	@GetMapping("/id")
	public String Id중복검사준비하다(){
		return "아이디중복검사창";
	}
	
	@PostMapping("/id")	
	ModelAndView Id중복검사하다(String id){
		
		boolean 아이디사용가능여부= 회원관리자.아이디사용가능여부를판단하다(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("아이디중복검사창");
		mv.addObject("id", id);
		mv.addObject("usable", 아이디사용가능여부);
		return mv;
	}

	@PostMapping("/member")	
	public ModelAndView 회원등록하다( Member 새회원) {
		
		회원관리자.저장하다(새회원);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", 새회원.getName());
		mv.setViewName("회원등록알림창");
		return mv;
	}
}
