<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.hansung.CMS.*" session = "true"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function delete_confirm(id){
		var res = confirm('really?');
		if(res){
				location.href="main.do?action=DELETE&id="+id;
		}
	}
</script>
<body>
	<%
		ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	%>
	<h2>회 원 목 록</h2>
	<table>
		<th border=1 align = center>아이디</th>
		<th border=1 align = center>이름</th>
		<th border=1 align = center>닉네임</th>
		<th border=1 align = center>삭제</th>
		<th border=1 align = center>수정</th>
		<tr>
			<%
			for(Member m : list){
				%>
			<td><%=m.getId() %></td>
			<td><a href = "/CMSProject/main.do?action=MEMBERDETAIL&id=<%=m.getId() %>"><%=m.getName() %></a></td>
			<td><%=m.getNick() %></td>
			<td><button onclick="delete_confirm('<%=m.getId()%>');">삭제</button>
			<td><input type=button value="수정" onclick="location.href('main.do?action=MODIFY&id=<%=m.getId()%>')"></td>
		</tr>
		<%
			}
			%>
			
	</table>
</body>
</html>