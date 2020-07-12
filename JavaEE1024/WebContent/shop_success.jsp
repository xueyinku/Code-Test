<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
			img{
				width: 100px;
				height: 100px;				
			}
			td{
				width = 150px;
				padding: 20px;
			}
			#sub{
				width: 100px;
				height: 40px;
				border: 0px;
				border-radius: 5px;
				background-color: #F10180;
				color: white;
				font-size: 20px;
				text-align: center;
				line-height: 40px;
			}
		</style>
</head>
<body>
<!-- 创建主页样式，点击购买将value传到后端 -->
		<form action="LoginServlet" method="post" id = "form">
		<table>
			<tr>
				<td><img src="image/dog.PNG"/></td>
				<td>煎饼狗子
				<br />价格：10元</td>
				<td><input type="button" value="+" id="btn_add" />
				<input type="text" id="dog_count" name="dog_count" value="4" />
				<input type="button" value="-" id="btn_sub" />
				</td>
			</tr>
			<tr>
				<td><img src="image/dogleg.PNG" id="dog_leg"/></td>
				<td>金华狗腿
				<br />价格：20元</td>
				<td><input type="button" value="+" id="btn_add_2" />
				<input type="text"  id="dogleg_count" name="dogleg_count" value="2" />
				<input type="button" value="-" id="btn_sub_2" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input id="sub" type="submit" value="购买"/></td>
				<td></td>
			</tr>
		</table>
		</form>
</body>
	<script type="text/javascript">
	//实现点击+-对应值会改变
		var btn_add = document.getElementById("btn_add");
		var btn_add_2 = document.getElementById("btn_add_2");
		var btn_sub = document.getElementById("btn_sub");
		var btn_sub_2 = document.getElementById("btn_sub_2");
		var dog_count = document.getElementById("dog_count");
		var dogleg_count = document.getElementById("dogleg_count");
		var form = document.getElementById("form");
		btn_add.onclick = function() {
			dog_count.value++;
		}
		btn_add_2.onclick = function() {
			dogleg_count.value++;
		}
		btn_sub.onclick = function() {
			if (dog_count.value > 0) {
			dog_count.value--;	
			}
		}
		btn_sub_2.onclick = function() {
			if (dogleg_count.value > 0) {
			dogleg_count.value--;
			}
			
		}
		form.onsubmit = function () {
			var result = confirm("总价为" + (dog_count.value * 10 + dogleg_count.value * 20) + "元,是否确认购买");
			return resullt;
		}
	</script>
</html>