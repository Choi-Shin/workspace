package com.stone.springmvc.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.게시물DAO;

@Controller
public class 게시물관리컨트롤러 {
	게시물DAO 게시물dao = 게시물DAO.getInstance();
	
	@RequestMapping("add")
	ModelAndView 게시물등록하다(Board board) {
		게시물dao.저장하다(board);
		ModelAndView 등록 = new ModelAndView();
		등록.addObject("board", board);
		등록.setViewName("forward:/list");
		return 등록;	
	}
	
	@RequestMapping("prepare")
	String 게시물등록준비하다() {
		return "게시물등록창";
	}


	@RequestMapping("list")
	ModelAndView 게시물목록을출력하다() {
		List<Board> 목록 = 게시물dao.모두수집하다();
		ModelAndView mv = new ModelAndView();
		mv.addObject("boards", 목록);
		mv.setViewName("게시물목록창");
		return mv;
	}

	@RequestMapping("remove")
	ModelAndView 목록지우다() {
		boolean isSuccess = 게시물dao.목록지우다();
		ModelAndView mv = new ModelAndView();
		if(isSuccess == true) {
			mv.addObject("success", true);
		} else {
			mv.addObject("success", false);
		}
		mv.setViewName("afterRemove");
		return mv;
	}
	
	@RequestMapping("detail")
	ModelAndView 상세내용을출력하다(int no) {
		ModelAndView mv = new ModelAndView();
		Board 찾은게시물 = 게시물dao.찾는다By번호(no);
		mv.setViewName("게시물상세창");
		mv.addObject("board",찾은게시물);
		return mv;
	}
}
