package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;

@Controller
public class 어떤컨트롤러 {
	
	@RequestMapping("게시물등록준비")
	String 게시물등록준비하다() {
		return "게시물등록창";
	}
	
	@RequestMapping("게시물등록")
	ModelAndView 게시물등록하다(Board board) {
		ModelAndView 등록 = new ModelAndView();
		등록.addObject("board", board);
		등록.setViewName("forward:/게시물목록출력");
		return 등록;
		
	}

	@RequestMapping("게시물목록출력")
	String 게시물목록출력하다(Board board) {
		return "게시물목록창";
	}
	
	@RequestMapping("목록지우기")
	void 목록지우다() {
	}
}
