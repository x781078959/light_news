<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$(document).ready(function() {
		//当提交表单时验证内容，验证过提交到服务器
		$("#btnSubmit").click(function () {
			var linkName = $("#linkName").val();
			var linkUrl = $("#linkUrl").val();
			var linkEmail = $("#linkEmail").val();
			var orderNum = $("#orderNum").val();
			$.ajax({
				url: "link?type=saveLink",
				type: "post",
				data: {
					linkName: linkName,
					linkUrl: linkUrl,
					linkEmail: linkEmail,
					orderNum: orderNum,
				},
				dataType: "json",
				success: function (data) {
					if (data.rlt === 1) {
						alert(data.type === "update" ? "修改成功" : "添加成功");
						window.location.href = 'link?type=toLink'
					} else {
						alert('失败');
					}
				}
			})
		})
	});
</script>
</head>
<body>
<div class="data_list backMain">

	<div class="data_content">
		<form  method="post" >
			<table style="padding: 5px">
				<tr>
					<td>
						<label>链接编号：</label>
					</td>
					<td>
						<input type="text" id="orderNum" name="orderNum" />
						<span id="errorId" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td>
						<label>链接名称：</label>
					</td>
					<td>
						<input type="text" id="linkName" name="linkName" />
						<span id="errorName" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td>
						<label>链接地址：</label>
					</td>
					<td>
						<input type="text" id="linkUrl" name="linkUrl" />
						<span id="errorUrl" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td>
						<label>联系人邮件：</label>
					</td>
					<td>
						<input type="text" id="linkEmail" name="linkEmail" />
						<span id="errorEmail" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<input type="button" id="btnSubmit" class="btn btn-primary" value="保存友情链接"/>&nbsp;&nbsp;
						<input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>&nbsp;&nbsp;
				</tr>
				
			</table>
		</form>
	</div>
</div>
</body>
</html>