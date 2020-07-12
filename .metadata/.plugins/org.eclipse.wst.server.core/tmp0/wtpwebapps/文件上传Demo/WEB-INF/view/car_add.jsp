<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/car/doAdd" method="post" enctype="multipart/form-data">
		<!-- 
			画面中如何设置文件上传的控件！
				<input type="file" name="picture"/>
			form表单中声明一个属性enctype：开启文件上传功能！
				enctype="mutipart/form-data"
		 -->
		车名：<input type="text" name="name"/>
		<br>
		价格：<input type="text" name="price"/>
		<br>
		请选择车图片：<input type="file" name="picture"/>
		<br>
		<input type="submit" value="添加"/>
	</form>
</body>
</html>