<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/taglib.jsp" %>
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
  	.layui-tab i:hover{cursor:pointer;}
  </style>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">油菜花网络后台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left" id="top_nav_view">
    
     
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
 <div class="layui-side layui-bg-black" id="side-nav">
    
 </div>
 
 <div class="layui-body" id="main">
    <!-- 内容主体区域 -->
    
    <div style="padding: 15px;" id="search_box">
      
      <form class="layui-form" action="">
      	
					  <div class="layui-form-item">
					    <label class="layui-form-label">过滤</label>
					    <div class="layui-input-inline">
				      <select name="quiz1">
				        <option value="">请选择省</option>
				        <option value="湖南省" selected="">湖南省</option>
				        
				      </select>
				    </div>
				    <div class="layui-input-inline">
				      <select name="quiz2">
				        <option value="">请选择市</option>
				        <option value="长沙">长沙</option>
				        <option value="常德">常德</option>
				        <option value="岳阳">岳阳</option>
				        <option value="株洲">株洲</option>
				        <option value="湘潭">湘潭</option>
				      </select>
				    </div>
				    <div class="layui-input-inline">
				      <select name="quiz3">
				        <option value="">请选择县/区</option>
				        <option value="长沙县">长沙县</option>
				        <option value="开福区">开福区</option>
				        <option value="芙蓉区">芙蓉区</option>
				      </select>
				    </div>
			      <div class="layui-input-inline">
				      <input name="search_key"  placeholder="请输入" autocomplete="off" class="layui-input" type="text">
				    </div>
				    <div class="layui-input-inline">
				      <button class="layui-btn" lay-submit="" lay-filter="demo1">查找</button>
				      
				    </div>
			    
			    
			  </div>
		  
		  </form>
      
      
    </div>
    
    <div style="padding: 0 15px;" id="school_list">
      
      
    </div>
		 
		<div style="width:80%;position:fixed;bottom:30px;;">
			<div id="page" style="text-align:center;"></div>
		</div>
		
  </div>
   <div class="layui-body" id="detail" style="display:none;">
     	
   	  <div class="layui-tab">
   	  	<i class="layui-icon" style="cursor:pointer;z-index: 100;position: relative;font-size: 20px; color: #1E9FFF;float:left;margin:0 50px 0 20px;z-index:100;">&#xe65c;返回</i>
			  <ul class="layui-tab-title" >
			    <li class="layui-this">学校注册信息</li>
			    <li>学校主页</li>
			    <li>招生简章</li>

			  </ul>
			  <div class="layui-tab-content">
			    <div class="layui-tab-item layui-show">
			    	<div class="layui-form">
			        <div class="layui-form-item">
						    <label class="layui-form-label">学校名称:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="湖南大学" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">学校地址:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="湖南长沙" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">办学许可证:</label>
						    <div class="layui-input-block">
						      <img src="images/school_cert.jpg" style="height:100px;">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">法人姓名:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="张三" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">法人身份证:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="431111111111111" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">法人电话:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="13882821234" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">管理员帐号:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="13882822897" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">管理员姓名:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="李四" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">管理员电话:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="13882822897" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						</div>
						
			    </div>
			    <div class="layui-tab-item">学校主页</div>
			    <div class="layui-tab-item">招生简章</div>

			  </div>
      </div>
   </div>
  <div class="layui-footer footer">
    <!-- 底部固定区域 -->
    © www.iychua.com - 湖南油菜花网络科技有限公司
  </div>
</body>

</html>
<script src="${basePath}admin/layui.js?t=1515376178709" charset="utf-8"></script>
<script src="${basePath}admin/app.js?t=1515376178709" charset="utf-8"></script>
<script>
	cur_mod="学校管理";
	var basePath ="${basePath}" ;
	app.init(function($){
		 
    	$.get("http://localhost:8080/kzych/university/list.do",function(schoollist){
    		   var ele = '';
    		   app.laypage.render({
					    elem: 'page'
					    ,limit:10
					    ,count: schoollist.data.total //数据总数
					    ,jump: function(obj){
					      console.log(obj)
					    }
					  });
					 var list = schoollist.data.list;
    		   for(var i in list){
    		   	   ele += '<div style="width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;" schoolid="' + list[i].id + '"> ';
    		   	   ele += '<img src="' + list[i].profile + '" style="width:160px;height:120px;float:left;"/>';
		         	 ele += '<lable style="float:left;">' + list[i].name + '</lable></div>';
		         
    		   }
    		   $("#school_list").append(ele);
    		   $("#school_list div").on("click",function(){
    		       $("#main").hide();
    		       $("#detail").show();
    		   });
    		   
    		   $(".layui-tab i").on("click",function(){
    		   	   $("#main").show();
    		       $("#detail").hide();
    		   });
    		   
    	});
	});
	
</script>