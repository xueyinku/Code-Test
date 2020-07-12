<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String name = (String)request.getAttribute("admin_name"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功页面</title>
<!--加载btn和text格式 -->
		<link rel="stylesheet" type="text/css" href="customer_btn_and_text_style.css"/>
<!--  		新 Bootstrap 核心 CSS 文件 -->
 		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css"> 
<!--  		可选的Bootstrap主题文件（一般不用引入） -->
 		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css"> 
<!--  		jQuery文件。务必在bootstrap.min.js 之前引入  -->
 		<script 	src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script> 
<!-- 		最新的 Bootstrap 核心 JavaScript 文件  -->
 		<script 	src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="page-header" contenteditable="true"></div>
	<h1 style="margin-left: 120px;">注册成功</h1>
<%-- 	用户名为:<%String tel = (String)request.getAttribute("cus_reg_ok_tel"); %> --%>
<%-- 	<%=tel %> --%>
	用户名为:<%=name %>
	<br />
	跳转到<a href="AdminServlet?flag=gotologin">登录</a>画面
</body> 
</html>