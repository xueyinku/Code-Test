<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		</style>
</head>
<body>
	<h1 class="text-center" contenteditable="true" style="color:#2d78f4;">欢迎登陆北方图书城</h1>
	<%if (alert != null ) {%>
	<%=alert %>
	<%} %>
		<div id="divcenter">
		<form action="AdminServlet" method="post">
		<input type="hidden" name="flag" value="goindex" />
		 	<table class="table" cellpadding="20px">
		 		<tr>
		 			<td class="txtlogin">账号：</td>
		 			<td class="td">
		 				<input class="textlogin1" type="text" name="user_id">
		 			</td>
		 			<td></td>
		 		</tr>
		 		<tr>
		 			<td class="txtlogin">密码：</td>
		 			<td class="td">
		 				<input class="textlogin1" type="text" name="user_password">
		 			</td>
		 			<td></td>
		 		</tr>
		 		<tr>
		 			<td class="txtlogin">验证码：</td>
		 			<td class="td">
		 				<input class="textlogin1" type="text" name="auth_code">
		 			</td>
		 			<td><img class="imgconfirm" src="ImgServlet" onclick="refresh(this)"/></td>
		 		</tr>
		 		<tr>
		 			<td></td>
		 			<td class="td">
		 				<input type="submit" class="submitregist" value="登陆"/></td>
		 			<td> <a href="">立即注册</a></td>
		 		</tr>
		 	</table>
		 	</form>
		 	</div>
</body>
<script type="text/javascript">
	function refresh(element) {
		//加入随机数的目的为了避免因为缓存机制的原因，导致请求路径相同而页面不刷新的问题
		element.src = "ImgServlet?r=" + Math.random();
	}
</script>
</html>