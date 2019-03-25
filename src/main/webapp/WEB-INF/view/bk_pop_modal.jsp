<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	height: 80%;
	min-height: 95%;
	border-radius: 0;
	overflow-y: hidden;
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

</style>
</head>
<body>
	<!-- The Modal -->
	<div class="modal fade" id="myPopModal" role="dialog"
		aria-labelledby="myFullsizeModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<!-- Modal body -->
				<div class="modal-body" style="margin-left: 30px;">
					<div class="row box-shadow" style="width: 100%;">
						<div class="col-md-6" style="padding-left: 0;">
						<div id="demo" class="carousel slide" data-ride="carousel" style="width: 205%; height: 106%;">
						 <a class="carousel-control-prev" href="#demo" data-slide="prev">
    					<span class="carousel-control-prev-icon"></span>
  						</a>
  						<a class="carousel-control-next" href="#demo" data-slide="next">
    					<span class="carousel-control-next-icon"></span>
  						</a>
  
								 <ul class="carousel-indicators ul" id="demo-slide" style="width:70%;">
								  </ul>

							  <!--  The slideshow -->
							  <div class="carousel-inner img" id="img-slide" style="background-color:red; height: 100%;">
							  </div>
						</div>
						</div>
					
						<input type="hidden" id="bk_num" name="bk_num" value=""/>
						<!-- Modal footer -->
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>
</html>