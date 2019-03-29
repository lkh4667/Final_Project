<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<link rel="stylesheet" type="text/css" href="css/mypageView.css">
<style type="text/css">
#list .action-button {
	width: 100px;
	background: #27AE60;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}

#list .action-button:hover, #list .action-button:focus {
	box-shadow: 0 0 0 2px white, 0 0 0 3px #27AE60;
}
</style>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#pwdchkBtn').on('click', function() {
			var mem_pw = $('#mem_pw').val();
			$.ajax({
				type : 'POST',
				url : 'pwdcheck.do',
				dataType : 'json',
				data : {
					mem_pw : mem_pw,
				},
				success : function(res) {
					if (res == 1) {
						alert('확인되었습니다.');
						$('#prechk').css('display', 'none');
						$('#afterchk').css('display', '');

					} else {
						alert('비밀번호가 옳지 않습니다.');
						$('.inputLabel').text('');
					}
				}

			});
		}); //pwdchkBtn 클릭
		
		////////////////////
			   var empJ = /\s/g;
			   // 비밀번호 정규식
			   var pwJ = /^[A-Za-z0-9]{4,12}$/;
			   // 이메일 검사 정규식
			  var mailJ = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			   // 휴대폰 번호 정규식
			  var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
			  // 숫자만
			  var regex= /[^0-9]/;
			  
		//이메일변경 버튼누를 시 input 활성화
			$('#emailUptBtn').on('click', function(){
				alert('이베일변경 클릭');
				$('#mem_mail').attr('disabled', false); 
				$('#nonemailcode').css('display', '');
			});
			// 모든 공백 체크 정규식
			
			var inval_Arr=new Array(3).fill(false);
		 	//비밀번호
				if(pwJ.test($('#mem_cpw').val())&&($('#mem_cpw').val()==($('#mem_pw2').val()))){
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
			 
			
			
			//비밀번호 chk
			
			var cpwchk=false;
			  $('#mem_cpw').blur(function() {
		    	  if($('#mem_cpw').val()==''){
		        	  $('#pwcheck').text('');
		          }else{
			         if (pwJ.test($('#mem_cpw').val())) {
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
					  else if ($('#mem_cpw').val() != $(this).val()) {
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
</script>
<body>

	<form id="list">
		<div class="title">회원 프로필</div>
		<div style="width: 100%; background-color: yellow;">
			<table class="type03" style="margin: auto;">
				<tr>
					<th scope="row">회원아이디</th>
					<td class="even">${id}</td>
				</tr>
				<tr>
					<th scope="row">회원이름</th>
					<td class="even">${name}</td>
				</tr>
				<tr id="prechk">

					<th scope="row">회원비밀번호</th>
					<td class="even"><input class="inputLabel" type="password"
						name="mem_pw" id="mem_pw" placeholder="비밀번호"
						style="margin-bottom: 20px;">
						<button type="button" id="pwdchkBtn" class="back action-button">확인</button></td>
				</tr>
			</table>
		</div>
		<table class="type03" id="afterchk"
			style="display: none; margin-left: 200px">
			<tr>
				<th scope="row">비밀번호 변경</th>
				<td><input type="password" name="mem_cpw" id="mem_cpw"
					placeholder="Password" />
					<div class="checkfont" id="pwcheck"></div>
			</tr>
			<tr>
				<th scope="row">비밀번호 확인</th>
				<td><input type="password" name="cpass" id="mem_pw2"
					placeholder="Confirm Password" />
					<div class="checkfont" id="cpwcheck"></div>
			</tr>
			<tr>
				<th scope="row">회원전화번호</th>
				<td><input type="tel" name="mem_phone" id="mem_phone"
					style="width: 140px;" placeholder="전화번호 변경" />
					<div class="checkfont" id="phonecheck"></div>
			</tr>
			<tr>
				<th scope="row">회원이메일</th>
				<td class="even"><input type="email" name="mem_mail"
					id="mem_mail" style="width: 140px;" disabled="disabled"
					placeholder="이메일 변경" />
					<button type="button" id="emailUptBtn" class="back action-button">메일
						변경</button>
					<div id="nonemailcode" style="display: none">
						<input type="text" name="mem_mailcode" id="mem_mailcode"
							style="width: 140px;  " placeholder="인증번호입력" />
						<button type="button" id="emailcode" class="submit action-button"
							style="width: 140px;">인증번호 전송</button>
						<button type="button" id="emailcodechk"
							class="submit action-button">인증번호 확인</button>
					</div></td>
			</tr>
		</table>

		<div>
			<button type="button" class="back action-button" id="updateBtn"
				style="width: 140px; font-size: large;">수정완료</button>
		</div>

		<input type="hidden" id="Urlvalue" value="${param.returnUrl}" /> <input
			type="hidden" id="mailIndex" name="mailIndex"
			value="${mdto.mem_mail}" />
	</form>
</body>
</html>