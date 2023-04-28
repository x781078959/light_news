<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%= basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/news.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function deleteType(typeid){
		if(window.confirm("确定要删除本条新闻类型吗？")){
			$.post("type?action=deleteType","newsTypeId="+typeid,deltype);
			function deltype(data){
				if(data.indexOf("true")+1){
					alert("删除成功！");
					window.location.href = "type?action=selectAll";
				}else{
					alert("删除失败！");
				}
			}
		}
	}
</script>
</head>
<body>
<div class="data_list backMain">
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th>序号</th>
				<th>新闻类别编号</th>
				<th>新闻类别名称</th>
				<th>操作</th>
			</tr>
			<!--  -->
			<c:forEach items="${types}" var="types">
			<c:set var="i" value="${i+1}"></c:set>
			<tr>
					<td>${i}</td>
					<td>${types.newsTypeId}</td>
					<td>${types.typeName}</td>
					<td>
						<button class="btn btn-info" type="button" >修改</button>
						<button class="btn btn-danger" type="button" onclick="deleteType(${types.newsTypeId})">删除</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>