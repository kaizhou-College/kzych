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
  
  <link rel="stylesheet" href="${basePath}admin/css/layui.css?t=1515376178709"  media="all">
  <link rel="stylesheet" href="${basePath}admin/css/global.css?t=1515376178709"  media="all">
  <style>
  	  .layui-upload-img{height:150px;width:auto;margin: 0 10px 10px 0;
}
  </style>
  <script src="${basePath}admin/layui.js?t=1515376178709" charset="utf-8"></script>
  <script src="${basePath}admin/app.js?t=1515376178709" charset="utf-8"></script>
  <script id="top_nav" type="text/html">
    	
  </script>
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
      <li class="layui-nav-item"><a href="javascript:exit();">退出</a></li>
    </ul>
  </div>
  
   <div class="layui-side layui-bg-black" id="side-nav">
    
   </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;" id="start-img-box">
      
      
      <fieldset class="layui-elem-field layui-field-title">
         <legend>开机画面(720X1280)</legend>
      </fieldset>
      <br><br>
			<div class="layui-upload">
			  <button type="button" class="layui-btn" id="start-img">上传图片</button>
			  <div class="layui-upload-list">
			    <img class="layui-upload-img" id="start-img-view" >
			    <p id="errText1"></p>
			  </div>
			</div>  
      <button type="button" class="layui-btn" id="btu_01">保存</button>
      
    </div>
        <div style="padding: 15px;" id="carousel-figure-box">
      
     
      <fieldset class="layui-elem-field layui-field-title">
         <legend> 轮播图(960X480)</legend>
      </fieldset>
      <br><br>
			<div class="layui-upload">
			  <button type="button" class="layui-btn" id="carousel-figure">上传图片</button>
			  <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
         预览图：
        <div class="layui-upload-list" id="carousel-figure-view"></div>
      </blockquote>
			</div>  
      <button type="button" class="layui-btn" id="btu_02">保存</button>
      
    </div>
  </div>
  
  <div class="layui-footer footer">
    <!-- 底部固定区域 -->
    © www.iychua.com - 湖南油菜花网络科技有限公司
  </div>
</div>
<script>
	
	
//JavaScript代码区域
var username ="${currentUser.username}";
var cur_mod="系统管理";
var basePath ="${basePath}" ;
var host_kzych="${host}";
app.init(function($){
	  //上传开机画面
  var uploadInst = app.upload.render({
    elem: '#start-img'
    ,url: '/university/save.do'
    ,auto: false //选择文件后不自动上传
    ,bindAction: '#btu_01' //指向一个按钮触发上传
    ,field: 'upload_file'
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#start-img-view').attr('src', result); //图片链接（base64）
      });
    }
    ,done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      //上传成功
    }
    ,error: function(){
      //演示失败状态，并实现重传
      var errText1 = $('#errText1');
      errText1.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
      errText1.find('.demo-reload').on('click', function(){
        uploadInst.upload();
      });
    }
  });
  
  
  //上传轮播图
  app.upload.render({
    elem: '#carousel-figure'
    ,url: '/university/save.do'
    ,auto: false //选择文件后不自动上传
    ,bindAction: '#btu_02' //指向一个按钮触发上传
    ,field: 'upload_file'
    ,multiple: true
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#carousel-figure-view').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
      });
    }
    ,done: function(res){
      //上传完毕
    }
  });
  
	
});

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