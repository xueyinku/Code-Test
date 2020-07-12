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
		.	redfont{
		color: red;}
	</style>
</head>
<body>
	<div>
	<h1>注册页面</h1>
	<form action="CusRegisterServlet" method="post">
	<table>
	<tr>
		<td>手机号码</td>
		<td><input type="text" name="tel" placeholder="11位手机号" /></td>
		<td class="redfont">*请输入11位手机号</td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" name="new_pasword" placeholder="6位密码" /></td>
		<td class="redfont">*请输入6位密码</td>
	</tr>
	<tr>
		<td>确认密码</td>
		<td><input type="text" name="con_pasword"  /></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="checkbox" />同意xxx协议</td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" id="sub"/></td>
		<td><a href="cus_login.jsp">登陆</a></td>
	</tr>
	</table>
	</form>
	</div>

</body>
</html>