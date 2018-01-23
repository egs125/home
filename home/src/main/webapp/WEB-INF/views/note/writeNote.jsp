<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>My Home</title>
	
	<script type="text/javascript" src="/home/resources/js/jquery-3.2.1.min.js"></script>
	
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<script src="/home/resources/js/note/writeNote.js"></script>
	
	<link rel="stylesheet" href="/home/resources/css/writeNote.css">
	
	<!-- CKEditor -->
	<script src="//cdn.ckeditor.com/4.8.0/standard/ckeditor.js"></script>
	
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div id="location" class="jumbotron">
		<h2>WRITE NOTES</h2>
		<h4> - How to make this website</h4>
	</div>
	
	<div id="main">
		<div id="writing">
			<form action="writeNote" method="POST" name="newNoteForm">
			<div class="input-group input-group-lg">
				<span class="input-group-addon" id="sizing-addon1">Title </span>
			  	<input name="title" id="title" type="text" class="form-control" aria-describedby="sizing-addon1" required style="width:100%;">
			</div>	
			<br>
			<textarea name="contents" id="contents" rows="10"></textarea>		
		</form>
		</div>
		<br>
		<br>
		<div id="btns">
			<button id="writeBtn" class="btn btn-primary">Write</button>
			&nbsp;&nbsp;&nbsp;
			<button class="btn btn-default" onclick="history.go(-1)">Back</button>
		</div>
		
	</div>
	
</body>
</html>