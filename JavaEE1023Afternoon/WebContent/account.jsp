<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	text{ 
	width:100px;
	height: 50px;
	}
	#sub{
	width:100px;
	height: 50px;
	background-color: gray;
	text-align: center;
	line-height: 50px;
	}
	</style>
</head>
<body>
	<div>
	<h1>转账画面</h1>
	<form action="AccountServlet" method="post">
	<table>
	<tr>
		<td>Form:</td>
		<td><input type="text" name="from" /></td>
	</tr>
	<tr>
		<td>To:</td>
		<td><input type="text" name="to" /></td>
	</tr>
	<tr>
		<td>Money:</td>
		<td><input type="text" name="money" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="转账" id="sub" /></td>
	</tr>
	</table>
	</form>
	</div>
</body>
</html>