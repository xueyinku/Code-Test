<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 展示权限数据 -->
	<c:forEach items="${userPermissionList}" var="userPermission">
		<c:forEach items="${permissionList}" var="permission">
			<c:if test="${userPermission.permissionId eq permission.id}">
				<a href="${permission.url}">${permission.name}</a>
			</c:if>
		</c:forEach>
	</c:forEach>
</body>
</html>


