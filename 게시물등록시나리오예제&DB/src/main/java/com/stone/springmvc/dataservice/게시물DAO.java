package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stone.springmvc.common.Board;

public class 게시물DAO {
	public void 저장하다(Board 새게시물) {
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB URL
	                    "root", "1234");  // USER_NAME과 PASSWORD
	        
	        PreparedStatement 명령자=con.prepareStatement("insert into board(title,contents) values(?,?)"); 
	        명령자.setString(1, 새게시물.getTitle());
	        명령자.setString(2, 새게시물.getContents());
	        명령자.executeUpdate();
	        
	            //DB조작
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }		
	}
	public List<Board> 모두수집하다(){
		List<Board> 게시물들 =new ArrayList<Board>();		
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB URL
	                    "root", "1234");  // USER_NAME과 PASSWORD	        
	        PreparedStatement 명령자=con.prepareStatement("select * from board order by no desc"); 
	        ResultSet 게시물표 =명령자.executeQuery();
	        while(게시물표.next()) {
	        	int 게시물번호 =게시물표.getInt("no");        	
	        	String 제목=게시물표.getString("title");
	        	String 내용=게시물표.getString("contents");	        	
	        	Board 게시물 = new Board();
	        	게시물.setNo(게시물번호);
	        	게시물.setTitle(제목);
	        	게시물.setContents(내용);
	        	게시물들.add(게시물);
	        } 
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }	
	   return 게시물들;
	}
	public Board 찾는다By번호(int 번호) {		
		Board 찾은게시물=null;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB URL
	                    "root", "1234");  // USER_NAME과 PASSWORD	        
	        PreparedStatement 명령자=con.prepareStatement("select * from board where no=?");
	        명령자.setInt(1, 번호);
	        ResultSet 게시물표 =명령자.executeQuery();
	        if(게시물표.next()) {
	        	//int 게시물번호 =게시물표.getInt("no");        	
	        	String 제목=게시물표.getString("title");
	        	String 내용=게시물표.getString("contents");	        	
	        	찾은게시물 = new Board();
	        	찾은게시물.setNo(번호);
	        	찾은게시물.setTitle(제목);
	        	찾은게시물.setContents(내용);
	        } 
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	   return 찾은게시물;
	}
}
