<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserServlet" method="post" id="form">
	<input type="hidden" name="flag" value="goindex" />
	<table>
		<tr>
			<td>账号</td>
			<td><input type="text" id="name" name="name"/></td>
			<td><span id="namemes"></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" id="password" name="password" /></td>
			<td><span></span></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="text"  id="passwordcom"/></td>
			<td><span id="passwordmes"></span></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit"/></td>
			<td></td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
 var nameresult = false;
 var passwordresult = false;
 	$("#name").blur(function(){
	 //账号失去焦点，利用ajax技术，去数据库查询是否重复
// 	 alert( $("#name").val());
	 if ($("#name").val() == "") {
	} else {
		 $.get(
					"UserServlet",//第一个参数为跳转路径	 
				 	{flag : "comfirmname",name : $("#name").val()},//第二个参数为json数据
					function(text){ //第三个参数为返回之后调用的方法
				 		if (text == "true") {
				 			$("#namemes").html("该账号可用");
				 			$("#namemes").prop("style", "color:green;");
				 			nameresult = true;
						} else {
							$("#namemes").html("该账号已被占用");
				 			$("#namemes").prop("style", "color:red;");
						}
				 	},
				 	"text"        //返回预计返回的数据类型只有text json html xml
				 )
	}
	
 	})
 	$("#passwordcom").blur(function(){
 		if ($("#password").val() == $("#passwordcom").val()) {
 			$("#passwordmes").html("密码可用");
 			$("#passwordmes").prop("style", "color:green;");
 			passwordresult = true;
		} else {
			$("#passwordmes").html("两次密码不一致");
 			$("#passwordmes").prop("style", "color:red;");
		}
 	})
 	
 	//进行校验，去首页
 	$("#form").submit(function(){
 		return nameresult && passwordresult;
 	})
</script>
</html>