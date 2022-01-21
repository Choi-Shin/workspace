package com.stone.springmvc.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.stone.springmvc.service.게시물업무자;

@Controller
public class 게시물컨트롤러 {
	@Autowired 게시물업무자 게시물업무자;
	
	@GetMapping("prepare")
	public ModelAndView 게시물등록준비하다() {
		
		ModelAndView mv = new ModelAndView();
		
		if(게시물업무자.게시물등록준비가능한가()) {				
			mv.setViewName("게시물등록창");
		}
		
		return mv;
	}
}
