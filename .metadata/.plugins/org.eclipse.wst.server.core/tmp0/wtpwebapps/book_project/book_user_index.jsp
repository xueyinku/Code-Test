<%@page import="com.xue.book.model.BookPageMes"%>
<%@page import="com.xue.book.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.xue.book.model.BookUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%BookUser user = (BookUser)session.getAttribute("user"); %>
<%BookPageMes list = (BookPageMes)request.getAttribute("bookMes"); %> 
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
		</style>
</head>
<body>
	<h1 class="text-center" contenteditable="true" style="color:#2d78f4;">欢迎登陆北方图书城</h1>
	<div id="user_id"><%=user.getId() %></div>
	<div id="divcenter">
	<table class="table" cellpadding="20px">
		<tr>
			<td class="txtlogin">编号</td>
			<td class="td"><input type="text" /> </td>
			<td></td>
		</tr>
		<tr>
			<td class="txtlogin">书名</td>
			<td class="td"><input type="text" /></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td class="td"><input type="submit" class="submitregist" value="查询"/></td>
			<td></td>
		</tr>
	</table>
	</div>
	<div>
	<table class="table" id="table_mes">
			<caption class="txtregist">共计-<%=list.getBookNum()%>-条</caption>
			<tr>
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
			<%int count = 0; %>
			<%for  (Book book : list.getBookMes()){%>
			
			<tr >
				<td><%=count %></td>
				<%count++; %>
				<td><%=book.getNo() %></td> 
				<td><%=book.getName() %> </td>
				<td><%=book.getAuthor()%></td> 
				<td><%=book.getPublish()%></td> 
				<td><%=book.getPrice() %></td>
				<td><%=book.getStore() %></td>
				<td>
					<a href="BookServlet?flag=gobuy&book_no=<%=book.getNo() %>">购买</a>
				</td>
			</tr>
			<% } %>
		</table>
		</div>
		<div id="pageSelect">
<%-- 		共计<%=list.getPageNum() %> --%>
		<ul class="pagination pagination-lg" >
<%-- 		<%if(list.getCurrentPage() != 1){ %> --%>
		<li <%if(list.getCurrentPage() == 1){ %> class="disabled"<%} %>>
		<%if(list.getCurrentPage() == 1){ %>
		<a href="BookServlet?flag=goindex_user&page=1">&laquo</a>
		<%} else{ %>
		<a href="BookServlet?flag=goindex_user&page=<%=list.getCurrentPage() - 1%>">&laquo</a>
		<%}%>
		</li>
<%-- 		<li>当前为<%=list.getCurrentPage() %>页</li> --%>
		<%for (int i = 0; i < list.getPageNum(); i++){ %>
		<li <%if(i+1 == list.getCurrentPage()) {%> class="active" <%} %>><a href="BookServlet?flag=goindex_user&page=<%=i+1%> "><%=i+1 %></a></li>
		<%} %>
		<li <%if(list.getCurrentPage() == list.getPageNum()) { %> class="disabled" <%} %>>
		<%if(list.getCurrentPage() == list.getPageNum()) { %>
		<a href="BookServlet?flag=goindex_user&page=<%= list.getPageNum()%>">&raquo</a>
		<%} else{ %>
		<a href="BookServlet?flag=goindex_user&page=<%=list.getCurrentPage() + 1%>">&raquo</a>
		<%} %>
		</li>
		</ul><br>
		</div>
</body>
</html>