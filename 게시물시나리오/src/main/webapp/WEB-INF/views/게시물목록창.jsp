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
	<%
	if (session.getAttribute("boardArr") != null) {
		int count = 1;
	%>
	<table border="1">
		<c:forEach items="${sessionScope.boardArr}" var="list">
			<tr>
				<td><%=count %></td>
				<td><c:out value="${list.title}" /></td>
				<td><c:out value="${list.contents}" /></td>
			</tr><% count++; %>
		</c:forEach>
	</table>
	<%
	}
	%>
	<form action="게시물등록준비">
	<button type="submit">게시물등록</button>
	</form>
	<form action="목록지우기">
		<button type="submit">목록지우기</button>
	</form>
</body>
</html>