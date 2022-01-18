<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function 우편번호조회하다(){
	  new daum.Postcode({
          oncomplete: function(data) {
         		document.querySelector("#post").value=data.zonecode;
         		document.querySelector("#post").value=data.roadAddress;
         		
         		document.querySelector("#detailAddress").focus();
          }
      }).open();
}
function id를중복검사하다(){
	document.querySelector("#id").value="";
	window.open("/id","","width=500,height=300");
}
function id를받다(id){
	document.querySelector("#id").value=id;
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원등록</h1>
<form> 
성명<input type="text" name="name"/><br>
전화번호<input type="text" name="tel"/><br>
우편번호<input type="text" name="post" id="post"/>
     <input type="button" onclick="우편번호조회하다()" value="우편조회"/><br>
주 소<input type="text" name="address" id="address" size=30/><br>
상세 주소<input type="text" name="detailAddress" id="detailAddress"/><br>
ID<input type="text" name="post" id="id"/>
     <input type="button" onclick="id를중복검사하다()" value="중복검사"/><br>
</form>
</body>
</html>