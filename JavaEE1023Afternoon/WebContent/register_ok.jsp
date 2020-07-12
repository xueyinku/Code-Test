<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>注册成功</h1>
	<br />
<!-- 	接收后端给的账号密码 -->
	您的账号为：<%String user_account = (String)request.getAttribute("ok_account");%>
	<%= user_account %>
	<br />
	您的密码为：<%String user_password =(String) request.getAttribute("ok_password");%>
	<%= user_password %>
	</div>

</body>
</html>