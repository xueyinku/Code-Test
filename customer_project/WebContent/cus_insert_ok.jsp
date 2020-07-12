<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String id =  (String)request.getAttribute("cus_insert_ok_id"); %>
<%String name =  (String)request.getAttribute("cus_insert_ok_name"); %>
<%String score =  (String)request.getAttribute("cus_insert_ok_score"); %>
<%String tel =  (String)request.getAttribute("cus_insert_ok_tel"); %>
<%String sex =  (String)request.getAttribute("cus_insert_ok_sex"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加成功</title>
<!--加载btn和text格式-->
		<link rel="stylesheet" type="text/css" href="css/customer_btn_and_text_style.css"/>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script 	src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script 	src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="page-header" contenteditable="true">
		<h1 style="margin-left: 120px;">添加成功</h1></div>
		<h2>添加的信息如下：</h2>
		<h3>编号：<%=id %> </h3>
		<h3>名字：<%=name %></h3>
		<h3>积分：<%=score %></h3>
		<h3>电话：<%=tel %></h3>
		<h3>性别：<%=sex %></h3>
		<hr />
		<h3>继续<a href="CustomerServlet?flag=gotoinsert">添加</a>下一个会员的信息</h3>
		<h3>跳转到<a href="CustomerServlet?flag=gotoindex">首页</a></h3>

</body>
</html>