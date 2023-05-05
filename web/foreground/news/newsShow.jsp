<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div>
		<div class="news_title"><h3>${news.title }</h3></div>
		<div class="news_info">
			发布时间：[<fmt:formatDate value="${news.publishDate }" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/>]&nbsp;&nbsp;作者：${news.author }
			&nbsp;&nbsp;新闻类别：[${news.typeName }]&nbsp;&nbsp;阅读次数：${news.click }
		</div>
		<div class="news_content">
			${news.content }
		</div>
	</div>
</div>