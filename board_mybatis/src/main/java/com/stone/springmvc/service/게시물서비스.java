package com.stone.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.IBoardDAO;

@Service
public class 게시물서비스 implements I게시물서비스 {
	@Autowired
	IBoardDAO boardDAO;
  
	@Override
	public void 등록하다(Board board) {
		boardDAO.저장하다(board);
	}

}
