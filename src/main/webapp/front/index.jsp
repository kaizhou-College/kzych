<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/iconeffects.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<link rel="stylesheet" href="css/layui.css?t=1515376178709"  media="all">

<style>
	.sep{height:25px;}
	.sep legend{width:auto;border-bottom:0;margin-bottom:0;margin-left: 70px;font-size:16px;line-height:10px;color: #009688 !important;}
</style>

<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
var host="${host}";
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			
		});
		
		$("#autosuggest-input").on("keyup",function(){
				 
				  if($(this).val().length > 0){
				  	  $(".search-magnify-btn-close").show();
				  }
				  else{
				  	  $(".search-magnify-btn-close").hide();
				  }
			});
			
			/*
		$(".more-item").on("click",function(event){
			
			   $(".C-global-cheggheader-rightsection-usermenu .nav-item .carrot").toggle();
			   $(".C-global-cheggheader-rightsection-usermenu .nav-item .hover-box").toggle();
			   
			   event.stopPropagation();
			   return false;
		});
		
		*/
		
		$(".more-item").hover(function(event){
			  $(".C-global-cheggheader-rightsection-usermenu .nav-item .carrot").show();
			  $(".C-global-cheggheader-rightsection-usermenu .nav-item .hover-box").show();
		},function(){
			  $(".C-global-cheggheader-rightsection-usermenu .nav-item .carrot").hide();
			  $(".C-global-cheggheader-rightsection-usermenu .nav-item .hover-box").hide();
		});
		$("body").on("click",function(){
				 $(".C-global-cheggheader-rightsection-usermenu .nav-item .carrot").hide();
			   $(".C-global-cheggheader-rightsection-usermenu .nav-item .hover-box").hide();		   
		});
		
		$(window).scroll(function () {
        //$(window).scrollTop()这个方法是当前滚动条滚动的距离
        //$(window).height()获取当前窗体的高度
        //$(document).height()获取当前文档的高度
        
        if($(window).scrollTop() > 10){
        	$(".chgg-hdr").removeClass("translucent");
        	  $(".chgg-hdr").addClass("easeIn");
        }
        else{
        	  $(".chgg-hdr").removeClass("easeIn");
        	  $(".chgg-hdr").addClass("translucent");
        }
        
    });
    
     //测试代码
    checkUserLogin();
    //测试代码
    function checkUserLogin(){
    	 var token = "${currentUser.username}" ;
    	 
    	  /*var arr,reg=new RegExp("(^| )"+"token" +"=([^;]*)(;|$)");
			if(arr=document.cookie.match(reg)){
			    token = unescape(arr[2])
			} */
			 //异步请求 看该用户是否管理员
			 $.ajax({
				    type:"post",
		  			url:host+"/user/isNotAdministrator.do",
		  			data:{"username":token},
		  			success:function(data){
		  				if(token == data.data.username&data.data.userType==1){
		  				  $("#admin_logined").show();
		  				  $("#logined").hide();
		  				  $("#nologin").hide();
		  				  $("#login1").attr("href","javascript:exit();");
		  				  $("#login1").text(data.data.username);
		  				  
		  				}
		  				else if(token == data.data.username&data.data.userType==0){
		  				   
		  				  $("#admin_logined").hide();
		  				  $("#logined").show();
		  				  $("#nologin").hide();
		  				  $("#login1").attr("href","javascript:exit();");
		  				  $("#login1").text(data.data.username);
		  				}else if(token == data.data.username&data.data.userType==2){
		  					  $("#admin_logined").hide();
			  				  $("#logined").show();
			  				  $("#nologin").hide();
			  				  $(".kzt").hide();
			  				  $("#login1").attr("href","javascript:exit();");
			  				  $("#login1").text(data.data.username);
		  				}
		  			},
		  			error:function(){
		  				alert("请求失败！！！");
		  			}
			  });
    	
    }
    
    //测试代码
    function getCookie(name)
		{
			var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
			if(arr=document.cookie.match(reg))
			return unescape(arr[2]);
			else
			return null;
		}
		//测试代码
    $(".quit").on("click",function(){
    	
 
			var exp = new Date();
			exp.setTime(exp.getTime() - 1);
			var cval=getCookie("token");
			if(cval!=null)
			document.cookie= "token" + "="+ '' +";expires="+exp.toGMTString() + ";path=/;";
			location.href = host+"/front";

    });
	});
