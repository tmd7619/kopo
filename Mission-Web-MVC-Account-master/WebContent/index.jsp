<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx"> 
<head>
<style>
        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        #modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
        }
 
</style>
</head>
<body>
 
    <!-- Header Section Begin -->
    	<jsp:include page="/include/topMenu.jsp"></jsp:include>
    <!-- Header End -->
    
     <!-- The Modal -->
    <div id="myModal" class="modal">
     <!-- Modal content -->
     <div id="modal-content">
                <p style="text-align: center;"><span style="font-size: 14pt;"><b><span style="font-size: 24pt;">공지</span></b></span></p>
                <p style="text-align: center; line-height: 1.5;"><br /></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">사이트 서버 점검으로</span></p>
                <p style="text-align: center; line-height: 1.5;"><b><span style="color: rgb(255, 0, 0); font-size: 14pt;">10:00 - 18:00 까지</span></b></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">사이트 사용이 중지 됩니다.</span></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;"><br /></span></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">이용에 불편을 드린 점 양해를 </span></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">부탁드립니다.</span></p>
                <p style="text-align: center; line-height: 1.5;"><br /></p>
                <p><br /></p>
            <div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="close_pop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                     닫기
                </span>
            </div>
      </div>
 
    </div>
    <!--End Modal-->
    <!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="hero-items owl-carousel">
            <div class="single-hero-items set-bg" data-setbg="<%=request.getContextPath() %>/resources/images/lukas-blazek-mcSDtbWXUZU-unsplash.jpg">
                <div class="container">
                    <div class="row">
                          <div class="col-lg-5">
                            <span style="color : #00075e">SW Groop's</span>
                            <h1>SW Bank</h1>
                            <p style="color : #343a40">SW 뱅크는 1960년도에 설립한 역사있는 은행으로서, 쉼없이 달리고 있습니다. 고객님의 행복을 위해 오늘도 SW뱅크는 달려갑니다.</p>
                            <a href="<%=request.getContextPath() %>/register.do" class="primary-btn" style="background-color: #00075e">REGISTER Now</a>
                        </div>
                    </div>
                </div>
            </div>
            <%-- <div class="single-hero-items set-bg" data-setbg="<%=request.getContextPath() %>/resources/images/marga-santoso-OmPqCwX422Y-unsplash.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5" style="margin-left: 1000px">
                            <h1 style="color: white">WELCOME !</h1>
                            <p style="color: white;">&nbsp;  현재 인기있는 금융 상품을 확인하세요!</p>
                            <a href="<%=request.getContextPath() %>/login.do" style="background-color: #00075e" class="primary-btn">Shop Now</a>
                        </div>
                    </div>
                </div>
            </div> --%>
        </div>
    </section>
    <!-- Hero Section End -->



    <!-- Footer Section Begin -->
    
    <!-- Js Plugins -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery-ui.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.countdown.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.nice-select.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.zoom.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.dd.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.slicknav.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>
    
    <!-- Footer Section Begin -->
    <footer class="footer-section" style="background-color: white">
        <div class="copyright-reserved" style="margin-top:0px" >
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="copyright-text">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
                        <div class="payment-pic">
                            <img src="<%=request.getContextPath() %>/resources/images/payment-method.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->


</body>
    <script type="text/javascript">
      
        $(document).ready(function() {
                $('#myModal').show();
        });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
        };
        
</script>



</html>