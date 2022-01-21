package com.stone.simple.member.presentation;

import java.io.File;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView 회원등록하다( Member 새회원,HttpServletRequest request) {
		
		회원관리자.저장하다(새회원);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", 새회원.getName());
		mv.setViewName("회원등록알림창");
		return mv;
	}
	@GetMapping("/member/{no}")  //예 /memeber/1<-패스변수
	public ModelAndView 회원조회하다(@PathVariable int no) {
		Member 찾은회원 = 회원관리자.회원정보를조회하다(no);
		ModelAndView mv=new ModelAndView();
		mv.addObject("member", 찾은회원);
		String profileString = Base64.getEncoder().encodeToString(찾은회원.getProfile()); 
		mv.addObject("profileString", profileString);
		mv.setViewName("회원정보창");
		return mv;
	}
}
