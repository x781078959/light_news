<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/news.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="js/ckeditor/ckeditor.js"></script>
<script src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function newsDelete(newsId){
			var flag = window.confirm("确定要删除本条新闻吗？");
			if(flag){
				$.post("news?action=deleteNews","newsId="+newsId,delNews);
				function delNews(data){
					if(data.indexOf("true")+1){
						alert("删除成功！");
						window.location.href = "news?action=backNewsList";
					}else{
						alert("删除失败！");
					}
				}
			}
		}

		function updateNewsById(newsId){
			window.location.href = 'news?action=selectNewsById&newsId='+newsId;
		}
	</script>
<title>新闻维护</title>
</head>
<body>
	<div class="data_list backMain">
		<div class="search_content" style="vertical-align: middle;">
			<form action="news?action=backNewsList" method="post">
				新闻标题: <input type="text" name="title" value="${search.title}">&nbsp;&nbsp;
				发布日期： <input type="text" name="startDate" class="Wdate"
					onclick="WdatePicker()" style="width: 120px;" value="${search.startDate}" />&nbsp;&nbsp;至&nbsp;&nbsp;
				<input type="text" name="endDate" class="Wdate"
					onclick="WdatePicker()" style="width: 120px;" value="${search.endDate}" />&nbsp;&nbsp;
				<button class="btn  btn-primary" type="submit"
					style="margin-top: -8px;">查询</button>
			</form>
		</div>
		<div class="data_content">
			<table class="table table-hover table-bordered">
				<tr>
					<th><input type="checkbox" id="checkedAll" /></th>
					<th>序号</th>
					<th>新闻标题</th>
					<th>新闻类别</th>
					<th>发布时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${news}" var ="news">
				<tr>
					<td><input type="checkbox" name="newsIds" value="" /></td>
					<td>${news.newsId}</td>
					<td>${news.title}</td>
					<td>${news.typeName}</td>
					<td>${news.publishDate}</td>
					<td>
						<button class="btn  btn-info" type="button" onclick="updateNewsById(${news.newsId})">修改</button>&nbsp;
						<button class="btn btn-danger" type="button" onclick="newsDelete(${news.newsId})">删除</button>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="pagination pagination-centered">${pageCode}</div>
	</div>
</body>
</html>