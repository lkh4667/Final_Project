var isEnd = false;
var cnt=8;
var pm=1;
var totalCnt =0;

var category ="";
$(document).ready(function() {
	
	// 카테고리 파라미터값 받아오기 
	// 없으면 전체 검색 무한스크롤
	// 값이 있으면 해당 카테고리에 대한 무한스크롤 
	category = $('#category').val();
	
	// 버킷리스트 선택 이벤트
		$(document).on('click', '.see-view', function(event) {
			var bk_num = $(this).attr('id');
			$('html, body').animate({
				scrollTop: $(this).offset().top
			}, 1);
			bucketModalShow(bk_num);
		});

});


$(window).scroll(function() {
	var scrollTop = $(window).scrollTop();
	var windowHeight = $(window).height();
	var documentHeight = $(document).height();
	// scrollbar의 thumb가 바닥 전 30px까지 도달 하면 리스트를 가져온다.
	if (scrollTop + windowHeight >= documentHeight) {
		
		pm++;
		console.log("pm:"+pm);
		if (isEnd == true) {
			return;
		}
		if (category == null || category == '') {
			fn_allInfiniteList();
		}else{
			fn_groupInfiniteList(category);
		}
	}
});

// 모든 리스트 무한스크롤
function fn_allInfiniteList() {
	var startNo = parseInt($('div.bk_body').children('div#img-box:last')
			.children('.project-hover').children('#count').val()) || 1;
	$.ajax({
		url : 'bkAllList.do?startRow='+startNo+'&cntRow=8',
		type : 'GET',
		dataType : 'json',
		beforeSend : function() {
			wrapWindowByMask(1);
		},
		success : function(res) {
			// alert(result)
			// 컨트롤러에서 가져온 방명록 리스트는 result에 담겨오도록 했다.
			// 남은 데이터가 10개 이하일 경우 무한 스크롤 종료
	       console.log(res);		
			 var length = res.length;
			cnt+=length;
			if (length < 8) {
				isEnd = true;
			}
			var html = "";
			
			/*background-image: url(/bucket_img/"+value.bp_file+");
			*/
			$.each(res, function(index, data) {
				$.each(res[index].pic_list, function(idx, value) {
				html += "<div id='img-box' class='col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft' ";
				html += "style='background-image: url(/bucket_img/"+value.bp_file+"); background-color: red;'>";
				html += "<div class='project-hover'>";
				html  += "<h4>"+data.bk_group+"</h4>";
				html	+= "<hr />";
				html	+= "<h2>";
				html	+= 	"<strong>"+data.bk_title+"</strong>";
				html	+= "</h2>";
				html	+= "<a href='#' class='see-view' id='"+data.bk_num+"'>See Project</a>";
			   	html += "<input type='hidden' id='count' value='"+cnt+"'>"
				html += "</div>";
				html +=  "</div>";
				});
			});
			$('.bk_body').append(html);
			
		},
		complete : function() {
			closeWindowByMask();
		}
	});
}

function fn_categoryinfiniteList(category) {
	alert("카테고리 무한스크롤=>"+ category);
}
// 버킷리스트 상품 모달 보기
function bucketModalShow(bk_num) {
	
			$.ajax({
				type : 'POST',
				url : 'view.do',
				data : 'num=' + bk_num,
				dataType : 'json',
				beforeSend : function() {
					wrapWindowByMask(1);
				},
				success : function(res) {
					$('#view_category').text(res.bk_group);
					$('#view_title').text(res.bk_title);
					var hashtag = "";
					$.each(res.hashtag, function(index, data) {
						hashtag += data.ht_name + " "
					});
					$('#view_hashtag').text(hashtag);
					$('#bk_num').val(res.bk_num);
					$('#bk_content').html(res.bk_content);
					var resultHtml = "";
					var div = "";
	
				 $.each(res.pic_list,function(entryIndex, entry) {
						if (entryIndex == 0) {
											div += "<li data-target='#demo' data-slide-to='"
													+ entryIndex
													+ "' class='active'></li>";
											resultHtml += "<div class='carousel-item active' style='height: 100%;' >";
										} else {
											div += "<li data-target='#demo' data-slide-to='"
													+ entryIndex + "'></li>"
											resultHtml += "<div class='carousel-item' style='height: 100%;'>";
										}
										resultHtml += "<img src='/bucket_img/"
												+ entry.bp_file
												+ "' height='100%' width='100%'>";
										resultHtml += "</div>";

									});
					$("#demo-slide").html(div);
					$("#img-slide").html(resultHtml);

					$("#myModal").modal("show");
				},
				complete : function() {
					closeWindowByMask();
				}
			});
}
