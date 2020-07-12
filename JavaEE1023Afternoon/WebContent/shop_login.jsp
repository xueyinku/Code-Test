<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		text{width: 100px;
		height: 40px;}
	</style>
</head>
<script type="text/javascript">
<!--
账号密码格式校验以及登陆跳转
//-->
	var account = document.getElementById("account");
	var password = document.getElementById("password");
	var acc_mes = document.getElementById("acc_mes");
	var pas_mes = document.getElementById("pas_mes");
	var formsub = document.getElementById("formsub");
	var reg_acc = /^[a-zA-Z]{2}[a-zA-Z0-9]{4,}$/;
	var reg_pas = /^\w{6,10}$/;
	var acc_result = false;
	var pas_result = false;
// 	文本框失去焦点旁边产生相应信息
	account.onblur = function () {
		if (reg_acc.test(account.value)) {
			acc_mes.innerHTML = "正确";
			acc_mes.style.backgroundColor = "green";
			acc_result = true;
		}else {
			acc_mes.innerHTML = "格式错误";
			acc_mes.style.color = "red";
		}
	}
	password.onblur = function () {
		if (reg_pas.test(password.value)) {
			pas_mes.innerHTML = "正确";
			pas_mes.style.color = "green";
			pas_result = true;
		}else {
			pas_mes.innerHTML = "格式错误";
			pas_mes.style.backgroundColor = "red";
		}
	}
	formsub.onsubmit = function () {
		return pas_result && acc_result;
	}
	
			
</script>
<body>
	<form action="https://www.baidu.com" id="formsub">
	<table>
		<tr>
			<td>账号：</td>
			<td><input type="text" id="account" /></td>
			<td><span id="acc_mes"></span></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" id="password" /></td>
			<td><span id="pas_mes"></span></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="登陆"/></td>
		</tr>
	</table>
	</form>
</body>

</html>