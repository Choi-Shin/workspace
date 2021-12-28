package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class 어떤컨트롤러 {
	//ModelAndView 이용 view 지정
	@RequestMapping("aaa")
	ModelAndView 요청처리자() {
		ModelAndView 모델과뷰 = new ModelAndView();
		//view를 abc.jsp로 지정
		모델과뷰.setViewName("abc");//abc.jsp
		return 모델과뷰;
	}
	
	@RequestMapping("bbb")
	String 요청처리자2() {
		return "abc";
	}
	
	@RequestMapping("abc")
	void 요청처리자3() {
	}
}
