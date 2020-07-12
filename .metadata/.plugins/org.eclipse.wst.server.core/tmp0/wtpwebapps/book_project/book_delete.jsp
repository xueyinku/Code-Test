<%@page import="com.xue.book.model.BookUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%BookUser user = (BookUser)session.getAttribute("user"); %>
<%String no = (String)request.getAttribute("no"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<style>
			#divcenter{
				position: absolute;
				left: 35%;
			}
			#submitregist{
				width: 160px;
				height: 30px;
				background-color: #3385ff;
				border: 1px solid #2d78f4;
				color: #fff;
				text-align: center;
				letter-spacing: 10px;
				border-radius: 8px;
			}
			#user_id{
				position: absolute;
				left: 95%;
				top: 0%;
			}
		</style>
</head>
<body>
	<h1 class="text-center" contenteditable="true" style="color:#2d78f4;">欢迎登陆北方图书城</h1>
	<div id="user_id"><%=user.getId() %></div>
	<div id="divcenter">
		<form action="BookServlet" id="formsub" method="post" onsubmit= confirm()>
		<input type="hidden" name="flag" value="godeleteok" />
	<table class="table" cellpadding="20px">
		<tr>
			<td class="txtlogin">编号</td>
			<td class="td"><input type="text" name="no"  value=<%=no %> readonly="readonly" /> </td>
		</tr>
		<tr>
			<td></td>
			<td class="td"><input type="submit" id="submitregist" value="删除"/></td>
		</tr>
	</table>
	</form>
	</div>
</body>
<script type="text/javascript">
	function confirm() {
		var result = confirm("确实是否删除");
		return result;
	}
</script>
</html>