<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<link rel="stylesheet" type="text/css" href="my.css">
<style type="text/css">
body {
	margin: 100px;
}
</style>

<script type="text/javascript"></script>
<script type="text/javascript">
function isNum(su){
	if("0" <= su && "9" >= su){
		return true;
	}
	return false;
}
function isNumInclude(str){
	for(var i=0; i<str.length;i++){
		var s=str.charAt(i);
		//if(isNum(s)){
		if(!isNaN(s)){
			return true;
		}
	}
	return false;
}
function regCheck(){
	var id=document.getElementById("ID");
	var pw=document.getElementById("PW");
	var pw2=document.getElementById("PW_check");
	 homePage=document.getElementById("HOMEPAGE");
	
	if(!isNumInclude(pw.value)){
		alert("비밀번호는 숫자를 포함해야 함~~~");
		pw.focus();
		return;
	}
	if(pw.value != pw2.value){
		alert("비밀번호와 비밀번호 확인은 같아야 함~~~");
		pw.focus();
		return;
	}
	if(!dotCheck()){
		alert("홈페이지는 형식에 맞게 입력해 주세요.");
		homePage.focus();
		return;
	}
	regForm.submit();
}//check()

function dotCheck(){
	var hvalue=homePage.value;
	for(var i=0;i<hvalue.length;i++){
		if(hvalue.charAt(i)=="."){
			return true;
		}
	}
	return false;
}

function myChange(ob){
	alert("주소변경:"+ob.value);
}
function fun_name(){
	alert("AAAA");
}
</script>
</head>
<body bgcolor="pink">
	<form name="regForm" method=post action="/CMSProject/main.do?action=MEMBERSAVE">
		<table>
			<tr>
				<td id="myid" align="right" width="50%">아이디</td>
				<td width="50%"><input type="text" name="ID" id="ID"
					required="required"></td>
			</tr>

			<tr>
				<td id="myid" align="right">비밀번호</td>
				<td><input type="password" name="PW" id="PW"></td>
			</tr>

			<tr>
				<td id="myid" align="right">비밀번호 확인</td>
				<td><input type="password" name="PW_check" id="PW_check"></td>
			</tr>

			<tr>
				<td class="name" align="right">이름</td>
				<td><input type="text" name="NAME"></td>
			</tr>

			<tr>
				<td class="name" align="right">닉네임</td>
				<td><input type="text" name="NICKNAME"></td>
			</tr>

			<tr>
				<td class="name" align="right">성별</td>
				<td><input type="radio" name="SEX" value="man" checked>남성
					<input type="radio" name="SEX" value="woman">여성<input
					type="radio" name="SEX" value="etc">기타</td>
			</tr>

			<tr>
				<td align="right">이메일</td>
				<td><input type="text" name="MAIL_ID"> @ <select
					name="MAIL_HOST">
						<option value="1">naver.com</option>
						<option value="2">gmail.com</option>
						<option value="3">daum.net</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">홈페이지/블로그</td>
				<td><input type="url" name="HOMEPAGE" id="HOMEPAGE"
					required="required" /></td>
			</tr>
			<tr>
				<td align="right">거주지</td>
				<td><select name="ADDRESS" id="address"
					onChange="myChange(this)">
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="광주">광주</option>
						<option value="경기도">경기도</option>
						<option value="강원">강원</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">취미</td>
				<td><input type="checkbox" name="HOBBY" value="h1">컴퓨터<input
					type="checkbox" name="HOBBY" value="h2">여행<input
					type="checkbox" name="HOBBY" value="h3">독서 <input
					type="checkbox" name="HOBBY" value="h4">영화</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="가입하기"><input
					type="reset" value="초기화"> <a href="login.jsp"> 로그인화면</a>
			</tr>
		</table>
	</form>
</body>
</html>