<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${success == true}">
	목록이 초기화되었습니다.<br>
	</c:if>
	<c:if test="${success == false}">
	지울 게시글이 존재하지 않거나, 삭제에 실패하였습니다.
	<br></c:if>

	<a href="index.jsp">메인화면으로</a>
</body>
</html>