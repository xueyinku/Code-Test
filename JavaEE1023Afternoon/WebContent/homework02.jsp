<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#sub{
		width:100px;
		height:30px;
		text-align: center;
		line-height:30px; 
		background-color: gray;
		}
		text{
		width:100px;
		height:30px;
		}
	</style>
</head>
	<body>
	<div>
	<h1>注册页面</h1>
	<form action="RegServlet" method="post">
	<table >
		<tr>
			<td>账号</td>
			<td><input type="text" name="account" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="password" /></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="text" name="confirm_pas" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" id="sub"/></td>
		</tr>
	</table>
	</form>
	</div>

</body>
</html>