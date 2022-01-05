package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.common.Board;

public class DAO {
	private Connection conn;
	private static DAO instance;

	private DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&"
					+ "characterEncoding=utf8&&ServerTimeZone=UTC";
			conn = DriverManager.getConnection(url, "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public int 입력하다(Board board) {
		String sql = "Insert into board(title, contents) values (?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		}
		return result;
	}

}
