<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="huiyuanjifenxitong.css"/>
</head>
<body>
<h1>删除会员信息画面</h1>
	<form action="CusDoDeleteServlet" method="post">
		<table>
			<tr>
				<td class="txtregist">会员编号</td>
				<td>
				<% String num1 = (String)request.getAttribute("delete_num"); %>
					<input id="textlogin3" type="text" name="vip_num" value = "<%=num1 %>"/>
				</td>
				<td class="txtredregist"></td>
			</tr>
			
			<tr>
				<td class="txtregist"></td>
				<td>
						<input class="submitall" type="submit" value="删除" />
				</td>
				<td>
					<a href="cus_index.jsp">首页</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>