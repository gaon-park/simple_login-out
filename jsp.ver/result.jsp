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
	<%=user %>로그인 결과 페이지..<br>
	<a href = "notice.jsp">공지사항 보기</a>
</body>
</html>