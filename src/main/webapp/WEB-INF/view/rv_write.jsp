<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/rv_write.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Insert title here</title>
<script type="text/javascript"
	src="static/sdk/nhn-se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<!-- <script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
 -->
</head>
<body>

	<form name="frm" id="frm" method="post" action="rv_insert.do">


		<a href="rv_list.do">목록으로가라</a> <input type="button" id="btnSave"
			value="저장" />
		<table id="type4">
			<tr>
				<th>SUBJECT</th>
				<td id="type4_td">
				<input id="title_write" type="text" name="rv_title" placeholder="제목을 입력하세요" /></td>
				<td></td>
				<td></td>
			</tr>

			<tr>
				<th>NAME</th>
				<td><input id="name_write" type="text" value="${mem_id}" name="mem_id" /></td>
			</tr>

			<tr>
				<!-- <td>내용</td> -->
				<td colspan="2">
					<textarea id="cont_write" name="rv_content"></textarea>
				</td>
			</tr>

			<tr>

				<td id="123"></td>
				<td></td>




				<!-- <td style="float:right;"><input type="submit" value="글쓰기" id="btn_write"/> -->
				<!-- <input type="reset" value="취소" id="btn_cancel" onclick="history.back()" /></td> -->
			</tr>
		</table>

		<div id="please">
			<span class="registercheck">

				<span class="cancelcheck"> <a href="rv_list.do" id="btn_list">삭제</a>
			</span>
			</span>
		</div>

	</form>
</body>
<script type="text/javascript" src="js/regReview.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$('#btnSave').on('click',function(){
		obj.getById["cont_write"].exec("UPDATE_CONTENTS_FIELD",[]);
		 $('[name=rv_content]').val($('[name=rv_content]').val().replace(/\n/gi, '<br/>')); 		
		  
		if($('#title_write').val()==""){
				alert("제목을 입력하세요")
				return false;
			}
		 
		  $('#frm').submit();
	});	
});
</script>
</html>