<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>My Home</title>

	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<script src="/home/resources/js/jquery-3.2.1.min.js"></script>
		
	<style>
		#loginDiv
		{
			padding : 5%;
		}
		
		#loginDiv input 
		{
			width : 40%;
		}
	</style>	
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<form action="login" method="POST" name="loginform">
		<div id="loginDiv">
			<h3>관리자 로그인</h3>
			<br>
			<div class="input-group input-group-lg">
				<span class="input-group-addon" id="sizing-addon1">ID &nbsp </span>
			  	<input name="id" type="text" class="form-control" aria-describedby="sizing-addon1" required style="width:40%;">
			</div>		
			<div class="input-group input-group-lg">
				<span class="input-group-addon" id="sizing-addon1">PW</span>
			  	<input name="pw" type="password" class="form-control" aria-describedby="sizing-addon1" required style="width:40%;">
			</div>
			<br>
			<br>
			
			<button class="btn btn-primary" type="submit"> Login</button>
			&nbsp;&nbsp;&nbsp;
			<button class="btn btn-default" onclick="history.go(-1)">Back</button>
		</div>
	</form>
	
</body>
</html>