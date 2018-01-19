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
	
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div class="jumbotron">
		READ NOTE
	</div>
	<%-- <input type="text" id="sn" value="${sn}"> --%>
	<div id="main">
		<div id="editor">
			${vo.sn}
			<br>
			${vo.title }
			<br>
			${vo.contents }		
		</div>
		
		<div id="btns" align="right">
		
			<input class="btn btn-default" type="button" value="Write" onclick="history.go(-1)">
			&nbsp;&nbsp;&nbsp;
			<input class="btn btn-default" type="button" value="취소" onclick="history.go(-1)">
			<!-- <input class="btn btn-default" type="button" value="저장" id="save">
			&nbsp;&nbsp;&nbsp;
			<input class="btn btn-default" type="button" value="취소" onclick="history.go(-1)">	 -->
		</div>
	</div>
	
	
</body>
</html>