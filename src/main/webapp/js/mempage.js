$(document).ready(function () {
	
	var sel_file;
	
	function handleImg(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function (f) {
			
			sel_file = f;
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#mem_pic_box').attr('src', e.target.result);
				$('#mem_pic_box').css('display','');
				$('#null_mem_pic').css('display', 'none');
			}
			
			reader.unload = function (d) {
				$('#mem_pic_box').attr('src', e.target.result);
				$('#null_mem_pic').css('display','');
				$('#mem_pic_box').css('display', 'none');
			}
			reader.readAsDataURL(f);
		});
	
	}
	
	$('#ReviseBtn').on('click', function(){
		$('#list').attr('action', 'memlist.do').submit();
	});
	

	
	$('#DeleteBtn').on('click', function(){
		var answer = confirm('정말로 탈퇴하시겠습니까?');
		if (answer)
		{
		  console.log('네');
		$('#list').attr('action', 'memDelete.do').submit();
		  alert('회원탈퇴 되었습니다.');	
		}
		else
		{
		  console.log('아니요');
		}
	});
	
	
	
});
// 회원수정
