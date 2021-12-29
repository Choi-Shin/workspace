<%@page import="java.util.ArrayList"%>
<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session = request.getSession(false);
ArrayList<Board> b = (ArrayList<Board>) session.getAttribute("boardArr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach items="b" var="list">
			<tr>
				<td><c:out value="${list.title}" /></td>
				<td><c:out value="${list.contents}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>