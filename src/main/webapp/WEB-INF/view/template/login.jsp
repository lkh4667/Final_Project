<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<%@page import="org.springframework.util.StringUtils"%><body>
	<script type="text/javascript">

$(document).ready(function () {
	$('#signIn').on('click', function () {
		 //$("#signInModal").modal("show"); 
		 location.href="loginPro.do";
	});
	
	var sessionId='<%=(String)session.getAttribute("id")%>';
	 $('#logOutBtn').on('click',function(){
		location.href="logout.do";
		alert('로그아웃 되었습니다.');
	}); 
});

</script>
	<%
		if (null == session.getAttribute("id") || StringUtils.isEmpty(session.getAttribute("id"))) {
	%>
	<strong><a href="#" id="signIn">로그인</a></strong>
	<%
		} else {
	%>
	<strong>
	<a href="myPage.do" id="session" style="color: yellow;">
		<%= session.getAttribute("name") %></a><span>
			님 환영합니다.</span></strong>
	<c:if test="${id == 'admin'}">
	<strong>
		<a style="color: yellow;"><%= session.getAttribute("name") %></a><span>
			님 환영합니다.</span></strong>
		<span><a href="admin.do" id="adminPagePro">관리자 페이지로 이동</a></span>
	</c:if>
	<span><button id="logOutBtn">로그아웃</button></span>
	<%
		}
	%>
	<!-- <strong><a href="#">회원가입</a></strong> -->
 </body>
</html>

