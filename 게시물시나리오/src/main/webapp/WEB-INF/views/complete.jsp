<%@page import="java.util.ArrayList"%>
<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Board board = new Board();
board.setTitle(request.getParameter("title"));
board.setContents(request.getParameter("contents"));
session = request.getSession();
ArrayList<Board> b = new ArrayList<>();
if (session.getAttribute("boardArr") != null) {
	b.addAll((ArrayList<Board>) session.getAttribute("boardArr"));
	b.add(board);
} else {
	b.add(board);
}
session.setAttribute("boardArr", b);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${board.title} 제목의 글이 등록되었습니다.
	<br>
	<form action="목록" method="post">
		<button type="submit">목록보기</button>
	</form>
</body>
</html>