</script>
<!-- start-smoth-scrolling -->

</head>
<body>
<!-- header -->
<div class="banner w3l">
	
	<!--header content start-->
	<div class="chgg-hdr-overlay  force-desktop"></div>
		  <p class="skip-navigation"><a href="#main-content-start">Skip Navigation</a></p>
			<!-- header contend start-->
			<div class="chgg-hdr  force-desktop  expandedSearchBox   type-home subtype- translucent" style="left: 0px; top: 0px;">
			    <div class="chgg-hdr-content">
			        <!--
			        <div class="chgg-menu-container" role="button" tabindex="0" aria-label="Hamburger Menu. Has product links in sub menu." aria-expanded="false">
			            <div class="chgg-menu-icon icon-chegg-hamburger"></div>
			        </div>
			
			        
			        <nav class="chgg-menu split-nav hidden">
			            <div class="carrot"><div class="chgg-menu-icon icon-chegg-cancel" role="button" tabindex="0" aria-label="Close Menu."></div></div>
			            <ul class="chgg-menu-items">
			                <li><a class="chgg-menu-item home track-home" href="https://www.chegg.com/" aria-label="Product Links .  Chegg Home.">
			                    <div class="chgg-menu-image icon-chegg-home-c"></div>
			                    <span>Chegg home</span>
			                </a></li>
			                <li><a class="chgg-menu-item books track-books" href="https://www.chegg.com/books" aria-label="Chegg Books">
			                    <div class="chgg-menu-image icon-chegg-books"></div>
			                    <span>Books</span>
			                </a></li>
			                <li><a class="chgg-menu-item study track-study" href="https://www.chegg.com/study" aria-label="Chegg Study">
			                    <div class="chgg-menu-image icon-chegg-study2"></div>
			                    <span>Study</span>
			                </a></li>
			                <li><a class="chgg-menu-item tutors track-tutors" href="https://www.chegg.com/tutors/" aria-label="Chegg Tutors">
			                    <div class="chgg-menu-image icon-chegg-tutors-person"></div>
			                    <span>Tutors</span>
			                </a></li>
			                <li><a class="chgg-menu-item testprep track-testprep" href="https://www.chegg.com/test-prep" aria-label="Chegg Test Prep">
			                    <div class="chgg-menu-image icon-chegg-TestPrep"></div>
			                    <span>Test Prep</span>
			                </a></li>
			                <li><a class="chgg-menu-item internships track-internships" href="https://www.chegg.com/internships/" aria-label="Chegg Internships">
			                    <div class="chgg-menu-image icon-chegg-career"></div>
			                    <span>Internships</span>
			                </a></li>
			                <li><a class="chgg-menu-item scholarships track-scholarships" href="https://www.chegg.com/scholarships" aria-label="Chegg Scholarships">
			                    <div class="chgg-menu-image icon-chegg-colleges2"></div>
			                    <span>Scholarships</span>
			                </a></li>
			            </ul>
			        </nav>
			        -->
			        
			        
			        <a class="chgg-logo home track-home" href="/" aria-label="">油菜花网络</a>
			
			        
			        <div class="chgg-hdr-navigation ">
			            <div class="nav-items home ">
			                    <div class="nav-item has-hover-box books-item">
			                            <a class="nav-item-header link-books" href="/" aria-expanded="false"  tabindex="0">
			                            首页
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        <!--
			                        <div class="nav-hover-box" style="display: none;">
			                            <div class="carrot" style="margin-left: 24px;"></div>
			                            <div class="nav-hover-box-section">
			                                <div class="links-section">
			                                    <a class="link-rent-buy rent-buy-item" href="http://www.iychua.com/">Rent / Buy</a>
			                                    <a class="link-sell sell-item" href="https://www.chegg.com/sell-textbooks">Sell</a>
			                                </div>
			                            </div>
			                        </div>
			                        -->
			                    </div>
			                    <div class="nav-item has-hover-box study-item">
			                            <a class="nav-item-header link-study" href="http://www.iychua.com" aria-expanded="false" aria-label="" tabindex="0">
			                            学校
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        <!--
			                        <div class="nav-hover-box" style="display: none;">
			                            <div class="carrot" style="margin-left: 22px;"></div>
			                            <div class="nav-hover-box-section">
			                                <div class="links-section">
			                                    <a class="link-textbook-solutions tbs-item" href="https://www.chegg.com/study/tbs">Textbook Solutions</a>
			                                    <a class="link-expert-qa qa-item" href="https://www.chegg.com/study/qa">Expert Q&amp;A</a>
			                                </div>
			                            </div>
			                        </div>
			                        -->
			                    </div>
			                    <div class="nav-item has-hover-box study-item">
			                            <a class="nav-item-header link-study" href="http://www.iychua.com" aria-expanded="false" aria-label="" tabindex="0">
			                            专业
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        
			                    </div>
			                    <div class="nav-item tutors-item">
			                            <a class="nav-item-header link-tutors" href="http://www.iychua.com" aria-label=" " tabindex="0">
			                            资讯
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                    </div>
			                    <!--
			                    <div class="nav-item has-hover-box testprep-item">
			                            <a class="nav-item-header link-test-prep" href="https://www.chegg.com/test-prep" aria-expanded="false" aria-label="Chegg Test Prep menu. Has sub menu." tabindex="0">
			                            Test Prep
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        <div class="nav-hover-box" style="display: none;">
			                            <div class="carrot" style="margin-left: 35px;"></div>
			                            <div class="nav-hover-box-section">
			                                <div class="links-section">
			                                    <a class="link-act act-item" href="https://www.chegg.com/test-prep/act" aria-label="ACT">ACT</a>
			                                    <a class="link-sat sat-item" href="https://www.chegg.com/test-prep/sat" aria-label="SAT">SAT</a>
			                                    <a class="link-gre gre-item" href="https://www.chegg.com/test-prep/gre" aria-label="GRE">GRE</a>
			                                    <a class="link-gmat gmat-item" href="https://www.chegg.com/test-prep/gmat" aria-label="GMAT">GMAT</a>
			                                    <a class="link-mcat mcat-item" href="https://www.chegg.com/test-prep/mcat" aria-label="MCAT">MCAT</a>
			                                    <a class="link-lsat lsat-item" href="https://www.chegg.com/test-prep/lsat" aria-label="LSAT">LSAT</a>
			                                    <a class="link-nclexrn nclex-rn-item" href="https://www.chegg.com/test-prep/nclex-rn" aria-label="NCLEX-RN">NCLEX-RN</a>
			                                    <a class="link-nclexpn nclex-pn-item" href="https://www.chegg.com/test-prep/nclex-pn" aria-label="NCLEX-PN">NCLEX-PN</a>
			                                    <a class="link-ap ap-item" href="https://www.chegg.com/test-prep/ap" aria-label="AP">AP</a>
			                                    <a class="link-asvab asvab-item" href="https://www.chegg.com/test-prep/asvab" aria-label="A S V A B">ASVAB</a>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                    -->
			                    <div class="nav-item has-hover-box internships-item">
			                            <a class="nav-item-header link-internships" href="http://www.iychua.com" aria-expanded="false" aria-label="" tabindex="0">
			                            社会实践
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        <!--
			                        <div class="nav-hover-box" style="display: none;">
			                            <div class="carrot" style="margin-left: 44px;"></div>
			                            <div class="nav-hover-box-section">
			                                <div class="links-section">
			                                    <a class="link-internships-jobs jobs-item" href="https://www.chegg.com/internships/">Internships &amp; jobs</a>
			                                    <a class="link-career-profiles career-profiles-item" href="https://www.chegg.com/career-center/explore">Career profiles</a>
			                                    <a class="link-advice advice-item" href="https://www.chegg.com/advice/career-center/">Advice</a>
			                                </div>
			                            </div>
			                        </div>
			                        -->
			                    </div>
			                    <div class="nav-item has-hover-box scholarships-item">
			                            <a class="nav-item-header link-scholarships" href="http://www.iychua.com" aria-expanded="false" aria-label="" tabindex="0">
			                            找工作
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        <!--
			                        <div class="nav-hover-box" style="display: none;">
			                            <div class="carrot" style="margin-left: 51.5px;"></div>
			                            <div class="nav-hover-box-section">
			                                <div class="links-section">
			                                    <a class="link-scholarships scholarships-item" href="https://www.chegg.com/scholarships">Scholarships</a>
			                                    <a class="link-explore-colleges explore-item" href="https://www.chegg.com/schools">Explore colleges</a>
			                                    <a class="link-my-college-list my-list-item" href="https://www.chegg.com/admissions/college-list">My college list</a>
			                                </div>
			                            </div>
			                        </div>
			                        -->
			                    </div>
			            </div>
			        </div>
			        
			        <div class="chgg-hdr-right-section-wrapper">

			            <div class="chgg-hdr-right-section ">
			                <div class="custom-content" id="chgg-hdr-right-section-custom-left"></div>
			                <div class="chgg-hdr-right-section-main">
			                	<div id="eggshell-21" class="C-global-cheggheader-rightsection">
			                		<div id="eggshell-22" class="C-global-cheggheader-rightsection-cart">
			                			<a class="chg-cart-area track-cart nav-item" rel="nofollow" data-noajax="data-noajax" href=""  style="display: none;">
			                				<span class="chg-cart"></span><span class="chg-cart-count"></span>
			                			</a>
			                		</div>
			                		<div id="eggshell-23" class="C-global-cheggheader-rightsection-notifications">
			                				<div class="chg-hdr-notifications embed-js" id="notifications-component"></div>
			                		</div>
			                		<div id="eggshell-24" class="C-global-cheggheader-rightsection-usermenu">
			                			<a href="login.jsp" id="login1" class="signin-item nav-item track-signin">登录</a>
			                			<div class="more-item nav-item">
			                				<div class="header" role="button" tabindex="0" aria-label="More Menu, has sub menu" aria-expanded="false">更多 <span class="icon-chegg-chevron"></span></div>
			                				<div class="carrot">
			                					<div class="carrot-inner"></div>
			                				</div>
			                				<div class="more-hover-content hover-box">
			                					<ul id="nologin">
			                						<li><a href="${host }/front/register.jsp" class="track-signup" aria-label="Create an account">注册</a></li>
			                						<li><a href="" class="track-help" data-noajax="" aria-label="Help">帮助</a></li>
			                					</ul>
			                					<ul id="logined" style="display:none;">
			                						<!-- <li><a href="/university/productTO.do">控制台</a></li> -->
			                						<li><a href="${host }/university/productTO.do"  class="kzt">控制台</a></li>
			                					
			                						<li class="quit"><a  class="track-signup " aria-label="Sign out" href="javascript:exit();">退出</a></li>
			                						
			                						
			                						
			                						
			                					</ul>
			                					<ul id="admin_logined" style="display:none;">
			                						 <!--<li><a href="/university/index.do">控制台</a></li> -->
			                						<li><a href="${host }/university/index.do" class="kzt">控制台</a></li>
			                						
			                						<li class="quit"><a href="javascript:exit();" class="track-signout hide-initially" aria-label="Sign out">退出</a></li>
			                					</ul>
			                				</div>
			                			</div>
			                		</div>
			                	</div>
			                </div>
			                
			                <div class="custom-content" id="chgg-hdr-right-section-custom-right"></div>
			            </div>
			        </div>
			    </div>
			 </div>
	<!--header cntent end -->
	<div class="banner-info">
		
			<!--nav start-->
		<div class="sohp-header">
			<div class="hero">
				<h1 class="headline">为你的成才之路保驾护航</h1>
				<h2 class="subheadline">学生择校、成长、找工作的平台</h2>
				<!--
				<video autoplay="" loop="" poster="//assets.cheggcdn.com/_public-assets/site/marketing/videos/summer17/summer_video_first_frame.jpg#TestingCSR" class="sohpVid sohpBackground-bottom" muted="">
					<source src="//assets.cheggcdn.com/_public-assets/site/marketing/videos/summer16/video-Summer16-MediumLow_Bitrate2.mp4" type="video/mp4">
				</video>	
				-->
			</div>
			<div class="gorilla-glass">
				<div id="eggshell-5" class="C-page-my-study">
					<div class="gorilla-container tabs-4">
							<div class="gorilla-carrot"><div class="outer-carrot"><div class="carrot-inner"></div></div></div>
							<div class="enroll gorilla-vertical" tabindex="0" role="tab" aria-selected="true">报名入学</div>
							<div class="promote gorilla-vertical" tabindex="0" role="tab" aria-selected="false">自我提升</div>
							<div class="practice gorilla-vertical" tabindex="0" role="tab" aria-selected="false">社会实践</div>
							<div class="find_job gorilla-vertical" tabindex="0" role="tab" aria-selected="false">寻找工作</div>
				  </div>
			  </div>
		  </div>
		  <div class="sohp-autosuggest heroimg-content tabs-4">

				<form class="chg-search-form" action="/search" onsubmit="return false">
					<input id="autosuggest-input" name="autosuggest-input" class="sohp-input-field form-input-sm" placeholder="找学校、找专业、找资讯、找工作" autocomplete="off" type="text">
					<a class="autosuggest-search-cancel search-magnify-btn-close autosuggest-search-cancel" href="#">
						<span class="icon-x">Close</span>
					</a>
		      <a data-type="button" class="autosuggest-search-btn search-magnify-btn" href="#">
		           <span class="icn-magnify">Submit</span>
		      </a>
				</form>
			  <div class="sohp-input-search-container">
			  	<div id="eggshell-10" class="C-common-search"><div id="eggshell-12" class="C-search-autosuggest"></div></div>
			  </div>
		  </div>
	   </div>
			<!--nav end-->
		</div>
	
