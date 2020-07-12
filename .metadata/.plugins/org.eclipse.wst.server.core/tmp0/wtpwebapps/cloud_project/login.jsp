<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
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
	<!-- 前端需要获取客户端本地所有cookie  这个是记住我的程序，不能做到免登陆 -->
 	<% boolean result = false;
		Cookie[] cookies = request.getCookies(); 
		if(cookies != null && cookies.length > 0){
			for(int i = 0; i < cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					result = true;
			}
		}
	}%>
	<%-- <%Cookie[] cookies = request.getCookies(); 
	String userName = "";
	String userPassword = "";
	String check = "";
	if(cookies != null && cookies.length > 0){
		for(int i = 0; i < cookies.length; i++){
			if("nameCookie".equals(cookies[i].getName())){
				userName =  cookies[i].getValue();
				check = "checked";
			}
			if("passwordCookie".equals(cookies[i].getName())){
				userPassword =  cookies[i].getValue();
			}
		}
	}
//  value="<%=userName %>"这事加载name= name 的文本框
	//value="<%=userPassword %>"这事加载name= Password 的文本框  <%=check %>这是加在checklimiande 
	%> --%>
	<h1>项目云平台</h1>
	<hr />
	<c:if test="${alert != null}">${alert}</c:if>
	<form action="UserServlet" method="post">
	<input type="hidden" name="flag" value="goindex" />
	<table>
	<tr>
		<td>账号</td>
		<td><input type="text" name="name"  /></td>
		<td></td>
	</tr>
	<tr>
		<td id="pas">密码</td>
		<td><input type="text" name="password"  /></td>
		<td></td>
	</tr>
	<tr>
		<td>验证码</td>
		<td><input type="text" name="confirm" /></td>
		<td><img class="imgconfirm" src="ImgServlet" onclick="refresh(this)"/></td>
	</tr>
	<tr>
		<td><input type="checkbox" value="true" name="checkbox_remeberMe" />七天免登陆</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="登陆" /></td>
		<td><a href="#">立即注册</a></td>
	</tr>
	</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
	function refresh(element) {
		//加入随机数的目的为了避免因为缓存机制的原因，导致请求路径相同而页面不刷新的问题
		element.src = "ImgServlet?r=" + Math.random();
	}
	//应该是直接直接到index页面 ,通过js方法跳转
	//只有当cookies里面有值才可以跳转
	if (<%=result%>) {
	//不能直接跳转到index页面，这样会把session数据丢失，需要想跳转后台
	window.location.href="CloudProjectServlet?flag=goindexNoCheck7";
	}

	
</script>
</html>