<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加成功</h1>
		<h2>添加的信息如下：</h2>
		<h3>编号：<%String add_no = (String)request.getAttribute("add_no"); %>
		<%=add_no %></h3>
		<h3>名字：<%String add_name = (String)request.getAttribute("add_name"); %>
		<%=add_name %></h3>
		<h3>积分：<%String add_score = (String)request.getAttribute("add_score"); %>
		<%=add_score %></h3>
		<h3>电话：<%String add_tel = (String)request.getAttribute("add_tel"); %>
		<%=add_tel %></h3>
		<h3>性别：<%String add_sex = (String)request.getAttribute("add_sex"); %>
		<%=add_sex %></h3>
		<hr />
		<h3>继续<a href="cus_insert.jsp">添加</a>下一个会员的信息</h3>
		<h3>跳转到<a href="cus_index.jsp">首页</a></h3>

</body>
</html>