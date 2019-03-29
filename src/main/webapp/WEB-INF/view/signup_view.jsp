<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/listView.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript" src="js/signup.js"></script>
<!-- multistep form -->
</head>
<body>
	<form id="list" enctype="multipart/form-data">
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">Create your account</h2>
			<h3 class="fs-subtitle">환영합니다.</h3>
			<input type="text" name="mem_id" id="mem_id" placeholder="Id" />
			<div class="checkfont" id="idcheck"></div>

			<input type="password" name="mem_pw" id="mem_pw"
				placeholder="Password" />
			<div class="checkfont" id="pwcheck"></div>

			<input type="password" name="cpass" id="mem_pw2"
				placeholder="Confirm Password" />
			<div class="checkfont" id="cpwcheck"></div>

			<input type="text" name="mem_name" id="mem_name" placeholder="Name" />
			<div class="checkfont" id="namecheck"></div>

			<input type="tel" name="mem_phone" id="mem_phone" placeholder="Phone" />
			<div class="checkfont" id="phonecheck"></div>
			<div>
			<input type="text" name="mem_mail" id="mem_mail" placeholder="Email" />
			<div class="checkfont" id="emailcheck"></div>
			</div>
			<div>
			<input type="text" name="mem_mailcode" id="mem_mailcode" style="width:140px;" placeholder="인증번호입력" />
			<button type="button" id="emailcode" class="submit action-button">인증번호 전송</button><button type="button" id="emailcodechk" style="display: none;" class="submit action-button">인증번호 확인</button>
			<div class="checkfont" id="emailcodecheck"></div>
			</div>
			<img src="images/nullImg.jpg" id="null_mem_pic" style="width: 100px; height: 100px; margin-bottom: 20px;" />
			<img src="#" id="mem_pic_box" style="display:none; width: 100px; height: 100px; margin-bottom: 20px;" />
			<input type="file" name="file" id="mem_pic" value="프로필사진 첨부" />
		
			<input type="button" name="back" id="backBtn" class="back action-button" value="Back" /> 
			<input type="submit" name="submit" id="registerBtn"	class="submit action-button" value="Submit" />
		</fieldset>
	</form>
</body>
</html>
