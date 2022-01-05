<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 등록 테스트용 화면</h1>
	<p>본 화면은 게시물등록 요청용 화면으로 구조와 관계 없음</p>
	<p>add.jsp요청부터 구조와 관계 있음</p>
	<form action="add.jsp" method="post">
	제목<input type="text" name="title" /><br>
	내용<textarea name="contents" cols="25" rows="5"></textarea><br>
	<input type="submit" value="등록" />
	</form>
</body>
</html>