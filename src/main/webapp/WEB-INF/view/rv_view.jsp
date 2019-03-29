<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/rv_view.css">
<script type="js/jquery-3.2.1.min.js"></script>
<script type="js/review.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

var urno='';
var writer = '${sessionScope.id}';

var update_text = '';
	$(document).ready(function() {
		$('#replyAddBtn').on('click', reply_list);
 		$(document).on('click', '.timeline button', reply_update_delete);
 		$(document).on('click', '#replyUpdateBtn', reply_update_send);
 		$(document).on('click', '#replyUpdateCancel', reply_update_cancel);
	});

	Handlebars.registerHelper("newDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		var hours = dateObj.getHours();
		var minutes = dateObj.getMinutes();
		
		/*두자리 숫자로 변환  */		
		month < 10 ? month = '0' + month : month;
		date < 10 ? date = '0' + date : date;
		hours < 10 ? hours = '0' + hours : hours;
		minutes < 10 ? minutes = '0' + minutes : minutes; 
		return year + ". " + month + ". " + date + " " + hours + ":" + minutes;
		
	});// registerHelper()
	

	function reply_list_result(res) {
		$('.timeline .time_sub').remove();
		$('.timeline .time_up_reply').remove();
		$('#replycntSmall').text('[' + res.length + ']');
		
		
		  $.each(res, function(index, value) {
			 var html = "";
			//handlebars를 이용하여 위에 주석과 똑같이 만들어주기
			 var source = "<div id = 'replyDiv' class='time_sub' id='{{rv_num}}'>"
					+ "<p>{{mem_id}}&nbsp; &nbsp; " 
					+ "{{newDate re_regdate}}"
				if(value.mem_id == writer){
						source = source + "<span id = 'btnSpan'><button type='button' id='{{re_num}}' class='updatebtn'>update</button>"
					+ "<button type='button' id='{{re_num}}'>delete</button></span></p>"
					+ "<p>{{re_content}}</p>";	
					 }
				else{ 
						 source = source  + "<p>{{re_content}}</p>";	
					}	
					
					html +=	"<div id = 'replyDiv' class='time_up_reply' id='"+value.rv_num+"' style='display: none'>";
					html +=	 "<table id = 'replyTableUpdate'>";
					html +=	"<tr><td ><p id = 'replyCancel'><a>"+value.mem_id+"&nbsp;</a>";
					html +=	 "<a id = 'replyUpdateCancel'>수정 취소</a>";
					html +=  "</p></td></tr><tr><td>";
					html +=	"<input type='text' class='form-control' id='upReplyText' value='"+value.re_content+"' />";
					html +=	"</td><td id ='registerBtn' rowspan = '2'>";
					html +=	"<div id = 'button_div'>";
					html +=	"<button type='button' id='replyUpdateBtn'>수 정</button>";
					html += "</div></td></tr></table></div>";	 
					
			var template = Handlebars.compile(source);
			$('.timeline').append(template(value));
			$('.timeline').append(html); 
			$('#ReplyText').val('');
		}); 
	}//end reply_list_result

	function reply_update_send() {
		  
		 var re_content = $(this).parents().parents().parents().children(':nth-child(1)').children().val();
		  $.ajax({
			type : 'GET',
			dataType : 'json',
			url : 'replyUpdate.do?rv_num='+'${dto.rv_num}'+'&re_num='+urno+'&re_content='+re_content,
			success : reply_list_result
		});  

		urno = '';

	}// end reply_update_send()

	function reply_update_delete() {
		//현재 이벤트가 발생된 객체를 가져오기
		if ($(this).text() == 'delete') {
			var drno = $(this).prop("id");
			$.ajax({
				type : 'GET',
				dataType : 'json',
				url : 'replyDelete.do?rv_num=${dto.rv_num}&re_num=' + drno,
				success : reply_list_result
			});
			
		} else if ($(this).text() == 'update') {
			urno = $(this).prop("id");
			console.log('urno= ' + urno);
			
			var time_up = $(this).parents().parents().parents();
			update_text = $(time_up).next().children().children(':nth-child(1)').children(':nth-child(2)').children(':nth-child(1)').children(':nth-child(1)').val();
		 	$(this).parents('#btnSpan').parents('.time_sub').next().css('display','');
			$(this).parents('#btnSpan').parents('.time_sub').css('display','none'); 
			
			//버튼 비활성화 시켜주기
			$('.updatebtn').attr('disabled', 'disabled');
		}
	}// end reply_update_delete()

	function reply_update_cancel(){
		$('.updatebtn').prop('disabled', false);
		var time_up = $(this).parents().parents().parents();
		var up_text = $(time_up).next().children(':nth-child(1)').children();
		$(up_text).val(update_text);
		$(this).parents().parents().parents().parents('.time_up_reply').css('display','none');
		$(this).parents().parents().parents().parents('.time_up_reply').prev().css('display','');
	}// end reply_update_cancel()
	
	//데이터가 입력되어있는지 아닌지 확인하기
	function reply_list() {
		if ($('#ReplyText').val() == '') {
			alert('Reply text를 작성하세요.');
			return false;
		}
 
 	$.ajax({
			type : 'POST',
			url : 'replyInsetList.do',
			dataType : 'json',
			data : {
				rv_num : "${dto.rv_num}",
				mem_id : $('#ReplyWriter').val(),
				re_content : $('#ReplyText').val()
				   },
			success : reply_list_result
		});
	}// end replay_list()
	
