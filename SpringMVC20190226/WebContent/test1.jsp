<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="aa/bb?id=1001&name=tom&age=19">跳转</a>
	
	<form action="aa/m2" method="post">
		学号：<input type="text" name="id"/>
		<br>
		姓名：<input type="text" name="name"/>
		<br>
		成绩：<input type="text" name="score"/>
		<br>
		<input type="submit" value="添加"/>
	</form>
</body>
</html>