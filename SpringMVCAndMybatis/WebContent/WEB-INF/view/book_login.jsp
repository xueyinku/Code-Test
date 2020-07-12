<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${mes}
	<form action="/SpringMVCAndMybatis/UserController/goindex" method="post">
		账号：<input type="text" name="id"/>
		密码:<input type="text" name="password"/>
		<input type="submit" />
	</form>
</body>
</html>