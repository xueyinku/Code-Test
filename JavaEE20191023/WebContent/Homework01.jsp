<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="TestServlet1" method="post" >
	<input type="text" name="num1">
	<input type="text" name="num2"/>
	<select name="symbol" id="select">
	<option >+</option>
	<option >-</option>
	<option >*</option>
	<option >/</option>
	</select>
	<input type="submit" value="calculate" id="calBtn"/>
	</form>
	

</body>
	<script>
	var num1 = document.getElementById("num1");
	var num2 = document.getElementById("num2");
	
	</script>
</html>