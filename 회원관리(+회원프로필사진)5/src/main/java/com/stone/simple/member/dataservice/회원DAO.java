package com.stone.simple.member.dataservice;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.stone.simple.member.common.Member;

import config.DBConfig;

@Repository
public class 회원DAO {
	public boolean 아이디가있는가(String id) {
		boolean 아이디있다 = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			PreparedStatement 명령자 = con.prepareStatement("select count(*) from member where id=?");
			명령자.setString(1, id);
			ResultSet 아이디갯수표 = 명령자.executeQuery();
			if (아이디갯수표.next()) {
				if (아이디갯수표.getInt(1) > 0) {
					아이디있다 = true;
				}
				System.out.println("DB확인");// @MyTest
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(아이디있다);// @MyTest
		return 아이디있다;
	}

	public Member 찾는다by번호(int 회원번호) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where no = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 회원번호);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setNo(회원번호);
				member.setId(rs.getString("id"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setDetailAddress(rs.getString("detailaddress"));
				member.setName(rs.getString("name"));
				member.setPost(rs.getString("post"));
				member.setPassword(rs.getString("password"));
				member.setProfile(rs.getBytes("profile"));
				member.setTel(rs.getString("tel"));
				member.setState(rs.getString("state").charAt(0));
				rs.close();
				pstmt.close();
				con.close();
				return member;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * CREATE TABLE IF NOT EXISTS `db2`.`member` ( `no` INT NOT NULL AUTO_INCREMENT,
	 * name VARCHAR(45), `tel` VARCHAR(20) NULL, `post` CHAR(5) NULL, `address`
	 * VARCHAR(45) NULL, `detailaddress` VARCHAR(45) NULL, `id` VARCHAR(45) NOT
	 * NULL, `password` VARCHAR(45) NULL, `email` VARCHAR(45) NULL, `state` CHAR(1)
	 * NULL, `rdate` TIMESTAMP NULL DEFAULT current_timestamp, PRIMARY KEY (`no`),
	 * UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE) ENGINE = InnoDB;
	 */
	public void 저장하다(Member 새회원) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			PreparedStatement 명령자 = con.prepareStatement(
					"insert into member(name,tel,profile,post,address,detailaddress,id,password,email) values(?,?,?,?,?,?,?,?,?)");
			명령자.setString(1, 새회원.getName());
			명령자.setString(2, 새회원.getTel());
			Blob blob = new SerialBlob(새회원.getProfile());
			명령자.setBlob(3, blob);
			명령자.setString(4, 새회원.getPost());
			명령자.setString(5, 새회원.getAddress());
			명령자.setString(6, 새회원.getDetailAddress());
			명령자.setString(7, 새회원.getId());
			명령자.setString(8, 새회원.getPassword());
			명령자.setString(9, 새회원.getEmail());
			System.out.println(명령자.toString());
			명령자.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
