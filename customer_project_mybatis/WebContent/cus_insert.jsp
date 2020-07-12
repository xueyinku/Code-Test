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
<title>天剑会员新信息</title>
<link rel="stylesheet" href="customer_btn_and_text_style.css" />
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
		<h1 style="margin-left: 120px;">添加会员信息画面</h1></div>
		<form action="CustomerServlet" method="post">
		<input type="hidden" name="flag" value="gotoinsertok"></input>
		<table>
			<tr>
				<td class="txtregist">会员编号</td>
				<td>
					<input class="textlogin1" type="text"  name="cus_id"/>
				</td>
				<td class="txtredregist">*请输入4会员编号</td>
			</tr>
			<table>
			<tr>
				<td class="txtregist">名字</td>
				<td>
					<input class="textlogin1" type="text" name="cus_name" />
				</td>
				<td class="txtredregist">*请输入正确的名字</td>
			</tr>
			<tr>
				<td class="txtregist">积分</td>
				<td>
					<input class="textlogin1" type="text" name="cus_score" />
				</td>
				<td class="txtredregist">*请输入数字</td>
			</tr>
			<tr>
				<td class="txtregist">电话</td>
				<td>
					<input class="textlogin1" type="text" name="cus_tel" />
				</td>
				<td class="txtredregist">*请输入11位手机号</td>
			</tr>
			<tr>
				<td class="txtregist">性别</td>
				<td class="textlogin1">
					<input type="radio" name="cus_sex" value="男"/>男<input type="radio" name="cus_sex" value= "女"/>女
				</td>
				<td></td>
			</tr>
			<tr>
				<td class="txtregist"></td>
				<td>
					<input class="submitall" type="submit" value="添加" />
				</td>
				<td>
					<a href="CustomerServlet?flag=gotoindex">首页</a>
				</td>
			</tr>
		</table>
		</form>
</body>
</html>