<%@page import="com.xue.book.model.Book"%>
<%@page import="com.xue.book.model.BookUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%BookUser user = (BookUser)session.getAttribute("user"); %>
<%Book book = (Book)request.getAttribute("book"); %>
<%String alert = (String)request.getAttribute("alert"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--加载btn和text格式-->
		<link rel="stylesheet" type="text/css" href="css/customer_btn_and_text_style.css"/>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script 	src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script 	src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<style>
			#user_id{
				position: absolute;
				left: 95%;
				top: 0%;
			}
			#divcenter{
				position: absolute;
				left: 50%;
			}
			#user_id{
				position: absolute;
				left: 95%;
				top: 0%;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/customer_btn_and_text_style.css"/>
</head>
<body>
	<h1 class="text-center" contenteditable="true" style="color:#2d78f4;"></h1>
	<div id="user_id"><%=user.getId() %></div>
	<div id="divcenter">
	<form action="BookServlet" method="post" onsubmit = confirm1() >
			<input type="hidden" name="flag" value="gobuyok" />
	<%if (alert != null ) {%>
	<%=alert %>
	<%} %>
	<table class="table" cellpadding="20px">
		<tr>
			<td class="txtlogin">书名</td>
			<td class="td"><input type="text" style="text-align: center;" name="name" value=<%=book.getName() %> readonly="readonly" /> </td>
		</tr>
		<tr>
			<td class="txtlogin">购买数量</td>
			<td class="td"><input type="text" name="store" /></td>
		</tr>
		<tr>
			<td></td>
			<td class="td"><input type="submit" class="submitregist" value="购买"/></td>
		</tr>
	</table>
	</form>
	</div>
</body>
<script type="text/javascript">
var store = document.getElementsByName("store");  //数组
function confirm1() {
	var sum = store[0].value * <%=book.getPrice() %>;
 	var result = confirm("总价" + sum + "元，是否购买");
 	return result;
}
</script>

</html>