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
	<form action="PermissionServlet" method="post">
		<input type="hidden" name="flag" value="doAuthorize"/>
		<c:forEach items="${permissionList}" var="permission">
			<input type="checkbox" 
				<c:forEach items="${userPermissionList}" var="userPermission">
					<c:if test="${userPermission.permissionId eq permission.id}">
						checked="checked"
					</c:if>
				</c:forEach>
			/> ${permission.name}
		</c:forEach>
		
		<input type="submit" value="授权"/>
	</form>
</body>
</html>