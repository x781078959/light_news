<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<base href="<%= basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/news.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<script src="bootstrap/js/jQuery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="js/ckeditor/ckeditor.js"></script>
<title>新闻管理</title>
	<script type="text/javascript">
		$(document).ready(function(){
			//当提交表单时验证内容，验证过提交到服务器
			$("#btnSubmit").click(function(){
				var title = $("#title").val();
				var author = $("#author").val();
				var typeId = $("#typeId").val();
				var content = CKEDITOR.instances.content.getData();
				var status = true;
				if(title==null||title===''){
					status = false;
					$("#errorTitle").html('标题不能为空');
				}else{
					status = true;
					$("#errorTitle").html('');
				}
				if(author==null||author===''){
					status = false;
					$("#errorAuthor").html('作者不能为空');
				}else{
					status = true;
					$("#errorAuthor").html('');
				}
				if(typeId==null||typeId===''){
					status = false;
					$("#errorType").html('请选择类别');
				}else{
					$("#errorType").html('');
				}
				if(content==null||content===''){
					$("#errorContent").html('内容不能为空');
				}else{
					$("#errorContent").html('');
				}
				//当status为true的时候才提交
				if(status){
					$.ajax({
						url: "news?action=saveNews",
						type: "POST",
						data:{
							title:title,
							author:author,
							typeId:typeId,
							content:content,
							isHead:$("input[name='isHead']:checked").val(),
							isHot:$("input[name='isHot']:checked").val(),
							newsId:$('#newsId').val()
						},
						dataType:"json",
						success: function(data) {  //括号里的data是服务器返回的数据
							if(data.rlt===1){
								alert(data.type==="update"?"修改成功":"添加成功");
								window.location.href = 'news?action=backNewsList'
							}else{
								alert('保存失败')
							}
						}
					});
				}
			})
		});
	</script>
</head>
<body>
<div class="data_list backMain">
	<div class="data_content">
		<form id="formNews"  method="post">
			<table style="padding: 5px;width: 100%">
				<tr>
					<td>
						<label>新闻标题：</label>
					</td>
					<td>
						<input type="text" id="title" name="title" class="input-xxlarge" value="${news.title}"/>
						<span id="errorTitle" style="color: red; "></span>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻作者：</label>
					</td>
					<td>
						<input type="text" id="author" name="author" value="张三"/>
						<span id="errorAuthor" style="color: red; "></span>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻类别：</label>
					</td>
					<td>

						<select id="typeId" name="typeId">
							<option value="">请选择新闻类别</option>
							<c:forEach items="${types}" var="types">
								<option value="${types.newsTypeId}" ${types.newsTypeId == news.typeId?'SELECTED':''}>${types.typeName}</option>
							</c:forEach>
						</select>
						<span id="errorType" style="color: red; "></span>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻属性：</label>
					</td>
					<td>
						<label class="checkbox inline">
						  <input type="checkbox" id="isHead" name="isHead" value="1" ${news.isHead == 1?'checked="checked"':''}>头条
						</label>
						<label class="checkbox inline">
						  <input type="checkbox" id="isHot" name="isHot" value="1" ${news.isHot == 1?'checked="checked"':''}>热点
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻内容：</label>
					</td>
					<td>
						<label for="content"><textarea class="ckeditor" id="content" name="content">${news.content}</textarea></label>
						<span id="errorContent" style="color: red; "></span>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="newsId" name="newsId" value="${news.newsId}"/>&nbsp;
					</td>
					<td>
						<input type="button" id="btnSubmit" class="btn btn-primary" value="保存新闻" />&nbsp;&nbsp;
						<input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>	
</body>
</html>