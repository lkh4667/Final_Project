<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/flex-box.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
div.imgTopic {
	position: relative;
	width: 70%;
	height: 97%;
	font-family: ’Dotum’, ’돋움’, sansserif;
	border: 1px solid black;

	/* 	background-image:
		url('https://img.insight.co.kr/static/2018/09/12/700/z7n04ul8ig3y27w6l6ok.jpg');
	background-size: 100% 100%; */
}

div.view_content {
	padding-left: 1050px;
	width: 30%;
	height: 97%;
	font-family: ’Dotum’, ’돋움’, sansserif;
	/* background-image:
		url('https://img.insight.co.kr/static/2018/09/12/700/z7n04ul8ig3y27w6l6ok.jpg');
	background-size: 100% 100%; */
	width: 30%;
}

span.subject {
	position: absolute;
	display: block;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 30%;
	/* background-image: url('images/blackOpacity.png'); */
}

#category {
	color: blue;
	margin-left: 5px;
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 3px;
	letter-spacing: 1px;
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
	height: 300px;
	min-height: 100px;
	border-radius: 0;
	overflow-y: hidden;
	width: 500px;
	margin: auto;
}
/* 
body {
    padding: 20px;
    font-family: 'Open Sans', sans-serif;
    background-color: #f7f7f7;
}
 */
.lib-panel {
	margin-bottom: 20Px;
}

.lib-panel img {
	width: 100%;
	background-color: transparent;
}

.lib-panel .row, .lib-panel .col-md-6 {
	padding: 0;
	background-color: #FFFFFF;
}

.lib-panel .lib-row {
	padding: 0 20px 0 20px;
}

.lib-panel .lib-row.lib-header {
	background-color: #FFFFFF;
	font-size: 20px;
	padding: 10px 20px 0 20px;
}

.lib-panel .lib-row.lib-header .lib-header-seperator {
	height: 2px;
	width: 26px;
	background-color: #d9d9d9;
	margin: 7px 0 7px 0;
}

.lib-panel .lib-row.lib-desc {
	position: relative;
	height: 100%;
	display: block;
	font-size: 13px;
}

.lib-panel .lib-row.lib-desc a {
	position: absolute;
	width: 100%;
	bottom: 10px;
	left: 20px;
}

.row-margin-bottom {
	margin-bottom: 20px;
}

.box-shadow {
	-webkit-box-shadow: 0 0 10px 0 rgba(0, 0, 0, .10);
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, .10);
}

.no-padding {
	padding: 0;
}
.pic_frame{
	border:1px solid black;
	width:105px;
	height:120px;
	text-align: center;
	background-color: #F781F3;
	margin-top: 10px;
}

body {margin: 10px}
.where {
  display: block;
  margin: 25px 15px;
  font-size: 11px;
  color: #000;
  text-decoration: none;
  font-family: verdana;
  font-style: italic;
} 
.filebox {display:inline-block; margin-right: 10px;}


.filebox label {
  display: inline-block;
  padding: .5em .75em;
  color: #999;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #fdfdfd;
  cursor: pointer;
  border: 1px solid #ebebeb;
  border-bottom-color: #e2e2e2;
  border-radius: .25em;
}

.filebox input[type="file"] {  /* 파일 필드 숨기기 */
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip:rect(0,0,0,0);
  border: 0;
}

.filebox.bs3-success label {
  color: #fff;
  background-color: #5cb85c;
    border-color: #4cae4c;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var fileTarget = $('.filebox .upload-hidden');

	fileTarget.on('change', function() {
		if (window.FileReader) {
			var filename = $(this)[0].files[0].name;
		} else {
			var filename = $(this).val().split('/').pop().split(
					'\\').pop();
		}

		$(this).siblings('.upload-name').val(filename);
	});
	
var sel_file;
	
	function handleImg(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function (f) {
			
			sel_file = f;
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#mem_pic_box').attr('src', e.target.result);
				$('#mem_pic_box').css('display','');
				$('#null_mem_pic').css('display', 'none');
			}
			
			reader.unload = function (d) {
				$('#mem_pic_box').attr('src', e.target.result);
				$('#null_mem_pic').css('display','');
				$('#mem_pic_box').css('display', 'none');
			}
			reader.readAsDataURL(f);
		});
	
	}
});


</script>
</head>
<body>
	<!-- The Modal -->
	 <div class="modal fade" id="myModal" role="dialog"
		aria-labelledby="myFullsizeModalLabel" style="min-width: 400px; ">
		<div class="modal-dialog" role="document"> 
			<div class="modal-content" style="">

				<!-- Modal body -->
				<div class="filebox bs3-primary" style="margin:auto;">
					<div class="row box-shadow" style="width: 400px;">
						<div class="col-md-6" style="padding-left: 0; margin: auto;">
						<div class="pic_frame">
							<img src="images/nullImg.jpg" id="null_mem_pic"
								style="width: 100px; height: 100px; " />
							<img src="/userImg/${mdto.mem_pic}" id="mem_pic_box"
								style="swidth: 100px; height: 100px; display:none; border-radius: 30px;"/>
						</div>
						<br />
						<div class="filebox">
                            <label for="ex_file">프로필 사진 첨부</label> 
                              <input type="file" id="ex_file" class="upload-hidden"> 
						</div>
							<hr />
						</div>
						<!-- Modal footer -->
					</div>
				</div>
			</div>
	 	</div>
	</div> 
</body>
</html>