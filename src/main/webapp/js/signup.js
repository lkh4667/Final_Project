$(document).ready(function() {
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
	
	
	$('#mem_pic').on("change", handleImg);
		
		 $('#registerBtn').on('click', function(){
			 var inval_Arr=new Array(4).fill(false);
		   		//비밀번호
		   		if(pwJ.test($('#mem_pw').val())&&($('#mem_pw').val()==($('#mem_pw2').val()))){
		   			inval_Arr[0]=true;
		   		}else{
		   			inval_Arr[0]=false;
		   			alert('모든 항목을 양식에 맞게 작성해주세요.');
		   			return false;
		   		}
		    	    
		   	  // 이름 정규식
		        if (nameJ.test($('#mem_name').val())) {
		           inval_Arr[1] = true;   
		        } else {
		           inval_Arr[1] = false;
		           alert('모든 항목을 양식에 맞게 작성해주세요.');
		           return false;
		        }
		        
		       
		       // 휴대폰번호 정규식
		           if(phoneJ.test($('#mem_phone').val())){
		              inval_Arr[2]=true;
		           }else{
		              inval_Arr[2]=false;
		              alert('모든 항목을 양식에 맞게 작성해주세요.');
		              return false;
		           }
		           
		           // 이메일 정규식
		           if (mailJ.test($('#mem_mail').val())){
		              inval_Arr[3] = true;
		           } else {
		              inval_Arr[3] = false;
		              alert('모든 항목을 양식에 맞게 작성해주세요.');
		              return false;
		           }
		          
		        var validAll = true;
		        for(var i = 0; i < inval_Arr.length; i++){
		           if(inval_Arr[i] == false){
		              validAll = false;
		           }
		        }
		        alert('validAll= '+validAll);
		    
		        if(validAll == true){ // 유효성 모두 통과
		        		alert($('form').prop('action'));
		        		
		        		alert('이메일 인증 메일을 보냈습니다.');
		        } else{
		        	alert('모든 항목을 양식에 맞게 작성해주세요.');
		        } 
	});  


//모든 공백 체크 정규식
	   var empJ = /\s/g;
	   //아이디 정규식
	   var idJ = /^[a-z0-9]{4,12}$/;
	   // 비밀번호 정규식
	   var pwJ = /^[A-Za-z0-9]{4,12}$/;
	   // 이름 정규식
	   var nameJ = /^[가-힣]{2,6}$/;
	   // 이메일 검사 정규식
	  var mailJ = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	   // 휴대폰 번호 정규식
	  var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	  //숫자만
	  var regex= /[^0-9]/g;
	  
	  
	  //blur 이벤트
	  //패스워드
	  
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
	  

      //이름에 특수문자 들어가지 않도록 설정
      $("#mem_name").blur(function() {
    	  if($('#mem_name').val()==''){
        	  $('#namecheck').text('');
          }else{
	         if (nameJ.test($(this).val())) {
	            $("#namecheck").text('');
	      } else {
	            $('#namecheck').text('이름을 확인해주세요');
	            $('#namecheck').css('color', 'red');
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
        	  $('#emailcode').click(function(){
            	  $('#emailcode').attr('disabled', true);
              });
          }else{
	         if (mailJ.test($(this).val())) {
	            $("#emailcheck").text('');
	            $('#emailcode').click(function(){
	          	  $('#emailcode').css('display', 'none');
	          	  alert('인증번호가 전송되었습니다.');
	          	  $('#emailcodechk').css('display', '');
	            });
	         } else {
	            $('#emailcheck').text('이메일 양식을 확인해주세요');
	            $('#emailcheck').css('color', 'red');
	            $('#emailcode').click(function(){
	            	  $('#emailcode').attr('disabled', true);
	              });
	         }
          }
      });
      
      /*$('#emailcodechk').click(function(){
    	  $.ajax({
   			type : 'GET',
   			dateType: 'text',
      		 url : 'emailChk.do?mem_code='+ mem_code,
   			success : function(data) {
				if(data==true){
					$('#idcheck').text('이미 사용중인 아이디입니다. :(');
					$('#idcheck').css('color', 'red');
					$("#registerBtn").attr("disabled", true);
				}else{
					
				}
   			}	
      });
      });*/
    /*  $("#mem_mailcode").blur(function() {
    	  if($('#mem_mailcode').val()==''){
    		  $('#emailcodecheck').text('');
    	  }else{
    		  if (regex.test($(this).val())) {
    			  $("#emailcodecheck").text('');
    		  } else {
    			  $('#emailcheck').text('인증번호는 숫자만 입력가능합니다.');
    			  $('#emailcheck').css('color', 'red');
    		  }
    	  }
      }); */
      /*//인증번호 유효성
      var mem_mailcode=$('#mem_mailcode').val();
      $('#emailcodechk').click(function(){
    	  $.ajax({
   			type : 'GET',
   			dateType: 'text',
      		 url : 'emailChk.do?code='+ mem_mailcode,
   			success : function(data) {
				if(data==true){
					$('#idcheck').text('이미 사용중인 아이디입니다. :(');
					$('#idcheck').css('color', 'red');
					$("#registerBtn").attr("disabled", true);
				}else{
      });
      */
	  
      
      
     //id 유효성검사
      $("#mem_id").blur(function() {
				if($('#mem_id').val()==''){
					$('#idcheck').text('아이디를 입력하세요.');
					$('#idcheck').css('color', 'red');   						
				} else if(idJ.test($('#mem_id').val())!=true){
					$('#idcheck').text('4~12자의 영문, 숫자만 사용 가능합니다.');
					$('#idcheck').css('color', 'red');
				} else if($('#mem_id').val()!=''){
	        	 
	        	var user_id=$('#mem_id').val();
	        	 $.ajax({
	     			type : 'GET',
	     			dateType: 'text',
	        		 url : 'idcheck.do?mem_id='+ user_id,
	     			success : function(data) {
					if(data==true){
						$('#idcheck').text('이미 사용중인 아이디입니다. :(');
						$('#idcheck').css('color', 'red');
						$("#registerBtn").attr("disabled", true);
					}else{
						if(idJ.test(user_id)){
							$('#idcheck').text('사용 가능한 아이디입니다. :)');
							$('#idcheck').css('color', 'blue');
							$("#registerBtn").attr("disabled", false);
						}else if(user_id==''){
							$('#idcheck').text('아이디를 입력해주세요. :)');
		      	            $('#idcheck').css('color', 'red');
		      	            $('#registerBtn').attr("disabled", true);
						}
						else{
							$('#idcheck').text("아이디는 소문자와 숫자 4~12자리만 가능합니다. ");
							$('#idcheck').css('color', 'red');
							$('#registerBtn').attr("disabled", true);
						}
					}
				 }
	        	 });//ajax///
	         }//else if
        
      });//blur
      
      $('#mem_id').focus(function(){
	  $("#idcheck").text("");
      });

});