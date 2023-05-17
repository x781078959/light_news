<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/background/resources/jquery-ui-1.13.2/jquery-ui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/background/resources/jquery-ui-1.13.2/jquery-ui.theme.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/background/resources/jquery-ui-1.13.2/external/jquery/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/background/resources/jquery-ui-1.13.2/jquery-ui.js"></script>
	<script type="text/javascript">
		function linkDelete(linkId){
			if(confirm("确定要删除本条链接吗？")){
				$.post("link?type=deleteLink","linkId="+linkId,delLink);
				function delLink(data){
					if(data.indexOf("true")+1){
						alert("删除成功！");
						window.location.href = "link?type=toLink";
					}else{
						alert("删除失败！");
					}
				}
			}
		}

		function updateLinkById(LinkId){
			window.location.href = 'link?type=selectLinkById&linkId='+LinkId;
		}
	</script>
</head>
<body>
	<div class="data_list backMain">
		<div class="data_content">
			<table class="table table-hover table-bordered">
				<tr>
					<th>链接编号</th>
					<th>链接名称</th>
					<th>链接地址</th>
					<th>联系人邮件</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${links}" var="links">
				<tr>
						<td>${links.orderNum}</td>
						<td>${links.linkName}</td>
						<td>${links.linkUrl}</td>
						<td>${links.linkEmail}</td>
						<td>
							<button class="btn btn-mini btn-info" type="button" id="addLinkBtn" onclick="updateLinkById(${links.linkId})">修改</button>&nbsp;&nbsp;
							<button class="btn btn-mini btn-danger" type="button" onclick="linkDelete(${links.linkId})">删除</button>
						</td>
				</tr>
				</c:forEach>
			</table>
			<section id="addLinkDia">
				<form method="post">
					<div>
						<label>
							<span>链接名称：</span>
							<input type="text" id="linkName" name="linkName"/>
						</label>
					</div>
					<div>
						<label>
							<span>链接地址：</span>
							<input type="text" id="linkUrl" name="linkUrl"/>
						</label>
					</div>
					<div>
						<label>
							<span>联系人邮件：</span>
							<input type="text" id="linkEmail" name="linkEmail"/>
						</label>
					</div>
					<div>
						<input type="hidden" id="linkId" name="linkId"/>&nbsp;
					</div>
				</form>
			</section>
		</div>
	</div>
<script>
	/*$("#addLinkBtn").click(function() {
		$("#addLinkDia").dialog("open");
	});*/
	// 添加模块框
	$("#addLinkDia").dialog({
		autoOpen: false,
		title: "修改链接",
		modal: true,
		buttons: [{
			text: "确认修改",
			click: doConfirmAddLink
		}],
		create:function (event, ui) {
			doLoadLink();
		}
	});

	function  doConfirmAddLink(){
		var linkName = $("#linkName").val();
		var linkUrl = $("#linkUrl").val();
		var linkEmail = $("#linkEmail").val();
		$.ajax({
			url: "link?type=saveLink",
			type: "post",
			data:{
				linkName:linkName,
				linkUrl:linkUrl,
				linkEmail:linkEmail,
				linkId:$('#linkId').val()
			},
			dataType:"json",
			success: function(data){
				if(data.rlt===1){
					alert(data.type==="update"?"修改成功":"添加成功");
					window.location.href = 'link?type=toLink'
				}else{
					alert('失败');
				}
			}
		})
	}

	function doLoadLink(selector){

	}
</script>
</body>
</html>