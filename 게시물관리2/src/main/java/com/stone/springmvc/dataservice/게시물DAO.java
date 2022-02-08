package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stone.springmvc.common.Board;

import config.DBConfig;

@Repository
public class 게시물DAO {
	public void 저장하다(Board 새게시물) {
		
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("insert into board(title,contents) values(?,?)");
	        명령자.setString(1, 새게시물.getTitle());
	        명령자.setString(2, 새게시물.getContents());        
	        명령자.executeUpdate();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }	    
	}
	
	public List<Board> 모든게시물을수집하다(){
		List<Board> 수집된게시물들=new ArrayList<Board>();
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select no,title from board");
	        ResultSet 게시물표= 명령자.executeQuery();
	        while(게시물표.next()) {
	        	
	        	int 게시물번호 =게시물표.getInt("no");
	        	String 제목= 게시물표.getString("title");
	        	
	        	Board 게시물 = new Board();	        	
	        	게시물.setNo(게시물번호);
	        	게시물.setTitle(제목);
	        	
	        	수집된게시물들.add(게시물);
	        }
	        
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 수집된게시물들;
	}
}
