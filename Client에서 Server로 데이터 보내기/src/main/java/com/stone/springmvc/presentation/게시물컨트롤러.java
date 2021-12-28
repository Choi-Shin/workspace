package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;

@Controller
public class 게시물컨트롤러 {
	
	@RequestMapping("addboard")
	ModelAndView 게시물등록하다(String title, String contents) {
		Board 게시물 = new Board();
		ModelAndView 모델앤뷰 = new ModelAndView();
		모델앤뷰.addObject("board", 게시물);
		게시물.setTitle(title);
		게시물.setContents(contents);
		System.out.println(title);
		System.out.println(contents);
		return 모델앤뷰;
	}
	
	@RequestMapping("prepareboard")
	String 게시물등록준비하다() {
		return "게시물등록창";
	}
}
