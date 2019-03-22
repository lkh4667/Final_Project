<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="css/mypageView.css">
<title>Insert title here</title>
</head>
<body>
	<div class="tablebody">

		<form id="list" action="myPage.do">
			<div class="title">회원 프로필</div>
			<table class="type03" style="margin-left: 200px;">
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
			<table class="type03">
			<tr class=picHeight>
					<th scope="row">회원사진</th>
					<td>
						<div class="pic_frame">
							<img src="images/nullImg.jpg" id="null_mem_pic"
								style="width: 100px; height: 100px; " />
							<img src="/userImg/${mdto.mem_pic}" id="mem_pic_box"
								style="swidth: 100px; height: 100px; display:none; border-radius: 30px;"/>
						</div>
					</td>
				</tr>
			</table>	
				<button class="buttonCst" id="ReviseBtn">회원수정</button>
				<span style="padding-left: 10px;"></span>
				<button class="buttonCst" id="DeleteBtn">회원탈퇴</button>
			<div id="picvalue" style="display: none;">/userImg/${mdto.mem_pic}</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/mempage.js"></script>
</html>