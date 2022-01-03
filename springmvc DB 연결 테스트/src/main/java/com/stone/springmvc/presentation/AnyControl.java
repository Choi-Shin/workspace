package com.stone.springmvc.presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnyControl {
	Connection con = null;

	@RequestMapping("test")
	public void process() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8&&ServerTimezone=UTC",
					"root", "1234");
			System.out.println("Success!!");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
