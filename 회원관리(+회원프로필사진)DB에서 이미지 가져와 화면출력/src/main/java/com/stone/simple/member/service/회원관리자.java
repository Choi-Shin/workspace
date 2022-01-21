package com.stone.simple.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.dataservice.*;

@Service
public class 회원관리자 {
   	@Autowired
	회원DAO 회원DAO;
	
	public boolean 아이디사용가능여부를판단하다(String id) {
		
			
		
		return !회원DAO.아이디가있는가(id);
	}
	
	public void 저장하다(Member 새회원) {
		회원DAO.저장하다(새회원);
	}
	
	public Member 회원정보를조회하다(int no) {
		
		//업무
		//DB처리
		return 회원DAO.찾다By번호(no);
	}
}
