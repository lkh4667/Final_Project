<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/rv_write.css">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function () {
	$('#btnSave').on('click',function(){
		  $('[name=rv_content]').val(
					$('[name=rv_content]').val().replace(/\n/gi, '<br/>')); 		
		  
		if($('#title_write').val()==""){
				alert("제목을 입력하세요")
				return false;
			}
		  
		  if($('#cont_write').val()==""){
				alert("내용을 입력하세요")
				return false;
			}
		  $('#frm').submit();
	});	
	
	/* 공백입력시 처리해주는거 */
/* function check(){
	var str = document.getElementById('title_write');
	var blank_pattern =  /[\s]/g;
	if(blank_pattern.test(str.value)==true){
		alert('공백은 사용할 수 없습니다.');
		return false;
	} */

	

});
</script>
</head>
<body>

	<form name="frm" id="frm" method="post" action="rv_updateEnd.do">


		<a href="rv_list.do">목록으로가라</a>
		<input type="button" id="btnSave" value="저장" />
		<table id="type4">
			<tr>
				<th>SUBJECT</th>
					<td id="type4_td">
						<input id="title_write" type="text" name="rv_title" value="${dto.rv_title}" /></td>
					<td></td>
					<td></td>
			</tr>

			<tr>
				<th>NAME</th>
				<td><input id="name_write" type="text" value="${sessionScope.id}" name="mem_id" /></td>
			</tr>

			<tr>
				<!-- <td>내용</td> -->
				<td colspan="2">
					<textarea id="cont_write" name="rv_content" >${dto.rv_content}</textarea>
				</td>
			</tr>

			<tr>

				<td id="123"></td>
				<td></td>


				<!-- <td style="float:right;"><input type="submit" value="글쓰기" id="btn_write"/> -->
				<!-- <input type="reset" value="취소" id="btn_cancel" onclick="history.back()" /></td> -->
			</tr>
		</table>
		<input type="hidden" name="rv_num" value="${dto.rv_num}" />
		<input type="hidden" name="currentPage" value="${currentPage}" />
		

		<div id="please">
			<span class="registercheck">
				<span class="cancelcheck">
					<a href="rv_list.do" id="btn_list">삭제</a>
				</span>
			</span>
		</div>

	</form>
</body>
</html>