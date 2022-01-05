package com.stone.springmvc.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.service.BoardService;

@Controller
public class 게시물관리컨트롤러 {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping("add")
	ModelAndView 게시물등록하다(Board board) {
		bs.게시물을등록하다(board);
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
		List<Board> 목록 = bs.게시물목록을수집하다();
		ModelAndView mv = new ModelAndView();
		mv.addObject("boards", 목록);
		mv.setViewName("게시물목록창");
		return mv;
	}

	@RequestMapping("remove")
	ModelAndView 목록지우다() {
		ModelAndView mv = new ModelAndView();
		int result = bs.목록지우다();
		if (result == 0) {
			mv.addObject("result", "지울 게시글이 존재하지 않습니다.");
		} else if(result == 1) {
			mv.addObject("result", "게시글 목록을 초기화하였습니다.");
		} else {
			mv.addObject("result", "알 수 없는 오류로 목록 삭제에 실패하였습니다.");
		}
		mv.setViewName("afterRemove");
		return mv;
	}
	
	@RequestMapping("detail")
	ModelAndView 상세내용을출력하다(int no) {
		ModelAndView mv = new ModelAndView();
		Board 찾은게시물 = bs.게시물을조회하다(no);
		mv.setViewName("게시물상세창");
		mv.addObject("board",찾은게시물);
		return mv;
	}
	
	@RequestMapping("delete")
	ModelAndView 삭제하다(int no) {
		ModelAndView mv = new ModelAndView();
		Board b = bs.게시물을조회하다(no);
		int result = bs.삭제하다(no);
		if (result == 0) {
			mv.addObject("result", "삭제에 실패하였습니다.");
		} else if(result == 1) {
			mv.addObject("result", b.getTitle()+"를 삭제하였습니다.");
		} 
		mv.setViewName("afterRemove");
		return mv;
	}
}
