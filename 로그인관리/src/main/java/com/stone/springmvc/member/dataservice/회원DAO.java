package com.stone.springmvc.member.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.stone.springmvc.member.model.Member;

import config.DBConfig;

@Repository
public class 회원DAO {
	Connection con;
	PreparedStatement 명령자;
	ResultSet 표;
	public boolean 있는가(String id, String password) {
		명령자 = null;
		String sql = "select count(*) from member where id=? and password=?";
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			명령자 = con.prepareStatement(sql);
			명령자.setString(1, id);
			명령자.setString(2, password);
			표 = 명령자.executeQuery();
			if(표.next()) {
				int count = 표.getInt(1);
				if(count > 0) {
					return true;
				} else {
					return false;
				}
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Member 찾는다byId(String id) {
		명령자 = null;
		String sql = "select * from member where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?useUnicode=true&characterEncoding=utf8&&ServerTimezone=UTC",
					"root", "1234");
			명령자 = con.prepareStatement(sql);
			명령자.setString(1, id);
			표 = 명령자.executeQuery();
			Member 회원 = new Member();
			if(표.next()) {
				회원.setNo(표.getInt("no"));
				회원.setName(표.getString("name"));
				회원.setId(표.getString("id"));
				회원.setPassword(표.getString("password"));
				return 회원;
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
