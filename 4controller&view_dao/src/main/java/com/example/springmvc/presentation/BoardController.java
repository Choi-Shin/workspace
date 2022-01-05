package com.example.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.common.Board;
import com.example.springmvc.dao.DAO;

@Controller
public class BoardController {
	DAO dao = DAO.getInstance();

	@RequestMapping("prepare")
	ModelAndView 게시글등록을준비하다() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("prepare");
		return mv;
	}

	@RequestMapping("add")
	ModelAndView 게시글등록하다(String title, String contents) {
		// 2.업무(service+DB)
//		1)업무 규칙 검사(무결성 검사, 접근 권한 체크)
		System.out.println("업무 규칙 검사 코드 실행 완료");
//		2)DB처리(add=>저장)
//		  -jdbc
		Board board = new Board();
		board.setTitle(title);
		board.setContents(contents);
		dao.입력하다(board);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("add");
		return mv;
	}

}
