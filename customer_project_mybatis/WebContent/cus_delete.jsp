<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String deleteId =  (String)request.getAttribute("deleteId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="customer_btn_and_text_style.css"/>
</head>
<body>
	<h1>删除会员信息画面</h1>
	<form action="CustomerServlet" method="post">
	<input type="hidden" name="flag" value="gotodeleteok" />
		<table>
			<tr>
				<td class="txtregist">会员编号</td>
				<td>
					<input id="textlogin3" type="text" name="cus_delete_id" value=<%=deleteId %> readonly/>
				</td>
				<td class="txtredregist"></td>
			</tr>
			
			<tr>
				<td class="txtregist"></td>
				<td>
				<input class="submitall" type="submit" value="删除" />
				</td>
				<td>
					<a href="CustomerServlet?flag=gotoindex">首页</a>
				</td>
			</tr>
		</table>
		</form>
</body>
</html>