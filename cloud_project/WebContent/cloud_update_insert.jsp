<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#user_id{
				position: absolute;
				left: 85%;
				top: 8%;
				color: lightgreen;
				font-size: 20px;
			}
		#user_id_mes{
		color: red;
		font-size: 20px;
		}	
	</style>
</head>
<body>
	<h1>项目云平台</h1>
	<hr />
	<span id="user_id"><span id="user_id_mes">欢迎你：</span>${sessionScope.user.name}</span>
	<form action="CloudProjectServlet" method="post">
<!-- 	当新增时，点击submit应该执行添加，当是修改时，点击submit应该执行的是修改 -->
	<c:if test="${projectMes == null}">
	<input type="hidden" name="flag"  value="goinsertpro"/>
	</c:if>
	<c:if test="${projectMes != null}">
	<input type="hidden" name="flag"  value="goupdatepro"/>
	<input type="hidden" name="proid"  value="${projectMes.id}"/>
	</c:if>
	<table>
	<tr>
		<td>项目名称</td>
		<td colspan="3"><input type="text" name="project_name" value="${projectMes.name}"/></td>
	</tr>
	<tr>
		<td>周期</td>
		<td><input type="date" name="project_starttime" value="${projectMes.starttime}"/></td>
		<td>-</td>
		<td><input type="date" name="project_endtime" value="${projectMes.endtime}"/></td>
	</tr>
	<tr>
		<td>负责人</td>
		<td colspan="3">
		<select name="hearer" ><option value="00">--请选择--</option>
		<c:forEach items="${userList}" var="user">
			<option value="${user.id}"
			 <c:if test="${projectMes.hearer == user.id}">
			 selected="selected"
			 </c:if>
			 >${user.name}</option>
		</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" /></td>
		<td></td>
		<td></td>
	</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
	if (${result} == true) {
		alert("数据提交成功");
	} else if (${result} == false) {
		alert("数据提交失败");
	}	
</script>
</html>