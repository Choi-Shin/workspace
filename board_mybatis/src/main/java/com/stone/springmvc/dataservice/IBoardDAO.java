package com.stone.springmvc.dataservice;

import java.util.List;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.common.Board2;

public interface IBoardDAO {
	void 저장하다(Board board);
	void 저장하다(Board2 board);
	List<Board> 기본조회하다();
	List<Board2> 작성자포함조회하다();
}
