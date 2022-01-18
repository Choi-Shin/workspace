package com.stone.simple.member.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import config.DBConfig;

@Repository
public class 회원DAO {
	public boolean 아이디가있는가(String id) {
		boolean 아이디있다=false;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select count(*) from member where id=?");
	        명령자.setString(1, id);
	        ResultSet 아이디갯수표 =명령자.executeQuery();
	        if(아이디갯수표.next()) {
	        	if(아이디갯수표.getInt(1)>0) {아이디있다=true;}
	        	System.out.println("DB확인");//@MyTest
	        } 
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	    System.out.println(아이디있다);//@MyTest
		return 아이디있다;
	} 
}
