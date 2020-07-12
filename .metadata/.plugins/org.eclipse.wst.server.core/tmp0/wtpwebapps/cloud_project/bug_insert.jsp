<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>bug</h1>
	<hr />
	<form action="BugServlet" method="post">
	<input type="hidden" name="proid" value="${proId}" />
	<c:if test="${bugMes.state == null}">
	<input type="hidden" name="flag" value="goInserBugSql" />
	</c:if>
	<input type="hidden" />
	<input type="hidden" />
	<table>
	<tr>
		<td>名称</td>
		<td colspan="3"><input type="text" name="name" value="${bugMes.name}"/></td>
	</tr>
	<tr>
		<td>现象</td>
		<td colspan="3"><textarea cols=3 rows=4 name="content" >${bugMes.pheContent}</textarea></td>
	</tr>
	<tr>
		<td>现象类型</td>
		<td><select name="phe_id" value="">
		<c:forEach items="${pheAlList}" var="phe">
		<c:if test="${bugMes.pheId == phe.phe_id}">
		<option value="${phe.phe_id}" selected="selected">${phe.phe_name}</option>
		</c:if>
		<option value="${phe.phe_id}" >${phe.phe_name}</option>
		</c:forEach>
		</select>
		</td>
		<td>发生阶段</td>
		<td><select name="stage" >
		<option 
		<c:if test="${bugMes.stage == 'CT'}">
		selected="selected"
		</c:if>
		>CT</option>
		<option 
		<c:if test="${bugMes.stage == 'UT'}">
		selected="selected"
		</c:if>
		>UT</option>
		<option 
		<c:if test="${bugMes.stage == 'TT'}">
		selected="selected"
		</c:if>
		>TT</option>
		<option 
		<c:if test="${bugMes.stage == 'ET'}">
		selected="selected"
		</c:if>
		>ET</option>
		
		</select>
		</td>
	</tr>
	<tr>
		<td>记录者</td>
		<td><select name="record">
		<c:forEach items="${userAll}" var="user">
		<option value="${user.id}"
		<c:if test="${bugMes.recoro == user.id}">
		selected
		</c:if>
		>${user.name}</option>
		</c:forEach>
		</select>
		</td>
		<td>发生日期</td>
		<td><input type="date" name="happ_time" value="${bugMes.happTime}"/></td>
	</tr>
	</table>
<hr />
<c:if test="${bugMes.state != null}">
	<table>
		<tr>
			<td>对策者</td>
			<td><select name="" id=""><option value=""></option></select></td>
			<td>对策日期</td>
			<td><input type="date" /></td>
		</tr>
		<tr>
			<td>对策类型</td>
			<td><select name="" id=""><option value=""></option></select></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>原因</td>
			<td colspan="3"><textarea cols=3 rows=4></textarea></td>
		</tr>
	</table>
	<hr />
	<c:if test="${bugMes.state >= 2}">
	<table>
		<tr>
			<td>确认者</td>
			<td><select name="" id=""><option value=""></option></select></td>
			<td>确认日期</td>
			<td><input type="date" /></td>
		</tr>
	</table>
	</c:if>
	</c:if>
	<table>
		<tr>
			<td></td>
			<td><input type="submit" value="提交"/></td>
			<td></td>
			<td><input type="submit" value="取消"/></td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
</html>