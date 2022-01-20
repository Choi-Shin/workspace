package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class 어떤컨트롤러 {
	
	@RequestMapping("ccc")
	ModelAndView c() {
		ModelAndView 모델앤뷰 = new ModelAndView();
		모델앤뷰.setViewName("forward:/aaa");
		return 모델앤뷰;
	}
	
	@RequestMapping("aaa")
	void a() {
		System.out.println("포워드 a성공");
	}
}
