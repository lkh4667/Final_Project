<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#menu-strong{
	font-size: 3em;
	text-align: center;
	height: 50px;
	background-color: red;
	padding-left: 0;
	
}
.row1{
	margin: auto;
	width: 800px;
	height: 50px;
	
}


	
</style>
</head>
<body>
	
	<div class="row1" ><!-- style="width: 100%; flex-wrap: nowrap; text-align: center; padding-left: 600px;" -->
		<strong id='menu-strong' class="menu-re ff"><a href="main.do" class="jh" style="color: white;">LIBRARY</a></strong>&nbsp;&nbsp;&nbsp;&nbsp;
		<strong id='menu-strong' class="menu-re"><a href="popular.do" class="jh" style="color: white;">POPULAR</a></strong>&nbsp;&nbsp;&nbsp;&nbsp;
		<strong id='menu-strong' class="menu-re"><a href="rv_list.do" class="jh" style="color: white;">REVIEW</a></strong>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${id != 'admin' }">
		<strong id='menu-strong' class="menu-re"><a href="challenge.do" class="jh" style="color: white;">MYBUCKET</a></strong>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
		<strong id='menu-strong' class="menu-re"><a href="about.do" class="jh" style="color: white;">ABOUT</a></strong>
	</div>
	
	
</body>
</html>