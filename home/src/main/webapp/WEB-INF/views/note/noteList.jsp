<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page isELIgnored="false" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>My Home</title>
	
	<script type="text/javascript" src="/home/resources/js/jquery-3.2.1.min.js"></script>
	<script src="/home/resources/js/note/noteList.js"></script>
	
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
	<link rel="stylesheet" href="/home/resources/css/noteList.css">
	
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div id="location" class="jumbotron">
		<h2>MAKING NOTES</h2>
		<h4> - How to make this website</h4>
	</div>
	
	<div id="main">
		<div id="tablePanel" class="panel panel-default">
		<div id="loading">
			<img src="/home/resources/img/loader.gif" />
		</div>
		<table class="table">
			<thead>
				<tr id="head">
					<th>#</th>
					<th>Title</th>
					<th>Date</th>
				</tr>
			</thead>
			
			<tbody>
			<c:choose>
			<c:when test="${list} ne null">
				<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.sn}</td>
					<td>${list.title}</td>
					<td>${list.insertDt }</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="3">불러올 글이 없습니다</td></tr>
			</c:otherwise>
			</c:choose>
			</tbody>
		</table>
		</div>
		<br>
		<c:if test="${admin ne null }">
		<div id="btn">
			<button id="toWrite" class="btn btn-default">Write</button>
		</div>
		</c:if>
		<br>
		
		<div id="paging">
		<nav>
			<ul class="pagination">
		    	<!--<li id="prevBtn"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		    	 <li><a href="#">1 </a></li>
		    	<li><a href="#">2 </a></li>
		    	<li><a href="#">3 </a></li>
		    	<li><a href="#">4 </a></li>
		    	<li><a href="#">5 </a></li> 
		    	<li id="nextBtn"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>	   --> 	
			</ul>
		</nav>
		</div>	
	</div>
</body>
</html>