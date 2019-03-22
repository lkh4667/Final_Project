<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/flex-box.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="static/sdk/nhn-se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

.main-title {
	font-weight: bold;
	font-size: 16px;
}

#preview img {
	width: 100px;
	height: 100px;
}

#preview p {
	text-overflow: ellipsis;
	overflow: hidden;
}

.preview-box {
	border: 1px solid;
	padding: 5px;
	border-radius: 2px;
	margin-bottom: 10px;
}
.modal-dialog {
	padding: 0;
	margin: 0;
	max-width: 80%;
	margin: auto;
	margin-top: 40px;
	margin-bottom: 40px;
	overflow-y: hidden;
	height: 100%;
	
	
}

.modal-content {
	height: 80%;
	min-height: 95%;
	border-radius: 0;
	overflow-y: hidden;
}
.delpic{
position: inherit; 
left: 100px; 
top: -36px;
color: red;
font-weight: bold;
}
.delHashtag{
position: inherit; 
left: 200px; 
top: -12px;
color: red;
font-weight: bold;
}
</style>

<title>MY BUCKETLIST : 버킷리스트 등록</title>
</head>
<body>
	<div class="bk_body"
		style="overflow-y: hidden; overflow-x:hidden; height: 100%; margin-left: 100px; margin-right: 100px;">
		<form action="bkUpdateEnd.do" method="post" id="bkWriteFrm" enctype="multipart/form-data"
			style="height: 100%; font-size: 2em; margin-top: 50px; margin-bottom: 50px;">
			<div class="row">
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-8">
					<label> <span><strong>제목 : </strong></span>&nbsp; <input
						type="text" class="" id="bk_title" name="bk_title"
						style="width: 43em;" value="${bdto.bk_title}">
					</label>
				</div>
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-8">
					<label> <span><strong>분류 : </strong></span> <select
						id="bk_group" name="bk_group" class="sBox-select"
						style="width: 113px; margin-left: 10px;">
							<option value="#">#</option>
							<option value="travel">travel</option>
							<option value="sports">sports</option>
							<option value="food">food</option>
							<option value="newskil">newskil</option>
							<option value="culture">culture</option>
							<option value="outdoor">outdoor</option>
							<option value="shopping">shopping</option>
							<option value="lifestyle">lifestyle</option>
					</select>
					</label>
				</div>
				<div class="col-xs-2 col-md-2"></div>
				
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-9" id="hash-teg-box">
					<label> <span><strong><a href="javascript:" onclick="HashUpAction();" 
					class="my_button">해쉬태그 생성 </a></strong></span></label>
					<c:forEach items="${bdto.hashtag}" var="ht" varStatus="cnt" >
						<strong class="delHashtag">x</strong>
						<input type="text" 
						style="width: 200px;" id="ht_name" name="ht_name" value="${ht.ht_name}"/>&nbsp;
					</c:forEach>
				</div>
				<div class="col-xs-2 col-md-1"></div>
				
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-8">
				    <a href="javascript:" onclick="fileUploadAction();" class="my_button">파일 업로드</a>
			        <input id="uploadInputBox" style="display: none;" type="file" name="filedata" multiple />
				</div>
				<div class="col-xs-2 col-md-2"></div>
				
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-8" id="img-box"style="height:125px; border: 2px solid #0AC9FF; padding: 10px; margin-top: 10px; margin-left: 17px;">
					   <c:forEach items="${bdto.pic_list}" var="pic" varStatus="cnt" >
					   	<strong class="delpic">x</strong>
					   	<img src="/bucket_img/${pic.bp_file}" style="width: 100px; height:100px;"/>
						<input type="hidden" id="bp_file" name="bp_file" value="${pic.bp_file}" />
					</c:forEach>
				</div>
				<div class="col-xs-2 col-md-2"></div>
			</div>
			<div class="row">
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-8">
					<label style="width: 110%;"><strong>상세내용 : </strong> <textarea
							name="bk_content" id="bk_content" rows="10" cols="100">${bdto.bk_content}</textarea> </label>
				</div>
				<div class="col-xs-2 col-md-2"></div>
			</div>
			<div class="row">
				<div class="col-xs-2 col-md-2"></div>
				<div class="col-xs-8 col-md-8 c" style="float: right;">
					<button type="button" class="btn btn-primary btn-sm"
						onclick="fn_upBucketEnd();">작성</button>
					<button type="button" class="btn btn-default btn-sm"
						onclick="javascript:location.href='notice.do';">취소</button>
				</div>
				<div class="col-xs-2 col-md-2"></div>
				<input type="hidden" id="bk_num" name="bk_num" value="${param.bk_num}"/>
				<input type="hidden" id="currentPage" name="currentPage" value="${param.currentPage}"/>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/regBucket.js"></script>
