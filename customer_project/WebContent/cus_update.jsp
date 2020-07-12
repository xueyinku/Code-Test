<%@page import="com.xue.custom.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--    接受要修改数据 -->
<%Customer update_customer =  (Customer)request.getAttribute("cusupdate"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员信息修改</title>
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
	<h1 style="margin-left: 120px;">修改会员信息画面</h1>
	<form action="CustomerServlet" method="post">
	<input type="hidden" name="flag" value="gotoupdateok" />
		<table>
			<tr>
				<td class="txtregist">会员编号</td>
				<td>
					<input id="textlogin3" type="text" name="update_id" value=<%=update_customer.getId() %> readonly />
				</td>
				<td class="txtredregist"></td>
			</tr>
			<table>
			<tr>
				<td class="txtregist">名字</td>
				<td>
					<input class="textlogin1" type="text" name="update_name" value=<%=update_customer.getName() %> />
				</td>
				<td class="txtredregist">*请输入正确的名字</td>
			</tr>
			<tr>
				<td class="txtregist">积分</td>
				<td>
					<input class="textlogin1" type="text" name="update_score"  value=<%=update_customer.getScore() %> />
				</td>
				<td class="txtredregist">*请输入数字</td>
			</tr>
			<tr>
				<td class="txtregist">电话</td>
				<td>
					<input class="textlogin1" type="text" name="update_tel" value=<%=update_customer.getTel()%> />
				</td>
				<td class="txtredregist">*请输入11位手机号</td>
			</tr>
			<tr>
				<td class="txtregist">性别</td>
				<td class="textlogin1">
					<input type="radio" name="update_sex" value="男"
					<%if (update_customer.getSex().equals("男")){ %>
						checked="checked"
					<%} %>
					/>男<input type="radio" name="update_sex" value="女"
					<%if (update_customer.getSex().equals("女")){ %>
						checked="checked"
					<%} %>/>女
				</td>
				<td></td>
			</tr>
			<tr>
				<td class="txtregist"></td>
				<td>
				<input class="submitall" type="submit" value="修改" />
				</td>
				<td>
					<a href="CustomerServlet?flag=gotoindex">首页</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>