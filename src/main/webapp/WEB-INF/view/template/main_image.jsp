<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
</style>
</head>


<body>

<div class="carousel slide" data-ride="carousel" data-interval="4000" id="myCarousel">
  <!-- Indicators -->
  <ol class="carousel-indicators" id="carsel-indi">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  
  <!-- Wrapper for slides -->
  <div class="carousel-inner" id="carsel-inn">
        <div class="item active">
        <img src="images/bucketimage.jpg" alt="Los Angeles" style="height:400px; width:100%;">
      </div>

      <div class="item">
        <img src="images/img1.jpg" alt="Chicago" style="width:100%; height:400px;">
      </div>
    
      <div class="item">
        <img src="images/a.jpg" alt="New york" style="width:100%; height:400px;">
      </div>
  </div> 
  <!-- Left and right controls -->
  <a id="control-ant" class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a id="control-ant" class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
  
</div>
</body>
<script type="text/javascript">
var height = 0;
$(document).ready(function() {
	
	$(window).scroll(function () {
		height = $(document).scrollTop();
		if (height >= 200) {
			$('#carsel-indi').remove();
			$('#control-ant').remove();
			$('#carsel-inn').slideUp('slow', function () { 
				console.log('slideUp')
			});
			return false;
		}
    }); 
});	
</script>
</html>