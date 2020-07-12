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
	<span id="user_id"><span id="user_id_mes">欢迎你：</span>${sessionScope.user.name}<br /><a onclick="if(confirm('确定退出?')==false)return false;" href="UserServlet?flag=logOut">退出</a></span>
	<table id="tabselect">
		<tr>
			<td>Bug名称</td>
			<td><input type="text" id="selectname"/></td>
			<td><input type="button" value="查询" onclick="selectBugByName(1)" /></td>
			<c:if test="${sessionScope.user.type == 1}"><td><a href="BugServlet?flag=goinsertbug">添加Bug</a></td></c:if>
		</tr>
	</table>
	<table id="tab">
	<caption id="capt"></caption>
			<tr>
				<th>NO.</th>
				<th>Bug名称</th>
				<th>状态</th>
				<th>发现者</th>
				<th>对策者</th>
				<th>确认者</th>
				<c:if test="${sessionScope.user.type == 1}"><th>操作</th></c:if>
			</tr>
	</table>
	<span id="pagenum"></span><span id="uppage"></span><span id="pagecount"></span><span id="downpage"></span>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script>
$(function(){
	selectBugByName(1);
});

function closebug(currentpage,no) { //执行关闭bugajax更新，两个参数，分别为当前页和删除的bugid
	var result = confirm("是否关闭" + no + "bug");
	if (result) {
		$.ajax({
			url : "BugServlet",//请求lujing
			type : "post",   //请求方式
			data : {flag : "goAjaxCloseBug", no : no}, //发到后端的数据
			dataType : "text",
			success : function(data){
				if (data == "true") {
					alert("关闭成功");
					selectBugByName(currentpage);
				} else {
					alert("关闭失败");
					selectBugByName(currentPage);
				}
			},
			error : function(data){
				alert("系统错误，您可能没有权限关闭这条信息");
			}
		})
	} else {
		alert("取消关闭，返回首页");
		return false;
	}
}
	
function ajaxdelete(currentpage,no) {//执行ajax删除操作，两个参数，分别为当前页和删除的bugid
	var result = confirm("是否删除" + no + "bug");
	if (result) {
		$.ajax({
			url : "BugServlet",//请求lujing
			type : "post",   //请求方式
			data : {flag : "goAjaxdelteBugById", no : no}, //发到后端的数据
			dataType : "text",
			success : function(data){
				if (data == "true") {
					alert("删除成功");
					selectBugByName(currentpage);
				} else {
					alert("删除失败");
					selectBugByName(currentPage);
				}
			},
			error : function(data){
				alert("系统错误，您可能没有权限删除这条信息");
			}
		})
	} else {
		alert("取消删除，返回首页");
		return false;
	}
}
function selectBugByName(currentpage) {
	$.ajax({
		url : "BugServlet",//跳转路径
		type : "get",//跳转方式
		data : {flag : "goselectBugBynamecurrentpageanduser",name : $("#selectname").val(),currentpage : currentpage,proId : ${proId}},
		dataType : "json",
		success : function(data){
			
			if (data.bugList.length == 0 && data.currentPage == 1 ) { //完全没有数据时，需要将将所有内容隐藏，显示抱歉，展示没有内容
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
			if (data.bugList.length == 0 && data.currentPage > 1) {  //查询当页没有数据，直接查询上一页数据
				selectBugByName(data.currentPage - 1);
			}
			//清楚之前的内容	
			$("#capt").html("项目一览 -" + data.bugList.length + "-");
			
			$("#tab tr:gt(0)").remove();//删除之前表格中的内容
			$.each(data.bugList,function(index,bug){
				var td = "";
				if (${sessionScope.user.type} == 1) {
					td = "<td><a href='BugServlet?flag=goBugUpdate&bugid="+bug.id+"'>更改</a>"+
					"<span>&nbsp;&nbsp;</span><a href='#' onclick='ajaxdelete(" + data.currentPage +", " + bug.id + ")' >删除</a>"+
					"<span>&nbsp;&nbsp;</span><a href='#' onclick='closebug(" + data.currentPage +", " + bug.id + ")' >关闭</a>"+
					"</td>";
				}
				//将userid与 pro.hearer进行关联
				var recoroName = ""; //给发现者找到对应姓名
				$.each(data.allUser, function(index,user){
					if (user.id == bug.recoro ) {
						recoroName = user.name;
					} else if (bug.recoro == 0) {
						recoroName = "-";
					}
				})
				var strName = "";//给对策者找到对应姓名
				$.each(data.allUser, function(index,user){
					if (user.id == bug.strUser ) {
						strName = user.name;
					} else if (bug.strUser == 0) {
						strName = "-";
					}
				})
				var confirmName = "";//给确认者找到对应姓名
				$.each(data.allUser, function(index,user){
					if (user.id == bug.confirmid ) {
						confirmName = user.name;
					} else if (bug.confirmid == 0) {
						confirmName = "-";
					}
				})
				var state = "";//给状态找到对应的名称
				var bugname ="";
				if (bug.state == 1) {
					state = "调差中";
					bugname = "<td><a href='#'>"+ bug.name +"</a></td>"
				} else if (bug.state == 2) {
					state = "对策完";
					bugname = "<td><a href='#'>"+ bug.name +"</a></td>"
				} else if (bug.state == 3) {
					state = "确认完";
					bugname = "<td><a href='#'>"+ bug.name +"</a></td>"
				} else if (bug.state == 4) {
					state = "已关闭";
					bugname = "<td>"+ bug.name +"</td>"
				}
				var tr = $("<tr>" +
						"<td>"+ index +"</td>" +
						       bugname+
						"<td>"+ state +"</td>" +
						"<td>"+ recoroName +"</td>" +
						"<td>"+ strName +"</td>" +
						"<td>"+ confirmName +"</td>" +
						 td +
					"</tr>");
				$("#tab").append(tr);
			})  //下列为加页码信息
			$("#pagenum").html("共" + data.pagenum +"页,当前为第" + data.currentPage + "页");
			$("#uppage").empty();
			if (data.currentPage == 1) {
				$("#uppage").html("上一页");
			} else {
				$("#uppage").html("<a href='#' onclick='selectBugByName("+ (data.currentPage - 1) +")'>上一页</a>");
			}
			$("#pagecount").empty();
			for (var i = 1; i <= data.pagenum; i++) {
				var spanpage = $("<a  href='#' onclick='selectBugByName("+ i +")'>" +i+ "</a><span>&nbsp;&nbsp;</span>");
				$("#pagecount").append(spanpage);
			}
			$("#downpage").empty();
			if (data.currentPage == data.pagenum) {
				$("#downpage").html("下一页");
			} else {
				$("#downpage").html("<a href='#' onclick='selectBugByName("+ (data.currentPage + 1) +")'>下一页</a>");
			}
		},
		error : function(data){
			alert("后台出错");
		}
	})
}
</script>
</html>