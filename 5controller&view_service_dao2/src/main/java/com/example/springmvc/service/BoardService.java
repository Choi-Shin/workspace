package com.example.springmvc.service;

import com.example.springmvc.common.Board;
import com.example.springmvc.dao.DAO;

public class BoardService {
	public void 등록하다(Board board) {
		// 2.업무(service+DB)
//		1)업무 규칙 검사(무결성 검사, 접근 권한 체크)
		System.out.println("업무 규칙 검사 코드 실행 완료");
//		2)DB처리(add=>저장)
//		  -jdbc
		DAO dao = DAO.getInstance();
		dao.입력하다(board);
	}
}
