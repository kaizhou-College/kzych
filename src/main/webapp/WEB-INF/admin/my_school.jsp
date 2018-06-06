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
	          <img src="https://kzych.oss-cn-qingdao.aliyuncs.com/${currentUser.userAvatar }" class="layui-nav-img">
          	  ${currentUser.username }
	        </a>
	        
	      </li>
	      <li class="layui-nav-item quit"><a onclick="exit()">退出</a></li>
	    </ul>
	  </div>
	  
		 <div class="layui-side layui-bg-black" id="side-nav">
		    
		 </div>
 
 
		 <div class="layui-body" id="main">
		    <!-- 内容主体区域 -->
		    
		   	  <div class="layui-tab" lay-filter="recruit-tab" style="margin-left:20px;">
		   	  	
					  <ul class="layui-tab-title" id="default_01">
					  
					  	
					    <li class="layui-this">招生电话</li>
					    <li class="">招生简章</li>
					    <li class="">通知公告</li>
					    <li class="">专业设置</li>

					  </ul>
					  <div class="layui-tab-content">
							  <!--招生电话 start -->
							  <div class="layui-tab-item layui-show" style="padding: 20px 20px 0 0;box-sizing: border-box;">
							  	
							  	 <div class="layui-form" style="padding: 30px 0;background: #fafafa;">
							    		
										  
										  <div class="layui-inline">
								      <label class="layui-form-label">招生电话</label>
								      <div class="layui-input-inline">
								        <input type="text" name="telephone" id="telephone" value="13764871235" autocomplete="off" class="layui-input">
								      </div>
								    </div>
								    <div class="layui-inline" style="margin-left:50px;">
								      <!--只有选择学校才显示-->
								     
								      <div class="layui-input-inline">
								        <button id="save" class="layui-btn updateByTelephone" lay-submit="" >保存</button>
								      </div>
								    </div>
									</div>
									
									
									
									
							  </div>
							  <!--招生电话 end -->
							  
							  <!--招生简章 start -->
				       <div class="layui-tab-item layui-show"  style="padding: 0px 20px 0 0;box-sizing: border-box;">
							  	
							  	
									
									<div  style="margin:30px 0 0 0;width:100%;">
								 			  <span style="float:right;"><button id="add-regulations" class="layui-btn"><i class="layui-icon" style="font-size: 20px; ">&#xe654;</i>增加</button></span>
												<hr class="layui-bg-green">
												<table class="layui-table" lay-data="{ height:300, url:'${basePath}/recruit/selectByUniversityId.do?universityId=${schoolInfo.id}'}" id="table2" lay-filter="regulations">
											  <thead>
											    <tr>
											    
											    	<th lay-data="{field:'datetime', width:'20%', sort: false, fixed: false}">发布时间</th>
											      
											      <th lay-data="{field:'name', width:'50%'}">标题</th>
											      <th lay-data="{fixed: 'right', width:'30%', align:'center', toolbar: '#regulations'}"></th>
											    </tr>
											  </thead>
											</table>
											 
											<script type="text/html" id="regulations">
											  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
											  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
											  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
											</script>
											
								  </div>
									
									
							  </div>
							  
							  <!--招生简章 end -->
							  
							  <!--通知公告 start -->
							   <div class="layui-tab-item layui-show"  style="padding: 0px 20px 0 0;box-sizing: border-box;">
							  	
							  	
									
									<div  style="margin:30px 0 0 0;width:100%;">
								 			  <span style="float:right;"><button id="add-notice" class="layui-btn "><i class="layui-icon " style="font-size: 20px; ">&#xe654;</i>增加</button></span>
												<hr class="layui-bg-green">
												<table class="layui-table" lay-data="{ height:300, url:'${basePath}/recruit/selectByUniversityId.do?universityId=${schoolInfo.id}'}" id="table3" lay-filter="notice">
											  <thead>
											    <tr>
											    
											    	<th lay-data="{field:'datetime', width:'20%', sort: false, fixed: false}">发布时间</th>
											      
											      <th lay-data="{field:'name', width:'50%'}">标题</th>
											      <th lay-data="{fixed: 'right', width:'30%', align:'center', toolbar: '#barNotice'}"></th>
											    </tr>
											  </thead>
											</table>
											 
											<script type="text/html" id="barNotice">
											  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
											  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
											  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
											</script>
											
								  </div>
									
									
							  </div>
							  <!--通知公告 end -->
							  
							  
							   <!--专业设置begin -->
							   <div class="layui-tab-item layui-show"  style="padding: 0px 20px 0 0;box-sizing: border-box;">
									
									<div  style="margin:30px 0 0 0;width:100%;">
								 			  <span style="float:right;"><button id="add-school-majar" class="layui-btn"><i class="layui-icon" style="font-size: 20px; ">&#xe654;</i>增加</button></span>
												<hr class="layui-bg-green">
												<table class="layui-table" lay-data="{ height:300, url:'${basePath}/university/mySchoolMajorInfo.do?universityId=${schoolInfo.id}'}" id="table4" lay-filter="majar">
											  <thead>
											    <tr>
											    
											      <th lay-data="{field:'level', width:'15%'}">学位层次 </th>
											    	<th lay-data="{field:'name', width:'40%', sort: false, fixed: false}">专业名称</th>
											    
											      <th lay-data="{field:'tuition', width:'15%'}">学费</th>
											      
											      <th lay-data="{fixed: 'right', width:'30%', align:'center', toolbar: '#barMajar'}"></th>
											    </tr>
											  </thead>
											</table>
											 
											<script type="text/html" id="barMajar">
											  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
											  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
											  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
											</script>
											
								  </div>
									 <!--专业设置end -->
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
								    <label class="layui-form-label">名称:</label>
								    <div class="layui-input-block">
								      <input type="text" name="" id="rsTitle" value="13764871235" autocomplete="off"  class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">内容:</label>
								    <div class="layui-input-block">
								       <textarea id="detail" ></textarea>
								    </div>
								  </div>
								  
									<div class="layui-form-item" style="text-align:center;">
								    <button id="majar-save" class="layui-btn" lay-submit="" >保存</button>
						        
								  </div>
								  
							</div>
		
		
				 </div>
		  </div>
   	  <div class="layui-body" id="majar-detail-page" style="display:none;">
		  	 <div class="" style="margin:20px;">
		   	  	
					  <div style="height:40px;width:100%;background:#fafafa;margin:10px 0;">
					  <i class="layui-icon majar-back" style="cursor:pointer;z-index: 100;position: relative;font-size: 20px; color: #1E9FFF;float:left;margin:0 50px 0 20px;z-index:100;">&#xe65c;返回</i>
					 </div>
					
					  	 <div class="layui-form" style="margin:20px;">
					  	 	
					  	  	<div class="layui-form-item">
								    <label class="layui-form-label">学位层次:</label>
								    <div class="layui-input-block">
								      <select name="interest" lay-filter="aihao">
							        <option value=""></option>
							        <option value="0" selected="">无</option>
							        <option value="1" selected="">中专</option>
							        <option value="2" >大专</option>
							        <option value="3">本科</option>
							        <option value="4">硕士</option>
							        <option value="5">博士</option>
							      </select>
								    </div>
								  </div>
					    		<div class="layui-form-item">
								    <label class="layui-form-label">专业名称:</label>
								    <div class="layui-input-block">
								      <input type="text" name="" value="会计" autocomplete="off"  class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">学费:</label>
								    <div class="layui-input-block">
								      <input type="text" name="" value="" autocomplete="off"  class="layui-input">
								    </div>
								  </div>
								  
								  <div class="layui-form-item">
								    <label class="layui-form-label">专业描述:</label>
								    <div class="layui-input-block">
								       <textarea id="majar-detail" ></textarea>
								    </div>
								  </div>
								  
									<div class="layui-form-item" style="text-align:center;">
								    <button id="save" class="layui-btn" lay-submit="" >保存</button>
						        
								  </div>
								  
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
	//用户名称
	var username ="${currentUser.username}";
	var host_kzych="${host}";
	var basePath = "${basePath}";
	app.init(function($){
		
		     $(".layui-tab-item").removeClass("layui-show");
		     $(".layui-tab-item:first").addClass("layui-show");
		     //$(".layui-tab:first").click();
		     toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough',
            'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|',
            'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'
        ];
        
        editor = new Simditor({ //文本编辑框初始化
            textarea: $('#detail'),
            placeholder: '',
            toolbar: toolbar, //工具栏
            upload: {
                url: '', //文件上传的接口地址
                params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey: 'Filedata', //服务器端获取文件数据的参数名
                connectionCount: 1,
                leaveConfirm: '正在上传文件'
            }
        });
        
        
        var editor1 = new Simditor({ //文本编辑框初始化
            textarea: $('#majar-detail'),
            placeholder: '',
            toolbar: toolbar, //工具栏
            upload: {
                url: '', //文件上传的接口地址
                params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey: 'Filedata', //服务器端获取文件数据的参数名
                connectionCount: 1,
                leaveConfirm: '正在上传文件'
            }
        });
        
        $("#add-regulations").on("click",function(){
        	    $("#main").hide();
        	    $("#detail-page").show();
        });
        
         $("#add-notice").on("click",function(){
        	    $("#main").hide();
        	    $("#detail-page").show();
        });
        
        $("#add-school-majar").on("click",function(){
        	  $("#main").hide();
        	  $("#majar-detail-page").show();
        });
        
        $(".back").on("click",function(){
        	  $("#main").show();
        	  $("#detail-page").hide();
        });
        
        $(".majar-back").on("click",function(){
        	  $("#main").show();
        	  $("#majar-detail-page").hide();
        });
        
        //监听工具条
			  app.table.on('tool(regulations)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			      layer.msg('ID：'+ data.id + ' 的查看操作');
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        obj.del();
			        layer.close(index);
			        delRS(data.id); //删除的函数
			      });
			    } else if(obj.event === 'edit'){
			      layer.alert('编辑行：<br>'+ JSON.stringify(data))
			    }
			  }); 
			  
			   app.table.on('tool(notice)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			      layer.msg('ID：'+ data.id + ' 的查看操作');
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        obj.del();
			        layer.close(index);
			        delRS(data.id); //删除的函数
			      });
			    } else if(obj.event === 'edit'){
			      layer.alert('编辑行：<br>'+ JSON.stringify(data))
			    }
			  }); 
			  
			   app.table.on('tool(majar)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			      layer.msg('ID：'+ data.id + ' 的查看操作');
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        obj.del();
			        layer.close(index);
			      });
			    } else if(obj.event === 'edit'){
			      layer.alert('编辑行：<br>'+ JSON.stringify(data))
			    }
			  });
		 //测试代码
		 
		 //放入页面值   --招生电话
		 if("${schoolInfo}"!=null){
			 //招生电话
			 $("#telephone").val("${schoolInfo.telephone}");
		 }
		
		
		//点击保存修改招生电话
		$(".updateByTelephone").on("click",function(id){
			var phone=/^1[3|4|5|8][0-9]\d{4,8}$/; //移动电话的标准格式 11位
		  	if(phone.test($("#telephone").val())){
				$.get(host_kzych+"/university/UpdateTelephone."+
						"do?id=${schoolInfo.id}&telephone="+$("#"+
						"telephone").val(),function(data){
  					if(data.substring(0,2)=="成功"){
  						shotMsg("保存成功");
  					}else{
  						shotMsg("保存失败");
  					}
  				});
		  	}else{
		  		shotMsg("亲请输入正确的手机号");
		  	}
		})
	
		//招生簡章的添加
		$("#majar-save").on("click",function(){
			$.ajax({
	  			type:"post",
	  			url:host_kzych+"/recruit/addRS.do",
	  			data:{"rsTitle":$("#rsTitle").val(),"rsContent":$("#detail").val(),"universityId":"${schoolInfo.id}"},  
	  			success:function(data){
	  				if(data.substring(0,4)=="添加成功"){
	  					shotMsg("添加成功");
	  					location.reload();//页面刷新
	  				}else{
	  					shotMsg("添加失败，请重新添加");
	  				}
	  			},
	  			error:function(){
	  				location.reload();
	  			}
			});	
		});
		
	});
	
	
	//退出
	function exit(){
		alert(1);
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
	function delRS(del_id){
		$.get(host_kzych+"/recruit/delRS.do?rsId="+del_id,
			  function(data){
			shotMsg(data);
		});
	}
	
</script>