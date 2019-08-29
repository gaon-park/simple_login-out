<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session = "true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check() { //로그인 버튼 클릭시 수행

		document.LoginForm.submit();//form 데이터를 서버로 전송, next.html로
	}
</script>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg == null) {

			msg = "";
		}
	%>
	<%=msg%>
	<h2>로그인해 주세요.</h2>
	<p />
	<form action="/CMSProject/main.do?action=LOGIN" name="LoginForm"
		method="post">
		<!-- <input type = "hidden" name = "action" value = "LOGIN"> -->
		<table>
			<tr>
				<th id="myid">ID :</th>
				<td><Input type="text" id='user' name='user' /></td>
			</tr>
			<tr>
				<th class="myclass">PW :</th>
				<td><Input type="password" id="pass" name='pass' /></td>
			</tr>
		</table>
		<Input type="button" value="로그인" onClick="check()" /> <input
			type="button" value="회원가입"
			onClick="location.href='/CMSProject/jsp.ver/member.jsp'" />

	</form>
	<p></p>
</body>
</html>