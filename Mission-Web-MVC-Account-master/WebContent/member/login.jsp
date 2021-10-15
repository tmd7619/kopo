<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<style>


</style>
<script>
	
	function checkForm(){
		let f = document.loginForm
		
		if(isNull(f.id,'아이디를 입력하세요')){
			return false
		}
		
		if(isNull(f.password,'비밀번호를 입력하세요')){
			return false
		}
		
		return true
	}
	
	
	
	
</script>
</head>
<body>
 
    <!-- Header Section Begin -->
    	<jsp:include page="/include/topMenu.jsp"></jsp:include>
    <!-- Header End -->


    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Login</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Form Section Begin -->

    <!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>Login</h2>
                        <form action="<%= request.getContextPath()%>/loginProcess.do" method="post" name="loginForm"
                        onsubmit="return checkForm()">
                            <div class="group-input">
                                <label for="username">UserID </label>
                                <input type="text" id="username" name="id">
                            </div>
                            <div class="group-input">
                                <label for="pass">Password </label>
                                <input type="password" id="password" name="password">
                            </div>
                            <button type="submit" class="site-btn login-btn">Sign In</button>
                        </form>
                        <div class="switch-login">
                            <a href="<%=request.getContextPath() %>/register.do" class="or-login">Or Create An Account</a>
                            <a id="kakao-login-btn" style="padding-left: 30px"></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!--     <a href="http://developers.kakao.com/logout">Logout</a> -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>    
<script type='text/javascript'>
          //<![CDATA[
          // 사용할 앱의 JavaScript 키를 설정해 주세요.
          Kakao.init('0f673edb4783a374b1213645c23c5f72');
          // 카카오 로그인 버튼을 생성합니다.
          Kakao.Auth.createLoginButton({
              container: '#kakao-login-btn',
              success: function (authObj) {
                 
                 Kakao.API.request({
                    
                    url: '/v2/user/me',
                    success: function(res) {
                       
                       var kakao_id = res.id;
                       
                       var email = res.kakao_account['email'];
                       
                       location.href = "<%= request.getContextPath() %>/kakaoLogin.do?kakao_email=" + email;
                    }
                    
                 })
                 
                  /* alert(JSON.stringify(authObj)); */
              },
              fail: function (err) {
                  alert(JSON.stringify(err));
              }
          });
          
          if(!Kakao.Auth.getAccessToken())  {
             
             console.log("Not logged in.");
          }
          
          Kakao.Auth.logout(function() { -- 로그아웃
             console.log(Kakao.Auth.getAccessToken()); 
          })
        //]]>
          
</script> 

    <!-- Footer Section Begin -->
    	<jsp:include page="/include/bottom.jsp" ></jsp:include>
    <!-- Footer Section End -->
</body>

</html>