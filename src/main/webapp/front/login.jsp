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
 <link rel="stylesheet" href="css/layui.css?t=1515376178709"  media="all">
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

<style>
	body{height:100%;}
	input{color:#323a45;}
	.layui-input-block{margin-left:95px;}
	
  #login-box{
	    width: 25rem;
			height: 25rem;
			padding: 3rem 3rem 1rem 0;
			border: 1px solid #eee;
			margin: auto;
			top: 100px;
			position: relative;
			background: #fff;
			border-radius: 10px;
  }
  .login-title{text-align:center;color:#EA675C;}
  #login-box form{margin-top:20px;}
</style>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
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
			
		$(".more-item").on("click",function(event){
			
			   $(".C-global-cheggheader-rightsection-usermenu .nav-item .carrot").toggle();
			   $(".C-global-cheggheader-rightsection-usermenu .nav-item .hover-box").toggle();
			   event.stopPropagation();
			   return false;
		});
		
		$("body").on("click",function(){
				 $(".C-global-cheggheader-rightsection-usermenu .nav-item .carrot").hide();
			   $(".C-global-cheggheader-rightsection-usermenu .nav-item .hover-box").hide();		   
		});
		
		
		
		$(window).scroll(function () {
        //$(window).scrollTop()这个方法是当前滚动条滚动的距离
        //$(window).height()获取当前窗体的高度
        //$(document).height()获取当前文档的高度
        console.log($(window).scrollTop());
        if($(window).scrollTop() > 10){
        	$(".chgg-hdr").removeClass("translucent");
        	  $(".chgg-hdr").addClass("easeIn");
        }
        else{
        	  $(".chgg-hdr").removeClass("easeIn");
        	  $(".chgg-hdr").addClass("translucent");
        }
        
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
			       
			        
			        <a class="chgg-logo home track-home" href="/front" aria-label="">油菜花网络</a>
			
			        
			        <div class="chgg-hdr-navigation ">
			            <div class="nav-items home ">
			                    <div class="nav-item has-hover-box books-item">
			                            <a class="nav-item-header link-books" href="/front" aria-expanded="false"  tabindex="0">
			                            首页
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        
			                    </div>
			                    <div class="nav-item has-hover-box study-item">
			                            <a class="nav-item-header link-study" href="http://www.iychua.com" aria-expanded="false" aria-label="" tabindex="0">
			                            学校
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                        
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
			                    
			                    <div class="nav-item has-hover-box internships-item">
			                        <a class="nav-item-header link-internships" href="/front" aria-expanded="false" aria-label="" tabindex="0">
			                            社会实践
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                       
			                    </div>
			                    <div class="nav-item has-hover-box scholarships-item">
			                        <a class="nav-item-header link-scholarships" href="/front" aria-expanded="false" aria-label="" tabindex="0">
			                            找工作
			                            <div class="nav-item-caret icon-chegg-chevron"></div>
			                        </a>
			                       
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
			                			<a href="login.html" class="signin-item nav-item track-signin">登录</a>
			                			<div class="more-item nav-item">
			                				<div class="header" role="button" tabindex="0" aria-label="More Menu, has sub menu" aria-expanded="false">更多 <span class="icon-chegg-chevron"></span></div>
			                				<div class="carrot">
			                					<div class="carrot-inner"></div>
			                				</div>
			                				<div class="more-hover-content hover-box">
			                					<ul>
			                						<li><a href="" class="track-help" data-noajax="" aria-label="Help">帮助</a></li>
			                						<li><a href="" class="track-signup" aria-label="Create an account">注册</a></li>
			                						<li><a href="" class="track-signin hide-initially" aria-label="Sign in">登录</a></li>
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
	<!--login start -->
	<div class="banner-info ">
		
			<div ID="login-box">
				   <h3 class="login-title">用户登录</h3>
				   <form action="" onsubmit="return testLogin();" id="form">
				   	  
				   	<div class="layui-form-item">
					    <label class="layui-form-label">帐号:</label>
					    <div class="layui-input-block">
					      <input name="username" id="username" lay-verify="required" placeholder="用户名／手机" autocomplete="off" class="layui-input" type="text">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">密码:</label>
					    <div class="layui-input-block">
					      <input name="password" id="password" lay-verify="required" placeholder="" autocomplete="off" class="layui-input" type="password">
					    </div>
					  </div>
					  <div class="layui-form-item" pane="">
					    <label class="layui-form-label"></label>
					    <div class="layui-input-block">
					      <input name="remember" lay-skin="primary" title="记住我" checked="" type="checkbox">记住我
					     
					    </div>
					  </div>
					  
					  <div class="layui-form-item">
					   
					    
					    <button class="layui-btn layui-btn-fluid" style="margin-left: 1.5rem;" >登录</button>
					  </div>
					   
				   </form>
				   <div style="width:100%;padding-left:1.5rem;box-sizing: border-box;"><a href="javascript:void(0);" style="float:left;color:#5097e8">忘记密码</a><span style="float:right;margin-right: -1.5rem;">还没有帐号？<a href="javascript:void(0);" style="color:#5097e8;">马上注册</a></span></div>
		       
		  </div>
				   	  
  </div>
  
  <!--login end -->
	
	
</div>

<div class="footer w3agile wow " >
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
			<div class="clearfix" ></div>
		</div>
	</div>
</div>
<!-- //footer -->
<!-- smooth scrolling -->


<button onmousedown="isNOtAdministrator()">123122312</button>
</body>
</html>

<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="layui.js?t=1515376178709" charset="utf-8"></script>
	<script type="text/javascript">
		var host_kzych = "${host}";
		$(document).ready(function() {
		
			layui.use(['form','layedit'], function(){
	     var form = layui.form
	     ,layer = layui.layer
	     ,layedit = layui.layedit
	     
	   });
		});
		
		//本代码只是用于测试
		function testLogin(){
			 
			  if(form.username.value ==  ''){
			     alert("请输入用户名");	
			     return false;
			  }
			  
			  if(form.password.value ==  ''){
			     alert("请输入用户密码");	
			     return false;
			  }
			  //异步请求 看该用户是否管理员
			 $.ajax({
				    type:"post",
		  			url:host_kzych+"/user/login.do",
		  			data:{"username":$("#username").val(),"password":$("#password").val()},
		  			success:function(data){
		  				if(data.status==0){
		  					 /* //管理员
				  			  if(data.data.userType == 1){
				  			  	   setCookie("token",data.data.username,"d1");
				  			  }
				  			   //普通用户
				  			  else{*/
				  			  	   setCookie("token",data.data.username,"d1");
				  			 /* }*/
				  			//location.href = "/front/index.jsp";
				  			location.href = host_kzych+"/front/index.jsp";
		  				}else{
		  					layer.msg('密码或者账号错误');
		  				}
		  			},
		  			error:function(){
		  				alert("请求失败！！！.3.3");
		  			}
			  });
			  return false;
		}
		
		function setCookie(name,value,time)
		{
		var strsec = getsec(time);
		var exp = new Date();
		exp.setTime(exp.getTime() + strsec*1);
		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/;";
		
	
		}
		
		function getsec(str)
		{
			
			var str1=str.substring(1,str.length)*1;
			var str2=str.substring(0,1);
			if (str2=="s")
			{
			return str1*1000;
			}
			else if (str2=="h")
			{
			return str1*60*60*1000;
			}
			else if (str2=="d")
			{
			return str1*24*60*60*1000;
			}
    }
	</script>