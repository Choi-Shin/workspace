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
	if (session.getAttribute("boardArr") != null) {
		session.invalidate();
	%>
	목록이 초기화되었습니다.<br>
	<%
	} else {
	%>
	지울 게시글이 존재하지 않습니다.<br>
	<%
	}
	%>
	<a href="index.jsp">메인화면으로</a>
</body>
</html>