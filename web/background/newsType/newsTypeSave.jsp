<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>新闻网站后台管理</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnSubmit").click(function(){
			var newsTypeId = document.getElementById("newsTypeId").value;
			var typeName = document.getElementById("typeName").value;
			console.log(newsTypeId);
			console.log(typeName);
			if(newsTypeId !== '' || newsTypeId.trim().length !== 0) {
				$.post("type?action=updateType","newsTypeId="+newsTypeId+"&typeName="+typeName,saveNews);
                function saveNews(data){
                    if(data.indexOf("true")+1){
                        alert("修改成功！");
                        window.location.href = "type?action=selectAll";
                    }else{
                        alert("修改失败！");
                    }
                }
			}else{
				if(typeName === '' || typeName.trim().length === 0)  {
					alert("请输入新闻类别名称");
				}else {
					$.post("type?action=saveType","typeName="+typeName,saveNews);
					function saveNews(data){
						if(data.indexOf("true")+1){
							alert("添加成功！");
							window.location.href = "type?action=selectAll";
						}else{
							alert("添加失败！");
						}
					}
				}

			}
		})
	})
</script>
</head>
<body>
<div class="data_list backMain">
	<div class="data_content">
		<form >
			<table style="padding: 5px">
				<tr>
					<td>
						<label>新闻类别名称：</label>
					</td>
					<td>
						<label for="typeName"></label><input type="text" id="typeName" name="typeName" value="${newsType.typeName}"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="newsTypeId" name="newsTypeId" value="${newsType.newsTypeId}"/>
					</td>
					<td>
						<input type="button" id="btnSubmit" class="btn btn-primary" value="保存新闻类别"/>&nbsp;&nbsp;
						<input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>&nbsp;&nbsp;<font id="error" color="red"></font>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</div>
</body>
</html>