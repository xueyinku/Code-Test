<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>删除成功</h1>
		<h2>删除的信息如下：</h2>
		<h3>编号：<%String no = (String)request.getAttribute("no"); %><%=no %> </h3>
		<hr />
		<h3>跳转到<a href="cus_index.jsp">首页</a></h3>

</body>
</html>