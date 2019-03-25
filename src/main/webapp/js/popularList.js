$(document).ready(function () {
			
			$(document).on('click', '.see-view', function () {
				bucketModalShow($(this).attr('id'));
			});
			
			// 버킷리스트 선택 이벤트
			$('.pop-view').on('click', function() {
				var category =$(this).prev().prev().prev().text();
				
				$.ajax({
					type : 'POST',
					url : 'popularGp.do',
					data : 'bk_group=' + category,
					dataType : 'json',
					success : function(res) {
						
						var result = "";
						$('.container-fluid').empty();
						$.each(res, function (index, entry) {
							result += "<div id= 'img-box' class='col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft'";
							result += "style='background-image: url(/bucket_img/"+entry.pic_dto.bp_file+"); background-color:bisque; background-size: 100% 100%;'>";
							result += "<div class='project-hover'>";
							result += "<h4><strong>TOP "+ (index+1) +" </strong>"+entry.bk_group+"</h4>";
							result += "<hr />";
							result += "<h2><strong>"+entry.bk_title+"</strong></h2>";
							result += "<a href='#' class='see-view' id='"+entry.bk_num+"'>See Project</a>";
							result += "</div>";
							result += "</div>";
						});
						
						result += "<div id= 'img-box' class='col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft'";
						result += "style='background-image: url(/bucket_img/#); background-color:bisque; background-size: 100% 100%;'>";
						result += "<div class='project-hover'>";
						result += "<h4><strong>이전으로</strong></h4>";
						result += "<hr />";
						result += "<a href='popular.do' class='back-view'>history back</a>";
						result += "</div>";
						result += "</div>";
						
						$('.container-fluid').html(result);
					}
				});
			});	
		});	
		
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
			