<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 관리 프로그램</title>
</head>
<body>
<c:if test="${!empty result}">
${afterdelete }
</c:if>
	<form action="prepare">
		<button type="submit">게시물등록</button>
	</form>
	<form action="list">
		<button type="submit">게시물목록</button>
	</form>
</body>
</html>