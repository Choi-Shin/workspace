<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.stone.springmvc.common.Board" %>    
<% List<Board> boards = (List<Board>)request.getAttribute("boards"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>게시물 목록창</h1>
   <ul>
   <%
       for(int i=1; i<= boards.size(); i++){
    	   Board board=boards.get(i-1);
   %>
   		<li><%=i%> 
   		    <a href="detail?no=<%= board.getNo()%>">
   		       <%=board.getTitle()%>
   		    </a>
   		</li>	 	   
   <%
       }
   
   %>
   </ul>
  
</body>
</html>