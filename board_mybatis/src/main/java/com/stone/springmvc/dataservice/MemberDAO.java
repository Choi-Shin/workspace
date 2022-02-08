package com.stone.springmvc.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stone.springmvc.common.Member;

@Repository
public class MemberDAO implements IMemberDAO {
	@Autowired IMemberMapper memberDAO;
	
	@Override
	public Member 찾는다By번호() {
		return memberDAO.findByNo();
	}

}
