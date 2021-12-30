package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;

@Controller
public class 게시물관리컨트롤러 {

	@RequestMapping("prepare")
	String 게시물등록준비하다() {
		return "게시물등록창";
	}

	@RequestMapping("add")
	ModelAndView 게시물등록하다(Board board) {
		ModelAndView 등록 = new ModelAndView();
		등록.addObject("board", board);
		등록.setViewName("forward:/list");
		return 등록;

	}

	@RequestMapping("list")
	ModelAndView 게시물목록을출력하다() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물목록창");
		return mv;
	}

	@RequestMapping("remove")
	void 목록지우다() {
	}
}
