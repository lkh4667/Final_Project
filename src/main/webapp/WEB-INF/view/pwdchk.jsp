<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<form id="frm">
<div type="text" name="mem_name"><%=session.getAttribute("id") %>
<input	class="inputLabel" type="password" name="mem_pw" id="mem_pw" placeholder="비밀번호" style="margin-bottom: 20px;">
<div id="check"></div>
<button id="pwdchkBtn" value="확인"></button>
</form>
</body>
</html>