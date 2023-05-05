<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div class="datas news_type_list">
		<ul>
			<c:forEach var="newsList" items="${newsListWithType }">
				<li>
					<span>
						<%--[<fmt:formatDate value="${newsList.publishDate }" type="date" pattern="yyyy-MM-dd"/>]--%>
					</span>&nbsp;&nbsp;
					<a href="news?action=detail&newsId=${newsList.newsId }" title="${newsList.title }">
						${fn:substring(newsList.title,0,42) }
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		${pageCode }
	</div>
</div>