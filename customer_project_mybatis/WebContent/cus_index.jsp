<%@page import="com.xue.custom.model.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.xue.custom.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	@SuppressWarnings("unchecked")
 List<Customer> allcustomer = (List<Customer>)request.getAttribute("allcustomer");
%> 
<%Admin admin = (Admin)session.getAttribute("admin"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">      
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="customer_btn_and_text_style.css"/>
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
		<h1 style="margin-left: 120px;">会员积分管理系统</h1>
<!-- 	<h1>会员信息查询画面</h1> -->
		用户：<%=admin.getName() %>
		<form  action="CustomerServlet" method="post">
		<input type="hidden" name="flag" value="gotoselect" />
		<table >
			<tr>
				<td class="txtregist">编号</td>
				<td>
					<input class="textlogin" type="text" name="id" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td class="txtregist">手机号</td>
				<td>
					<input class="textlogin" type="text" name="tel"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input class="submitall" type="submit" value="搜索" />
				</td>
				<td ">
					<a href="CustomerServlet?flag=gotoinsert">添加</a>
				</td>
			</tr>
		</table>
		</form>
		<table class="table">
			<caption class="txtregist">共计-<%=allcustomer.size()%>-条</caption>
			<tr>
				<th>#</th>
				<th>编号</th>
				<th>名字</th>
				<th>积分</th>
				<th>手机号</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
		<!-- 通过mysql值给表格赋值 -->
			<%int count = 0; %>
			<%for  (Customer customer : allcustomer){%>
			
			<tr >
				<td><%=count %></td>
				<%count++; %>
				<td><%=customer.getId() %></td> 
				<td><%=customer.getName() %> </td>
				<td><%=customer.getScore()%></td> 
				<td><%=customer.getTel()%></td> 
				<td><%=customer.getSex() %></td>
				<td>
					<a href="CustomerServlet?flag=gotoupdate&cus_update_id=<%=customer.getId() %>">修改</a>
					&nbsp;<a href="CustomerServlet?flag=gotodelete&cus_delete_id=<%=customer.getId() %>">删除</a>
				</td>
			</tr>
			<% } %>
		</table>
</body>
</html>