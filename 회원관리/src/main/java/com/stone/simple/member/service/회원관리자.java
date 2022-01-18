package com.stone.simple.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.simple.member.dataservice.*;

@Service
public class 회원관리자 {
   	@Autowired
	회원DAO 회원DAO;
	
	public boolean 아이디사용가능여부를판단하다(String id) {
		
			
		
		return !회원DAO.아이디가있는가(id);
	}
}
