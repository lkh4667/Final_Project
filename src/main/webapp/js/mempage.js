$(document).ready(function () {
	$('#ReviseBtn').on('click', function(){
		$('#memlist').attr('action', 'memlist.do').submit();
	});
	
	$('#DeleteBtn').on('click', function(){
		$('#memlist').attr('action', 'memDelete.do').submit();
		alert('로그아웃되었습니다.');	
		location.href="/mybucket/main.do";
	});
	
	var pic=$('#picvalue').text();
	
	if(pic==null || pic==''){
		$('#mem_pic_box').css('display', 'none');
		$('#null_mem_pic').css('display', '');
	}else{
		$('#null_mem_pic').css('display', 'none');
		$('#mem_pic_box').css('display', '');
	} 
});
// 회원수정
