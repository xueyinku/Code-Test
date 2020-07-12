<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>修改成功</h1>
		<h2>修改的信息如下：</h2>
		<h3>编号：<%String upda_no = (String)request.getAttribute("upda_no"); %>
		<%=upda_no %></h3>
		<h3>名字：<%String upda_name = (String)request.getAttribute("upda_name"); %>
		<%=upda_name %></h3>
		<h3>积分：<%String upda_score = (String)request.getAttribute("upda_score"); %>
		<%=upda_score %></h3>
		<h3>电话：<%String upda_tel = (String)request.getAttribute("upda_tel"); %>
		<%=upda_tel %></h3>
		<h3>性别：<%String upda_sex = (String)request.getAttribute("upda_sex"); %>
		<%=upda_sex %></h3>
		<hr />
		<h3>跳转到<a href="cus_index.jsp">首页</a></h3>	

</body>
</html>