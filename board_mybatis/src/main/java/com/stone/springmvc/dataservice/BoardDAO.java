package com.stone.springmvc.dataservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.common.Board2;

@Repository
public class BoardDAO implements IBoardDAO {
	@Autowired IBoardMapper boardDAO; 

	@Transactional
	@Override
	public void 저장하다(Board board) {
		boardDAO.save2(board);
	}
	
	@Transactional
	@Override
	public void 저장하다(Board2 board) {
		boardDAO.save3(board);
	}

	@Override
	public List<Board> 기본조회하다() {
		return boardDAO.selectAll2();
	}

	@Override
	public List<Board2> 작성자포함조회하다() {
		return boardDAO.selectAll3();
	}
	
	

}
