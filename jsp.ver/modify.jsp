<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.hansung.CMS.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 100px;
}
</style>
<%
	Member m = (Member)request.getAttribute("member");
	String []hobby = m.getHobby();
	String []hobs = {"컴퓨터", "여행", "독서", "영화"};
	String [][]sex = {
			{"man", "남성"}, {"woman", "여성"}, {"etc", "기타"}
	};
%>
<script type="text/javascript">
	function myChange(ob) {
		alert("주소변경:" + ob.value);
	}
</script>
</head>
<c:set var="m" value='<%=(Member) request.getAttribute("member")%>' />
<body onload="javascript:checkEx();">
	<h2>수정 페이지</h2>
	<form name=modifyfrom method=post action="main.do?action=MODIFYSAVE">
		<table>
			<tr>
				<td id="myid" align="right" width="50%">아이디</td>
				<td width="50%"><input type=text name = "ID" value='${m.getId() }' readonly></td>
			</tr>

			<tr>
				<td id="myid"  align="right">비밀번호</td>
				<td><input type=text name = "PW" value='${m.getPw() }'></td>
			</tr>

			<tr>
				<td class="name" align="right">이름</td>
				<td><input type=text name = "NAME" value='${m.getName() }'></td>
			</tr>

			<tr>
				<td class="name" align="right">닉네임</td>
				<td><input type=text name="NICKNAME" value='${m.getName() }'></td>
			</tr>

			<tr>
				<td class="name" align="right">성별</td>
				<td>
					<%
						for(int i = 0; i < 3; i++){
							%><input type="radio" name="SEX" value="<%=sex[i][0]%>"<%
									if(m.getSex().equals(sex[i][0])){
										%>checked<%
									}
							%>><%=sex[i][1] %><%
						}
					%>
				</td>
			</tr>

			<tr>
				<td align="right">이메일</td>
				<td><input type=text name="MAIL_ID" value='${m.getEmail() }'></td>
			</tr>
			<tr>
				<td align="right">홈페이지/블로그</td>
				<td><input type=text name="HOMEPAGE" value='${m.getHomepage() }'></td>
			</tr>
			<tr>
				<td align="right">거주지</td>
				<td><input type=text name="ADDRESS" value='${m.getAddress() }'></td>
			</tr>
			<tr>
				<td align="right">취미</td>
					<td><%
						for(int i = 0; i < 4; i++){
							%><input type=checkbox name=HOBBY value="h<%=i+1%>"<%
							for(int j = 0; j < hobby.length; j++){
								if(hobby[j].equals("h"+(i+1))){
									%>checked<%	}
							}
							%>><%=hobs[i] %><%
						}
					%>
					</td>
					
			</tr>
			<tr>
				<td colspan="2" align="right"><input type=submit value="저장">
					<a href="/CMSProject/main.do?action=MEMBERLIST">회원 목록</a>
			</tr>
		</table>
	</form>
	<br>
</body>
</html>