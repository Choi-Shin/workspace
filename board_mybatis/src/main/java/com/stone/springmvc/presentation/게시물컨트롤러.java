package com.stone.springmvc.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.service.I게시물서비스;

@Controller
public class 게시물컨트롤러 {
	@Autowired I게시물서비스 게시물서비스;
	
	@GetMapping("/board")
	void 게시물저장하다() {
		//Test 코드
		Board 새게시물=new Board();
		새게시물.setTitle("title1");
		새게시물.setContents("contents1");
		게시물서비스.등록하다(새게시물);
	}

}
