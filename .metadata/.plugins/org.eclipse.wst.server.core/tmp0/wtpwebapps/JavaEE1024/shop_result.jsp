<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
购物成功！总共花费价格为：<%int money = (int)request.getAttribute("total_price"); %>
<%=money %>
</body>
</html>