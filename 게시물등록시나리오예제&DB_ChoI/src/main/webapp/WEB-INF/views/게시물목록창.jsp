<%@page import="java.util.List"%>
<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List <Board> boards = (List<Board>) request.getAttribute("boards");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
	<c:if test="${!empty boards}">
		<table border="1">
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.no}</td>
					<td>
					<a href="detail?no=${board.no}">${board.title}</a>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<form action="prepare">
		<button type="submit">게시물등록</button>
	</form>
	<form action="remove">
		<button type="submit">목록지우기</button>
	</form>
</body>
</html>