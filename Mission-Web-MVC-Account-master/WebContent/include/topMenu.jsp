<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SW BANK</title>

<!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">
    <!-- Css Styles -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <link rel="stylesheet" href="bower_components/themify-icons/themify-icons.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/themify-icons.css" >
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" type="text/css">
</head>    
    
       <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    
<!-- Header Section Begin -->
    <header class="header-section">
        <div class="header-top">
            <div class="container">
            	<c:choose>
            	<c:when test="${empty userVO }">
                <div class="ht-right">
                    <a href="<%=request.getContextPath() %>/register.do" class="login-panel"><i class="fa fa-user"></i>Register</a>
                    <a href="<%=request.getContextPath() %>/login.do" class="login-panel" style="padding-right: 25px"><i class="fa fa-user"></i>Login</a>
                </div>
                </c:when>
                <c:otherwise>
              	<div class="ht-right">
                    <a href="#" class="login-panel"><i class="fa fa-user"></i>Mypage</a>
                    <a href="<%=request.getContextPath() %>/logout.do" class="login-panel" style="padding-right: 25px"><i class="fa fa-user" ></i>Logout</a>
                    <a href="#" class="login-panel" style="padding-right: 20px;"><b>${userVO.name }님 환영합니다</b></a>
                </div>
                </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="container">
            <div class="inner-header">
                <div class="row">
                    <div class="col-lg-2 col-md-2" >
                        <div class="logo">
                             <a href="<%=request.getContextPath()%>/">
                                <img src="<%=request.getContextPath() %>/resources/images/logo.jpg"  alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 text-right col-md-3">
                        <ul class="nav-right">
                           <!--  <li class="heart-icon">
                                <a href="#">
                                    <i class="icon_heart_alt"></i>
                                    <span>1</span>
                                </a>
                            </li> -->
                            <li class="cart-icon">
                               <!--  <a href="#">
                                    <i class="icon_bag_alt"></i>
                                    <span>3</span>
                                </a> -->
                                <div class="cart-hover">
                                    <div class="select-items">
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td class="si-pic"><img src="<%=request.getContextPath() %>/resources/images/select-product-1.jpg" alt=""></td>
                                                    <td class="si-text">
                                                        <div class="product-selected">
                                                            <p>$60.00 x 1</p>
                                                            <h6>Kabino Bedside Table</h6>
                                                        </div>
                                                    </td>
                                                    <td class="si-close">
                                                        <i class="ti-close"></i>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="si-pic"><img src="<%=request.getContextPath() %>/resources/images/select-product-2.jpg" alt=""></td>
                                                    <td class="si-text">
                                                        <div class="product-selected">
                                                            <p>$60.00 x 1</p>
                                                            <h6>Kabino Bedside Table</h6>
                                                        </div>
                                                    </td>
                                                    <td class="si-close">
                                                        <i class="ti-close"></i>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="select-total">
                                        <span>total:</span>
                                        <h5>$120.00</h5>
                                    </div>
                                    <div class="select-button">
                                        <a href="#" class="primary-btn view-card">VIEW CARD</a>
                                        <a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="nav-item">
            <div class="container">
                <nav class="nav-menu mobile-menu">
                    <ul>
                        <li class="active" ><a href="<%=request.getContextPath()%>">Home</a></li>
                        <li><a href="<%= request.getContextPath()%>/board/list.do">게시판</a></li>
                        <li><a href="#">계좌 거래</a>
                            <ul class="dropdown">
                                <li><a href="<%=request.getContextPath()%>/account/depositForm.do">입금</a></li>
                                <li><a href="<%=request.getContextPath()%>/account/withdrawForm.do">출금</a></li>
                                <li><a href="<%=request.getContextPath()%>/account/transferForm.do">계좌이체</a></li>
                            </ul>
                        </li>
                        <li><a href="<%=request.getContextPath()%>/account/list.do">계좌 조회</a>
                        	<ul class="dropdown">
                                <li><a href="<%=request.getContextPath()%>/account/list.do">SW 뱅크 조회</a></li>
                                <li><a href="<%=request.getContextPath()%>/account/otherBankList.do">다른 은행 조회</a></li>
                            </ul>
                        </li>
                        <li><a href="<%=request.getContextPath()%>/account/openAccountForm.do">계좌 개설</a></li>
                        <li><a href="#">계좌 관리</a>
                            <ul class="dropdown">
                                <li><a href="<%=request.getContextPath()%>/account/updateList.do">계좌 수정</a></li>
                            <%--     <li><a href="<%=request.getContextPath()%>/account/deleteList.do">계좌 해지</a></li> --%>
                            </ul>
                        </li>
                        <li><a href="<%=request.getContextPath()%>/account/transactionList.do">거래내역</a>
                        <ul class="dropdown">
                                <li><a href="<%=request.getContextPath()%>/account/transactionList.do">SW 뱅크 조회</a></li>
                                <li><a href="<%=request.getContextPath()%>/account/otherBankTransactionList.do">다른 은행 조회</a></li>
                        </ul>
                        </li>
                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>
