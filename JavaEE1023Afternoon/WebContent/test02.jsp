<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userMessage" method="post">
	<input type="text" name="uesr_name" />
	你最喜欢的水果：
	<select name="firit">
		<option>苹果</option>
		<option>西瓜</option>
		<option>葡萄</option>
	</select>
	对它的评价：
	<textarea name="evaluate" id="" cols="30" rows="10"></textarea>
	<input type="submit" value="提交" />
	</form>
</body>
</html>