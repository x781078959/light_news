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
<script src="js/ckeditor/ckeditor.js"></script>
<title>新闻管理</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<div class="data_list backMain">
	<div class="data_content">
		<form id="formNews"  method="post">
			<table style="padding: 5;width: 100%">
				<tr>
					<td width="80px">
						<label>新闻标题：</label>
					</td>
					<td>
						<input type="text" id="title" name="title" class="input-xxlarge" value="贴吧门和魏则西事件缠身 李彦宏如何挥别2016？"/>
						<font id="errorTitle" color="red"></font>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻作者：</label>
					</td>
					<td>
						<input type="text" id="author" name="author" value="张三"/>
						<font id="errorAuthor" color="red"></font>
					</td>
				</tr>
				<tr>
					<td>
						<label>新闻类别：</label>
					</td>
					<td>
						<select id="typeId" name="typeId">
							<option value="">请选择新闻类别</option>
								<option value="">科技新闻</option>
								<option value="">科技新闻</option>
								<option value="">科技新闻</option>
								<option value="">科技新闻</option>
						</select>
						<font id="errorType" color="red"></font>
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
					<td valign="top">
						<label>新闻内容：</label>
					</td>
					<td>
						<textarea class="ckeditor" id="content" name="content">2016年的尾巴，百度又获得了一次刷屏。它以近亿估值全资收购了“李叫兽”公众号及其团队，“李叫兽”本名李靖，出生于1991年，有一系列营销方法论，成了百度最年轻的副总裁。

　　有人感慨，都说百度收购的动作慢了，但快起来还是有点眼花缭乱，不知道它这一个亿买了什么？其实，对百度而言，花这点钱不算什么，另外，百度副总裁有二十多位，并不意味着李靖就进入了核心管理层。岁尾给公司注入更有活力的血液，这笔钱花得还算值。

　　将日历翻回一个半月前，北京已是初冬，乌镇依然满眼翠绿。小镇一年中最沸腾的日子就在这几天，中文互联网世界最有话语权的人齐聚于此。每到黄昏，细雨洒落小巷，最具价值的时光才刚刚开始，那些或喧嚣或隐秘的宴会，比白天正襟危坐的论坛更有嚼头。

　　11月17日晚，乌镇78号民宿，百度董事长李彦宏做东请客。这次聚会没有网易CEO丁磊的“互联网半壁江山饭局”那样出名，更像私人小聚，门口没有记者蹲守，事后也没有流传出段子。到场的有杨致远、雷军、田溯宁、沈南鹏、龚宇等。他们都是李彦宏比较谈得来的朋友，这些人坐在一起，你很容易在他们身上找到共同特点，那就是理性与冷静。据说，那天有一半的时间，大家都在讨论乐视。当时乐视危机刚刚浮出水面，从11月2日至7日，四个交易日内市值蒸发128亿元。

　　没有人提到百度在这一年所遇到的危机，那天是李彦宏48岁生日，这个猴年，他过得相当不平静。</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="newsId" name="newsId" value=""/>&nbsp;
					</td>
					<td>
						<input type="button" id="btnSubmit" class="btn btn-primary" value="保存新闻"/>&nbsp;&nbsp;
						<input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>&nbsp;&nbsp;<font id="errorContent" color="red"></font>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>	
</body>
</html>