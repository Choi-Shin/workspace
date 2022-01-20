package com.stone.springmvc.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.service.게시물관리;

@Controller
public class 게시물관리컨트롤러 {
	@Autowired 게시물관리 게시물관리;
	
	@RequestMapping("list")
	ModelAndView 게시물목록을출력하다(@RequestParam(value="pageno",required=false,defaultValue="1")int 페이지번호) {
		int 페이지당게시물수=5;//일때
		int 범위끝게시물일련번호=페이지당게시물수*페이지번호;
		//예 페이지가 1이면     범위시작게시물일련번호 1  범위끝게시물일련번호 5
		//        2                    6               10  
//      //        3                    11              15
		int 시작게시물일련번호=범위끝게시물일련번호-(페이지당게시물수-1);
		
		Object[] 수집된게시물들과게시물수=게시물관리.게시물목록을수집하다(시작게시물일련번호,페이지당게시물수);
		
		int 수집된게시물수=(int)수집된게시물들과게시물수[1];             //테이블 내의 게시물수가 아니다.
        //페이지당게시물수로 나눈 나머지가 있으면  한페이지를 추가
        int 마지막페이지번호=(int)(수집된게시물수/페이지당게시물수)+((수집된게시물수%페이지당게시물수>0)?1:0);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물목록창");
		mv.addObject("boards", 수집된게시물들과게시물수[0]);
		mv.addObject("pageNo", 페이지번호);
		mv.addObject("lastPageNo", 마지막페이지번호);
		return mv;
	}
	
	
	@RequestMapping("add")
	ModelAndView 게시물을등록하다(Board board) {
	
		게시물관리.게시물을등록하다(board);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("forward:/list");
		return mv;
	}
	
	@RequestMapping("prepare")
	ModelAndView 게시물등록을준비하다( ) {
		게시물관리.게시물등록준비하다();
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물등록창");
		return mv;
	}
	
	@RequestMapping("detail")
	ModelAndView 상세내용을출력하다(int no){
		Board 찾은게시물 = 게시물관리.게시물변경준비하다(no);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물상세창");
		mv.addObject("board", 찾은게시물);
		return mv;
	}
	
	@RequestMapping("prepare_update")
	ModelAndView 게시물을변경준비하다(int no){
		Board 찾은게시물 = 게시물관리.게시물을조회하다(no);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물변경창");
		mv.addObject("board", 찾은게시물);
		return mv;
	}
	
	@RequestMapping("update")
	ModelAndView 게시물을변경하다(Board board) {
	
		게시물관리.게시물을변경하다(board);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물변경통보창");
		return mv;
	}
	
	@RequestMapping("delete")
	ModelAndView 게시물을삭제하다(int no){
		게시물관리.게시물을삭제하다(no);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("게시물삭제통보창");		
		return mv;
	}
}
