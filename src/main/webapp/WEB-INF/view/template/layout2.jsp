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

.main-image-row {
	/* position: fixed;
	top: 0;
	left: 0; */
	width: 100%;
	background-color: pink;
	height: 400px;
	/* transition: all 1s ease-in; */
}

/* .main-image-row:hover {
	height: 100px;
} */
/* 
@keyframes example {
from{ height: -293px; }
to { height: -293px; }

} */
p {
	margin-bottom: 0px;
}

menu {
	height: 50px;
	background-color: teal;
	width: 100%;
	padding-left: 0px;
	text-align: center;
}

section {
	padding-top:20px;
	padding-left:130px;
 	background-color: black;
 	width: 100%;
	height: 100px;
	text-align: center;
	/* 	overflow-y: scroll; */
}

footer {
	padding-top:20px;
    background-color: aquamarine;
	height: 100px;
	clear: both;
}
</style>

</head>
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
	<menu>
		<tiles:insertAttribute name="menu" />
	</menu>
	<tiles:insertAttribute name="body" />
	<footer>
			<tiles:insertAttribute name="footer" />
	</footer>

</html>