</script>
</head>
<body>
	
	<div id = "allDiv">
	<form name="frm" id="frm" method="get">
		<div class="viewDiv">
			<table id="viewTable">

				<tr>
					<th>${dto.rv_title}</th>
					<td id="listTd" colspan="2">
						<a href="rv_list.do">목록버튼자리</a>
					</td>
				</tr>

				<tr>
					<td id="tdName">${dto.mem_id}</td>

					<td id="tableDate" colspan="2">조회수 ${dto.rv_count} &nbsp; | &nbsp;
						<fmt:formatDate pattern="yyyy.MM.dd" dateStyle="short" value="${dto.rv_regdate}" />
					</td>

				</tr>

				<tr>
					<!-- <th>CONTENT</td> -->
					<td id="cont_space" colspan="3">${dto.rv_content}</td>
				</tr>

				<tr>
					<td id="likeTd">좋아요♡</td>
					
					<!-- id세션값으로 받은 뒤 게시글의 수정, 삭제 버튼 나타나게 하기 -->
					<c:choose>
						<c:when test="${sessionScope.id== dto.mem_id}">
							<td id="updateTd">
								<a href="rv_update.do?rv_num=${dto.rv_num}&currentPage=${currentPage}">수정</a>
							</td>
							<td id="delTd">
								<a href="rv_delete.do?rv_num=${dto.rv_num}&currentPage=${currentPage}">삭제</a>
							</td>
						</c:when>
						<c:otherwise>
							<td id="updateTd">
								<a href="rv_update.do?rv_num=${dto.rv_num}&currentPage=${currentPage}">&nbsp;</a>
							</td>
							<td id="delTd">
								<a href="rv_delete.do?rv_num=${dto.rv_num}&currentPage=${currentPage}">&nbsp;</a>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>

			</table>
		</div>



		<input type="hidden" name="rv_num" value="${dto.rv_num}" />
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}" />


		<!-- box box-success 시작 -->
		<div class="box box-success">
			<div class="box-header">
 				<span class="bg-green">댓글수 <small id='replycntSmall'> [ ${fn:length(rv_list)} ] </small></span>
			</div>

			

			<div class="box-footer">
				
			</div>
		</div>
		<!-- box box-success 끝 -->

		<hr />
		
		<!-- 댓글 리스트 보여주는 곳 -->
		<div id = "replyAll">
		<ul class="timeline">

			<c:forEach items="${rv_list}" var="replyDTO">
				<div id = "replyDiv" class="time_sub" id="${replyDTO.rv_num}">
					<p>${replyDTO.mem_id}&nbsp; &nbsp; 
					<fmt:formatDate pattern="yyyy. MM. dd " dateStyle="short" value="${replyDTO.re_regdate}" />
					
					<!-- 댓글에 시간 나타내주는 fmt -->
					<fmt:formatDate pattern="HH:mm " timeStyle="short" value="${replyDTO.re_regdate}" />
					&nbsp; &nbsp; 
					
					<!-- ?????????이게뭐지??????????? -->
					<!-- <span id = "rep_reply">
						<a ></a>
					</span> -->
					
					<span id = "btnSpan">
						<!-- 댓글 입력 전 아이디 값 받고 본인의 글에만 수정, 삭제 뜨게 하는 부분 -->
						<c:choose>
							<c:when test="${sessionScope.id==replyDTO.mem_id}">
							
								<button type = "button" id="${replyDTO.re_num}" class="updatebtn" >update</button>
								<button type = "button" id="${replyDTO.re_num}">delete</button>
							</c:when>
							<c:otherwise>&nbsp;</c:otherwise>
						</c:choose>
					</span>
					</p>
					<p>${replyDTO.re_content}</p>
				
				</div>
				
				<!-- 댓글에서 수정버튼 눌렀을때 -->
				<div id = "replyDiv" class="time_up_reply" id="${replyDTO.rv_num}" style="display: none">
					<table id = "replyTableUpdate">
						<tr>
							<td >
								<p id = "replyCancel">
									<a>${replyDTO.mem_id} &nbsp; </a>
								<a id = "replyUpdateCancel">수정 취소</a>
								</p>
								<%-- <input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter" value = "${replyDTO.mem_id}"> --%>
							</td>
						</tr>
				
						<tr> 
							<td>
								<input class="form-control" type="text" placeholder="REPLY TEXT" id="upReplyText" value = "${replyDTO.re_content}">
							</td>
							<td id ="registerBtn" rowspan = "2">
								<div id = "button_div">
									<button type="button" id="replyUpdateBtn">수 정</button>
								</div>
							</td>
						</tr>
					</table>				
				</div>
				
			</c:forEach>
		</ul>
		
		
		<!-- 댓글 등록하는 부분 -->
		<div class="box-body">
				
			<c:choose>
				<c:when test="${id != null}">
					<label for="newReplyWriter"></label>
					<table id = "replyTable">
						<tr>
							<td>
								<input class="form-control"  type="hidden" value="${id}"  id="ReplyWriter">
							</td>
						</tr>
				
						<tr>
							<td>
								<input class="form-control" type="text" placeholder="REPLY TEXT" id="ReplyText">
							</td>
				
							<td id ="registerBtn" rowspan = "2">
								<div id = "button">
									<button type="button" class="btn btn-primary" id="replyAddBtn">등 록</button>
								</div>
							</td>
					
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table id = "replyTable">
					</table>
				</c:otherwise>
			</c:choose>	
				
				<label for="newReplyText"></label>
				
		</div>
	</div>
</form>

	</div>
</body>
</html>
