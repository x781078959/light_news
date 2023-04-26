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
		$(document).ready(function() {
			$("#formNews").submit(function(){
                var title = $("#title").val();
                var author = $("#author").val();
                var typeId = $("#typeId").val();
                var content = CKEDITOR.instances.content.getData();
				var status = true;
				if(title==null||title==""){
					status = false;
					${"#errorTitlle"}.html('标题不能为空');
				}
				if(author==null||author==""){
                    status = false;
                    ${"#errorAuthor"}.html('作者不能为空');
                }
				if(content==null||content==""){
                    status = false;
                    ${"#errorContent"}.html('内容不能为空');
                }
				if(status){
                    $.ajax(
							{
								type: "post",
                                url: "news?action=saveNews",
                                data: {
                                    title: title,
                                    author: author,
                                    typeId: typeId,
                                    content: content,
									isHead:$('#isHead').val(),
									isHot:$('#isHot').val(),
									newsId:$('#newsId').val()
                                },
                                success: function(data){
                                    if(data.indexOf("true")+1){
										alert(data.type=="update"?"修改成功":"添加成功");
										window.location.href = 'news?action=backNewsList'
                                    }else{
                                        alert("保存失败");
                                    }
                                }
							}
					)
                }
            })
		})



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
						<input type="text" id="title" name="title" class="input-xxlarge" value=""/>
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
								<option value="${types.newsTypeId}">${types.typeName}</option>
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
						  <input type="checkbox" id="isHead" name="isHead" value="1">头条
						</label>
						<label class="checkbox inline">
						  <input type="checkbox" id="isHot" name="isHot" value="1">热点
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻内容：</label>
					</td>
					<td>
						<label for="content"><textarea class="ckeditor" id="content" name="content"></textarea></label>
						<span id="errorContent" style="color: red; "></span>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="newsId" name="newsId" value=""/>&nbsp;
					</td>
					<td>
						<input type="button" id="btnSubmit" class="btn btn-primary" value="保存新闻" onclick="onsubmit()"/>&nbsp;&nbsp;
						<input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>	
</body>
</html>