<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.hansung.CMS.Member" session = "true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%
Member m = (Member)request.getAttribute("member");
%> --%>
<c:set var="m" value='<%=(Member)request.getAttribute("member") %>'/>
<body bgcolor=pink>
	<h2>결과 화면</h2>
	<hr>
	<table border=1>
		<tr>
			<td>id</td>
			<td>${m.getId() }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${m.getName() }</td>
		</tr>
		<tr>
			<td>nick</td>
			<td>${m.getNick() }</td>
		</tr>
		<tr>
			<td>sex</td>
			<td>${m.getSex() }</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${m.getEmail() }</td>
		</tr>
		<tr>
			<td>home page</td>
			<td>${m.getHomepage() }</td>
		</tr>
		<tr>
			<td>address</td>
			<td>${m.getAddress() }</td>
		</tr>
		<tr>
			<td>hobby</td>
			<td>
				${m.getHobbyString() }
			</td>
		</tr>
	</table>
	<a href = "/CMSProject/main.do?action=LOGOUT">로그인 화면</a><br>
	<a href = "/CMSProject/main.do?action=MEMBERLIST">회원 목록</a><br>
</body>
</html>