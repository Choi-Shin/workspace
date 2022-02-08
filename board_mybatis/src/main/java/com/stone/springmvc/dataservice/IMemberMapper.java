package com.stone.springmvc.dataservice;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.stone.springmvc.common.Member;

@Mapper
public interface IMemberMapper {
	
	@Select("select * from member where no = #{no}")
	@Results(value = {
			@Result(property = "no", column = "no"),
			@Result(property = "name", column = "name")
	})
	Member findByNo();
	
}
