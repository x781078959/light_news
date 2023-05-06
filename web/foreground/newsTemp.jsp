<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闪电新闻网</title>
	<link rel="icon" href="<%=request.getContextPath()%>/images/logo.jpg">
<link href="style/news.css" rel="stylesheet">
<link href="style/index.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
<jsp:include page="/foreground/common/head.jsp"/>

<div class="row-fluid">
	<div class="span8">
		<jsp:include page="${mainPage }"/>
	</div>
	<div class="span4">
		<div class="data_list right_news_list">
			<div class="dataHeader">最新新闻</div>
			<div class="datas">
				<ul>
					<c:forEach var="newestNews" items="${newestNewsList }">
						<li><a href="news?action=detail&newsId=${newestNews.newsId }" title="${newestNews.title }">${fn:substring(newestNews.title,0,29) }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="data_list right_news_list">
			<div class="dataHeader">热门新闻</div>
			<div class="datas">
				<ul>
					<c:forEach var="hotNews" items="${hotNewsList }">
						<li><a href="news?action=detail&newsId=${hotNews.newsId }" title="${hotNews.title }">${fn:substring(hotNews.title,0,29) }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/foreground/common/foot.jsp"/>
</div>
</body>
</html>