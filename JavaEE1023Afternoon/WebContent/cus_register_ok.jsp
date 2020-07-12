<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册成功</h1>
	手机号为：<%String tel = (String)request.getAttribute("user_tel"); %>
	<%=tel %>
	<br />
	跳转到 <a href="cus_login.jsp">登陆</a>画面
	
</body>
</html>