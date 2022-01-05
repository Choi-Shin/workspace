package com.example.service;

import com.example.common.Board;
import com.example.dao.DAO;

public class BoardService {
	public int 등록하다(Board board) {
		// 2.업무(service+DB)
//		1)업무 규칙 검사(무결성 검사, 접근 권한 체크)
		System.out.println("업무 규칙 검사 코드 실행 완료");
//		2)DB처리(add=>저장)
//		  -jdbc
		DAO dao = DAO.getInstance();
		int result = dao.입력하다(board);
		return result;
	}
}
