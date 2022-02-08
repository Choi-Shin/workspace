<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="com.stone.springmvc.board.common.*" %>    
<%
    Board board=(Board)request.getAttribute("board");
    Boolean isWriter=(Boolean)request.getAttribute("isWriter");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 상세</h1>
제목:<%=board.getTitle() %><br>
내용:<textarea rows=5 cols=25 readonly><%=board.getContents() %></textarea><br>
적성자:${board.writer.name}<br>
조회수:${board.views}<br>
<button>확인</button>
<!-- 글쓴이와 로그인한 회원이 동일 인 일때 -->
<%if( isWriter!=null && isWriter==true ){ %>
<button onclick="location.href='#'">삭제</button>
<button onclick="location.href='#'">수정</button>
<%} %>
<button onclick="location.href='/boards'">목록</button>
</body>
</html>