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
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>

	if('${ userVO }' == '') {
	location.href = "<%=request.getContextPath() %>/login.do"
	
	}
	
	
	$(document).ready(function(){
		
		$('#backBtn').click(function(){
			location.href = "<%=request.getContextPath()%>/" // home으로 돌아가기
		})
		

</script>
</head>
<body>
	
	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>
	
	<div class="contact-title" id="title">
	<h2>간편 계좌이체</h2>
	</div>
	<section class="contact-section spad" >
	<form action="<%= request.getContextPath()%>/account/transferProcess.do" method="post" name="transactionForm"
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
								<div><strong>이체 금액</strong></div>
								<input type="text" name="amount"/>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-5">
					<div class="contact-title" style="text-align: center">
						<h4>상대방 정보 입력</h4>
					</div>
					<div class="contact-widget">
						<div class="cw-item">
							<div class="ci-icon">
								<i class="fas fa-angle-right"></i>
							</div>
							<div class="ci-text">
								<div><strong>상대방 계좌번호</strong></div>
								<input type="text" name="receiverAccountNo"/>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="fas fa-angle-right"></i>
							</div>
							<div class="ci-text">
								<div><strong>은행명</strong></div>
								<input type="text" name="bankName"/>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="fas fa-angle-right"></i>
							</div>
							<div class="ci-text">
								<div><strong>예금주</strong></div>
								<input type="text" name="receiver"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="fbBtn">
		<button type="submit" class="site-btn login-btn" style="width: 200px">송금하기</button>
		<button type="button" id="backBtn" class="site-btn login-btn">취소하기</button>
		</div>
		</form>
	</section>
	
	<!-- Footer Section Begin -->
		<jsp:include page="/include/bottom.jsp"></jsp:include>
	<!-- Footer Section End -->
	
</body>
</html>