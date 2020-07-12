<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		请输入验证码：<input type="text" name="code">
		<img src="ImgServlet" onclick="refresh(this)"/>
		<br>
		<input type="submit" value="验证"/>
	</form>
</body>
<script type="text/javascript">
	function refresh(element) {
		//加入随机数的目的为了避免因为缓存机制的原因，导致请求路径相同而页面不刷新的问题
		element.src = "ImgServlet?r=" + Math.random();
	}
</script>
</html>



