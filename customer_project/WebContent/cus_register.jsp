<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String alert = (String)request.getAttribute("alert"); %>
<% if (!"".equals(alert) && null != alert){ %>
	<%=alert %>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员信息注册</title>
<!--加载btn和text格式-->
		<link rel="stylesheet" type="text/css" href="customer_btn_and_text_style.css"/>
<!-- 		<!-- 新 Bootstrap 核心 CSS 文件 --> 
 		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css"> 
<!-- 		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
 		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css"> 
<!-- 		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script 	src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 		<!-- 最新的 Bootstrap 核心 JavaScript 文件 --> 
		<script 	src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> 
</head>
<body>
		<div class="page-header" contenteditable="true"></div>
		<h1 style="margin-left: 120px;">注册页面</h1>
		<form action="AdminServlet" method="post">
		<input type="hidden" name="flag" value="gotoregisterok" />
		<table>
			<tr>
				<td class="txtregist">手机号码 </td>
				<td>
					<input class="textlogin2" type="text" name="customer_reg_tel" placeholder="11位手机号" /><input class="submitregist" type="button"value="发送" /></td>
				<td class="txtredregist">*请输入11位手机号</td>
			</tr>
			<tr>
				<td class="txtregist">验证码</td>
				<td>
					<input class="textlogin1" type="text" placeholder="4位验证码" />
				</td>
				<td class="txtredregist">*请输入4位验证码</td>
			</tr>
			<tr>
				<td class="txtregist">用户名</td>
				<td>
					<input class="textlogin1" type="text" placeholder="请输入用户名" name="admin_name" />
				</td>
				<td class="txtredregist">*请输入5-18位用户名</td>
			</tr>
			<tr>
				<td class="txtregist">密码</td>
				<td>
					<input class="textlogin1" type="text" placeholder="请输入密码" name="admin_password"/>
				</td>
				<td class="txtredregist">*请输入6-12位密码</td>
			</tr>
			<tr>
				<td class="txtregist">确认密码</td>
				<td><input  class="textlogin1" type="password" name="confirm_password"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="checkbox" />同意XXX协议</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input class="submitall" type="submit" value="注册"/>
				</td>
				<td>
				<a href="AdminServlet?flag=gotologin">登录</a>
				</td>
			</tr>
		</table>
		</form>
<!-- 		</div> -->
</body>
</html>