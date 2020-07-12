<%@page import="com.xue.book.model.Book"%>
<%@page import="com.xue.book.model.BookUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%BookUser user = (BookUser)session.getAttribute("user"); %>
<%Book book = (Book)request.getAttribute("book"); %>
<%String alert  = (String) request.getAttribute("alert"); %> 
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
		<form action="BookServlet" id="formsub" method="post">
		<input type="hidden" name="flag" value="goupdateok" />
	<%if (alert != null ) {%>
	<%=alert %>
	<%} %>
	<table class="table" cellpadding="20px">
		<tr>
			<td class="txtlogin">编号</td>
			<td class="td"><input type="text" name="no"  value=<%=book.getNo() %> readonly="readonly" /> </td>
		</tr>
		<tr>
			<td class="txtlogin">书名</td>
			<td class="td"><input type="text" name="name" value=<%=book.getName() %> /></td>
		</tr>
		<tr>
			<td class="txtlogin">作者</td>
			<td class="td"><input type="text" name="author" value=<%=book.getAuthor() %> /></td>
		</tr>
		<tr>
			<td class="txtlogin">发布时间</td>
			<td class="td"><input type="text" name="publish" value=<%=book.getPublish() %> /></td>
		</tr>
		<tr>
			<td class="txtlogin">价格</td>
			<td class="td"><input type="text" name="price" value=<%=book.getPrice() %> /></td>
		</tr>
		<tr>
			<td class="txtlogin">库存</td>
			<td class="td"><input type="text" name="store" value=<%=book.getStore() %> /></td>
		</tr>
		<tr>
			<td></td>
			<td class="td"><input type="submit" id="submitregist" value="修改"/></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>