<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String 도시명 = (String) request.getAttribute("city");
	int 크기 = (Integer) request.getAttribute("size");
	Board board = (Board) request.getAttribute("board");
	%>
도시명: <%=도시명 %><br>
크기: <%=크기 %><br>
게시물 제목: <%=board.getTitle() %><br>
게시물 내용: <%=board.getContents() %><br>
</body>
</html>