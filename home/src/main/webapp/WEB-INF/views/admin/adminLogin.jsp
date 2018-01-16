<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>My Home</title>

	<!-- <link rel="stylesheet" type="text/css" href="/blog/resources/css/home.css" /> -->
	<script src="/home/resources/js/jquery-3.2.1.min.js"></script>
	
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<style>
		#loginDiv
		{
			padding : 5%;
		}
		
		
	
	</style>	
</head>
<body>
	
	<form action="login" method="POST" name="loginform">
		<div id="loginDiv">
			ID : <input type="text" id="id" name="id" />
			<br>
			PW : <input type="text" id="pw" name="pw" />
			<br>
			<button id="loginBtn" type="submit" class="btn btn-default"> Login </button>
		</div>
	</form>
	
</body>
</html>