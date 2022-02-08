package com.stone.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.*;
@Service
public class 게시물업무자 {
	@Autowired 게시물DAO 게시물DAO; 
	
	public boolean 게시물등록준비가능한가() {
			return true;
	}
	
	public void 게시물을등록하다(Board 새게시물) {
		게시물DAO.저장하다(새게시물);
	}
	
	public List<Board> 모든게시물을수집하다(){
		
		return 게시물DAO.모든게시물을수집하다();
	}
}
