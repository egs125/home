<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>My Home</title>
	
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<script src="/home/resources/js/jquery-3.2.1.min.js"></script>
	<script src="/home/resources/js/note/noteList.js"></script>
	
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div id="main">
	
		<div id="tablePanel" class="panel panel-default">
		<table class="table">
			<tr id="head">
				<th>#</th>
				<th>Title</th>
				<th>Date</th>
			</tr>
		</table>
		</div>
		
		<br><br>
		
		<div id="paging">
		<nav>
			<ul class="pagination">
		    	<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		    	<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		    	<li><a href="#">2 </a></li>
		    	<li><a href="#">3 </a></li>
		    	<li><a href="#">4 </a></li>
		    	<li><a href="#">5 </a></li>
		    	<li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>	    	
			</ul>
		</nav>
		</div>	
	</div>
	

</body>
</html>