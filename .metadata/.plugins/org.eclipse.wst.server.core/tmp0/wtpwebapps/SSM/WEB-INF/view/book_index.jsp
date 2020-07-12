<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			<td><a href="/SpringMVCAndMybatis/BookController/goinsert">添加</a></td>
		</form>
		</tr>
	</table>
	<table class="table" id="table_mes">
			<caption class="txtregist">共计-${BookMes.bookNum}-条</caption>
			<tr>
				<th>全选
				<input type="checkbox" name="check"/>
				</th>
				<th>#</th>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>发布日期</th>
				<th>价格</th>
				<th>库存</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${BookMes.bookMes}" var="book" varStatus="i">
			<tr >
				<td><input type="checkbox" class="check" value="${book.no}"/></td>
				<td>${i.count}</td>
				<td>${book.no}</td> 
				<td>${book.name} </td>
				<td>${book.author}</td> 
				<td>${book.publish}</td> 
				<td>${book.price}</td>
				<td>${book.store}</td>
				<td>
					<a href="#">购买</a>
				</td>
			</tr>
		</c:forEach>	
		</table>
		总计：${BookMes.pageNum}页，当前为第${BookMes.currentPage}页
		<c:if test="${BookMes.currentPage != 1 }">
			<a href="">上一页</a>
		</c:if>
		<c:forEach var="item" varStatus="i" begin="1" end="${BookMes.pageNum}">
				<a href="#">${i.index}</a>
		</c:forEach>
		<c:if test="${BookMes.currentPage != pageNum }">
			<a href="#">下一页</a>
		</c:if>
		<input type="button" value="删除" onclick="deleteManyNo()" />
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.11.2.js"></script>
<script type="text/javascript">
<!--

//-->
	function deleteManyNo() {
		var result = confirm("确认是否删除");
		if (result) {
			var manyNo = [];//定义数组，装取每个被选择的编号
			$.each($(".check:checked"), function (index, obj){
				manyNo.push($(obj).val());
			});
			$.ajax({
				url : "<%=request.getContextPath()%>/BookController/ajaxDeleteManyNo",//请求路径
				type : "post",
				data : {manyNo : manyNo.toString()},
				dataType : "text",
				success : function (data) {
					alert(data);
				},
				error : function (data) {
					alert(data);
				}
			})
		}
	}
</script>
</html>