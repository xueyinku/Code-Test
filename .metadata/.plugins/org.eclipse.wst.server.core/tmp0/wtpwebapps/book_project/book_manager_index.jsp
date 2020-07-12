<%@page import="com.xue.book.model.BookPageMes"%>
<%@page import="com.xue.book.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.xue.book.model.BookUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%BookUser user = (BookUser)session.getAttribute("user"); %> 
<%-- <%BookPageMes list = (BookPageMes)request.getAttribute("bookMes"); %>    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--加载btn和text格式-->
		<link rel="stylesheet" type="text/css" href="css/customer_btn_and_text_style.css"/>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
		<link rel="stylesheet" 	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script 	src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script 	src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<style>
			#user_id{
				position: absolute;
				left: 95%;
				top: 0%;
			}
			#divcenter{
				position: absolute;
				left: 35%;
			}
			#table_mes{
			position: absolute;
			top:55%;
			}
			#pageSelect{
			position: absolute;
			top:75%;
 			left: 35%; 
			}
			.pageSelect1{
			position: absolute;
			top:45%;
 			left: 35%; 
			}
		</style>
</head>
<body>
<h1 class="text-center" contenteditable="true" style="color:#2d78f4;">欢迎登陆北方图书城</h1>
	<div id="user_id"><%=user.getId() %></div>
	<div id="divcenter">
	<table class="table" cellpadding="20px">
		<tr>
			<td class="txtlogin">编号</td>
			<td class="td"><input type="text" id="select_no"/> </td>
			<td></td>
		</tr>
		<tr>
			<td class="txtlogin">书名</td>
			<td class="td"><input type="text" id="select_name" /></td>
			<td></td>
		</tr>
		<tr>
		<form action="">
			<td></td>
			<td class="td"><input type="button" class="submitregist" id="btn" value="查询" onclick="findbypage(1)"/></td>
			<td><a href="BookServlet?flag=goinsert">添加</a></td>
		</form>
		</tr>
	</table>
	</div>
	<div>
	<table class="table" id="table_mes">
			<caption class="txtregist" id="cap"></caption>
			<tr>
				<th><input type="checkbox" id="selectall"/>全选</th>
				<th>#</th>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>发布日期</th>
				<th>价格</th>
				<th>库存</th>
				<th>操作</th>
			</tr>
		<!-- 通过mysql值给表格赋值 -->
<%-- 			<%int count = 0; %> --%>
<%-- 			<%for  (Book book : list.getBookMes()){%> --%>
			
<!-- 			<tr > -->
<%-- 				<td><%=count %></td> --%>
<%-- 				<%count++; %> --%>
<%-- 				<td><%=book.getNo() %></td>  --%>
<%-- 				<td><%=book.getName() %> </td> --%>
<%-- 				<td><%=book.getAuthor()%></td>  --%>
<%-- 				<td><%=book.getPublish()%></td>  --%>
<%-- 				<td><%=book.getPrice() %></td> --%>
<%-- 				<td><%=book.getStore() %></td> --%>
<!-- 				<td> -->
<%-- 					<a href="BookServlet?flag=gotoupdate&bookno=<%=book.getNo() %>">修改</a> --%>
<%-- 					&nbsp;<a href="BookServlet?flag=gotodelete&bookno=<%=book.getNo()%>">删除</a> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
<%-- 			<% } %> --%>
		</table>
		</div>
		<div id="pageSelect">
<!-- 		<span id="booksum">shngyiye </span> -->
<!-- 		<span id="pagecurrent">xiayiye </span> -->
<%-- 		共计<%=list.getPageNum() %> --%>
		<ul class="pagination pagination-lg" id="ul" >
		
