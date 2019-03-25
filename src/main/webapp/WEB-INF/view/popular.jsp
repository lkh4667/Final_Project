<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/flex-box.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Insert title here</title>
<style type="text/css">
.title-arch {
	text-align: center;
	margin: 50px 0;
	font-size: 22px;
	letter-spacing: 2px;
	text-transform: uppercase;
}

.project {
	width: 100%;
	height: 500px;
	background-image:
		url(https://image.freepik.com/free-vector/abstract-geometric-background-design_1045-764.jpg);
	background-size: cover;
	background-position: center;
	padding: 0 !important;
	float: left;
}

.project-2 {
	background-image:
		url(https://image.freepik.com/free-vector/abstract-geometric-background-design_1045-764.jpg);
}

.project-3 {
	background-image:
		url(https://image.freepik.com/free-vector/abstract-geometric-background-design_1045-764.jpg);
}

.project-4 {
	background-image:
		url(https://image.freepik.com/free-vector/abstract-geometric-background-design_1045-764.jpg);
}

.project-hover {
	width: 100%;
	height: 100%;
	color: #fff;
	opacity: 0;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	background-color: #51575d85;
	padding: 40% 30px !important;
}

.project-hover hr {
	height: 30px;
	width: 0;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	background-color: rgba(255, 255, 255, 1);
	border: 0;
}

.project-hover a {
	color: rgba(255, 255, 255, 1);
	padding: 2px 22px;
	line-height: 40px;
	border: 2px solid rgba(255, 255, 255, 1);
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}

.project-hover a:hover {
	border-color: rgba(51, 51, 51, 1);
	color: rgba(51, 51, 51, 1);
	background-color: #FFF;
}

.project:hover .project-hover {
	opacity: 1;
}

.project:hover .project-hover hr {
	width: 100%;
	height: 5px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>travel</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>sports</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>food</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>newskill</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>culture</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>outdoor</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>shopping</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view">See Project</a>
			</div>
		</div>
		<div id="img-box"
			class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			style="background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;">
			<div class="project-hover">
				<h3>lifestyle</h3>
				<hr />
				<h2>TOP 8</h2>
				<a href="#" class="pop-view" >See Project</a>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<jsp:include page="bk_pop_modal.jsp" />
</body>
<script type="text/javascript" src="js/popularList.js"></script>
<script type="text/javascript" src="js/util.js"></script>
</html>