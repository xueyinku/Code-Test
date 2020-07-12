<%@page import="com.asjy.customer.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//接取数据
	List<Customer> cusList = (List<Customer>)request.getAttribute("cusList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#">
		<table>
			<tr>
				<td>编号：</td>
				<td>
					<input type="text" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td>
					<input type="text" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="搜索"/>
				</td>
				<td>
					<a href="CustomerServlet?flag=goInsert">添加</a>
				</td>
			</tr>
		</table>
	</form>
	
	共计 - <%=cusList.size() %> - 条
	<table>
		<tr>
			<th>#</th>
			<th>编号</th>
			<th>姓名</th>
			<th>积分</th>
			<th>电话</th>
			<th>性别</th>
			<th>操作</th>
		</tr>
		
		<!-- 通过循环，展示集合中的数据 -->
		<% 
			int count = 0;
			for(Customer customer : cusList){ 
				count++;
		%>
			<tr>
				<td><%=count %></td>
				<td><%=customer.getId() %></td>
				<td><%=customer.getName() %></td>
				<td><%=customer.getScore() %></td>
				<td><%=customer.getTel() %></td>
				<td><%=customer.getSex() %></td>
				<td>
					<a href="#">修改</a>
					<!-- html实体：&nbsp; -->
					&hearts;&hearts;
					<a href="#">删除</a>
				</td>
			</tr>
		<% } %>
		
		
	</table>
	
</body>
</html>