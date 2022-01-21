package com.example.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.common.Board;
import com.example.springmvc.service.BoardService;

@Controller
public class BoardController {
	
	@RequestMapping("prepare")
	ModelAndView 게시글등록을준비하다() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("prepare");
		return mv;
	}
	
	@RequestMapping("add")
	ModelAndView 게시글등록하다(Board board) {
		ModelAndView mv = new ModelAndView();
		BoardService bs = new BoardService();
		bs.등록하다(board);
		mv.setViewName("add");
		return mv;
	}
	
}
