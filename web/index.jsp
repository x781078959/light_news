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
<title>闪电新闻网</title>
<link href="style/news.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="style/index.css" rel="stylesheet" />
<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="js/slider.js"></script>
<script type="text/javascript">
	$(function() {
		$('#focus').flexslider({
			animation : "slide",
			direction : "horizontal",
			easing : "swing"
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
					<li><div class="img">
							<img src="images/focus01.jpg" />
						</div></li>
					<li><div class="img">
							<img src="images/focus02.jpg" />
						</div></li>
					<li><div class="img">
							<img src="images/focus2.jpg" />
						</div></li>
				</ul>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span4">
				<div class="data_list news_list">
					<div class="dataHeader">
						军事新闻 <span class="more"> <a href="#">更多...</a>
						</span>
					</div>
					<div class="datas">
						<ul>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="span4">
				<div class="data_list news_list">
					<div class="dataHeader">
						军事新闻 <span class="more"> <a href="#">更多...</a>
						</span>
					</div>
					<div class="datas">
						<ul>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="span4">
				<div class="data_list news_list">
					<div class="dataHeader">
						军事新闻 <span class="more"> <a href="#">更多...</a>
						</span>
					</div>
					<div class="datas">
						<ul>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
							<li>01-03&nbsp; <a href="#" title="辽宁舰赴南海为何要全程飙高速 暴露反潜战力短板">
									辽宁舰赴南海为何要全程飙高速 暴露反 </a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="/foreground/common/foot.jsp" />
	</div>
</body>
</html>