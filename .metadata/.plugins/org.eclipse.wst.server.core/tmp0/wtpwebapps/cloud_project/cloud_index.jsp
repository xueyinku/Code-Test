<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#user_id{
				position: absolute;
				left: 85%;
				top: 8%;
				color: lightgreen;
				font-size: 20px;
			}
		#user_id_mes{
		color: red;
		font-size: 20px;
		}	
	</style>
</head>
<body>
	<h1>项目云平台</h1>
	<hr />
	当前访问人数：${count}人
	<span id="user_id"><span id="user_id_mes">欢迎你：</span>${sessionScope.user.name}<br /><a onclick="if(confirm('确定退出?')==false)return false;" href="UserServlet?flag=logOut">退出</a></span>
	<table id="tabselect">
		<tr>
			<td>项目名称</td>
			<td><input type="text" id="selectname"/></td>
			<td><input type="button" value="查询" onclick="checkByname(1)" /></td>
			<c:if test="${sessionScope.user.type == 1}"><td><a href="CloudProjectServlet?flag=goaddproject">添加项目</a></td></c:if>
		</tr>
	</table>
	<table id="tab">
	<caption id="capt"></caption>
			<tr>
				<th>NO.</th>
				<th>项目名称</th>
				<th>周期</th>
				<th>负责人</th>
				<c:if test="${sessionScope.user.type == 1}"><th>操作</th></c:if>
			</tr>
	</table>
	<span id="pagenum"></span><span id="uppage"></span><span id="pagecount"></span><span id="downpage"></span>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
		$(function(){
			checkByname(1);
		});
		var td = "";
	function ajaxdelete(no,currentPage) {
		var result = confirm("确认删除\"" + no + "\"项目" );
		if (result) {
			$.ajax({
				url : "CloudProjectServlet",//请求lujing
				type : "post",   //请求方式
				data : {flag : "goAjaxdelteByNo", no : no}, //发到后端的数据
				dataType : "text",//预计返回的是成功还是失败
				success : function(data){
					if (data == "true") {
						alert("删除成功");
						checkByname(currentPage);
					} else {
						alert("删除失败");
						checkByname(currentPage);
					}
				},
				error :  function(){
					alert("系统错误，您可能没有权限删除这条信息");
				}
			})
		} else {
			alert("取消删除，返回首页");
			return false;
		}
	}
	function checkByname(currentpage) {
		$.ajax({
			url : "CloudProjectServlet",//请求lujing
			type : "post",   //请求方式
			data : {flag : "ajaxseletebynameandpage", name : $("#selectname").val(), page : currentpage},//传到后端的数据
			dataType : "json", //预计返回的数据类型
			success : function (data) {  //成功的回调函数
			if (data.project.length == 0 && data.currentPage == 1 ) { //完全没有数据时，需要将将所有内容隐藏，显示抱歉，展示没有内容
				$("#tab").hide();
				$("#pagenum").hide();
				$("#uppage").hide();
				$("#pagecount").hide();
				$("#downpage").hide();
				var div = $("<div class='divmes pageSelect1'><span>抱歉，展示没有内容</span></div> ");
				$("#tabselect").after(div);
			} else {
				$("#tab").show();
				$("#pagenum").show();
				$("#uppage").show();
				$("#pagecount").show();
				$("#downpage").show();
				$(".divmes").remove();
			}	
			 //如果本页数据没有，将重新调用上一页数据
			if (data.project.length == 0 && data.currentPage > 1) {  //查询当页没有数据，直接查询上一页数据
				checkByname(data.currentPage - 1);
			}
			//清楚之前的内容	
			$("#capt").html("项目一览 -" + data.pagenum * 3 + "-");
			
			$("#tab tr:gt(0)").remove();//删除之前表格中的内容
			$.each(data.project, function(index,pro){
				if (${sessionScope.user.type} == 1) {
					td = "<td><a href='CloudProjectServlet?flag=goupdateproject&proid="+ pro.id +"'>更改</a><span>&nbsp;&nbsp;</span><a href='#' class='ajaxdelete' >删除</a></td>";
				}
				//将userid与 pro.hearer进行关联
				var userName = "";
				$.each(data.allUser, function(index,user){
					if (user.id == pro.hearer ) {
						userName = user.name;
					}
				})
				var tr = $("<tr>" +
						"<td>"+ index +"</td>" +
						"<td><a href='BugServlet?flag=gobugindex&proId="+ pro.id +"'>"+ pro.name +"</a></td>" +
						"<td>"+ pro.starttime+ "-"+ pro.endtime +"</td>" +
						"<td>"+ userName +"</td>" +
						 td +
					"</tr>");
				$("#tab").append(tr);
				if (td != "") {
				$(".ajaxdelete").eq(index).attr("onclick","ajaxdelete("+ pro.id +","+data.currentPage+")")	
				} 
			});
			$("#pagenum").html("共" + data.pagenum +"页,当前为第" + data.currentPage + "页");
			$("#uppage").empty();
			if (data.currentPage == 1) {
				$("#uppage").html("上一页");
			} else {
				$("#uppage").html("<a href='#' onclick='checkByname("+ (data.currentPage - 1) +")'>上一页</a>");
			}
			$("#pagecount").empty();
			for (var i = 1; i <= data.pagenum; i++) {
				var spanpage = $("<a  href='#' onclick='checkByname("+ i +")'>" +i+ "</a><span>&nbsp;&nbsp;</span>");
				$("#pagecount").append(spanpage);
			}
			$("#downpage").empty();
			if (data.currentPage == data.pagenum) {
				$("#downpage").html("下一页");
			} else {
				$("#downpage").html("<a href='#' onclick='checkByname("+ (data.currentPage + 1) +")'>下一页</a>");
			}
			},
			error : function (data) {  //后台报错的回调函数
				alert("搜索失败，请检查输入格式");
			}
		})
	}
</script>
</html>