<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<style>
* {
	margin: 0px;
}

.login-row {
	width: 100%;
	background: green;
	height: 29px;
	text-align: right;
}

header {
	width: 100%;
	height: 67px;
	background-color: aqua;
}


p {
	margin-bottom: 0px;
}

menu {
	height: 50px;
	background-color: red;
	width: 100%;
}

section {
	/* 	overflow-y: scroll; */
	/* 	padding-left:130px; */
 	/*  width: 100%; */
/* 	padding-top:20px;
 	background-color: black;
	height: 100px;
	text-align: center; */
	
	
}

footer {
	padding-top:20px;
    background-color: aquamarine;
	height: 100px;
	clear: both;
}
</style>

</head>
<body id="wrap">
	<script type="text/javascript">
		
	</script>
	<div class="login-row">
		<p style="margin-right: 20px;">
			<tiles:insertAttribute name="login" />
		</p>
	</div>
	<header>
			<tiles:insertAttribute name="header" />
	</header>
	<div class="main-image-row">
			<tiles:insertAttribute name="main_image" />
	</div>
	
	<menu>
		<tiles:insertAttribute name="menu" />
	</menu>
	
	<section>
		<tiles:insertAttribute name="category" />
	</section>
	
	<tiles:insertAttribute name="body" />
	<footer>
			<tiles:insertAttribute name="footer" />
	</footer>

</body>
</html>