</div>
<!-- //header -->
<!-- navigation -->

<div class="header w3ls wow bounceInUp" data-wow-duration="1s" data-wow-delay="0s">
	
<!--
	<div class="container">
						<nav class="navbar navbar-default">
							
							<div class="navbar-header logo">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<h1>
									<a class="navbar-brand link link--yaku" href="index.html">Real Site</a>
								</h1>
								
							</div>
							
							<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
								<nav class="cl-effect-1">
									<ul class="nav navbar-nav ">
										<li><a class="hvr-overline-from-center active" href="index.html">Home</a></li>
										<li><a class="hvr-overline-from-center" href="about.html">About</a></li>
										<li><a class="hvr-overline-from-center" href="gallery.html">Properties</a></li>
										<li><a class="hvr-overline-from-center" href="services.html">Services</a></li>
										<li><a class="hvr-overline-from-center" href="codes.html">Short Codes</a></li>
										<li><a class="hvr-overline-from-center" href="contact.html">Contact</a></li>
									</ul>
								</nav>
						</nav>
	</div>
</div>
-->

<!-- //navigation -->
<!-- make -->
<div class="make wthree all_pad">
	<div class="container">
		<h2 class="title">附近学校<span>更多》</span></h2>
		<div class="make-grids">
			<div class="col-md-4 make-grid-one wow bounceInUp school-item" data-wow-duration="1.5s" data-wow-delay="0s">
				<div class="make-left">
					<div class="item item-type-double">
						<!--
						<div class="item-hover">
							<div class="item-info">
								<div class="date">Real Site</div>			
								<div class="line"></div>			
								<div class="headline">Doloremque laudantium</div>
								<div class="line"></div>
							</div>
							<div class="mask"></div>
							
						</div>
						-->
						<div class="item-img"><img class="img-responsive" src="images/hndx.jpg" alt=" " /></div>
					</div>
				</div>
			</div>
			<div class="col-md-4 make-grid-two wow bounceInUp school-item" data-wow-duration="1.5s" data-wow-delay="0.1s">
				<div class="make-left">
					<div class="item item-type-double">
						<!--
						<div class="item-hover">
							<div class="item-info">
								<div class="date">Real Site</div>			
								<div class="line"></div>			
								<div class="headline">Doloremque laudantium</div>
								<div class="line"></div>
							</div>
							<div class="mask"></div>
							
						</div>
						-->
						<div class="item-img"><img class="img-responsive" src="images/zndx.jpg" alt=" " /></div>
					</div>
				</div>
			</div>
			<div class="col-md-4 make-grid-two  wow bounceInUp school-item" data-wow-duration="1.5s" data-wow-delay="0.2s">
				<div class="make-left">
					<div class="item item-type-double">
						<!--
						<div class="item-hover">
							<div class="item-info">
								<div class="date">Real Site</div>			
								<div class="line"></div>			
								<div class="headline">Doloremque laudantium</div>
								<div class="line"></div>
							</div>
							<div class="mask"></div>
							
						</div>
						-->
						<div class="item-img"><img class="img-responsive" src="images/hnsf.jpg" alt=" " /></div>
					</div>
				</div>
			</div>
			<div class="col-md-4 make-grid-two make-top wow bounceInUp school-item" data-wow-duration="1.5s" data-wow-delay="0.3s">
				<div class="make-left">
					<div class="item item-type-double">
						<!--
						<div class="item-hover">
							<div class="item-info">
								<div class="date">Real Site</div>			
								<div class="line"></div>			
								<div class="headline">Doloremque laudantium</div>
								<div class="line"></div>
							</div>
							<div class="mask"></div>
							
						</div>
						-->
						<div class="item-img"><img class="img-responsive" src="images/xtdx.jpg" alt=" " /></div>
					</div>
				</div>
			</div>
			<div class="col-md-4 make-grid-two make-top wow bounceInUp school-item" data-wow-duration="1.5s" data-wow-delay="0.4s">
				<div class="make-left">
					<div class="item item-type-double">
						<!--
						<div class="item-hover">
							<div class="item-info">
								<div class="date">Real Site</div>			
								<div class="line"></div>			
								<div class="headline">Doloremque laudantium</div>
								<div class="line"></div>
							</div>
							<div class="mask"></div>
							
						</div>
						-->
						<div class="item-img"><img class="img-responsive" src="images/nhdx.jpg" alt=" " /></div>
					</div>
				</div>
			</div>
			<div class="col-md-4 make-grid-two make-top wow bounceInUp school-item" data-wow-duration="1.5s" data-wow-delay="0.4s">
				<div class="make-left">
					<div class="item item-type-double">
						<!--
						<div class="item-hover">
							<div class="item-info">
								<div class="date">Real Site</div>			
								<div class="line"></div>			
								<div class="headline">Doloremque laudantium</div>
								<div class="line"></div>
							</div>
							<div class="mask"></div>
						</div>
						-->
						<div class="item-img"><img class="img-responsive" src="images/hnly.jpg" alt=" " /></div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- //make -->

