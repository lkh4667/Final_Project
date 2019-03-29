$(document).ready(function() {
	loginalert();  // alert 띄우는 함수 호출
	
	$('#signUpBtn').on('click', function() {
		$('form').attr('action', 'signUp.do');
		console.log('ok');
	});

	/*$("#mem_pw").on('keydown', function() {
		if (window.event.keyCode == 13) {
			document.getElementById('loginBtn').click();
		}
	});*/
	
	var returnUrl=$('#Urlvalue').val();
	$('#loginBtn').on('click', function() {
		var mem_id = $('#mem_id').val();
		var mem_pw = $('#mem_pw').val();
		$.ajax({
			type : 'POST',
			url : 'login.do',
			dataType : 'json',
			data : {
				mem_id : mem_id,
				mem_pw : mem_pw,
				returnUrl : returnUrl
			},
			success : function(res) {
				if (res.chk == 1) { /* id pw 통과 */
					alert('로그인 되었습니다.');
					location.href=res.Url;
				} else { /* id, pw 잘못입력하면 */
					alert('아이디와 비밀번호를 확인해주세요.');
					reset();
				}
			},
			error: function(res){
				alert('오류');
			}
		});// ajax
	});
	$('#backBtn').on('click', function(){
		history.back();
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
