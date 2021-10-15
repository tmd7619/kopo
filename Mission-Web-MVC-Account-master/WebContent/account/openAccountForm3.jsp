<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
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

</script>
</head>


<body>

    <!-- Header Section Begin -->
   		<jsp:include page="/include/topMenu.jsp" />
    <!-- Header End -->

    <section class="checkout-section spad">
       <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>계좌 정보 설정</h2>
                        <form action="<%= request.getContextPath()%>/account/openAccountProcess.do" method="post" name="registerForm"
                        onsubmit="return checkForm()">
                            <div class="group-input">
                                <label for="username">계좌 별칭 입력 (생략가능) </label>
                                <input type="text" id="nickname" name="nickname">
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
                            
                            <button type="submit" class="site-btn login-btn">계좌 개설</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </section>


    <!-- Footer Section Begin -->
	    <jsp:include page="/include/bottom.jsp" />
    <!-- Footer Section End -->
    
    
</body>

</html>