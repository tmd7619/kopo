<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style>
	#checkPhone {
	/* 	display: inline-block; */
		color: #ffffff;
		background: #1A213A;
		font-size: 13px;
		font-weight: 700;
		text-transform: uppercase;
		border: 1px solid #1A213A;
		/* right: 0;
		top: 0; */
		height : 50px;
		width: 130px;
		padding: 13px 20px 12px;
		margin-left : 100px;
		cursor: pointer;
	}
	
	#backBtn{
	
		width: 50%;
		float:left;
		background-color: white ; 
		color : black;
	}
</style>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>

	if('${ userVO }' == '') {
	location.href = "<%=request.getContextPath() %>/login.do"
	
	}
	
	$(document).ready(function(){
		
		$('#backBtn').click(function(){
			location.href = "<%=request.getContextPath()%>/" // home으로 돌아가기
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
                        <h2>${userVO.name }님의 계좌생성하기</h2>
                        <br>
                        <form action="<%= request.getContextPath()%>/account/openAccountForm2.do" method="post" name="openAccountForm"
                        onsubmit="return checkForm()">
                        	<h4>본인인증</h4>
                        	<br>
                            <div class="group-input">
                                <label for="username">아이디 입력 </label>
                                <input type="text" id="userid" name="id">
                            </div>
                            <div class="group-input">
                                <label for="pass">패스워드 입력  </label>
                                <input type="password" id="password" name="password">
                            </div>
                       <!--      <div class="group-input">
                                <label for="username">휴대폰 인증 </label>
                                <input type="text" id="username" name="phone" style="width: 50%;float:left">
                                <button id="checkPhone" >인증하기</button>
                            </div> -->
                            
                            <button type="button" id="backBtn" class="site-btn login-btn" >이전</button>
                            <button type="submit" class="site-btn login-btn"style="width: 50%">다음</button>
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