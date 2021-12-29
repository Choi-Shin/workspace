package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;

@Controller
public class 게시물컨트롤러 {
	
	@RequestMapping("addboard")
	ModelAndView 게시물등록하다(Board newBoard) {
		ModelAndView 모델앤뷰 = new ModelAndView();
		모델앤뷰.addObject("newBoard", newBoard);
		모델앤뷰.setViewName("결과창");
		return 모델앤뷰;
	}
	
	@RequestMapping("prepareboard")
	String 게시물등록준비하다() {
		return "게시물등록창";
	}
}
