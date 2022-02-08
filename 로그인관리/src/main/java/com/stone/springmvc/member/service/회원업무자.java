package com.stone.springmvc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.member.dataservice.회원DAO;
import com.stone.springmvc.member.model.Member;

@Service
public class 회원업무자 {
	@Autowired 회원DAO 회원dao;
	
	public boolean 있는가(String id, String password) {
		return 회원dao.있는가(id, password);
	}
	
	public Member 찾는다byId(String id) {
		return 회원dao.찾는다byId(id);
	}
}
