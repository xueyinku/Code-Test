 <%@page import="com.asjy.model.BookPage"%>
<%@page import="com.asjy.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>编号：</td>
			<td>
				<input type="text" id="id"/>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>书名：</td>
			<td>
				<input type="text" id="name"/>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" value="查询" onclick="findBookByPage(1)"/>
			</td>
			<td>
				<a href="#">添加</a>
			</td>
		</tr>
	</table>

	共计 - * - 条
	<table id="message">
		<tr>
			<td>#</td>
			<td>编号</td>
			<td>书名</td>
			<td>作者</td>
			<td>发布日期</td>
			<td>价格</td>
			<td>库存</td>
			<td>操作</td>
		</tr>
	</table>
	
	<span id="pageMessage"></span>		<!-- 存储页码信息 -->
	<a href="#" id="upPage"></a>		<!-- 存储上一页 -->
	<span id="pageCount"></span>		<!-- 展示每页超链接 -->
	<a href="#" id="downPage"></a>		<!-- 存储下一页 -->
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
	//JQ页面加载事件
	$(function(){
		//页面加载完成后，触发的内容
		findBookByPage(1);
	})
	
	function findBookByPage(page) {
		$.ajax({
			url : "BookServlet",
			type : "post",
			data : {flag : "findBookByPage", bookName : $("#name").val(), bookId : $("#id").val(), currentPage : page},
			dataType : "json",
			success : function (data) {
				//注意：每次追加表格数据时，需要清除上一次追加的数据
				$("#message tr:gt(0)").remove();
				
				//1. 将后台响应的当前页数据展示到表格中
				$.each(data.pageList, function(index, obj){
					//创建tr和td的节点
					var tr = $("<tr>" + 
									"<td>" + (index + 1) + "</td>" + 
									"<td>" + obj.no + "</td>" + 
									"<td>" + obj.name + "</td>" + 
									"<td>" + obj.author + "</td>" + 
									"<td>" + obj.publish + "</td>" + 
									"<td>" + obj.price + "</td>" + 
									"<td>" + obj.store + "</td>" + 
									"<td>" + 
										"<a href='#'>修改</a>" + 
										"<a href='#'>删除</a>" + 
									"</td>" + 
							   "</tr>");
					$("#message").append(tr);
				});
				
				//2. 展示页码信息
				$("#pageMessage").html("当前第" + data.currentPage + "页，共" + data.totalPage + "页");
				
				//3. 展示上一页下一页超链接
				if (data.currentPage != 1) {
					$("#upPage").html("上一页");
				}else {
					$("#upPage").html("");
				}
				
				if (data.currentPage != data.totalPage) {
					$("#downPage").html("下一页");
				}else {
					$("#downPage").html("");
				}
				
				//4. 负责给上一页和下一页超级链接加入单击事件！
				$("#upPage").attr("onclick", "findProjectByPage(" + (data.currentPage - 1) + ")")
				$("#downPage").attr("onclick", "findProjectByPage(" + (data.currentPage + 1) + ")")
				
				//5. 展示每页页码超级链接！
				//注意：每次追加页码超链接之前，需要清空上次数据
				//6. 给每页页码超链接追加单击事件！
				$("#pageCount").empty();
				for(var i = 1; i <= data.totalPage; i++){
					var a = $("<a href='#' onclick='findProjectByPage(" + i + ")'>" + i + "</a><span>&nbsp;&nbsp;&nbsp;</span>");
					$("#pageCount").append(a);
				}
			},
			error : function (data) {
				alert("失败！")
			}
		})
	}
	
</script>
</html>



