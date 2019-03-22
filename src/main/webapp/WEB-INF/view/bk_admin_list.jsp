<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- check -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<style type="text/css">
.main-title {
	font-weight: bold;
	font-size: 16px;
}

.search-box {
	width: 100%;
	text-align: center;
	height: 100px;
	padding: 22px;
	padding-left: 0;
}

.pagelist a{
   text-decoration: none;
   color: black;
}

.pagelist a:hover, .pagelist .pagecolor{
   text-decoration: underline;
   color: red;
}
.form-inline{
margin-top: 9px;
}
.table td{
vertical-align: inherit;
}
.pagelist span{
	font-size: 1.7em;
	font-weight: bold;
	border: 2px solid #58D3F7;
	display: inline-table;
	width: 30px;
}
.pagelist a{
	color:#2E9AFE;
}
.pagelist #prev{
	font-size: 1.7em;
	font-weight: bold;
	border: 2px solid #58D3F7;
	color:#2E9AFE;
	display: inline-table;
	width: 50px;
}

.pagelist #next{
	font-size: 1.7em;
	font-weight: bold;
	border: 2px solid #58D3F7;
	color:#2E9AFE;
	display: inline-table;
	width: 50px;
}
.write-box{
    width: 75%;
    height: 30px;
    line-height: 31px;
    padding-left: 99em;
}
#bk_write{
	color: #FAFAFA;
	background-color: #28a745;
}
</style>
</head>

<body>
	<div class="container"
		style="max-width: 100%; height: 850px; padding-left: 160px; padding-right: 160px;">
		<div class="search-box">
       		<form class="form-inline" action="#" method="POST">
                        <select class="form-control" id="category_opt">
                            <option value="">전체</option>
							<option value="travel">travel</option>
							<option value="sports">sports</option>
							<option value="food">food</option>
							<option value="newskill">newskill</option>
							<option value="culture">culture</option>
							<option value="outdoor">outdoor</option>
							<option value="shopping">shopping</option>
							<option value="lifestyle">lifestyle</option>
                        </select>
                    
                    
                       <div class="input-group custom-search-form">
                            <input type="text" class="form-control" id="keyword" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" id="search_btn">
                                      <i>search</i>
                                    </button>
                                </span>
                        </div>
                        <div class="write-box">
                        <button type="button" id="bk_write"
									style="width: 60pt; height: 30pt; border: 2px solid #28a745; border-radius: 10px; font-size: 1.3em;"><strong>Add</strong></button>
                        </div>
        </form>
		</div>
		<div class="row col-md-10 col-md-offset-2 custyle"
			style="max-width: 100%; height: 83%; padding-top: 20px; padding-bottom: 20px;">
			<table class="table table-striped custab" style="height: 100%;">
				<thead>
					<tr>
						<th>ID</th>
						<th>img</th>
						<th>category</th>
						<th>title</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
					<c:forEach items="${bk_list}" var="bk" varStatus="cnt" >
							<c:forEach items="${bk.pic_list}" var="pic">
				<tr>
					<td>${bk.bk_num}</td>
					<td><img src="/bucket_img/${pic.bp_file}" style="border:1px solid black; width: 100px; height: 100px;"></td>
					<td>${bk.bk_group}</td>
					<td>${bk.bk_title}</td>
					<td class="text-center">
					<c:url var="update" value="bk_update.do">
							<c:param name="currentPage" value="${pv.currentPage}" />
							<c:param name="bk_num" value="${bk.bk_num}" />
						</c:url> 
					<a class='btn btn-info btn-xs' href="${update}">
					<span class="glyphicon glyphicon-edit"></span> Edit</a> 
						<c:url var="del" value="bk_delete.do">
							<c:param name="currentPage" value="${pv.currentPage}" />
							<c:param name="bk_num" value="${bk.bk_num}" />
						</c:url> 
						<a href="${del}" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
				</c:forEach>
				</c:forEach>
			</table>
		</div>
		<div id="page" style="text-align: center; width: 100%;">
			<div id="pagelist">
				<div class="pagelist">
					<!-- 이전 출력 시작 -->
					<c:if test="${pv.startPage>1}">
							<c:url var="prevPage" value="admin.do">
								<c:param name="currentPage" value="${pv.startPage-pv.blockPage}" />
								<c:if test="${param.keyword != null}">
								<c:param name="keyword" value="${param.keyword}" />
								</c:if>
								<c:if test="${param.category != null}">
								<c:param name="category" value="${param.category}" />
								</c:if>
							</c:url>
						<a id="prev" href="${prevPage}">이전</a>
					</c:if>
					<!-- 이전 출력 끝 -->

					<!-- 페이지 출력 시작 -->
					<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
						<span> 
						    <c:url var="currPage" value="admin.do">
								<c:param name="currentPage" value="${i}" />
								<c:if test="${param.keyword != null}">
								<c:param name="keyword" value="${param.keyword}" />
								</c:if>
								<c:if test="${param.category != null}">
								<c:param name="category" value="${param.category}" />
								</c:if>
							</c:url>
							
							 
							<c:choose>
								<c:when test="${i==pv.currentPage}">
									<a href="${currPage}" class="pagecolor"> <c:out
											value="${i}" /></a>
								</c:when>
								<c:otherwise>
									<a href="${currPage}"> <c:out value="${i}" /></a>
								</c:otherwise>
							</c:choose>
						</span>
					</c:forEach>
					<!-- 페이지 출력 끝 -->

					<!-- 다음 출력 시작 -->
					<c:if test="${pv.totalPage>pv.endPage}">
						<c:url var="nextPage" value="admin.do">
								<c:param name="currentPage" value="${pv.startPage+pv.blockPage}" />
								<c:if test="${param.keyword != null}">
								<c:param name="keyword" value="${param.keyword}" />
								</c:if>
								<c:if test="${param.category != null}">
								<c:param name="category" value="${param.category}" />
								</c:if>
							</c:url>
						<a id="next" href="${nextPage}">다음</a>
					</c:if>
					<!-- 다음 출력 끝 -->
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var category = "";
	$(document).ready(function(e) {
		category = "${param.category}";
		$('option[value="'+category+'"]').attr('selected', 'selected');

		$("#category_opt").change(function() {
			category = $('#category_opt option:selected').val();
		});

		
		$('#bk_write').on('click', function () {
			location.href="bkWrite.do";
		});
		
		$('#search_btn').on('click', function () {
			 var keyword = $('#keyword').val();
			console.log(category);
			console.log(keyword);
			
			if (category != '' || keyword != '') {
				location.href="admin.do?keyword="+keyword+"&category="+category;
			}else{
				location.href="admin.do";
			}
			/* location.href="adminSearch.do?category="+category+"&keyword="+keyword; */
		});
	});
	
function fn_searchList() {
	/* var keyword = $('#keyword').val();
	var category = $('option').attr('selected', 'selected').val();
	location.href="adminSearch.do?category="+category+"&keyword="+keyword;  */
}	
</script>
</html>
