<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/rv_list.css">

</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.reviewDiv').on('click', function() {
				alert("클릭입니다");
			});
			
			//검색 버튼 누르면 실행하는 이벤트
			$('#searchbox').on('click', function(){
				alert("셀렉트박스 : " + $('#optionbox option:selected').val() + " 내용값 :" + $('#searchtext').val());
				var select = $('#optionbox option:selected').val();
				var content = $('#searchtext').val();
				location.href='search.do?selected='+select+'&content='+content;
			
				});
		});
		
	</script>
	
	<!-- 페이지 번호까지 포함하는 div -->
	<div id = "reviewContent">
		<div id = "title">
		<a id = 'reviewtitle'>R E V I E W<br/></a> 
		<a id = 'reviewsubtitle'>버킷리스트 후기를 공유합니다</a>
		</div>
		
		<div>
			<a href = "rv_list.do">전체</a>
			<a>&nbsp; | &nbsp;</a>
			<a href = "searchGroup.do?rv_group=">TRAVEL</a>
			<a>&nbsp; | &nbsp;</a>
			<a>SPORTS</a>
			<a>&nbsp; | &nbsp;</a>
			<a>FOOD</a>
			<a>&nbsp; | &nbsp;</a>
			<a>NEW SKILL</a>
			<a>&nbsp; | &nbsp;</a>
			<a>CULTURE</a>
			<a>&nbsp; | &nbsp;</a>
			<a>OUTDOOR</a>
			<a>&nbsp; | &nbsp;</a>
			<a>SHOPPING</a>
			<a>&nbsp; | &nbsp;</a>
			<a>LIFESTYLE</a>
		</div>
		
		<!-- 로그인을 하지 않으면 글쓰기 버튼이 보이지 않게 하기 -->
		<c:if test="${sessionScope.id!=null }">
			<div id = "reviewWrite">
				<a href = "rv_write.do">글쓰기기기</a>
			</div>
		</c:if>
	
		<!-- 테이블까지만 포함하는 div -->
	<div id = "reviewDiv">
		
		<table>
			<tbody id = "tbody1">
				<c:forEach var="dto" items="${aList}">
					<tr>
						<td id = "imgTd" rowspan="3" >
							<div class="imgDiv" >
							<c:forEach var="pic" items="${dto.rv_pic_list}">
								<img src="/reviewImg/${pic.rp_file}"/>
							</c:forEach>
							</div>
						</td>
						<td id="titleTd" colspan="2">
						
						<a id = "groupA">[ ${dto.rv_group} ]</a>
							<a href = "rv_view.do?rv_num=${dto.rv_num}&currentPage=${pv.currentPage}" id="titlename"> ${dto.rv_title}</a>
						
						<!-- 제목 옆에 댓글갯수 표현하기 -->
								<c:if test="${dto.re_count>0}">
									<small id='replycntSmall'> &nbsp; [ ${dto.re_count} ] </small>
								</c:if>
						</td>
						<td id = "dateTd">
							<fmt:formatDate pattern="yyyy. MM. dd" dateStyle="short" value="${dto.rv_regdate}"/>
						</td>
					</tr>
					
					<tr>
						<td id="writerTd" colspan="3"><a href="challenge.do?mem_id=${dto.mem_id}">${dto.mem_id}</a></td>
					</tr>
					
					
					<tr>
						<td id = "likeTd" >좋아요 하트하트</td>
						<td></td>
						<td id = "countTd">조회수 : ${dto.rv_count}</td>
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
		
	
		<!-- 게시글 아래 검색하는 곳 부분 -->	
			
		<div class='searchbar'>
			<form name='frm' method='GET' action='rv_list.do'>
				<div id='search' >
					<select name='col' id='optionbox'>
						<!-- 검색 컬럼 -->
						<option value='rv_title_content'>제목+내용</option>
						<option value='rv_title'>제목</option>
						<option value='rv_content'>내용</option>
						<option value='mem_id'>아이디</option>
						<option value='rv_group'>분류</option>
					</select>
					
						<input id="searchtext" type='text' name='word' value='' placeholder="내용 입력">
						<input id="searchbox" type='button' value = "검색">
				</div>
			</form>
		
	
		
	<!-- 페이징처리 -->	
	<div id="pageList" style="text-align: center">
			<!-- 이전 처리 -->
			<!-- 이전으로 이동할 것이 있을 경우에만 이전이 뜨도록 -->
			<!-- 이전 4 5 6 / 이전을 누르면 1 2 3이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
			<!-- 이전의 조건 : 현재페이지의 값이 1보다 클때 , 현재페이지-한블럭에보여줄페이지 (4-3=1페이지가 선택되어서 나옴) -->
			<c:if test="${pv.startPage>1}">
				<a href="rv_list.do?currentPage=${pv.startPage-pv.blockPage}">이전</a>
			</c:if>


			<!-- 페이지 이동하는 부분 -->
			<%--<c:forEach begin="${requestScope.pv.startPage }"
				end="${requestScope.pv.endPage }" var="i">
				<span><a class="aPage" href="list.sb?currentPage=${i}">${i}</a></span>
			</c:forEach> --%>
			<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
				<span> <c:url var="currPage" value="rv_list.do">
						<c:param name="currentPage" value="${i}" />
					</c:url> 
					
					<c:choose>
						<c:when test="${i==pv.currentPage}">
							<a href="${currPage}" class="pagecolor"> <c:out value="${i}" /></a>
						</c:when>
						<c:otherwise>
							<a href="${currPage}"> <c:out value="${i}" /></a>
						</c:otherwise>
					</c:choose>
				</span>
			</c:forEach>


			<!-- 다음 처리 -->
			<!-- 다음으로 이동할 것이 있을 경우에만 다음이 뜨도록 -->
			<!-- 1 2 3 다음 / 다음을 누르면 4 5 6이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
			<!-- 다음의 조건 : 현재 마지막 페이지보다 토탈페이지가 더 클때, 현재페이지+한블럭에보여줄페이지 (1+3=4페이지가 선택되어서 나옴) -->
			<!-- 리퀘스트 영역에 있는 값들은 '이름.값'으로 가지고 와도 됨(생략해서 많이 사용, 생략하지 않고 다 쓰는것이 정석이기는 함)  -->
			<c:if test="${pv.totalPage>pv.endPage}">
				<a href="rv_list.do?currentPage=${pv.startPage+pv.blockPage}">다음</a>
			</c:if>
			
		</div>
		</div>
	</div>
	
</div>
	
</body>
</html>

