<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.hansung.CMS.Member" session = "true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = (String)session.getAttribute("user");
	%>
	<%=user%>님 반갑습니다.<br>
	<h2>오늘은 주주총회날 입니다.</h2>
	<ol>
		<li>엘리베이터 이용을 자제해주세요.</li>
		<li>조용히 해 주세요.</li>
		<li>18층을 이용하지 말아주세요.</li>
	</ol>
	<a href = "/CMSProject/main.do?action=LOGOUT">로그아웃</a><br>
	<a href = "/CMSProject/main.do?action=MEMBERLIST">회원목록</a>
</body>
</html>