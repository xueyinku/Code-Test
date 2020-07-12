<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 新建账号密码登录界面，在js进行账号密码格式校验 ，如果账号密码没问题跳转下一画面，不成哥弹窗并留在本画面 -->
	<form action="shop_success.jsp" id="form_index" method="get">
	<table>
	<tr>
		<td>账号</td>
		<td><input type="text" id="account"/></td>
		<td><span id="account_message"></span></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" id="password" /></td>
		<td><span id="password_message"></span></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="登录" /></td>
		<td></td>
	</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
		var reg_acc = /^[a-zA-Z]{2}[a-zA-Z0-9]{4,}$/;
		var reg_pas = /^\w{6,10}$/;
		var account = document.getElementById("account");
		var account_message = document.getElementById("account_message");
		var password = document.getElementById("password");
		var password_message = document.getElementById("password_message");
		var form_index = document.getElementById("form_index");
		var result_acc = false;
		var result_pas = false;
		account.onblur = function(){
			if (reg_acc.test(account.value)) {
				account_message.style.color = "green";
				account_message.innerHTML = "成功";
				result_acc = true;
			} else {
				account_message.style.color = "red";
				account_message.innerHTML = "格式错误";
				result_acc = false;
			}
		}
		password.onblur = function(){
			if (reg_pas.test(password.value)) {
				password_message.style.color = "green";
				password_message.innerHTML = "成功";
				result_pas = true;
			} else {
				password_message.style.color = "red";
				password_message.innerHTML = "格式错误";
				result_pas = false;
			}
		}
		form_index.onsubmit = function(){
			return result_acc&&result_pas;
		}
	</script>
</html>