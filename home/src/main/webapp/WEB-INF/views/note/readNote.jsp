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
	<script src="/home/resources/js/note/readNote.js"></script>
	
	<link rel="stylesheet" href="/home/resources/css/readNote.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div id="location" class="jumbotron">
		<h2>READ NOTES</h2>
		<h4> - How to make this website</h4>
	</div>
	<div id="main">
		<div id="reading">
			
			<input type="text" id="sn" value="${vo.sn}">
			<br>
			<div id="noteTitle">
				<h4>${vo.title}</h4>
			</div>
			
			<br>
			<div id="noteContents">
			${vo.contents }	
			</div>
				
		</div>
		<br><br>
		<div id="btns">
		
			<input class="btn btn-default" type="button" value="Update" id="toWrite">
			&nbsp;&nbsp;&nbsp;
			<input class="btn btn-default" type="button" value="Back" onclick="history.go(-1)">

		</div>
	</div>
	
	
</body>
</html>