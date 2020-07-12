<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" /> 
	<select >  
		<option>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
	</select>
	<input type="text" />
	计算结果为：<span id="span"></span>
	<input type="button" value="计算" />
</body>
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script>
		$(":button:first").click(function(){ //ajax技术只能用于局部刷新，不能用于跳页
// 			alert("ok");
// 		alert( $(":selected").val());
		//定义ajax引擎
		$.get(
				"AjaxTestServlet",//第一个参数，请求路径
				{numone : $(":text:first").val(), numtwo : $(":text:eq(1)").val() , sym : $(":selected").val()},//第二个参数为json数据，可以是json数据、数组、数据+数组
				function(test){  //第三个参数为返回的方法，比如将得到的数据，进行湖面展示
					//接取返回的数据
					$("#span").html(test);
				},
				"text" //预期后台响应的数据类型
				)
		})
	</script>
</html>