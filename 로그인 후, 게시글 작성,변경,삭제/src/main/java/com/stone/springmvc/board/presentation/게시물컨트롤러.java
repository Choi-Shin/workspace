package com.stone.springmvc.board.presentation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.board.common.Board;
import com.stone.springmvc.board.service.I게시물업무자;
import com.stone.springmvc.member.common.Member;


@Controller
public class 게시물컨트롤러 { 
	@Autowired I게시물업무자 게시물업무자;
	
	@GetMapping("/board")
	public String 게시물작성을준비하다() {
		if(게시물업무자.게시물작성이가능한가()) {		
			return "board/게시물등록창";
		}
		return null;//실제는 작성이 불가 안내 창
	}
	
	@PostMapping("/board")
	public String 게시물을등록하다(Board 새게시물, HttpSession session) {
		//로그인한 회원의 번호 구해야함-로그인 당시 회원번호를   setAttribute 했다는 것을 전제로 할때
		int 로그인한회원의번호=(int)session.getAttribute("회원번호");
		//로그인한 회원이 작성자이므로 새게시물에 작성자를 set 해주어야함
		Member 작성한회원=new Member();
		작성한회원.setNo(로그인한회원의번호);
		새게시물.setWriter(작성한회원);
		
		게시물업무자.게시물을등록하다(새게시물);
		return "board/게시물등록알림창";
	}
	
	@GetMapping("/boards")
	public ModelAndView 게시물목록을출력하다() {
		List<Board> 수집된게시물들 = 게시물업무자.모든게시물을수집하다();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("board/게시물목록창");
		mv.addObject("boards", 수집된게시물들);
		return mv;
	}
	@GetMapping("/board/{게시물번호}")
	public ModelAndView 게시물상세츨력하다(@PathVariable int 게시물번호,HttpSession session) {
		Board 찾은게시물=게시물업무자.게시물을조회하다And조회수증가하다(게시물번호);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("board/게시물상세창");
		mv.addObject("board",찾은게시물);
		//로그인 안되어 있으면=>  로그인회원와게시물작성자가동일인물인가=null
		Boolean 로그인회원와게시물작성자가동일인물인가=null;
	    if(session!=null) {
	    	Integer 회원번호=(Integer)session.getAttribute("회원번호");
	    	 if(회원번호!=null) { //로그인된 경우
	    		 //로그인 회원와 게시물 작성자가 동일 인물
	    		 if(회원번호==찾은게시물.getWriter().getNo()) {
	    			 로그인회원와게시물작성자가동일인물인가=true;
	    		 }
	    		 else //로그인 회원와 게시물 작성자가 다른 인물
	    		 {
	    			 로그인회원와게시물작성자가동일인물인가=false;
	    		 }
	    	 }
	    }
	    
		mv.addObject("isWriter", 로그인회원와게시물작성자가동일인물인가);
		return mv;
	}
	
}
