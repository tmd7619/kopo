<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h2 style="padding-bottom: 20px">계좌 별칭 수정</h2>
	</div>
	<form action="<%= request.getContextPath()%>/account/updateProcess.do" method="post" name="transactionForm"
                        onsubmit="return checkForm()">
        <input type="hidden" name="accountNo" value="${param.accountNo }"/> 
		<div class="container" >
			<div class="row" style="justify-content: center;">
				<div class="col-lg-5" >
					<div class="contact-widget">
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-location-pin"></i>
							</div>
							<div class="ci-text">
								<div><strong>계좌번호</strong></div>
								<h6><c:out value="${param.accountNo}" /></h6>
							</div>
							
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-location-pin"></i>
							</div>
							<div class="ci-text">
								<div><strong>현재 계좌 별칭</strong></div>
								<h6><c:out value="${param.nickName}" /></h6>
							</div>
							
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-mobile"></i>
							</div>
							<div class="ci-text">
								<div><strong>수정할 계좌 별칭</strong></div>
								<input type="text" name="newNickName"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="fbBtn">
		<button type="submit" class="site-btn login-btn" style="width: 200px">수정하기</button>
		<button type="button" id="backBtn" class="site-btn login-btn">취소하기</button>
		</div>
		</form>
	</section>

	<footer>
		<jsp:include page="/include/bottom.jsp"></jsp:include>
	</footer>

</body>
</html>