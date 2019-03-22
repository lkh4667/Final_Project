<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Fira+Sans:300"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/category.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: white;
	margin: 0;
}

.row {
	background-color: white;
	width: 100%;
}

.hj {
	float: none;
	width: auto;
}

.hj {
	margin: 0;
	padding: 0;
}

.button {
	background: aqua;
	border: 1px solid #d4d4d4;
	border-radius: 4px;
	list-style-type: none;
	margin: 4px;
	padding: 2px;
}

@media screen and (min-width: 100px) {
	.button {
		width: 150px;
		float: left;
	}
	.hj {
		margin-left: 216px;
	}
}
</style>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$('.button').on('click', function() {
				var category = $(this).val();
				if (category == 'allBtn') {
					location.href="main.do";
				}else{
					location.href="bkSearch.do?category="+category;					
				}
				
			});
		});
	</script>

	<div class="row">
		<!-- style="width: 100%; flex-wrap: nowrap; padding-left: 25px;" -->
		<div class="hj">
			<div class="hj2">
				<button class="button" value="allBtn">전체</button>
				<button class="button" value="travel">Travel</button>
				<button class="button" value="sports">Sports</button>
				<button class="button" value="food">Food</button>
				<button class="button" value="newskill">Skill</button>
				<button class="button" value="culture">Culture</button>
				<button class="button" value="outdoor">Outdoor</button>
				<button class="button" value="shopping">Shopping</button>
				<button class="button" value="lifestyle">Lifestyle</button>
			</div>
		</div>
	</div>
</body>
</html>