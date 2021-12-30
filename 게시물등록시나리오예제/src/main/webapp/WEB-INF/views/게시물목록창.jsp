<%@page import="java.util.ArrayList"%>
<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session = request.getSession();
String title = request.getParameter("title");
String contents = request.getParameter("contents");
Board board = null;
if (title != null && !title.isEmpty()) {
	board = new Board();
	board.setTitle(title);
	board.setContents(contents);
}
ArrayList<Board> b = null;
if (session.getAttribute("boardArr") != null && board != null) {
	b = (ArrayList<Board>) session.getAttribute("boardArr");
	b.add(board);
	session.setAttribute("boardArr", b);
} else if (session.getAttribute("boardArr") == null && board != null) {
	b = new ArrayList<>();
	b.add(board);
	session.setAttribute("boardArr", b);
} else {
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 목록창</h1>
	<%
	if (b != null) {
	%>
	<ul>
		<%
		for (int i = 0; i < b.size(); i++) {
		%>
		<li>글번호: <%=i+1%>
		<li>제목:<%=b.get(i).getTitle()%>
		<li>내용:<%=b.get(i).getContents()%> <br> <br> <%
 }
 %>
	</ul>
	<%
	}
	%>
	<form action="prepare">
		<button type="submit">게시물등록</button>
	</form>
	<form action="remove">
		<button type="submit">목록지우기</button>
	</form>
</body>
</html>