<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>油菜花网络</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <!-- <link rel="stylesheet" href="css/layui.css?t=1515376178709"  media="all">
  <link rel="stylesheet" href="css/global.css?t=1515376178709"  media="all"> -->
  <link rel="stylesheet" href="${basePath}/admin/css/layui.css"  media="all">
  <link rel="stylesheet" href="${basePath}/admin/css/global.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">油菜花网络后台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left " id="top_nav_view" >

      
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="${currentUser.userAvatar }" class="layui-nav-img">
          ${currentUser.username }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="javascript:exit();">退了</a></li>
    </ul>
  </div>
  
     
    <div class="layui-side layui-bg-black" id="side-nav">
    
   </div>
 
  <!--
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <!--
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">应用管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:app.loadTopNav();">开机画面</a></dd>
            <dd><a href="javascript:;">主页轮播图</a></dd>
      
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">首页内容推荐</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">学校推荐</a></dd>
            <dd><a href="javascript:;">热门专业</a></dd>
            <dd><a href="">文章视频</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
         	<a href="javascript:;">优惠活动</a>
         </li>
         <li class="layui-nav-item">
         	<a href="javascript:;">事件通知</a>
         </li>

      </ul>
    </div>
    
  </div>
  -->
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
      
      
      <br><br>
      <blockquote class="layui-elem-quote">
        欢迎您进入油菜花网络的后台，您在这里的每一个操作，都将对系统及运营产生很大的影响，请谨慎操作。
        
      </blockquote>
      
      
    </div>
  </div>
  
  <div class="layui-footer footer">
    <!-- 底部固定区域 -->
    © www.iychua.com - 湖南油菜花网络科技有限公司
  </div>
</div>
<script src="${basePath}admin/layui.js?t=1515376178709" charset="utf-8"></script>
<script src="${basePath}admin/app.js?t=1515376178709" charset="utf-8"></script>
<script>
//JavaScript代码区域
	var cur_mod="系统管理";
	app.init();
	/*1.在js中使用el表达式必须先用变了接收，让后在js文件中才可以用 ，不能直接在js文件中使用
	  2.el表达式必须使用加""或者''才可以使用
	*/
	var basePath = "${basePath}";
	var host_kzych="${host}";
	//退出
	function exit(){
		$.ajax({
				type:"get",
				url:host_kzych+"/user/logout.do",
				success:function(data){
	  				location.href=host_kzych+"/front/index.do";
	  			},
	  			error:function(){
	  				location.reload();
	  			}
		});
	}
	//弹  未满足的条件
	function shotMsg(string){
		layui.use(['layer', 'form'], function(){
  	 	 	var layer = layui.layer
  	  		,form = layui.form;
  	  		layer.msg(string);
  		});
	}
</script>

</body>
</html>