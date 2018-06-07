<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>招生管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  
  <link rel="stylesheet" href="${basePath}admin/css/layui.css?t=1515376178709"  media="all">
  <link rel="stylesheet" href="${basePath}admin/css/global.css?t=1515376178709"  media="all">
  <link rel="stylesheet" href="${basePath}admin/css/simditor.css?t=1515376178709"  media="all">
  
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
	          <img src="${currentUser.userAvatar }" class="layui-nav-img">
           	  ${currentUser.username }
	        </a>
	        
	      </li>
	      <li class="layui-nav-item quit"><a href="javascript:void(0);">退出</a></li>
	    </ul>
	  </div>
	  
		 <div class="layui-side layui-bg-black" id="side-nav">
		    
		 </div>
 
 
		 <div class="layui-body" id="main">
		    <!-- 内容主体区域 -->
		    
		   	  <div class="layui-tab" lay-filter="recruit-tab" style="margin-left:20px;">
		   	  	
					  <ul class="layui-tab-title" >
					  
					  	<li class="layui-this">报名管理</li>
					   
					    
	
					  </ul>
					  <div class="layui-tab-content">
							  
							 
							  
							  
							  
							   <!--报名管理begin -->
							   <div class="layui-tab-item layui-show"  style="padding: 0px 20px 0 0;box-sizing: border-box;">
							  	
							  	<form class="layui-form" action="" style="    background: #fafafa;padding: 10px 0;">
							  		<div class="layui-form-item">
							  			<div class="layui-inline">
									      <label class="layui-form-label">报名状态</label>
									      <div class="layui-input-inline">
									          <select name="modules" lay-verify="required" lay-search="">
											          <option value="">全部</option>
											          <option value="1">未交学费</option>
											          <option value="2">已交学费</option>
											          <option value="3">已办入学</option>
											      </select>
									      </div>
									    </div>
									    <div class="layui-inline">
									      <label class="layui-form-label">报名ID</label>
									      <div class="layui-input-inline">
									        <input name="number" lay-verify="required|number" autocomplete="off" class="layui-input" type="text">
									      </div>
									    </div>
									    <div class="layui-inline">
									      <label class="layui-form-label">学员姓名</label>
									      <div class="layui-input-inline">
									        <input name="date" id="name" autocomplete="off" class="layui-input" type="text">
									      </div>
									    </div>
									    <div class="layui-inline">
									      <label class="layui-form-label">专业</label>
									      <div class="layui-input-inline">
									        <select name="modules" lay-verify="required" lay-search="">
											          <option value="">全部</option>
											          <option value="1">会计</option>
											          <option value="2">工商管理</option>
											          <option value="3">软件工程</option>
											    </select>
									      </div>
									    </div>
									    <div class="layui-inline">
									      <label class="layui-form-label"></label>
									      <div class="layui-input-inline">
									         <button class="layui-btn" lay-submit="">查找</button>
									      </div>
									    </div>
									  </div>
							    </form>
									
									<div  style="margin:30px 0 0 0;width:100%;">
								 			  
												<table class="layui-table" lay-data="{ height:300, url:'${basePath}/admin/testdata/enroll_list.json',page:true}"  id="enroll_list" lay-filter="enroll">
											  <thead>
											    <tr>
											    
											      <th lay-data="{field:'orderid', width:'10%'}">报名ID </th>
											      <th lay-data="{field:'name', width:'15%'}">姓名</th>
											      <th lay-data="{field:'tel', width:'15%'}">电话</th>
											      <th lay-data="{field:'level', width:'10%'}">学位等级</th>
											      <th lay-data="{field:'majar', width:'10%', sort: true}">专业</th>
											      <th lay-data="{field:'status', width:'10%', sort: true, fixed: false}">状态</th>
											    	<th lay-data="{field:'tuition', width:'10%', sort: false, fixed: false}">学费</th>
											    	
											    	
											    
											      
											      <th lay-data="{fixed: 'right', width:'20.2%', align:'center', toolbar: '#barEnroll'}"></th>
											    </tr>
											  </thead>
											</table>
											 
											<script type="text/html" id="barEnroll"">
											  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
											  <a class="layui-btn layui-btn-xs" lay-event="enroll">交费/入学</a>
											  
											</script>
											
								  </div>
									 <!--报名管理end -->
							</div>
					  </div>
				 </div>
				 
		 </div>
		  <div class="layui-body" id="detail-page" style="display:none;">
		  	 <div class="" style="margin:20px;">
		   	  	<div style="height:40px;width:100%;background:#fafafa;margin:10px 0;">
					  <i class="layui-icon back" style="cursor:pointer;z-index: 100;position: relative;font-size: 20px; color: #1E9FFF;float:left;margin:0 50px 0 20px;z-index:100;">&#xe65c;返回</i>
					 </div>
				
					  	 <div class="layui-form">
					    		<div class="layui-form-item">
								    <label class="layui-form-label">报名ID:</label>
								    <div class="layui-input-block">
								      <input type="text" name="" value="1001" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">姓名:</label>
								    <div class="layui-input-block">
								      <input type="text" name="name" value="张小二" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  <div class="layui-form-item">
								    <label class="layui-form-label">电话:</label>
								    <div class="layui-input-block">
								      <input type="text" name="tel" value="13938380101" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">学位等级:</label>
								    <div class="layui-input-block">
								      <input type="text" name="level" value="大专" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">专业:</label>
								    <div class="layui-input-block">
								      <input type="text" name="majar" value="会计" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">报名状态:</label>
								    <div class="layui-input-block">
								      <input type="text" name="status" value="未交费" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">学费:</label>
								    <div class="layui-input-block">
								      <input type="text" name="tuition" value="5000元" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								   <div class="layui-form-item">
								    <label class="layui-form-label">毕业学校:</label>
								    <div class="layui-input-block">
								      <input type="text" name="school" value="新化县第三中学" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">家庭住址:</label>
								    <div class="layui-input-block">
								      <input type="text" name="add" value="新化县上梅镇接龙村" autocomplete="off" disabled="disabled" class="layui-input">
								    </div>
								  </div>
								  
									
								  
							</div>
		
		
				 </div>
		  </div>
   	  <div class="layui-body" id="pay-detail-page" style="display:none;">
		  	 <div class="" style="margin:20px;">
				   	  <div style="height:40px;width:100%;background:#fafafa;margin:10px 0;">
							  <i class="layui-icon pay-back" style="cursor:pointer;z-index: 100;position: relative;font-size: 20px; color: #1E9FFF;float:left;margin:0 50px 0 20px;z-index:100;">&#xe65c;返回</i>
							</div>
					
					  	 <div class="layui-form" style="margin:20px;">
					  	 	
					  	  	<div class="layui-form-item">
							    <label class="layui-form-label">支付方式</label>
							    <div class="layui-input-block">
							      <input name="paymode" value="1" title="支付宝"  type="radio">
							      <input name="paymode" value="2" title="微信" type="radio">
							      
							    </div>
							  </div>
								  
							</div>
		          <div style="width:300px;height:400px;padding:50px;box-sizing:border-box;text-align:center;">
		          	<label class="" style="display:inline-block;width;100%;text-align:center;">学费:5000元</label>
		          	<img src="/admin/images/qrcode.png" style="width:160px;text-align:center;"></img>
		          	<div style="display:inline-block;width;100%;text-align:center;">支付宝支付</div>
		          </div>
		
				 </div>
		  </div>
   <div class="layui-footer footer">
    <!-- 底部固定区域 -->
    © www.iychua.com - 湖南油菜花网络科技有限公司
   </div>
  </div>
