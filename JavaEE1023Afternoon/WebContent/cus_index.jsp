<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	text{width: 200px;
		height:40px; 
		}
		#sub{width: 200px;
		height: 40px;
		
		border-radius: 10px;
		background-color: blue;
		text-align: center;
		line-height: 40px;
		color: white;
		font-size: 20px;
		letter-spacing: 5px;}
	</style>
</head>
<body>
	<div>
	<h1>会员信息查询画面</h1>
	<form action="" method="post">
	<table>
	<tr>
		<td>编号：</td>
		<td><input type="text" /></td>
		<td></td>
	</tr>
	<tr>
		<td>手机号：</td>
		<td><input type="text" /></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td><form action="cus_index.jsp"><input type="submit" id="sub" /></form></td>
		<td> <a href="cus_insert.jsp">添 加</a></td>
	</tr>
	</table>
	</form>
	</div>
	<table border="1px" cellspacing="0" cellpadding="20px">
	<caption class="txtregist">共计-5-条</caption>
			<tr>
				<th>#</th>
				<th>编号</th>
				<th>名字</th>
				<th>积分</th>
				<th>手机号</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
			
			<tr>
				<td>1</td>
				<td>1001</td>
				<td>小红</td>
				<td>200</td>
				<td>13399990000</td>
				<td>男</td>
				<td>
					<a href="cus_update.jsp">修改</a>&nbsp;<a href="ServletNoOne?num=1001">删除</a>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td>1002</td>
				<td>小利</td>
				<td>300</td>
				<td>13399990001</td>
				<td>女</td>
				<td>
					<a href="cus_update.jsp">修改</a>&nbsp;<a href="ServletNoOne?num=1002">删除</a>
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td>1003</td>
				<td>小明</td>
				<td>400</td>
				<td>13399990002</td>
				<td>男</td>
				<td>
					<a href="cus_update.jsp">修改</a>&nbsp;<a href="ServletNoOne?num=1003">删除</a>
				</td>
			</tr>
			<tr>
				<td>4</td>
				<td>1004</td>
				<td>小黑</td>
				<td>500</td>
				<td>13399990003</td>
				<td>男</td>
				<td>
					<a href="cus_update.jsp">修改</a>&nbsp;<a href="ServletNoOne?num=1004">删除</a>
				</td>
			</tr>
			<tr>
				<td>5</td>
				<td>1005</td>
				<td>小刘</td>
				<td>600</td>
				<td>13399990004</td>
				<td>男</td>
				<td>
					<a href="cus_update.jsp">修改</a>&nbsp;<a href="ServletNoOne?num=1005">删除</a>
				</td>
			</tr>
	</table>

</body>
</html>