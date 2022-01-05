package com.stone.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.게시물DAO;

@Service
public class BoardService {
	
	@Autowired
	게시물DAO 게시물dao;
	
	public void 게시물등록준비하다() {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
	}

	public List<Board> 게시물목록을수집하다() {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
		return 게시물dao.모두수집하다();
	}

	public void 게시물을등록하다(Board 새게시물) {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
		게시물dao.저장하다(새게시물);
	}
	
	public int 목록지우다() {
		int count = 게시물dao.count();
		if (count == 0) {
			return 0;
		} else if (count > 0) {
			게시물dao.목록지우다();
			return 1;
		} else {
			return -1;
		}
	}
	
	public int 삭제하다(int no) {
		return 게시물dao.삭제하다(no);
	}
	
	public Board 게시물을조회하다(int 게시물번호) {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
		return 게시물dao.찾는다By번호(게시물번호);
	}
}
