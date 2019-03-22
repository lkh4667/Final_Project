<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- W3 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}


.w3-center ,w3-padding-32{
	font-size: 50px;

}

.w3-button ,w3-black ,w3-round-xxlarge{
	width: 150px;
}
.w3-third ,w3-container ,w3-margin-bottom{

}

.w3-hover-opacity{
	
}

.box1{
/* 	width: 350px;
	height: 400px; */
}


</style>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<div class="w3-white w3-content" style="max-width:1600px;" >

<!-- Sidebar/menu -->
<div class = "row" style="z-index:3;width:300px; height: 20px; margin-left:20px; padding-left: 30px; " id="mySidebar"><br>
	<div class="w3-container">
  <div class="w3-container" style="margin-top: 20px;">
    <img src="images/img1.jpg" style="width:70%;" class="w3-round"><br><br>
    <h4><b>${id }</b></h4>
  </div>
  <div class="w3-bar-block">
    <a href="#about"  id="csing" onclick="w3_close()" class="w3-bar-item w3-button w3-padding" style="height: 50px; font-size: 19px;"><i class="w3-margin-right"></i>도전중</a> 
    <a href="#contact" id="csp" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"style="height: 50px; font-size: 19px;" ><i class="w3-margin-right"></i>도전완료</a>
  
  </div>
  </div>
</div>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Header -->
  <div id="portfolio">
    <div class="w3-container">
   <div>
    <h1><b>My BucketList</b></h1>
    <div class="w3-section w3-bottombar w3-padding-16">
     </div>
    </div>
    </div>
  </div>
  <!-- First Photo Grid-->
  <div class="w3-row-padding" style="">
  <c:forEach  items="${c_list}" var="ck" varStatus="cnt" >
      <div class="w3-third w3-container" style="height: 300px; width: 400px;">
      
      <div class="box1" style="height: 200px;">
      <img src="/bucket_img/${ck.bp_file}" alt="Norway" style="width:100%; height: 100%;" class="w3-hover-opacity">
      <div class="w3-container w3-white">
        <h5>${ck.bk_title}</h5>
        <div style="width: 400px; height: 100px;">
        	 <p><button id="reviewBtn" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="margin-left: 170px;" value="${ck.bk_num}">리뷰 쓰러가기</button>
			 <button id="rDeleteBtn" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="margin-left: 0; width: 50px;" value="${ck.bk_num}">삭제</button></p> 
        </div>
      </div>
      
      </div>
    </div>
     </c:forEach>
  </div>


  <!-- Pagination -->
  <div class="w3-center ">
    <div class="w3-bar">
    <c:if test ="${cpdto.startPage>1 }">
      <a href="challengeSuccess.do?currentPage=${cpdto.startPage-cpdto.blockPage }" >이전</a>
    </c:if> 
     
     <c:forEach var="i" begin="${cpdto.startPage}" end="${cpdto.endPage }">
     	<span>
     		<c:url var="currPage" value="challengeSuccess.do">
     			<c:param name="currentPage" value="${i }"/>
     		</c:url>
     		<c:choose>
     			<c:when test="${i == cpdto.currentPage}">
     				<a herf="${currPage}" ><c:out value="${i}"/></a>
     			</c:when>
     			    <c:otherwise>	
			       <a href="${currPage}"> <c:out value="${i}" /></a>
			     </c:otherwise>		
     		</c:choose>
     	</span>
     </c:forEach>
     
      
     <c:if test="${cpdto.totalPage>cpdto.endPage }">
      <a href="challengeSuccess.do?currentPage=${cpdto.startPage+cpdto.blockPage }" >다음</a>
    </c:if>
    
    </div>
  </div>

 
</div>
</div>


</body>
<script type="text/javascript">
	$(document).ready(function(){
	
		$('#csing').on('click',function(){
			location.href="challenge.do";
			
		});
		
		$(document).on('click','#reviewBtn',function(){
			location.href="rv_list.do"
		});
		
		$(document).on('click','#rDeleteBtn',function(){
			/* alert($(this).val()); */
			var bk_num = $(this).val();
			location.href="challengeReciewDelete.do?bk_num="+bk_num
			});
			
		
	});
	
	

</script>
</html>