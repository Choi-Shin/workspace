<%@page import="com.example.service.BoardService"%>
<%@page import="com.example.common.Board"%>
<%@page import="com.example.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//1.요청 제어(controller)
String 제목 = request.getParameter("title");
String 내용 = request.getParameter("contents");
Board board = new Board();
board.setTitle("제목");
board.setContents("내용");
BoardService bs = new BoardService();
int result = bs.등록하다(board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3.응답 화면생성-view역할 -->
	<%
	if (result > 0) {
	%>등록되었습니다.
	<br>
	<a href="main.jsp">메인화면으로</a>
	<%
	} else {
	%> 등록에 실패하였습니다.
	<%
	}
	%>
</body>
</html>