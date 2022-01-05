package com.example.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.springmvc.common.Board;

public class DAO {
	private Connection conn;
	private static DAO instance;

	private DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&"
					+ "characterEncoding=utf8&&ServerTimeZone=UTC";
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("연결성공");
		} catch (ClassNotFoundException | SQLException e) {
		}
	}

	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public void 입력하다(Board board) {
		String sql = "Insert into board(title, contents) values (?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		}
	}
}
