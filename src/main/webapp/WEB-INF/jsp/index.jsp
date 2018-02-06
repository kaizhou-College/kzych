<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../common/comm.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<title>油菜花</title>
		<link href="${basePath}/static/fonts/iconfont.css" rel="stylesheet"/>
		<link href="${basePath}/static/css/bass.css" rel="stylesheet"/>
		<link href="${basePath}/static/css/index.css" rel="stylesheet"/>
	</head>
	<body>

		<div id="index-z">
			<div class="index-head" style="background-image: url('${basePath}/static/images/timg.jpg')">
				<div class="hmap" id="gomap"><span class="icon-uniE902"></span>长沙</div>
				<div class="head-input-row head-search">
					<input id="search" type="search" placeholder="学校、专业、工作、单位" >
						<span class=" head-icon-left icon-uniE90F"></span>
						<span class=" head-icon-right icon-uniE939"></span>
				</div>
			</div>
			<div class="index-nav">
				<ul>
				<li>
					<a href="${basePath}/university/list.do">
						<img src="${basePath}/static/images/bmrx.png" />
						<p>报名入学</p>
					</a>
				</li>
				<li>
					<a href="search.html">
						<img src="${basePath}/static/images/zwts.png" />
						<p>自我提升</p>
					</a>
				</li>
				<li>
					<a href="search.html">
						<img src="${basePath}/static/images/shsj.png" />
						<p>社会实践</p>
					</a>
				</li>
				<li>
					<a href="yhq.html">
						<img src="${basePath}/static/images/xzgz.png" />
						<p>寻找工作</p>
					</a>
				</li>
			</ul>
			</div>
			<div class="index-choice">
				<div class="choice-header">
					<p><span class="choice-sx">&nbsp;|&nbsp;</span><span class="choice-zt">热门专业</span><span class="choice-fh">&gt;</span></p>
				</div>
				<hr class="choice-x"/>
				<div class="index-option">
					<ul class="option">
						<li><a href="#">软件开发</a></li>
						<li><a href="#">通信工程</a></li>
						<li><a href="#">外贸英语</a></li>
						<li><a href="#">会计</a></li>
						<li><a href="#">法学</a></li>
						<li><a href="#">土木工程</a></li>
						<li><a href="#">会计学</a></li>
						<li><a href="#">新闻学</a></li>
					</ul>
				</div>
			</div>
			<div class="index-choice">
				<div class="choice-header">
					<p><span class="choice-sx">&nbsp;|&nbsp;</span><span class="choice-zt">学校</span><span class="choice-fh">&gt;</span></p>
				</div>
				<hr class="choice-x"/>
				<div class="index-option">
					<ul>
						<li><a href="#">湖南大学</a></li>
						<li><a href="#">中南大学</a></li>
						<li><a href="#">复旦大学</a></li>
						<li><a href="#">武汉大学</a></li>
						<li><a href="#">深圳大学</a></li>
						<li><a href="#">中山大学</a></li>
						<li><a href="#">厦门大学</a></li>
						<li id="option-br"><a href="#">东南大学</a></li>
					</ul>
				</div>
			</div>
			<div class="index-choice">
				<div class="choice-header">
					<p><span class="choice-sx">&nbsp;|&nbsp;</span><span class="choice-zt">工作</span><span class="choice-fh">&gt;</span></p>
				</div>
				<hr class="choice-x"/>
				<div class="index-option">
					<ul>
						<li><a href="#">java工程师</a></li>
						<li><a href="#">java实习生</a></li>
						<li><a href="#">C++工程师</a></li>
						<li><a href="#">Python开发</a></li>
					</ul>
				</div>
				<div style="height: 5rem;"></div>
			</div>
		</div>
		<nav class="nav-bar nav-bar-tab">
	    			<a class="nav-tab-item nav-active">
	        			<span class="nav-icon icon-uniE90A"></span>
	       				<span class="nav-tab-label">首页</span>
	    			</a>
	    			<a href="chatrecord.html" class="nav-tab-item">
	        			<span class="nav-icon icon-uniE903"></span>
	        			<span class="nav-tab-label">资讯</span>
	    			</a>
	     			<a href="userPu.html" class="nav-tab-item">
	        			<span class="nav-icon icon-uniE90B"></span>
	        			<span class="nav-tab-label">我的</span>
	   			</a>
		</nav>
	</body>
	<!-- 引入js资源 -->
	<script type="text/javascript" src="js/zepto.min.js"></script>
  	<script type="text/javascript" src="js/zepto.kslider.js"></script>
</html>