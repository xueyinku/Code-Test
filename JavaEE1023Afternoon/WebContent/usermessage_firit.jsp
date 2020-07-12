<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String usermess = (String)request.getAttribute("usermes"); %>
	<!--<%String shuiguo = (String)request.getAttribute("firitchoose"); %>-->
	<!--<%String because = (String)request.getAttribute("yuanyin"); %>-->
	<%out.print(usermess); %>
	<!--<br />-->
	<!--您最喜欢的水果：-->
	<!--<%=shuiguo %>-->
	<!--<br />-->
	<!--喜欢的原因：-->
	<!--<%=because %>-->
</body>
</html>