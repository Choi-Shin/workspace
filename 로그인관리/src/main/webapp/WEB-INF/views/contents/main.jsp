<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
boolean isLogin = (boolean) request.getAttribute("isLogin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (isLogin) {
	%>
	${loginUser.id}님
	<br> 로그인성공
	<br>
	<a href="../member">회원정보보기</a>
	<a href="../logout">로그아웃</a>
	<%
} else {
%>
	<a href="../login">로그인</a>
	<%
	}
	%>
</body>
</html>