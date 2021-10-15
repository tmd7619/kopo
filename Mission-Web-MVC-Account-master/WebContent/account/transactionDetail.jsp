<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>거래내역 조회</title>


<style>
	#title h2{
		color: #252525;
	    font-weight: 1000;
	    text-align: center;
	    margin-top : 100px;
	    font-family: "Muli", sans-serif;
	}
	
	
	.p_name{
		
		text-align: center;
	
	}

</style>
</head>

<body>
    <!-- Header Section Begin -->
    <header>
        <jsp:include page="/include/topMenu.jsp"></jsp:include>
    </header>
    <!-- Header End -->

    <!-- Breadcrumb Section Begin -->
    
    <div class="contact-title" id="title">
			<h2>${param.accountNo } 계좌의 거래내역</h2>
	</div>
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th >거래번호</th>
                                    <th >거래날짜</th>
                                    <th >거래유형</th>
                                    <th>거래금액</th>
                                    <th>거래 후 잔액</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center;">
                				<c:forEach items="${list }" var="transaction" varStatus="loop">
                                <tr>
                                    <td class="p-price first-row">
                                        <h5><c:out value="${loop.count }"/></h5>
                                    </td>
                                    <td class="p-price first-row">
                                        <h5><c:out value="${transaction.tranDate }"/></h5>
                                    </td>
                                    <td class="p-price first-row">
                                    	<h5><c:out value="${transaction.tranType }"/></h5>
                                    </td>
                                    <td class="p-price first-row">
                                    	<c:choose>
	                                    	<c:when test="${transaction.tranType eq '거래입금' }">
	                         	            	<h5>+<c:out value="${transaction.tranAmount }"/>원</h5>
	                                    	</c:when>
	                                    	<c:when test="${transaction.tranType eq '거래출금' }">
		                         	            <h5>-<c:out value="${transaction.tranAmount }"/>원</h5>
	                                    	</c:when>
	                                    	<c:otherwise>
	                                    		 <h5><c:out value="${transaction.tranAmount }"/>원</h5>
	                                    	</c:otherwise>	
                                    	</c:choose>
                                    </td>
                                    <td class="total-price first-row">
                                    	<h5><c:out value="${transaction.tranBalance }"/>원</h5>
                                    </td>
                                </tr>
                         		</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->


    <!-- Footer Section Begin -->
    <footer>
    	<jsp:include page="/include/bottom.jsp"></jsp:include>
    </footer>
    <!-- Footer Section End -->

</body>

</html>