$(document).ready(function () {
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
    
        $('#ReviseBtn').on('click', function(){
        	if(validAll == true){ // 유효성 모두 통과
        		$('#memupdate').attr('action','memUpdate.do');
        		alert('회원정보가 수정되었습니다.');
		}else{
			alert('회원정보를 다시 수정해주세요.');
			$("#ReviseBtn").attr("disabled", true);
		}
	});
        
// 회원수정
	
	$('#BackBtn').on('click', function(){
		history.back();
	});//뒤로가기 
	 
	
	
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
	  
});




