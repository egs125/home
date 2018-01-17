<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<script>
		$(function(){
			var trigger = $("#trigger");
			var menu = $("nav ul");
			$(trigger).on('click', function(e){
				menu.slideToggle();
			});
			
			$(window).resize(function(){
				var w = $(window).width();
				if(w > 320 && menu.is(":hidden")){
					menu.removeAttr("style");
				}
			});
		});
	
	</script>
	
	<style>
		.clearfix : before,
		.clearfix : after {
			content : " ";
			display : table;
		}
		
		.clearfix : after {
			clear : both;
		}
		
		.clearfix {
			zooom : 1;
		}
			
		nav {
			height : 40px;
			width : 100%;
			background : #34495e;
			font-size : 1em;
			font-family : Arial, sans-serif;
			font-weight : bold;
			position : relative;
			border-bottom : 2px soild #34495e;
		}
		
		nav ul {
			width : 600px;
			height : 40px;
		}
		
		nav li {
			display : inline;
			float : left;
		}
	
		nav a, nav span {
			color : #fff;
			display : inline-block;
			width : 100px;
			text-align : center;
			text-decoration : none;
			line-height : 40px;
			text-shadow : 1px 1px 0px #283744;
		}
		
		nav li a {
			border-right : 1px solid #576979;
			box-sizing : border-box;
			-moz-box-sizing : border-box;
			-webkit-box-sizing : border-box;
		}
		
		nav li:last-chilld a {
			border-right : 0;
		}
		
		nav a:hover, nav a:active, nav span {
			background-coloor : #2c3e50;
		}
		
		nav #trigger {
			display : none;	
		}
		
		
		@media screen and (max-width : 600px) {
			nav {
				height : auto;
			}
			
			nav ul {
				width : 100%;
				display : block;
				height : auto;
			}
			
			nav li {
				width : 50%;
				float : left;
				position : relative;
			}
			
			nav li a {
				border-bottom : 1px solid #576979;
				border-right : 1px solid #576979;
			}
			
			nav a {
				text-align : left;
				width : 100%;
				text-indent : 25px;
			}
		}
		
		@media screen and (max-width : 320px) {
			nav {
				border-bottom : 0;
			}
			
			nav ul {
				display : none;
				height : auto;
			}
			
			nav li {
				display : block;
				float : none;
				width : 100%;
			}
			
			nav li a {
				border-bottom : 1px solid #576979;
			}
			
			nav #trigger {
				display : block;
				background-color : #283744;
				width : 100%;
				position : relative;
				cursor : hand;
			}
			
			nav #trigger : after {
				content : "";
				width : 30px;
				height : 30px;
				display : inline-block;
				position : absolute;
				right : 15px;
				top : 10px;
			}
		
		}
	</style>
</head>
<body>

	<nav class="clearfix">
		<ul class="clearfix">
			<li><a href="#">HOME</a></li>
			<li><a href="#">ABOUT</a></li>
			<li><a href="#">MAKING</a></li>
			<li><a href="#">GUESTS</a></li>
			<li><a href="/home/loginView">ADMIN</a></li>
		</ul>
		<span id="trigger"><span class="glyphicon glyphicon-align-justify" aria-hidden="true">&nbsp MENU</span></span>
		
	</nav>

</body>
</html>