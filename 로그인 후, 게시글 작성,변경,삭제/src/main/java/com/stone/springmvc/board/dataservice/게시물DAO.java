package com.stone.springmvc.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stone.springmvc.board.common.Board;
import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.member.dataservice.I회원DAO;

import config.DBConfig;

@Repository
public class 게시물DAO implements I게시물DAO {
	@Autowired I회원DAO 회원DAO;
	@Override
	public void 저장하다(Board 새게시물) {
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("insert into board(title,contents,writer) values(?,?,?)");
	        명령자.setString(1, 새게시물.getTitle());
	        명령자.setString(2, 새게시물.getContents());
	        명령자.setInt(3, 새게시물.getWriter().getNo());//작성자 회원의 번호를 준다
	        명령자.executeUpdate();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	}

	@Override
	public List<Board> 모든게시물을수집하다() {
		List<Board> 수집된게시물들 = new ArrayList<Board>(); 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select no,title,writer,views from board");
	        ResultSet 게시물표= 명령자.executeQuery();
	        while(게시물표.next()) {
	        	int no = 게시물표.getInt("no");
	        	String title=게시물표.getString("title");
	        	int 작성한회원의번호 = 게시물표.getInt("writer");	        	
	        	int views = 게시물표.getInt("views");
	        	Member 작성한회원 = 회원DAO.찾다By회원번호(작성한회원의번호);
	        	
	        	Board 게시물=new Board();
	        	게시물.setNo(no);
	        	게시물.setTitle(title);
	        	게시물.setWriter(작성한회원);//주목
	        	게시물.setViews(views);
	        	
	        	수집된게시물들.add(게시물);
	        }
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 수집된게시물들;
	}

	@Override
	public Board 게시물을찾다And조회수증가하다(int 게시물번호) {
		Board 게시물 = null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자2=con.prepareStatement("update board set views=views+1 where no=?");
	        명령자2.setInt(1, 게시물번호);
	        명령자2.executeUpdate();
	        명령자2.close();
	        
	        PreparedStatement 명령자=con.prepareStatement("select no,title,contents,writer,views from board where no=?");
	        명령자.setInt(1, 게시물번호);
	        ResultSet 게시물표= 명령자.executeQuery();
	        if(게시물표.next()) {
	        	int no = 게시물표.getInt("no");
	        	String title=게시물표.getString("title");
	        	String contents =게시물표.getString("contents");
	        	int 작성한회원의번호 = 게시물표.getInt("writer");	        	
	        	int views = 게시물표.getInt("views");
	        	Member 작성한회원 = 회원DAO.찾다By회원번호(작성한회원의번호);
	        	
	        	게시물=new Board();
	        	게시물.setNo(no);
	        	게시물.setTitle(title);
	        	게시물.setContents(contents);
	        	게시물.setWriter(작성한회원);//주목
	        	게시물.setViews(views);
	        }
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 게시물;
	}
	
	
}
