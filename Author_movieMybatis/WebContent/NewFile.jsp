<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>项目云平台</h1>
	<hr />
	<table id="tabselect">
		<tr>
			<td>项目名称</td>
			<td><input type="text" id="selectname"/></td>
			<td><input type="button" value="查询" onclick="checkByname(1)" /></td>
		</tr>
	</table>
	<table id="tab">
	<caption id="capt"></caption>
			<tr>
				<th>NO.</th>
				<th>项目名称</th>
				<th>周期</th>
				<th>负责人</th>
				<th>操作</th>
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
	function checkByname(currentpage) {
		$.ajax({
			url : "ProjectServlet",//请求lujing
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
				//将userid与 pro.hearer进行关联
				var tr = $("<tr>" +
						"<td>"+ index +"</td>" +
						"<td>"+ pro.name +"</a></td>" +
						"<td>"+ pro.starttime+ "-"+ pro.endtime +"</td>" +
						"<td>"+ pro.hearer +"</td>" +
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