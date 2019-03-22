<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	회원 프로필
	<form id="list" action="memUpdate.do" method="post">
		<table class="type01">
			<tr>
				<th scope="row">회원아이디</th>
				<td>${mdto.mem_id}</td>
			</tr>
			<tr>
				<th scope="row">회원이름</th>
				<td>${mdto.mem_name}</td>
			</tr>
			<tr>
				<th scope="row">회원 비밀번호</th>
				<td><input type="password" name="mem_pw" id="mem_pw"
					placeholder="비밀번호"></td>
				<div class="checkfont" id="pwcheck"></div>
			</tr>
			<tr>
				<th scope="row">회원 비밀번호 재 확인</th>
				<td><input type="password" name="mem_pw2" id="mem_pw"
					placeholder="비밀번호"></td>
				<div class="checkfont" id="cpwcheck"></div>
			</tr>
			<tr>
				<th scope="row">회원전화번호</th>
				<td><input type="tel" name="mem_phone" id="mem_phone"
					placeholder="전화번호"></td>
				<div class="checkfont" id="phonecheck"></div>
			</tr>
			<tr>
				<th scope="row">회원 이메일</th>
				<td>${mdto.mem_mail}<button id="emailupdateBtn" class="submit action-button">이메일 변경</button></td>
			</tr>
			<%-- <tr>
        <th scope="row">회원사진</th>
        <td><img src="/user_img/${mdto.mem_pic}" id="mem_pic_box" style="swidth: 100px; height: 100px;" /></td>
    	<input type="file" name="upfile" id="mem_pic" value="프로필사진 변경" />
    	<img src="#" id="mem_pic_box" style="display:none; width: 100px; height: 100px;" />
    </tr> --%>
		</table>
		<button id="ReviseBtn" type="submit">회원수정</button>
		<span style="padding-left: 50px;"></span>
		<button id="BackBtn">BACK</button>

	</form>
</body>
<script type="text/javascript" src="js/mem_update.js"></script>
</html>