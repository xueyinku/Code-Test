<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div id="divcenter">
	${mes}
	<form action="/SpringMVCAndMybatis/BookController/goinsertok" id="formsub" method="post">
	<table class="table" cellpadding="20px">
		<tr>
			<td class="txtlogin">编号</td>
			<td class="td"><input type="text" name="no" /> </td>
			
		</tr>
		<tr>
			<td class="txtlogin">书名</td>
			<td class="td"><input type="text"  name="name"/></td>
			
		</tr>
		<tr>
			<td class="txtlogin">作者</td>
			<td class="td"><input type="text"  name="author"/></td>
			
		</tr>
		<tr>
			<td class="txtlogin">发布时间</td>
			<td class="td"><input type="text" name="publish" /></td>
			
		</tr>
		<tr>
			<td class="txtlogin">价格</td>
			<td class="td"><input type="text" name="price" /></td>
			
		</tr>
		<tr>
			<td class="txtlogin">库存</td>
			<td class="td"><input type="text" name="store" /></td>
			
		</tr>
		<tr>
			<td></td>
			<td class="td"><input type="submit" id="submitregist" value="添加"/></td>
			
		</tr>
	</table>
	</form>
	</div>

</body>
<script type="text/javascript">
</script>
</html>