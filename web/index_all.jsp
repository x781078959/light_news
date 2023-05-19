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
<%--	<base href="<%=basePath%>">--%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>闪电新闻网</title>
	<link rel="icon" href="images/logo.jpg">
	<link href="style/news.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<link  href="style/index.css" rel="stylesheet"/>
	<script src="bootstrap/js/jQuery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="js/slider.js"></script>
	<script type="text/javascript">
		try {
			window.console && window.console.log && (console.log("这是一个最好的时代，\n科技的发展给予了每个人创造价值的可能性；\n这也是一个最充满想象的时代，\n每一位心怀梦想的人，终会奔向星辰大海。\n百度与你们一起仰望星辰大海，携手共筑未来！\n"),
					console.log("%c百度2023校园招聘简历投递：https://talent.baidu.com/jobs/list", "color:red"))
		} catch (e) {}
		$(function(){
			$('#focus').flexslider({
				animation: "slide",
				direction:"horizontal",
				easing:"swing"
			});
		});

	</script>
</head>
<body>
<div class="container">
	<jsp:include page="/foreground/common/head.jsp" />
	<div class="row-fluid">
		<div id="focus" class="flexslider">
			<ul class="slides">
				<li><div class="img"><img src="images/focus01.jpg" /></div></li>
				<li><div class="img"><img src="images/focus02.jpg" /></div></li>
				<li><div class="img"><img src="images/focus01.jpg" /></div></li>
			</ul>
		</div>
	</div>
	<c:forEach var="allIndexNews" items="${allIndexNewsList }" varStatus="allStatus">
		<c:if test="${allStatus.index%3==0 }">
			<div class="row-fluid">
		</c:if>
		<c:forEach var="indexNews" items="${allIndexNews }" varStatus="oneStatus">
			<c:if test="${oneStatus.first }">
				<div class="span4">
				<div class="data_list news_list">
				<div class="dataHeader">
						${newsTypeList.get(allStatus.index).typeName }
					<span class="more">
								<a href="news?action=newsList&typeId=${ newsTypeList.get(allStatus.index).newsTypeId}">更多...</a>
							</span>
				</div>
				<div class="datas">
				<ul>
			</c:if>
			<li>
				<fmt:formatDate value="${indexNews.publishDate }" type="date" pattern="yyyy-MM-dd"/>&nbsp;
				<a href="news?action=detail&newsId=${indexNews.newsId }" title="${indexNews.title }">
						${fn:substring(indexNews.title,0,21) }
				</a>

			</li>
			<c:if test="${oneStatus.last }">
				</ul>
				</div>
				</div>
				</div>
			</c:if>
		</c:forEach>
		<c:if test="${allStatus.index%3==2 || allStatus.last }">
			</div>
		</c:if>
	</c:forEach>

	<jsp:include page="/foreground/common/link.jsp" />
	<jsp:include page="/foreground/common/foot.jsp" />
</div>
</body>
</html>