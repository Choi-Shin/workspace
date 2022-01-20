package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class 어떤컨트롤러 {
	
	@RequestMapping("bbb")
	String B() {
		return "redirect:/aaa";
	}
	
	@RequestMapping("aaa")
	String A() {
		return null;
	}
}
