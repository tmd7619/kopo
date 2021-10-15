<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section{
		margin-top: 100px;
	}
	
	#title h2{
		color: #252525;
	    font-weight: 700;
	    text-align: center;
	    margin-top : 100px;
	    font-family: "Muli", sans-serif;
	}
	
	#backBtn {
	width: 200px;
	background-color: white;
	color: black;
	text-align: center;
	
	}

	#fbBtn{
	text-align: center;
	margin-top : 50px;
	margin-bottom: 100px;

	}

</style>
<script>

	if('${ userVO }' == '') {
		location.href = "<%=request.getContextPath() %>/login.do"
		
	}

</script>
</head>
<body>

	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>

	<section class="contact-section spad" >
	<div class="contact-title" id="title">
	<h2 style="padding-bottom: 20px">간편 출금하기</h2>
	</div>
	<form action="<%= request.getContextPath()%>/account/withdrawProcess.do" method="post" name="transactionForm"
                        onsubmit="return checkForm()">
		<div class="container" >
			<div class="row" style="justify-content: center;">
				<div class="col-lg-5" >
					<div class="contact-title" style="text-align: center">
						<h4>내 정보 입력</h4>
					</div>
					<div class="contact-widget">
						<div class="cw-item">
							<div class="ci-icon">
								<i class="fas fa-angle-right"></i>
							</div>
							<div class="ci-text">
								<div><strong>내 계좌번호</strong></div>
								<input type="text" name="myAccountNo"/> 
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="fas fa-angle-right"></i>
							</div>
							<div class="ci-text">
								<div><strong>비밀번호</strong></div>
								<input type="password" name="myPassword"/>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="fas fa-angle-right"></i>
							</div>
							<div class="ci-text">
								<div><strong>출금할 금액</strong></div>
								<input type="text" name="amount"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="fbBtn">
		<button type="submit" class="site-btn login-btn" style="width: 200px">출금하기</button>
		<button type="button" id="backBtn" class="site-btn login-btn">취소하기</button>
		</div>
		</form>
	</section>

	<footer>
		<jsp:include page="/include/bottom.jsp"></jsp:include>
	</footer>

</body>
</html>