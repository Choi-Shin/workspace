<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 상세</h1>
제목: ${board.title}<br>
내용: <textarea rows="5" cols="25" readonly="readonly">${board.contents}</textarea><br>
<a href="list">목록</a>
</body>
</html>