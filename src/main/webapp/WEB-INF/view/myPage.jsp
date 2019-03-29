<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="css/mypageView.css">
<title>Insert title here</title>
<script type="text/javascript">

$(document).ready(function () {
	$('#picUptBtn').on('click', function(){
		$('#myModal').modal('show');
	});
});
</script>
</head>
<body>
	<div class="tablebody">

		<form id="list" action="myPage.do" enctype="multipart/form-data" >
			<div class="title">회원 프로필</div>
			<table class="type03" style="margin-left: 200px; height:300px;">
				<tr>
					<th scope="row">회원아이디</th>
					<td class="even">${mdto.mem_id}</td>
				</tr>
				<tr>
					<th scope="row">회원이름</th>
					<td class="even">${mdto.mem_name}</td>
				</tr>
				<tr>
					<th scope="row">회원전화번호</th>
					<td>${mdto.mem_phone}</td>
				</tr>
				<tr>
					<th scope="row">회원이메일</th>
					<td class="even">${mdto.mem_mail}</td>
					
				</tr>
			</table>
				<button class="buttonCst" id="ReviseBtn">회원수정</button>
				<span style="padding-left: 10px;"></span>
				<button class="buttonCst" id="DeleteBtn">회원탈퇴</button>
			<table class="type03" style="height:300px;">
			<tr class=picHeight>
					<th scope="row">회원사진</th>
					<td>
						<div class="pic_frame">
							<img src="images/nullImg.jpg" id="null_mem_pic"
								style="width: 100px; height: 100px;" />
							<img src="/userImg/${mdto.mem_pic}" id="mem_pic_box"
								style="width: 100px; height: 100px; display:none; border-radius: 30px;"/>
						</div>
						<br />
						<button type="button" id="picUptBtn"
							class="buttonCst" value="프로필 사진 변경" style="width:110px; font-size: medium;">변경</button>
						</td>
				</tr>
			</table>	
		</form>
			<input type= "hidden" id="pic"  value="/userImg/${mdto.mem_pic}"/>
	</div>
</body>
<script type="text/javascript" src="js/mempage.js"></script>
<jsp:include page="modal.jsp" />
</html>