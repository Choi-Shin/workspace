package com.stone.springmvc.dataservice;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.common.Board2;

@Mapper
public interface IBoardMapper {
	//save3,selectAll3에 대한 객체,테이블관계가 아래와 같다고 가정하면
	// board-1-to-1->member
	/*
	class Member{
	    int no;//회원번호
	    String name;
	}
	class Board {
		int no;//게시물번호
		String title;
		String contents;
		Member writer;//작성한 회원 get/setWriter()
	}
	create table member(
	    no int,  --회원번호
	    name varchar(20)
	)

	create table board2(
	    no int primary key auto_increment,
	    title varchar(20),
	    contents varchar(100),
	    writer int //작성 회원번호 member.no 값을 참조함
	)
	 */
	
	// board.getTtitle()
	@Insert("insert into board(title,contents) values(#{title},#{contents})")
	void save2(Board board);

	@Insert("insert into board2(title,contents,writer) values(#{title},#{contents},#{writer})")
	void save3(Board2 board);

	@Select("select * from board")
	@Results(value = { 
			@Result(property = "no", column = "no"), 
			@Result(property = "title", column = "title"),
			@Result(property = "contents", column = "contents"), })
	List<Board> selectAll2();
	
	@Select("select * from board2")
	@Results(value = { 
			@Result(property = "no", column = "no"), 
			@Result(property = "title", column = "title"),
			@Result(property = "contents", column = "contents"),
			@Result(property = "writer", column = "writer", one = @One(select = "com.stone.springmvc.dataservice.IMemberMapper.findByNo")) })
	List<Board2> selectAll3();


}
