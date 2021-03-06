<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<% 
     List<Board> boards = (List<Board>)request.getAttribute("boards");
     int  현재페이지번호 = (int)request.getAttribute("pageNo");
     int 마지막페이지번호=(int)request.getAttribute("lastPageNo");
     int 블럭당최대페이지수=5;
     int 블럭시작페이지번호=현재페이지번호-((현재페이지번호-1)%블럭당최대페이지수);
     int 예상블럭끝페이지번호=블럭시작페이지번호+(블럭당최대페이지수-1);
     int 블럭끝페이지번호=(예상블럭끝페이지번호<=마지막페이지번호)?예상블럭끝페이지번호:마지막페이지번호;		 
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
  text-decoration-line: none;
}
</style>
</head>
<body>
  <!-- 게시물목록 출력 -->
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
  <!-- 페이지번호들 블럭 출력 -->
  <%if(블럭시작페이지번호>1){ %>
  	<a href="list?pageno=<%=블럭시작페이지번호-1 %>"> << </a>
  <%} %>
  <%
     for(int 페이지번호=블럭시작페이지번호; 페이지번호<=블럭끝페이지번호;페이지번호++){ 
        String 출력페이지번호=(페이지번호==현재페이지번호)?"["+페이지번호+"]":" "+페이지번호+" ";
     %>
       <a href="list?pageno=<%=페이지번호 %>">
           <%=출력페이지번호 %>
        </a>
        &nbsp;&nbsp; 
  <% } %>
  <%if(블럭끝페이지번호<마지막페이지번호){ %>
  	<a href="list?pageno=<%=블럭끝페이지번호+1 %>"> >> </a>
  <%} %>  
</body>
</html>