<script type="text/javascript">
	var sel_files = [];
	var hashIndex = 0;
	
	$(document).ready(function () {
		
		$('#uploadInputBox').on('change', handleImgFileSelect);
		$('option[value="${bdto.bk_group}"]').attr('selected','selected');
		
		/* $('.delpic').on('click', function () {
			$(this).next().next('#bp_file').remove();
			$(this).next().remove();
			$(this).remove();
		}); */
		
		$(document).on('click', '.delpic', function () {
			$(this).next().next('#bp_file').remove();
			$(this).next().remove();
			$(this).remove();
		});
		
		$(document).on('click', '.delHashtag', function () {
			$(this).next().remove();
			$(this).remove();
		})
		
	});
	
	function HashUpAction() {
		// 해쉬태그 입력창 생성 
		console.log($('.delHashtag').length);
		var delhashtag = $('.delHashtag').length;
		var html = "";
		if (delhashtag == 4) {
			alert("해쉬태그 생성은 4까지");
			return false;
		}else{
		html += "<strong class='delHashtag'>x</strong>"
		html += "<input type='text' style='width:200px;' id='ht_name' name='ht_name' value='#'/>&nbsp;"
		}
		$('#hash-teg-box').append(html);
	}
	
	function deleteImageAction(index) {
		console.log("index : " + index);
		sel_files.splice(index, 1);
		console.log(sel_files);
	}
	
	function fileUploadAction() {
		console.log('fileUploadAction');
		$('#uploadInputBox').trigger('click');
	}
	function handleImgFileSelect(e) {
		/* sel_files = [];
		$('#img-box').empty(); */
		
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		console.log("arr=>"+filesArr.length)
		var index = 0;
		filesArr.forEach(function(f) {
			sel_files.push(f);
			var reader = new FileReader();
			reader.onload = function(e){
				console.log(sel_files);
				/* var html = "<img src='"+e.target.result+"' style='width:100px; height:100px;'/>";
				 */
				 var html ="";
				 html += "<strong class='delpic' onclick=\"deleteImageAction("+index+")\">x</strong>";
				 html += "<a href=\"javascript:void(0);\" id=\"img_id_"+index+"\"><img src=\""+ e.target.result +"\"data-file='"+f.name+"' class='selProductFile' title='Click remove' style='width:100px; height:100px;'></a> ";
				 $('#img-box').append(html);
				
				index++;
			}
			
			reader.readAsDataURL(f);
		})
	}
	
	function fn_upBucketEnd() {
		
		if ($('#bk_title').val() == "") {
			alert('제목을 입력하세요');
			return false;
		}
		var seleted = $('option[value="${bdto.bk_group}"]').attr('selected','selected');
		
		if ($(seleted).val() == "#") {
			alert('카테고리를 확인해주세요');
			return false;
		}
		
		if($('#ht_name').val() == ""){
			alert('해쉬태그를 입력하세요');
			return false;
		}
		
		if ($('#bk_content').val() == "") {
			alert('글 내용을 입력하세요');
			return false;
		}
		
		
		oEditors.getById["bk_content"].exec("UPDATE_CONTENTS_FIELD",[]);
		var form = $('#bkWriteFrm')[0];
        var formData = new FormData(form);

        for (var index = 0; index < Object.keys(sel_files).length; index++) {
            //formData 공간에 files라는 이름으로 파일을 추가한다.
            //동일명으로 계속 추가할 수 있다.
            formData.append('sel_files',sel_files[index]);
        }
       /*  formData.append('bk_title', $('#bk_title').val());
       	 */
        
        //ajax 통신으로 multipart form을 전송한다.
        $.ajax({
            type : 'POST',
            enctype : 'multipart/form-data',
            processData : false,
            contentType : false,
            cache : false,
            /*timeout : 600000, */
            url : 'bkUpdateEnd.do',
            dataType : 'text',
            data : formData,
            success : function(result) {
                //이 부분을 수정해서 다양한 행동을 할 수 있으며,
                //여기서는 데이터를 전송받았다면 순수하게 OK 만을 보내기로 하였다.
                //-1 = 잘못된 확장자 업로드, -2 = 용량초과, 그외 = 성공(1)
               	location.href='admin.do?currentPage='+result;
            //전송실패에대한 핸들링은 고려하지 않음
        	}
        });
	}
</script>
</html>