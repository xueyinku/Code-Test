<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	计算结果为：<%double calculateResult = (double)request.getAttribute("calculate"); %>
	<%out.print(calculateResult); %>
</body>
</html>