package com.stone.springmvc.member.dataservice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stone.springmvc.board.dataservice.I게시물DAO;
import com.stone.springmvc.member.common.Member;

import config.DBConfig;

@Repository
public class 회원DAO implements I회원DAO {
	
	/*
	public boolean 있는가(String id, String password) {
		boolean 있다=  false;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select count(*) from member where id=? and password=?");
	        명령자.setString(1, id);
	        명령자.setString(2, password);
	        ResultSet 있냐표 =명령자.executeQuery();
	        if(있냐표.next()) {
	        	if(있냐표.getInt(1)==1) {
	        		있다=true;
	        	}
	        }
	        있냐표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	    return 있다;
	}
	*/
	@Override
	public Member 찾다ById와Password(String id, String password) {
	
	    Member 찾은회원=null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select no,name from member where id=? and password=?");
	        명령자.setString(1, id);
	        명령자.setString(2, password);
	        ResultSet 회원표 =명령자.executeQuery();
	        if(회원표.next()) {
	        	int 회원번호=회원표.getInt("no");
	        	String 성명=회원표.getString("name");
	        	찾은회원=new Member();
	        	찾은회원.setNo(회원번호);
	        	찾은회원.setName(성명);
	        }
	        회원표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
		return 찾은회원;
	}
    @Override
	public Member 찾다By회원번호(int no) {
    	Member 찾은회원=null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select no,name,id from member where no=?");
	        명령자.setInt(1, no);
	        ResultSet 회원표 =명령자.executeQuery();
	        if(회원표.next()) {
	        	int 회원번호=회원표.getInt("no");
	        	String 성명=회원표.getString("name");
	        	String id=회원표.getString("id");
	        	찾은회원=new Member();
	        	찾은회원.setNo(회원번호);
	        	찾은회원.setName(성명);
	        	찾은회원.setId(id);
	        }
	        회원표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
		return 찾은회원;
    }
}
