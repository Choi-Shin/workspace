package com.stone.springmvc.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.service.게시물업무자;

@Controller
public class 게시물컨트롤러 {
	@Autowired 게시물업무자 게시물업무자;
	
	@GetMapping("prepare")
	public ModelAndView 게시물등록준비하다() {
		
		ModelAndView mv = new ModelAndView();
		
		if(게시물업무자.게시물등록준비가능한가()) {				
			mv.setViewName("게시물등록창");
		}
		
		return mv;
	}
	
	@PostMapping("insert")
	public  ModelAndView 게시물등록하다(Board 새게시물) {
		
		게시물업무자.게시물을등록하다(새게시물);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물등록알림창");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView 게시물목록을출력하다() {
		List<Board> 수집된게시물들 =게시물업무자.모든게시물을수집하다();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물목록창");
		mv.addObject("boards",수집된게시물들 );
		return mv;
	}
}
