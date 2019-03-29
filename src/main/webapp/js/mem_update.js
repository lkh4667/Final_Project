$(document).ready(function () {
 	
	// 모든 공백 체크 정규식
	   var empJ = /\s/g;
	   // 비밀번호 정규식
	   var pwJ = /^[A-Za-z0-9]{4,12}$/;
	   // 이메일 검사 정규식
	  var mailJ = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	   // 휴대폰 번호 정규식
	  var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	  // 숫자만
	  var regex= /[^0-9]/;
	
	var inval_Arr=new Array(3).fill(false);
 	//비밀번호
		if(pwJ.test($('#mem_pw').val())&&($('#mem_pw').val()==($('#mem_pw2').val()))){
			inval_Arr[0]=true;
		}else{
			inval_Arr[0]=false;
			alert('모든 항목을 양식에 맞게 작성해주세요.');
			return false;
		}
		
		 // 휴대폰번호 정규식
        if(phoneJ.test($('#mem_phone').val())){
           inval_Arr[1]=true;
        }else{
           inval_Arr[1]=false;
           alert('모든 항목을 양식에 맞게 작성해주세요.');
           return false;
        }
        
        var validAll = true;
        alert('validAll 돼요');
        
        console.log(validAll);
        for(var i = 0; i < inval_Arr.length; i++){
           
           if(inval_Arr[i] == false){
              validAll = false;
           }
        }
        
        alert('validAll= '+validAll);
    
        $('#updateBtn').on('click', function(){
        	if(validAll == true){ // 유효성 모두 통과
        		$('#memupdate').attr('action','memUpdate.do');
        		alert('회원정보가 수정되었습니다.');
		}else{
			alert('회원정보를 다시 수정해주세요.');
			$("#updateBtn").attr("disabled", true);
		}
	});
        
// 회원수정
	
	$('#BackBtn').on('click', function(){
		history.back();
	});//뒤로가기 
	 
	//이메일변경 버튼누를 시 input 활성화
	$('#emailUptBtn').on('click', function(){
		$('#mem_mail').css('disabled', 'disabled' );
		$('#nonemailcode').css('display', '');
	})
	
	
	//비밀번호 chk
	
	var cpwchk=false;
	  $('#mem_pw').blur(function() {
		  console.log('pwcheck 성공');
    	  if($('#mem_pw').val()==''){
        	  $('#pwcheck').text('');
          }else{
	         if (pwJ.test($('#mem_pw').val())) {
	            $('#pwcheck').text('사용 가능한 비밀번호입니다. :)');
	            $('#pwcheck').css('color', 'blue');
	            cpwchk=true;
	         } else {
	            $('#pwcheck').text('4~12자의 숫자 , 문자로만 사용 가능합니다');
	            $('#pwcheck').css('color', 'red');
	            cpwchk=false;
	         }
          }
    	  console.log(cpwchk);
      });
	  
	  $('#mem_pw2').blur(function(){
		  if($('#mem_pw2').val()==''){
			  $('#cpwcheck').text('');
			  cpwchk==false;
		  }
		  else if(cpwchk==false){
			  if($('#mem_pw2').val()==''){
				  $('#cpwcheck').text('');
			  }
		 		$('#cpwcheck').text('비밀번호 입력란을 먼저 양식에 맞게 입력해주세요 --;;');
		 		$('#cpwcheck').css('color', 'red');
		  }else{
			  if($('#mem_pw2').val()==''){
				  $('#cpwcheck').text('');
			  }
			  else if ($('#mem_pw').val() != $(this).val()) {
		            $('#cpwcheck').text('비밀번호가 일치하지 않습니다 :(');
		            $('#cpwcheck').css('color', 'red');
		          /*  $("#register").attr("disabled", true);*/
		         } else {
		            $('#cpwcheck').text('비밀번호가 일치합니다. :)');
		            $('#cpwcheck').css('color', 'blue');
		         }
		 	}
	  });
	  
	//핸드폰 유효성
      $('#mem_phone').blur(function(){
     	 if($('#mem_phone').val()==''){
         	  $('#phonecheck').text('');
           }else{
	             if(phoneJ.test($(this).val())){
	                $("#phonecheck").text('');
	             }else {
	                  $('#phonecheck').text('전화번호를 확인해주세요.');
	                  $('#phonecheck').css('color', 'red');
	              }
           }
        });   
	
      //이메일 유효성
      $("#mem_mail").blur(function() {
    	  if($('#mem_mail').val()==''){
        	  $('#emailcheck').text('');
          }else{
	         if (mailJ.test($(this).val())) {
	            $("#emailcheck").text('');
	         } else {
	            $('#emailcheck').text('이메일 양식을 확인해주세요');
	            $('#emailcheck').css('color', 'red');
	         }
          }
      });
      $('#emailcode').on('click', function(){
    	  $("#updateBtn").attr("disabled", true);
    	  var temp_id=$('#mem_mail').val();
		  alert('인증번호가 전송되었습니다.');
		  $('#emailcode').css('display', 'none');
		  $('#emailcodechk').css('display', '');
		  $("#updateBtn").attr("disabled", true);
		  $.ajax({
			type : 'POST',
  			url : 'codeSend.do',
  			data : {
  				temp_id : temp_id 
  			},
  			dataType : 'json',
  			success : function(res){
  				alert('res값은= '+res);
  				$('#emailcodechk').on('click', function(){
  					var emailcode=$('#mem_mailcode').val();
  					alert('res= '+res);
  					if(res==emailcode){  
	  					$('#emailcodecheck').text('인증되었습니다. :)');
	  					$('#emailcodecheck').css('color', 'blue');
	  					$("#updateBtn").attr("disabled", false);
	  				}else{// 실패
	  					$('#emailcodecheck').text('인증번호가 올바르지 않습니다. :(');
	  					$('#emailcodecheck').css('color', 'red');
	  					$("#updateBtn").attr("disabled", true);
	  				}
  				});
  				console.log('success');
  			 },// success
  			 error:function(){
  				 alert('오류');
  			 }
		  }); // ajax
      	});
	  
});