<!-- differencials -->
<div class="different agileits all_pad">
	<div class="container">
		<h3 class="title">热门专业<span>更多》</span></h3>
		<div class="diff-grids">
			<div class="col-md-4 diff-grid diff-one bor-bot wow bounceInDown major-itemitem" data-wow-duration="1.5s" data-wow-delay="0.1s">
				<div class="port-1 effect-3">
                	<div class="image-box">
                    	<img class="img-responsive" src="images/zhuanye1.jpg" alt="Image-3">
                    </div>
                    <div class="text-desc">
                    	<h4>临床医学</h4>
                        <p>据阳光高考平台数据显示，临床医学专业的就业率在80%至85%之间.</p>
                    </div>
                </div>
			</div>
	
			<div class="col-md-4 diff-grid diff-one bor-bot  wow bounceInDown major-itemitem" data-wow-duration="1.5s" data-wow-delay="0.3s">
				<div class="port-1 effect-3">
                	<div class="image-box">
                    	<img class="img-responsive" src="images/zhuanye2.jpg" alt="Image-3">
                    </div>
                    <div class="text-desc">
                    	<h4>计算机</h4>
                        <p>据教育部就业指导中心统计数据显示，近几年计算机科学与技术专业的就业率区间在86%至90%之间.</p>
                    </div>
                </div>
			</div>

			<div class="col-md-4 diff-grid diff-one bor-bot  wow bounceInDown major-itemitem" data-wow-duration="1.5s" data-wow-delay="0.3s">
				<div class="port-1 effect-3">
                	<div class="image-box">
                    	<img class="img-responsive" src="images/zhuanye3.jpg" alt="Image-3">
                    </div>
                    <div class="text-desc">
                    	<h4>土木工程</h4>
                        <p>随着城市建设的提速和公路建设的不断增加，土木工程专业的就业形势持续走高.</p>
                    </div>
                </div>
			</div>
						<div class="col-md-4 diff-grid diff-one bor-bot  wow bounceInDown major-itemitem" data-wow-duration="1.5s" data-wow-delay="0.3s">
				<div class="port-1 effect-3">
                	<div class="image-box">
                    	<img class="img-responsive" src="images/zhuanye4.jpg" alt="Image-3">
                    </div>
                    <div class="text-desc">
                    	<h4>会计专业</h4>
                        <p>会计学专业本科毕业生规模为10万人以上，就业率在85%-90%之间。男女比例：男生25%;女生75%.</p>
                    </div>
                </div>
			</div>
						<div class="col-md-4 diff-grid diff-one bor-bot  wow bounceInDown major-itemitem" data-wow-duration="1.5s" data-wow-delay="0.3s">
				<div class="port-1 effect-3">
                	<div class="image-box">
                    	<img class="img-responsive" src="images/zhuanye5.jpg" alt="Image-3">
                    </div>
                    <div class="text-desc">
                    	<h4>财务管理</h4>
                        <p>全国普通高校财务管理专业 毕业生规模为60000-65000人，近几年全国就业率区间为85%-90%.</p>
                    </div>
                </div>
			</div>
						<div class="col-md-4 diff-grid diff-one bor-bot  wow bounceInDown major-itemitem" data-wow-duration="1.5s" data-wow-delay="0.3s">
				<div class="port-1 effect-3">
                	<div class="image-box">
                    	<img class="img-responsive" src="images/zhuanye6.jpg" alt="Image-3">
                    </div>
                    <div class="text-desc">
                    	<h4>国际经济与贸易</h4>
                        <p>国际经济与贸易专业的毕业生规模为8.5万至9万人，近几年全国就业率区间为85%至90%，属于就业率较高的专业.</p>
                    </div>
                </div>
			</div>
		
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- differencials -->


