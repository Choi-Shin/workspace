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
	request.setCharacterEncoding("UTF-8");
	Board newBoard = (Board) request.getAttribute("newBoard");
	%>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${newBoard.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${newBoard.contents}</td>
		</tr>
	</table>
	<a href="index.jsp">메인화면</a>
</body>
</html>