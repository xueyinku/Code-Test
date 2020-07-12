<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String alert = (String)request.getAttribute("alert"); %>
     <%if(!"".equals(alert) && null != alert){ %> 
		 <%=alert %>
	 <%}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h1 style="margin-left: 120px;">会员积分管理系统</h1>
		<form action="AdminServlet" method="post">
		<input type="hidden" name="flag"  value="gotoindex"/>
		<table>
			<tr>
				<td class="txtlogin">账号</td>
				<td>
					<input class="textlogin" type="text" name="admin_name"  />
				</td>
				<td></td>
			</tr>
			<tr>
				<td class="txtlogin">密码</td>
				<td class="textlogin">
					<input class="textlogin" type="text" name="admin_password"  />
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input class="submitall" type="submit" value="登录"/>
				</td>
				<td>
				<a href="AdminServlet?flag=gotoregister">注册</a>
				</td>
			</tr>
		</table>
		</form>

		
		
<!-- CustomerServlet?flag=gotoregister -->
</body>
<!--  <script type="text/javascript">  -->
<!--   window.onkeydown = function(){ -->
<%-- 	 <%if(!"".equals(alert) && null != alert){ %>  --%>
<%-- 	 confirm(<%=alert %>);  --%>
<%-- 	 <%}%> --%>
<!-- //  } -->
<!-- </script>  -->
</html>