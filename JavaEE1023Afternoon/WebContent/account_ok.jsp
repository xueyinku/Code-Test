<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>转账成功</h1>
	从  <%String from_peo = (String)request.getAttribute("from_people"); %>
	<%=from_peo %>
	向<%String to_peo = (String)request.getAttribute("to_people"); %>
	<%=to_peo %>
	转了<%String money = (String)request.getAttribute("money"); %>
	<%=money %>
	元
	<br />
	手续费：<%double commission = (double)request.getAttribute("commission"); %> 
	<%=commission %>
	元
	</div>

</body>
</html>