<%-- <%-- 		<%if(list.getCurrentPage() != 1){ %> --%> 
<%-- 		<li <%if(list.getCurrentPage() == 1){ %> class="disabled"<%} %>> --%>
<%-- 		<%if(list.getCurrentPage() == 1){ %> --%>
<!-- 		<a href="BookServlet?flag=goindex_manager&page=1">&laquo</a> -->
<%-- 		<%} else{ %> --%>
<%-- 		<a href="BookServlet?flag=goindex_manager&page=<%=list.getCurrentPage() - 1%>">&laquo</a> --%>
<%-- 		<%}%> --%>
<!-- 		</li> -->
<%-- <%-- 		<li>当前为<%=list.getCurrentPage() %>页</li> --%> 
<%-- 		<%for (int i = 0; i < list.getPageNum(); i++){ %> --%>
<%-- 		<li <%if(i+1 == list.getCurrentPage()) {%> class="active" <%} %>><a href="BookServlet?flag=goindex_manager&page=<%=i+1%> "><%=i+1 %></a></li> --%>
<%-- 		<%} %> --%>
<%-- 		<li <%if(list.getCurrentPage() == list.getPageNum()) { %> class="disabled" <%} %>> --%>
<%-- 		<%if(list.getCurrentPage() == list.getPageNum()) { %> --%>
<%-- 		<a href="BookServlet?flag=goindex_manager&page=<%= list.getPageNum()%>">&raquo</a> --%>
<%-- 		<%} else{ %> --%>
<%-- 		<a href="BookServlet?flag=goindex_manager&page=<%=list.getCurrentPage() + 1%>">&raquo</a> --%>
<%-- 		<%} %> --%>
<!-- 		</li> -->
		
		</ul><br>
		<input type="button" id="btndelete" value="删除" />
		</div>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
// 使用ajax必须在事件的基础上，而且不能跳页，只能用于局部渲染
	var count = 0;
	$(function(){
		findbypage(1);
	});
	$("#selectall").click(function(){  //全选按钮作用
		if ($("#selectall").prop("checked") == true) { //如果全选按钮被选中，选项被选中
			$(".checkall").prop("checked",true);
		} else {
			$(".checkall").prop("checked",false); //如果全选按钮不被选中，选项不被选中
		}
	});
	function checkfun() {   //点击下面的选型控制全选按钮
		if ($(".checkall").length == $(".checkall:checked").length) {
			$("#selectall").prop("checked",true);
		} else {
			$("#selectall").prop("checked",false);
		}
	};
	function ajaxdelemany(currentpage) {
		var result = confirm("确认是否删除所选书籍？");
		if (result) {
			var arr = [];    //获取要删除的编号，小技巧在添加每个checkbox时其value设置成对应的bookno ，这样可以更快的获取
			$.each($(".checkall:checked"), function(idnex,obj){
				arr.push($(obj).val());
			})
			$.ajax({
				url : "BookServlet",  //请求路径
				type : "post",  //请求方式
				data : {flag : "goajaxdeletemany", manyno : arr.toString()},  //ajax传递的数据,数组不能识别（只识别text和json数据），只能先转换成字符串进行传递
				dataType : "text",  //预计接收数据类似
				success : function (data) {  //成功的回调函数
					if (data == "true") { //删除成功，重新加载数据
						 findbypage(currentpage);
					} else {
						alert("删除失败");
					}
				},
				error : function (data) {//失败的回调函数
					alert("加载失败");
				}
			})
		} else {
				alert("取消删除");
		}
	}
	function ajaxdelete(bookno,currentpage){
		var result = confirm("确认是否删除？"); //点击删除之后验证是否确认删除
		if (result) {  //如果确认删除，执行数据库删除数据据，之后局部渲染，需要用到ajax引擎
			$.ajax({
				url : "BookServlet", //请求lujing
				type : "post",  //请求方式,post 和get 建议post 安全
				data : {flag : "ajaxdeleteno", no : bookno},  //json数据，传到后端数据
				dataType : "text",  //预计返回类型，删除功能返回成功失败即可
				success : function(data){  //成功的回调函数
					if (data == "true") {
						findbypage(currentpage);   //成功重新更新本页数据，会出现bug 1.本页数据全部删除需要显示上一页数据，需要在查询的ajax中操作
												//2。如果没有数据据，将全部内容隐藏，显示抱歉，展示没有数据
					} else {
						alert("删除失败")
					}
				
				},
				error : function (data) { //失败的回调函数
					alert("操作失败");
				}
			})			
		} else {
			alert("取消删除 ");
		}
	}
	function findbypage(page){
// 		alert($("#select_no").val());
// 		alert($("#select_name").val());
// 		$.post(
// // 			第一个参数为，跳转路径
// 		"BookServlet",
// // 		第二个参数为json数据，或者json数组，或者json数据+数组
// 		{flag : "goselect_by_no_and_name" , no : $("#select_no").val(), name : $("#select_name").val() },
// // 		第三个参数为返回之后的方法，渲染或者警告子类
// 		function(text){
// 			count = 0;
// //			首先清空table数据
// 			$("#table_mes tr:gt(0)").remove();
// 			$("#pageSelect").remove();
// 			$.each(text,function(index,json){
// // 				$("#test").html(json.name);	
// 			var $tr = $("<tr >" + 
// 					"<td>" + count + "</td>" + 
// 					"<td>" + json.no + "</td>" + 
// 					"<td>" + json.name + "</td>" +
// 					"<td>" + json.author + "</td>" +
// 					"<td>" + json.publish + "</td>" +
// 					"<td>" + json.price + "</td>" +
// 					"<td>" + json.store + "</td>" +
// 					"<td><a href=" + "BookServlet?flag=gotoupdate&bookno=" + (json.no + "") + ">修改</a>"+
// 					"&nbsp;<a href=" + "BookServlet?flag=gotodelete&bookno=" + (json.no + "") + ">删除</a></td>" +
// 					"</tr>"
// 			)
// 			if (json != "" ) {
// 				count++;
// 			} 
// 			$("#table_mes").append($tr);
// 			} )
// 			$("#cap").text("共计-" + count + "-条")
// 		},
// //  		第四个参数为，预计返回的数据类型
// 		"json"
// 		)

			//用ajax结构分页完成
		$.ajax({
			url : "BookServlet",		   //代表请求路径
			type : "post",                  //请求方式
			//请求参数
			data : {flag : "goselect_by_no_and_name", no : $("#select_no").val(), name : $("#select_name").val(), currentPage : page },			
			dataType : "json",   //预期后台响应的数据类型
			success : function (data){  //后台没有异常出现的回调函数
				if (data.bookMes.length == 0 && data.currentPage == 1 ) {  //完全没有数据时，需要将将所有内容隐藏，显示抱歉，展示没有内容
					//隐藏表格和页码
					$("#table_mes").hide();
				 	$("#pageSelect").hide();
				 	$(".divmes").remove();
					var div = $("<div class='divmes pageSelect1'><span>抱歉，展示没有内容</span><img src='img/u=2995143552,1363900887&fm=26&gp=0.jpg'></img></div> ");
					$("#divcenter").after(div);
				} else {
					$("#table_mes").show();
				 	$("#pageSelect").show();
				 	$(".divmes").remove();
				 	//给删除按钮添加事件
				 	$("#btndelete").attr("onclick" , "ajaxdelemany("+data.currentPage+")");
				 	 //如果本页数据没有，将重新调用上一页数据
					 if (data.bookMes.length == 0) {  //查询当页没有数据，直接查询上一页数据
						 findbypage(data.currentPage - 1);
					}
					
					count = 0;//编号重新定义
					$("#table_mes tr:gt(0)").remove();//清空table数据
					$.each(data.bookMes, function(index,object){
						var $tr = $("<tr >" + 
								"<td><input type='checkbox' value = '"+object.no +"' class = 'checkall' onclick='checkfun()'/></td>" +
								"<td>" + count + "</td>" +
								"<td>" + object.no + "</td>" + 
								"<td>" + object.name + "</td>" +
			 					"<td>" + object.author + "</td>" +
			 					"<td>" + object.publish + "</td>" +
			 					"<td>" + object.price + "</td>" +
			 					"<td>" + object.store + "</td>" +
			 					"<td><a href=" + "BookServlet?flag=gotoupdate&bookno=" + (object.no + "") + ">修改</a>"+
//	 		 					"&nbsp;<a href=" + "BookServlet?flag=gotodelete&bookno=" + (object.no + "") + ">删除</a></td>" +
								"&nbsp;<a onclick='ajaxdelete("+object.no+"," +data.currentPage+ ")'>删除</a></td>" +
								"</tr>");
			 			$("#table_mes").append($tr);
			 			if (object.no != "") {
			 				count++;
			 			}
					})
						$("#cap").text("共计-" + data.bookNum + "-条"); //表头总计多少书
//	 					$("#booksum").html("总计" + data.pageNum + "页");
//	 					$("#pagecurrent").html("当前为" + data.currentPage + "页");
						$("#ul").empty();
						var upPage = $("<li><a ><span>&laquo</span></a></li>"); //加上一页按钮
						$("#ul").append(upPage);   
						for (var i = 1; i <= data.pageNum; i++) {  //加上最小到最大页码之间的页数展示出来
							var li = $("<li onclick='findbypage("+ i  +")'><a> " + i +"</a></li>");
							$("#ul").append(li);
						}
						var downPage = $("<li><a><span>&raquo</span></a></li>");//加下一页按钮
						$("#ul").append(downPage);
						if (data.currentPage <= 1) {  //给上一页添加事业，使用ajax引擎，让上一页可以渲染画面，如果是第一页这不添加事件
							$("#ul :first").prop("class" , "disabled");
						} else  {
							$("#ul :first").attr("onclick" , "findbypage("+ (data.currentPage - 1)+")");
						}
						if (data.currentPage >= data.pageNum) {//给下一页添加事业，使用ajax引擎，让上一页可以渲染画面，如果是最后一页这不添加事件
							$("#ul :last").prop("class" , "disabled");
						} else  {
							$("#ul :last").attr("onclick" , "findbypage("+ (data.currentPage + 1)+")");
						}
						$("li").eq(data.currentPage).attr("class" , "active");
				}
				
					
			},		
			error : function(text){ //后台有异常出现的回调函数
				alert("搜索失败，请检查输入格式");
			}
		})
		}
</script>
</html>