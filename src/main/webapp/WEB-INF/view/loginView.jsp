<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/listView.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript" src="js/login_modal.js"></script>
<!-- multistep form -->
</head>
<body>
	<form id="list" method="post">
		<!-- fieldsets -->
		<fieldset>
			<input type="text" name="mem_id" id="mem_id" placeholder="Id" />
			<input type="password" name="mem_pw" id="mem_pw"
				placeholder="Password" />
			<input type="button" name="back" class="back action-button"
				value="Back" /> <input type="button" name="submit" id="loginBtn"
				class="submit action-button" value="Submit" />
				<div>
				<hr style="line-height: 20px; color: #8e8e8e">
				</div>
						
				<a href="/" id="signIn"class="memSearchBtn" id="signUp2Btn"
							style="background-color: transparent; border: none;">
							아이디 찾기<img src="" />
						</a>
						<button class="memSearchBtn"
							style="background-color: transparent; border: none;">
							비밀번호 찾기<img src="" />
						</button>
						<button class="memSearchBtn" id="signUpBtn"
							style="background-color: transparent; border: none;">
							회원가입<img src="" />
						</button>
						<c:if test="${param.prevUrl != null }">
							<input type="hidden" id="Urlvalue" value="${param.prevUrl}"/>
						</c:if>
						<input type="hidden" id="Urlvalue" value="${param.returnUrl}"/>
		</fieldset>
	</form>
</body>

</html>
