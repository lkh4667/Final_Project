$(document).ready(function() {
	
	loginalert();  // alert 띄우는 함수 호출
	
	$('#signUpBtn').on('click', function() {
		// $("#signInModal").modal("hide");
		$('form').attr('action', 'signUp.do');
		// location.href="signUp.do";
		console.log('ok');
	});
	
	$('#loginBtn').on('click', function() {
		
		 
		var mem_id = $('#mem_id').val();
		var mem_pw = $('#mem_pw').val();
		alert('mem_id=' + mem_id);
		$.ajax({
			type : 'POST',
			url : 'login.do',
			dataType : 'json',
			data : {
				mem_id : mem_id,
				mem_pw : mem_pw
			},
			success : function(res) {
				alert("res= " + res);
				if (res == 1) { /* id pw 통과 */
					// $('#signInModal').modal('hide');
					alert('로그인 되었습니다.');
					// location.href=document.referrer;
					location.href = "main.do";
				} else { /* id, pw 잘못입력하면 */
					alert('아이디와 비밀번호를 확인해주세요.');
					reset();
					// $('#signInModal').modal('show'); /* 모달창띄우기 */
				}
			}
		});// ajax
	});
	
	function loginalert(){  //인터셉터실행시 alert 메세지 띄우는 함수
		var Url=location.href;
	    var returnUrl="returnUrl";
		if(Url.includes(returnUrl)){
			alert('로그인이 필요한 서비스입니다.');			 
		}
	}
	function reset() {  //input초기화 함수
		$('.inputLabel').val('');
	}
});// ready()
