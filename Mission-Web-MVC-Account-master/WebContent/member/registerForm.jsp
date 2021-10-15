<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
        <link rel="stylesheet" href="new_main.css">
<style>
html {
    height: 100%;
}

body {
    margin: 0;
    height: 100%;
    background: white;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}


#header h2 {
	margin-top : 100x;
    color: #252525;
    font-weight: 700;
    text-align: center;
}
#wrapper {
    position: relative;
    height: 100%;
}

#content {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    width: 460px;
}




/* 입력폼 */

label{
	
	display: block;
    font-size: 18px;
    color: #252525;
    margin-bottom: 13px;

}


h3 {
    margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}


.box {
    display: block;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
}

.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
}

input {
    font-family: Dotum,'돋움',Helvetica,sans-serif;    
}

.box.int_id {
    padding-right: 110px;
}

.box.int_pass {
    padding-right: 40px;
}

.box.int_pass_check {
    padding-right: 40px;
}

.step_url {
    /*@naver.com*/
    position: absolute;
    top: 16px;
    right: 13px;
    font-size: 15px;
    color: #8e8e8e;
}

.pswdImg {
    width: 18px;
    height: 20px;
    display: inline-block;
    position: absolute;
    top: 50%;
    right: 16px;
    margin-top: -10px;
    cursor: pointer;
}

#bir_wrap {
    display: table;
    width: 100%;
}

#bir_yy {
    display: table-cell;
    width: 147px;
    
}

#bir_mm {
    display: table-cell;
    width: 147px;
    vertical-align: middle;
}

#bir_dd {
    display: table-cell;
    width: 147px;
}

#bir_mm, #bir_dd {
    padding-left: 10px;
}

select {
    width: 100%;
    height: 29px;
    font-size: 15px;
    background: #fff url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50% no-repeat;
    background-size: 20px 8px;
    -webkit-appearance: none;
    display: inline-block;
    text-align: start;
    border: none;
    cursor: default;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}

/* 에러메세지 */

.error_next_box {
    margin-top: 9px;
    font-size: 12px;
    color: red;    
    display: none;
}

#alertTxt {
    position: absolute;
    top: 19px;
    right: 38px;
    font-size: 12px;
    color: red;
    display: none;
}

/* 버튼 */

.btn_area {
    margin: 30px 0 91px;
}

#btnJoin {
    width: 100%;
    padding: 21px 0 17px;
    border: 0;
    cursor: pointer;
    color: #fff;
    background-color: #1A213A;
    font-size: 20px;
    font-weight: 400;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script>	
	 function doWrite(){
		
		let f = document.joinForm
		if(f.id.value == '') {
			alert('아이디를 입력하세요')
			f.id.focus()
			return false
		}
		
		if(f.password.value == '') {
			alert('비밀번호를 입력하세요')
			f.password.focus()
			return false
		}
		
		if(f.pwd2.value == '') {
			alert('재확인 비밀번호를 입력하세요')
			f.pwd2.focus()
			return false
		}
		
		if(f.name.value == '') {
			alert('이름을 입력하세요')
			f.name.focus()
			return false
		}
		
		if(f.birth.value == '') {
			alert('생년월일을 입력하세요')
			f.birth.focus()
			return false
		}
		 
		
		 
		if(f.phone.value == '') {
			alert('전화번호를 입력하세요')
			f.phone.focus()
			return false
		}
		
		return true
	} 
	
 	$(document).ready(function(){
		
 		$('#pwd-success').hide()
		$('#pwd-fail').hide() 
		
		$('#pswd2').on("propertychange change keyup paste input",
        	function() {
				let val = $(this).val()
				if(val == $('#pswd1').val()) {
					$('#pwd-success').show()
					$('#pwd-fail').hide()
					$('#btnJoin').attr('disabled', false)
				} else {
					$('#pwd-success').hide()
					$('#pwd-fail').show()
					$('#btnJoin').attr('disabled', true)
				}
				if(val == '') {
					$('#pwd-success').hide()
					$('#pwd-fail').hide()
					$('#btnJoin').attr('disabled', true)
				}
		
			})
		
	})	
	
