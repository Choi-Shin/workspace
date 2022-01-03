package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.stone.springmvc.common.Board;

public class 게시물DAO {

	private Connection conn;
	private static 게시물DAO instance;

	private 게시물DAO() { // 생성자 private 로 선언
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db1?useUnicode=true&" + "characterEncoding=utf8&&ServerTimeZone=UTC",
					"root", "1234");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("Connection을 연결할 수 없습니다.");
		}
	}

	public static 게시물DAO getInstance() { // private 로 선언된 instance 참조변수의 주소값을 얻기위한 getter
		if (instance == null)
			instance = new 게시물DAO(); // 참조변수가 null 경우에만 인스턴스화
		return instance; // 참조변수값 리턴
	}

	public void 저장하다(Board 새게시물) {
		String sql = "insert into board (title, contents) values(?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 새게시물.getTitle());
			pstmt.setString(2, 새게시물.getContents());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("저장 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Board> 모두수집하다() {
		String sql = "select * from board order by no desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> 게시물들 = new ArrayList<Board>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board 게시물 = new Board();
				게시물.setNo(rs.getInt("no"));
				게시물.setTitle(rs.getString("title"));
				게시물.setContents(rs.getString("contents"));
				게시물들.add(게시물);
			}
			return 게시물들;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public Board 찾는다By번호(int 번호) {
		Board 찾는게시물 = null;
		PreparedStatement 명령자 = null;
		ResultSet 게시물표 = null;
		String sql = "select * from board where no = ?";
		try {
			명령자 = conn.prepareStatement(sql);
			명령자.setInt(1, 번호);
			게시물표 = 명령자.executeQuery();
			if (게시물표.next()) {
				String 제목 = 게시물표.getString("title");
				String 내용 = 게시물표.getString("contents");
				찾는게시물 = new Board();
				찾는게시물.setNo(번호);
				찾는게시물.setTitle(제목);
				찾는게시물.setContents(내용);
			}
		} catch (SQLException e) {
		}
		return 찾는게시물;
	}

	public int count() {
		String sql = "select count(*) from board";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
		}
		return 0;
	}

	public boolean 목록지우다() {
		String sql = "TRUNCATE TABLE board";
		Statement stmt = null;
		
		if(count() > 0) {
			
		}

		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
