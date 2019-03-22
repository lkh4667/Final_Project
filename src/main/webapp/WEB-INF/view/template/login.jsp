<%@page import="org.springframework.util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body>
	<script type="text/javascript">


$(document).ready(function () {
	$('#signIn').on('click', function () {
		 //$("#signInModal").modal("show"); 
		
		 location.href="loginPro.do";
	});
	
	/* 	$('loginBtn').on('click',function(){
	$('#signInModal').modal('show');
}); */
	var sessionId='<%=(String)session.getAttribute("id")%>';
	if(sessionId=='admin'){
		$('#adminPagePro').css('display', '');
	}
	
	$('#session').on('click',function(){
			location.href="myPage.do";
	});
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
	<%-- <img src="/user_img/<%=session.getAttribute("pic")%>" id="mem_pic_box" style="display:none; width: 100px; height: 100px;" /> --%>
	<a href="myPage.do" id="session" style="color: yellow;">
	<%=session.getAttribute("name")%></a><span>
			님 환영합니다.</span></strong>

	<span><a href="admin.do" id="adminPagePro" style="display: none;">관리자 페이지로 이동</a></span>

	<span><button href="/bk_list.jsp" id="logOutBtn">로그아웃</button></span>
	<%
		}
	%>
	<!-- <strong><a href="#">회원가입</a></strong> -->
 </body>
</html>