<!-- map -->
<!--
<div class="map">
	<iframe src="" style="border:0"></iframe>
</div>
-->
<!-- //map -->
<div class="footer w3agile wow bounceInDown" data-wow-duration="1.5s" data-wow-delay="0s">
	<div class="container">
		<!-- <div class="foo-arr text-center"><img src="images/arrows.png" alt=" "/></div> -->
		<div class="col-md-4 footer-left">
			<i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i><p>湖南长沙市长沙经济技术开发区天华南路1号<span></span></p>
		</div>
		<div class="col-md-4 footer-left">
			<i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><p><a href="mailto:support@iychua.com">support@iychua.com</a><span><a href=""></a></span></p>
		</div>
		<div class="col-md-4 footer-left">
			<i class="glyphicon glyphicon-earphone" aria-hidden="true"></i><p>0731-84162633<span></span></p>
		</div>
		<div class="clearfix"></div>
		<div class="copyrights w3">
			<div class="copy">
				<p>油菜花网络版权所有©2018</p>
			</div>
			<!--
			<div class="copy-right agileinfo">
				<ul class="fb_icons">
					<li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
					<li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
					<li class="hvr-rectangle-out"><a class="goog" href="#"></a></li>
					<li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
					<li class="hvr-rectangle-out"><a class="drib" href="#"></a></li>
				</ul>
			</div>
			-->
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- //footer -->
<!-- smooth scrolling -->
	<script type="text/javascript">
	var host="${host}";
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
		
		//退出
		function exit(){
			$.ajax({
	  			type:"post",
	  			url:host+"/user/logout.do",
	  			success:function(data){
	  				location.href="/front/";
	  			},
	  			error:function(){alert("退出失败");}
			});
		}
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
</body>
</html>