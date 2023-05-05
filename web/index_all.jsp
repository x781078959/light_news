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
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>闪电新闻网</title>
	<link href="style/news.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<link  href="style/index.css" rel="stylesheet"/>
	<script src="bootstrap/js/jQuery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="js/slider.js"></script>
	<script type="text/javascript">
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
				<%--<fmt:formatDate value="${indexNews.publishDate }" type="date" pattern="MM-dd"/>&nbsp;--%>
				<a href="news?action=detail&newsId=${indexNews.newsId }" title="${indexNews.title }">
						${fn:substring(indexNews.title,0,18) }
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