package com.stone.springmvc.service;

import java.util.List;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.게시물DAO;

public class 게시물관리 {
	게시물DAO 게시물DAO = new 게시물DAO();

	public void 게시물등록준비하다() {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
	}

	public List<Board> 게시물목록을수집하다() {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
		return 게시물DAO.모두수집하다();
	}

	public String 게시물을등록하다(Board 새게시물) {
		// (업무)
		// 현재 업무 규칙 없음
		//(가상업무) 제목에 한글과 영문만 게시 가능
		if (새게시물.getTitle().matches("/^[가-힣a-zA-Z]+$/;")) {
			게시물DAO.저장하다(새게시물);
			return null;
		} else {
			return "제목에는 한글과 영문만 입력 가능합니다.";
		}
		// (DB)
	}

	public Board 게시물을조회하다(int 게시물번호) {
		// (업무)
		// 현재 업무 규칙 없음
		// (DB)
		return 게시물DAO.찾는다By번호(게시물번호);
	}
}
