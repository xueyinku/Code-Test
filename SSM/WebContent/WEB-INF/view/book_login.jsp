<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="<%=request.getContextPath() %>/UserController/goindex" method="post">
		用户名：<input type="text" name="id" />
		<br />
		密码：<input type="text" name="password" />
		<br />
		<input type="submit" value="登陆 " />
	</form>

</body>
</html>