<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	text{width: 200px;
		height:40px; 
		}
		#sub{width: 200px;
		height: 40px;
		
		border-radius: 10px;
		background-color: blue;
		text-align: center;
		line-height: 40px;
		color: white;
		font-size: 20px;
		letter-spacing: 5px;}
	</style>
</head>
<body>
	<div>
	<h1>会员积分管理系统</h1>
	<form action="cus_index.jsp" method="post">
	<table>
	<tr>
		<td>账号</td>
		<td><input type="text" placeholder="请输入账号" name="account" /></td>
		<td></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" placeholder="请输入密码" name="password" /></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="登陆"  id="sub"/></td>
		<td> <a href="cus_register.jsp" >注册</a></td>
	</tr>
	</table>
	</form>
	</div>
</body>
</html>