</body>

</html>
<script src="${basePath}admin/layui.js?t=1515376178709" charset="utf-8"></script>
<script src="${basePath}admin/app.js?t=1515376178709" charset="utf-8"></script>
<script type="text/javascript" src="${basePath}admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}admin/js/module.min.js"></script>

<script type="text/javascript" src="${basePath}admin/js/hotkeys.min.js"></script>
<script type="text/javascript" src="${basePath}admin/js/uploader.min.js"></script>
<script type="text/javascript" src="${basePath}admin/js/simditor.js"></script>
<script>
	cur_mod="招生";
	var username ="${currentUser.username}";
	var basePath = "${basePath}";
	var host_kzych="${host}";
	app.init(function($){
		     toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough',
            'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|',
            'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'
        ];
        
       
      ///////////表 
        $(".back").on("click",function(){
        	
        	  $("#main").show();
        	  $("#detail-page").hide();
        });
        
        $(".pay-back").on("click",function(){
        	
        	  $("#main").show();
        	  $("#pay-detail-page").hide();
        });
        
        //监听工具条
			  app.table.on('tool(enroll)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			      $("#main").hide();
        	  $("#detail-page").show();
			    }else if(obj.event === 'enroll'){
			        $("#main").hide();
        	  $("#pay-detail-page").show();
			    }
			  }); 
			  
			   
		 //测试代码
	});
	
</script>