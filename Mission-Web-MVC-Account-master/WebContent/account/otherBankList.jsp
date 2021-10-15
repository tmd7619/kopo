<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.accountlist{
	
	    flex: 0 0 20%;
	    max-width: 20%;
		
	}
	
	#title h2{
		color: #252525;
	    font-weight: 1000;
	    text-align: center;
	    margin-top : 100px;
	    font-family: "Muli", sans-serif;
	}


	section{
	    justify-items: center;
	    margin-left: 20%;
	    margin-right: 20%;
	    width: 60%;
	}
</style>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>

	if('${ userVO }' == '') {
	location.href = "<%=request.getContextPath() %>/login.do"
	
	}
	
</script>
</head>
<body>

	<!-- Header Section Begin -->
	<jsp:include page="/include/topMenu.jsp"></jsp:include>
	<!-- Header End -->


	<section>
		<div class="contact-title" id="title">
			<h2>다른 은행 계좌 목록</h2>
		</div>
		<div class="benefit-items">
			<div class="row">
				<c:forEach items="${list }" var="account" varStatus="loop">
				<div style="margin-top: 30px;float:left;" class="col-lg-4 col-sm-6" class="accountlist">
					<div class="single-benefit">
						<div class="sb-text">
							<h6>통장별칭 : <c:out value="${account.nickName}" /></h6>
							<h6>계좌번호 : <c:out value="${account.no}" /></h6>
							<h6>잔액 : <c:out value="${account.balance}" />원</h6>
							<h6>예금주 : <c:out value="${account.holder}" /></h6>
							<h6>계좌개설일 : <c:out value="${account.regDate}" /></h6>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>


	<!-- Footer Section Begin -->
	<jsp:include page="/include/bottom.jsp"></jsp:include>
	<!-- Footer Section End -->




</body>
</html>