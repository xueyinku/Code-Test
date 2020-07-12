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
<h1>添加会员信息画面</h1>
<form action="CusDoupdateServlet"method="post">
		<table>
			<tr>
				<td class="txtregist">会员编号</td>
				<td>
					<input id="textlogin3" type="text" value="1001"readonly name="update_no"/>
				</td>
				<td class="txtredregist"></td>
			</tr>
			<table>
			<tr>
				<td class="txtregist">名字</td>
				<td>
					<input class="textlogin1" type="text" value="xiaohong" name="update_name"/>
				</td>
				<td class="txtredregist">*请输入正确的名字</td>
			</tr>
			<tr>
				<td class="txtregist">积分</td>
				<td>
					<input class="textlogin1" type="text"value="200" name="update_score"/>
				</td>
				<td class="txtredregist">*请输入数字</td>
			</tr>
			<tr>
				<td class="txtregist">电话</td>
				<td>
					<input class="textlogin1" type="text" value="13399990000"name="update_tel"/>
				</td>
				<td class="txtredregist">*请输入11位手机号</td>
			</tr>
			<tr>
				<td class="txtregist">性别</td>
				<td class="textlogin1">
					<input type="radio" name="sex1" value="男"/>男<input type="radio" name="sex1" value="女" checked="checked"/>女
				</td>
				<td></td>
			</tr>
			<tr>
				<td class="txtregist"></td>
				<td>
						<input class="submitall" type="submit" value="修改" />
				</td>
				<td>
					<a href="cus_index.jsp">首页</a>
				</td>
			</tr>
		</table>
		</form>

</body>
</html>