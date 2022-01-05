<%@page import="com.example.common.Board"%>
<%@page import="com.example.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//1.요청 제어(controller)
String 제목 = request.getParameter("title");
String 내용 = request.getParameter("contents");
Board board = new Board();
board.setTitle("제목");
board.setContents("내용");
//2.업무(service+DB)
//	1)업무 규칙 검사(무결성 검사, 접근 권한 체크)
System.out.println("업무 규칙 검사 코드 실행 완료");
//	2)DB처리(add=>저장)
//	  -jdbc
DAO dao = DAO.getInstance();
int result = dao.입력하다(board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3.응답 화면생성-view역할 -->
	<%
	if (result > 0) {
	%>등록되었습니다.
	<br>
	<%=제목%><br>
	<%=내용%><br>
	<%
	} else {
	%> 등록에 실패하였습니다.
	<%
	}
	%>




</body>
</html>