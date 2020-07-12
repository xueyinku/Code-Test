<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		.photo{
			width: 100px;
			height: 100px;
		}
	</style>
</head>
<body>
	<a href="<%=request.getContextPath() %>/car/goAdd">添加</a>
	<table>
		<tr>
			<td>汽车名</td>
			<td>价格</td>
			<td>汽车图片描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${carList}" var="car">
			<tr>
				<td>${car.name}</td>
				<td>${car.price}</td>
				<td>
					<img class="photo" src="<%=request.getContextPath() %>/img/${car.imgName} " />
				</td>
				<td>
					<img class="photo" src="<%=request.getContextPath() %>/img/${car.inImgName}" />
				</td>
				<td>
					<a href="#">租车</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>