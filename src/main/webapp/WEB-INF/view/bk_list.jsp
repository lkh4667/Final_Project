<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/flex-box.css">
<!-- check -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</head>

<body>
	<script type="text/javascript">
		$(document).ready(function () {
			// 버킷리스트 선택 이벤트
			$('.see-view').on('click', function() {
				var bk_num = $(this).attr('id');
				bucketModalShow(bk_num);
			});
		});
	</script>
	<div class="bk_body" style="margin-left: 100px; margin-right: 100px;">
	<c:forEach items="${bk_list}" var="bk" varStatus="cnt" >
		<c:forEach items="${bk.pic_list}" var="pic">
			<div id="img-box"
				class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
				style="background-image: url(/bucket_img/${pic.bp_file}); background-size: 100% 100%;  ">
				<div class="project-hover">
					<h4>${bk.bk_group}</h4>
					<hr />
					<h2>
						<strong>${bk.bk_title}</strong>
					</h2>
					<a href="#" class="see-view" id="${bk.bk_num}">See Project</a>
					<input type="hidden" id="count" value="${cnt.count}">
				</div>
			</div>
		</c:forEach>
	</c:forEach>
		<input type="hidden" id="category" value="${param.category}">
	</div>
	<jsp:include page="modal_view.jsp" />
</body>
<script type="text/javascript" src="js/bucketList.js"></script>
<script type="text/javascript" src="js/util.js"></script>
</html>
