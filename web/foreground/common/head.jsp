<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid">
      <div class="logo">
          <div class="logo_img">
              <img src="images/logo.jpg" width="80px" alt="闪电新闻网" title="闪电新闻网" />
              <h2 style="font-family:Arial,ui-serif;position: absolute; left: 390px; top:20px;">闪电新闻网</h2>
          </div>
          <div class="weather">
          </div>
      </div>
</div>
<div class="row-fluid">
	<div class="span12">
		<div class="navbar">
		  <div class="navbar-inner">
		    <a class="brand" href="#">首页</a>
		    <ul class="nav">
				<c:forEach var="types" items="${types}">
		       		<li><a href="#">${types.typeName}</a></li>
				</c:forEach>
		    </ul>
		  </div>
		</div>
	</div>
</div>