<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function 우편번호조회하다() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.querySelector("#post").value = data.zonecode;
				document.querySelector("#address").value = data.roadAddress;

				document.querySelector("#detailAddress").focus();
			}
		}).open();
	}
	function id를중복검사하다() {
		document.querySelector("#id").value = "";
		window.open("/id", "", "width=500,height=300");
	}
	function id를받다(id) {
		document.querySelector("#id").value = id;
	}

	function 회원등록하다() {
		let 성명 = document.querySelector("#name").value;
		if (성명.trim() == "") {
			alert("이름을 입력하세요.");
			return false;
		}
		let 아이디 = document.querySelector("#id").value;
		if (아이디.trim() == "") {
			alert("아이디를 입력하세요.");
			return false;
		}
		let 비밀번호 = document.querySelector("#password").value;
		if (비밀번호.trim() == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		let 비밀번호2 = documetn.querySelector("#password2").value;
		if (비밀번호.trim() == "") {
			alert("비밀번호를 한번 더 입력하세요.");
			return false;
		}
		if(비밀번호 != 비밀번호2) {
			alert("비밀번호가 서로 일치하지 않습니다.");
			return false;
		}
		let 이메일1 = document.querySelector("#email1").value;
		if (이메일1.trim() == "") {
			alert("이메일을 입력하세요.");
			return false;
		}
		let 이메일2 = document.querySelector("#email2").value;
		let 이메일 = 이메일1 + "@" + 이메일2;
		document.querySelector("#email").value = 이메일;
		return true;
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록</h1>
	<form onsubmit="return 회원등록하다()" action="/member" method="post" >
		성명<input type="text" name="name" /><br>
		프로필<img id="profile" src="/img/no_image.jpeg" width="100px" height="auto"/> <br>
		<input type="file" name="profile" id="profilefile"/>
		전화번호<input type="text" name="tel" /><br> 
		우편번호<input type="text" name="post" id="post" />
		<input type="button" onclick="우편번호조회하다()" value="우편조회" /><br> 
		주소<input type="text" name="address" id="address" size=30 /><br>
		상세 주소<input type="text" name="detailAddress" id="detailAddress" /><br>
		ID<input type="text" name="id" id="id" /> 
		<input type="button" onclick="id를중복검사하다()" value="중복검사" /><br> 
		비밀번호<input type="password" name="password" id="password" /> 
		<input type="password" name="password2" id="password2" /> <br>
		<input type="hidden" id="email"/>
		이메일<input type="email" name="email1" id="email1">@ 
		<select>
			<option value="naver.com" id="email2">naver.com
			<option value="daum.net" id="email2">daum.net
			<option value="gmail.com" id="email2">gmail.com
		</select><br> 
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>