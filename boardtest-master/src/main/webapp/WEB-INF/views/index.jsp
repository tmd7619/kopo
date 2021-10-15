<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>digitalex</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="../resources/css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="../resources/css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="../resources/images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="../resources/css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->
<body class="main-layout">
	<!-- loader  -->
	<div class="loader_bg">
		<div class="loader">
			<img src="../resources/images/loading.gif" alt="#" />
		</div>
	</div>
	<!-- end loader -->
	<!-- header -->
	<header>
		<!-- header inner -->
		<div class="header">
			<div class="white_bg">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
							<div class="full">
								<div class="center-desk">
									<div class="logo">
										<a href="index.jsp"><img src="../resources/images/logo.png" alt="#" /></a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
							<nav class="navigation navbar navbar-expand-md navbar-dark ">
								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#navbarsExample04"
									aria-controls="navbarsExample04" aria-expanded="false"
									aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse" id="navbarsExample04">
									<ul class="navbar-nav mr-auto">
										<!--<li class="nav-item active">
                                    <a class="nav-link" href="index.html"> 홈  </a>
                                 </li>-->
										<li class="nav-item"><a class="nav-link"
											href="index.jsp"> 홈 </a></li>
										<li class="nav-item"><a class="nav-link" href="#">계좌조회</a>
										</li>
										<li class="nav-item"><a class="nav-link" href="#">이체
										</a></li>

										<li class="nav-item d_none le_co"><a class="nav-link"
											href="#" data-toggle="modal"
											data-target="#modalSubscriptionForm"><i
												class="fa fa-user" aria-hidden="true"></i> Login</a></li>
										<li class="nav-item d_none le_co"><a class="nav-link"
											href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
										</li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
				<!-- end header inner -->
				<!-- end header -->
				<!-- banner -->
				<section class="banner_main">
					<div id="banner1" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#banner1" data-slide-to="0" class="active"></li>
							<li data-target="#banner1" data-slide-to="1"></li>
							<li data-target="#banner1" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<div class="container-fluid">
									<div class="carousel-caption">
										<div class="row">
											<div class="col-md-12 col-lg-7">
												<div class="text-bg">
													<span>Account inquiry</span>
													<h1>계 좌 조 회</h1>
													<p>It is a long established fact that a reader will be
														distracted by the readable It is a long established fact
														that a reader will be distracted by the readable</p>
													<a class="read_more" href="#"><img
														src="../resources/images/btn_h.png" alt="#" /> Discover Now</a>
												</div>
											</div>
											<div class="col-md-12 col-lg-5">
												<div class="text_img">
													<figure>
														<img src="../resources/images/ban_img.png" alt="#" />
													</figure>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<div class="container-fluid">
									<div class="carousel-caption">
										<div class="row">
											<div class="col-md-12 col-lg-7">
												<div class="text-bg">
													<span>Transfer</span>
													<h1>이 체</h1>
													<p>It is a long established fact that a reader will be
														distracted by the readable It is a long established fact
														that a reader will be distracted by the readable</p>
													<a class="read_more" href="#"><img
														src="../resources/images/btn_h.png" alt="#" /> Discover Now</a>
												</div>
											</div>
											<div class="col-md-12 col-lg-5">
												<div class="text_img">
													<figure>
														<img src="../resources/images/ban_img.png" alt="#" />
													</figure>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#banner1" role="button"
							data-slide="prev"> <i class="fa fa-chevron-left"
							aria-hidden="true"></i>
						</a> <a class="carousel-control-next" href="#banner1" role="button"
							data-slide="next"> <i class="fa fa-chevron-right"
							aria-hidden="true"></i>
						</a>
					</div>
				</section>
			</div>
		</div>
	</header>
	<!-- end banner -->
	<!-- about section -->
	<!-- <div class="about">
         <div class="container">
            <div class="row d_flex">
               <div class="col-md-12 col-lg-5">
                  <div class="about_img">
                     <figure><img src="images/about.png" alt="#"/></figure>
                  </div>
               </div>
               <div class="col-md-12 col-lg-7">
                  <div class="titlepage">
                     <h2> <span class="yellow">ABOUT US</span><br>Welcome TO OUR DEGITALEX</h2>
                     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco </p>
                     <a class="read_more" href="#">Read More</a>
                  </div>
               </div>
            </div>
         </div>
      </div>-->
	<!-- about section -->
	<!-- services section -->
	<!-- <div class="services">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2> <span class="yellow">Services</span><br>consectetur adipiscing elit</h2>
                  </div>
               </div>
               <div class="col-md-3 col-sm-6">
                  <div id="ho_color" class="services_main">
                     <i><img src="images/services_icon1.png" alt="#"/></i>
                     <img class="ho" src="images/services_icon1h.png" alt="#"/>
                     <h3>Safe & Secure</h3>
                     <p>ncididunt ut labore et dolore 
                        magna aliqua. Ut enim
                     </p>
                     <a class="read_more" href="#">Read More</a>
                  </div>
               </div>
               <div class="col-md-3 col-sm-6">
                  <div id="ho_color" class="services_main">
                     <i><img src="images/services_icon2.png" alt="#"/></i>
                     <img class="ho" src="images/services_icon2h.png" alt="#"/>
                     <h3>Mobile Apps</h3>
                     <p>ncididunt ut labore et dolore 
                        magna aliqua. Ut enim
                     </p>
                     <a class="read_more" href="#">Read More</a>
                  </div>
               </div>
               <div class="col-md-3 col-sm-6">
                  <div id="ho_color" class="services_main">
                     <i><img src="images/services_icon3.png" alt="#"/></i>
                     <img class="ho" src="images/services_icon3h.png" alt="#"/>
                     <h3>Wallet</h3>
                     <p>ncididunt ut labore et dolore 
                        magna aliqua. Ut enim
                     </p>
                     <a class="read_more" href="#">Read More</a>
                  </div>
               </div>
               <div class="col-md-3 col-sm-6">
                  <div id="ho_color" class="services_main">
                     <i><img src="images/services_icon4.png" alt="#"/></i>
                     <img class="ho" src="images/services_icon4h.png" alt="#"/>
                     <h3>Experts Support</h3>
                     <p>ncididunt ut labore et dolore 
                        magna aliqua. Ut enim
                     </p>
                     <a class="read_more" href="#">Read More</a>
                  </div>
               </div>
            </div>
         </div>
      </div>-->
	<!-- end services section -->
	<!-- bitcoins section -->
	<div class="bitcoins">
		<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<div class="titlepage">
						<h2>
							<span class="yellow">Buy and Sell Bitcoins</span><br>Why are
							so many people investing in digital
						</h2>
					</div>
				</div>
				<div class="col-md-8 offset-md-2">
					<div class="bitcoins_main">
						<figure>
							<img src="../resources/images/bitcoins.jpg" alt="#" />
						</figure>
						<a class="read_more" href="#">Start now </a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end bitcoins section -->
	<!-- wallet section -->
	<div class="wallet">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>
							<span class="yellow">wallet</span><br>A MOST POWERFUL WALLET
							USE THIS WALLET FOR NEXT SECURE TRANSACTION.
						</h2>
					</div>
				</div>
				<div class="col-md-8 offset-md-2">
					<div class="wallet_main">
						<figure>
							<img src="../resources/images/wallet.jpg" alt="#" />
						</figure>
						<a class="read_more" href="#">Make wallet</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end wallet section -->
	<!-- Subscribe section -->
	<!-- <div class="subscribe">
         <div class="container">
            <div class="row">
               <div class="col-md-8 offset-md-2">
                  <div class="subscribe_main">
                     <h3>Subscribe to our newsletter</h3>
                     <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, </p>
                     <form class="news_form">
                        <input class="enter_form" placeholder="Enter your email" type="text" name="Enter your email">
                        <button class="subscribe_btn">subscribe now</button>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>-->
	<!-- end Subscribe section -->
	<!-- testimonial -->
	<!--<div  class="testimonial">
         <div class="container">
            <div class="row">
               <div class="col-md-12 ">
                  <div class="titlepage">
                     <h2> <span class="yellow">Testimonial</span><br>What is says our clients</h2>
                  </div>
               </div>
            </div>
         </div>
         <div id="testimoni" class="carousel slide testimonial_Carousel " data-ride="carousel">
            <ol class="carousel-indicators">
               <li data-target="#testimoni" data-slide-to="0" class="active"></li>
               <li data-target="#testimoni" data-slide-to="1"></li>
               <li data-target="#testimoni" data-slide-to="2"></li>
               <li data-target="#testimoni" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <div class="container">
                     <div class="carousel-caption ">
                        <div class="row">
                           <div class="col-md-10 offset-md-1">
                              <div class="test_box">
                                 <i><img src="images/test.png"></i>
                                 <h3>distracted by</h3>
                                 <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters,  </p>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <div class="carousel-caption">
                        <div class="row">
                           <div class="col-md-10 offset-md-1">
                              <div class="test_box">
                                 <i><img src="images/test.png"></i>
                                 <h3>distracted by</h3>
                                 <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters,  </p>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <div class="carousel-caption">
                        <div class="row">
                           <div class="col-md-10 offset-md-1">
                              <div class="test_box">
                                 <i><img src="images/test.png"></i>
                                 <h3>distracted by</h3>
                                 <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters,  </p>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <div class="carousel-caption">
                        <div class="row">
                           <div class="col-md-10 offset-md-1">
                              <div class="test_box">
                                 <i><img src="images/test.png"></i>
                                 <h3>distracted by</h3>
                                 <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters,  </p>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <a class="carousel-control-prev" href="#testimoni" role="button" data-slide="prev">
            <i class="fa fa-chevron-left" aria-hidden="true"></i>
            </a>
            <a class="carousel-control-next" href="#testimoni" role="button" data-slide="next">
            <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </a>
         </div>
      </div>-->
	<!-- end testimonial section -->
	<!-- comments  section
      <div class="contact ">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2> <span class="yellow">Contact Us</span><br> Reqesute a call back</h2>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-10 offset-md-1">
                  <form id="contac_form" class="contac_form">
                     <div class="row">
                        <div class="col-md-12 ">
                           <input class="contac_control" placeholder=" Name" type="type" name="Name"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contac_control" placeholder="Phone Number  " type="type" name="Phone Number  ">                          
                        </div>
                        <div class="col-md-12">
                           <input class="contac_control" placeholder="Email Address" type="type" name="Email Address">                          
                        </div>
                        <div class="col-md-12">
                           <textarea class="textarea" placeholder="Message" type="type" Message="Name">Message </textarea>
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn">Send</button>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
            <div class="row">
               <div class="col-md-12">
                  <div class="map">
                     <figure><img src="images/map-(1).png" alt="#"/></figure>
                  </div>
               </div>
            </div>
         </div>
      </div> -->
	<!-- end contact  section -->
	<!--  footer -->

	<div class="modal fade" id="modalSubscriptionForm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3>
						<b>로그인</b>
					</h3>
				</div>
				<form action="" method="post">
					<div class="modal-body mx-3">
						<div class="md-form mb-5" style="margin: 10px;">
							<input type="text" name="id" placeholder="아이디"
								class="form-control validate">
						</div>
						<div class="md-form mb-5" style="margin: 10px;">
							<input type="text" name="pwd" placeholder="패스워드"
								class="form-control validate">
						</div>
						<hr>
					</div>
					<div style="float: right;"
						class="modal-footer d-flex justify-content-center">
						<button type="submit" class="btn btn-primary btn-icon-split">
							제출 <i class="fa fa-paper-plane-o ml-1"></i>
							</submit>
					</div>
				</form>
			</div>
		</div>
	</div>



	<footer>
		<div class="footer">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-md-6 col-sm-6">
						<a class="logo2" href="index.jsp"><img
							src="../resources/images/loogo2.png" alt="#" /></a>
						<div class="follow">
							<p>reader will be distracted by the readable content of a
								page when looking at its layout. The point of using Lorem Ipsum
								is that it has a more-or-less normal di</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6">
						<h3>Quick link</h3>
						<ul class="link_icon">
							<li class="active"><a href="#"> <i
									class="fa fa-chevron-right" aria-hidden="index.jsp"></i>Home
							</a></li>
							<li><a href="#"> <i class="fa fa-chevron-right"
									aria-hidden="blog"></i>Hbout
							</a></li>
							<li><a href="#"> <i class="fa fa-chevron-right"
									aria-hidden="contact"></i>Currency
							</a></li>
							<li><a href="#"> <i class="fa fa-chevron-right"
									aria-hidden="blog"></i>Exchange
							</a></li>
							<li><a href="#"> <i class="fa fa-chevron-right"
									aria-hidden="contact"></i>Subscribe
							</a></li>
						</ul>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6">
						<h3>Instagram</h3>
						<div class="follow">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do</p>
							<ul class="social_icon">
								<li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
								<li><a href="https://github.com/Jiyoooon/probono"><i
										class="fa fa-github"></i></a></li>

							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6">
						<h3>Contact us</h3>
						<ul class="location_icon">
							<li><a href="#"><i class="fa fa-map-marker"
									aria-hidden="true"></i></a>Reader will be dis<br> tracted by
								the reada</li>
							<li><a href="#"><i class="fa fa-envelope"
									aria-hidden="true"></i></a>demo@gmail.com</li>
							<li><a href="#"><i class="fa fa-volume-control-phone"
									aria-hidden="true"></i></a>+01 102586954775</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="copyright">
				<div class="container">
					<div class="row">
						<div class="col-md-10 offset-md-1">
							<p>
								Copyright 2019 All Right Reserved By<a
									href="https://html.design/"> Free html Templates</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- end footer -->
	<!-- Javascript files-->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/popper.min.js"></script>
	<script src="../resources/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/js/jquery-3.0.0.min.js"></script>
	<!-- sidebar -->
	<script src="../resources/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="../resources/js/custom.js"></script>
</body>
</html>