<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String deleteId = (String)request.getAttribute("deleteId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>删除成功</h1>
		<h2>删除的信息如下：</h2>
		<h3>编号：<%=deleteId %></h3>
		<hr />
		<h3>跳转到<a href="CustomerServlet?flag=gotoindex">首页</a></h3>
</body>
</html>