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
	Boolean a = (Boolean)request.getAttribute("isForward");
%>
	ccc 요청으로 "forward/:aaa" 호출<br>
	현재 aaa.jsp 파일로 포워드 되었음.<br>
	isForward??? <%=a %>
</body>
</html>