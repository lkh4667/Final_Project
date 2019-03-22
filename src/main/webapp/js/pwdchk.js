$(document).ready(function () {
	$('#ReviseBtn').on('click', function(){
		$('#memlist').attr('action', 'memlist.do').submit();
	});
	
	$('DeleteBtn').on('click', function(){
		location.href="/mybucket/memDelete.do";
	});

});
// 회원수정
