<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 画面接取java传回来的值 -->
		<%String resultName = (String)request.getAttribute("javaToJspName");%>
		<%String resultAge = (String)request.getAttribute("javaToJspAge");%>
		<%out.print("姓名为"+ resultName + ",年龄" + resultAge + "岁"); %>
		<!--  <%String result = (String) request.getAttribute("result"); %>-->
		<!--<%= result %>-->
		
</body>
</html>