$(document).ready(function(){
      $("#id").keyup(function() {
              var id = $('#id').val();
              var pattern1 = /^[a-z]+[a-z0-9]{5,19}$/g ;
              
              if (pattern1.test(id)){//정규식이 통과한 경우
                 $.ajax({
                       url : '${pageContext.request.contextPath}/idOverlapCheck.do',
                       type : 'get',
                       contentType: "application/x-www-form-urlencoded; charset=utf-8",
                       dataType: "json",
                       data : {"id" :id},
                       success : function(data){ // temp 값 넘어옴  1이면 db에 저장 o, else는 저장x => 사용가능
                          
                          if(data == 1) {
                          $('#check_id').text("사용 중인 아이디 입니다.");
                          $('#submit').attr("disabled", "disabled");      
                          } else {
                                $('#check_id').text("사용가능한 아이디 입니다.");
                                $("#btnJoin").removeAttr("disabled");                    
                          }
                       }, error : function(){
                       }
                    });
              }else if (id ==""){
                 $('#check_id').text("아이디를 입력해 주세요");
               $('#btnJoin').attr("disabled", "disabled");   
              }    else {
                 $('#check_id').text("형식에 맞지 않는 아이디입니다.");
               $('#btnJoin').attr("disabled", "disabled");   
                 //정규식 통과에 실패한 경우
              }
      });
});
</script>
    </head>
    <body>
    
    	 <!-- Header Section Begin -->
   			<jsp:include page="/include/topMenu.jsp" />
   		 <!-- Header End -->
   		 
   		 
        <!-- header -->
        <div id="header">
           <h2 style="margin-top: 100px;">회원가입</h2>
        </div>

		
        <!-- wrapper -->
        <div id="wrapper">

            <!-- content-->
            <div id="content">

                <!-- ID -->
				<form action="<%=request.getContextPath() %>/registerProcess.do" method = "post" 
						name="joinForm" onsubmit= "return doWrite()">
                <div>
                    <h3 class="join_title">
                        <label for="id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" id="id" class="int" maxlength="20" name = "id" id="id">
                        <!-- <span class="step_url"></span> -->
                    </span>
                        <div id="check_id" style="font-size:14px; color:#ff0000;">아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다</div>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="pswd1" class="int" maxlength="20" name = "password">
                        <span id="alertTxt">사용불가</span>
                        
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW2 -->
                <div>
                    <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                    <span class="box int_pass_check">
                        <input type="password" id="pswd2" class="int" name="pwd2" maxlength="20">     
                    </span>
                      <span id="pwd-success" style="color:blue;">비밀번호가 일치합니다.</span>
					  <span id="pwd-fail" style="color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" id="name" class="int" maxlength="20" name = "name">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- BIRTH -->
                 <div>
                    <h3 class="join_title"><label for="name">생년월일</label></h3>
                    <span class="box int_name">
                        <input type="date" class="int" name="birth"/>
                    </span>
                    <span class="error_next_box" maxlength="20"></span>
                </div>

                <!-- EMAIL -->
                <div>
                    <h3 class="join_title"><label for="email">본인확인 이메일<span class="optional">(선택)</span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" class="int" maxlength="100" placeholder="선택입력" name="email">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div> 

                <!-- MOBILE -->
                <div>
                    <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                    <span class="box int_mobile">
                        <input type="tel" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력(숫자만 입력)" name="phone" pattern="(010|011|017)[0-9]{4}[0-9]{4}" maxlength="11">
                    </span>
                    <span class="error_next_box"></span>    
                </div>


                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="submit" id="btnJoin">
                        <span>가입</span>
                    </button>
                </div>
	
                </form>

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
        
        
      <!-- Footer Section Begin -->
	    <jsp:include page="/include/bottom.jsp" />
    <!-- Footer Section End --> 
        
    <script src="main.js"></script>
    </body>
</html>