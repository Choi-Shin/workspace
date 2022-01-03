package com.stone.springmvc.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.*;

@Controller
public class 게시물관리컨트롤러 {
	게시물DAO 게시물DAO =new 게시물DAO();
	
	@RequestMapping("list")
	ModelAndView 게시물목록을출력하다(    ) {
		
		List<Board> 수집된게시물들=게시물DAO.모두수집하다();
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물목록창");
		mv.addObject("boards", 수집된게시물들);
		return mv;
	}
	
	
	@RequestMapping("add")
	ModelAndView 게시물을등록하다(Board board) {
	
		게시물DAO.저장하다(board);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("forward:/list");
		return mv;
	}
	
	@RequestMapping("prepare")
	ModelAndView 게시물등록을준비하다( ) {
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물등록창");
		return mv;
	}
	
	@RequestMapping("detail")
	ModelAndView 상세내용을출력하다(int no){
		Board 찾은게시물 = 게시물DAO.찾는다By번호(no);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물상세창");
		mv.addObject("board", 찾은게시물);
		return mv;
	}
}
