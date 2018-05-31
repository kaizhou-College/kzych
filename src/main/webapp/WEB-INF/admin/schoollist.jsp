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
  	.layui-tab i:hover{cursor:pointer;}
  </style>
  <script src="${basePath}admin/layui.js?t=1515376178709" charset="utf-8"></script>
  <script src="${basePath}admin/app.js?t=1515376178709" charset="utf-8"></script>
  <script src="${basePath}admin/lay/modules/jquery.js"></script>
  <link rel="stylesheet"  href="${basePath}admin/css/layui.css" />
  <script type="text/javascript" src="${basePath}admin/data.js"></script>
  <script type="text/javascript" src="${basePath}admin/province.js"></script>
  <script type="text/javascript">
	var defaults = {
		s1 : 'provid',
		s2 : 'cityid',
		s3 : 'areaid',
		v1 : null,
		v2 : null,
		v3 : null
	};
  </script>
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
      <li class="layui-nav-item"><a href="javascript:exit();" >退了</a></li>
    </ul>
  </div>
 <div class="layui-side layui-bg-black" id="side-nav">
    
 </div>
 
 <div class="layui-body" id="main">
    <!-- 内容主体区域 -->
    
    <div style="padding: 15px;" id="search_box">
      
   			 <form class="layui-form"  method="get">
					<input type="hidden" value="2" name="publishStatus">
					<div class="layui-form-item">
						<label class="layui-form-label">选择地区</label>
						<div class="layui-input-inline">
							<select name="provid" id="provid" lay-filter="provid">
								<option value="1">请选择省</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="cityid" id="cityid" lay-filter="cityid">
								<option value="2">请选择市</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select class="layui-select" name="areaid" id="areaid"
								lay-filter="areaid">
								<option value="3">请选择县/区</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<input name="search_key" placeholder="请输入" autocomplete="off"
								class="layui-input" type="text" id="search_key">
						</div>
						<div class="layui-input-inline">
							<button class="layui-btn" lay-submit lay-filter="formDemo"id="but_submit">查找</button>

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
						      <input type="text" name="" value="湖南大学" id="school_Name" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">学校地址:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="湖南长沙" id="school_Address" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">办学许可证:</label>
						    <div class="layui-input-block">
						      <img src="images/school_cert.jpg" id="school_License" style="height:100px;">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">法人姓名:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="张三" id="legal_person_Name" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">法人身份证:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="431111111111111" id="legal_person_Card" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">法人电话:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="13882821234" autocomplete="off" id="legal_person_Phone" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">管理员帐号:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="13882822897" id="administrator_Account" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">管理员姓名:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="李四" id="administrator_Name" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">管理员电话:</label>
						    <div class="layui-input-block">
						      <input type="text" name="" value="13882822897" id="administrator_Phone" autocomplete="off" disabled class="layui-input">
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
<script>
	var username ="${currentUser.username}";
	cur_mod="学校管理";
	var basePath ="${basePath}" ;
	var host_kzych="${host}";
	app.init(function($){
		 
		layui.use('form', function(){
			  var form = layui.form;
			  
			  //监听提交  (省份筛选)
			  form.on('submit(formDemo)', function(data){
				  $.ajax({
			  			type:"post",
			  			url:host_kzych+"/university/dimListPage.do",
			  			data:{"provid":$("#provid").val(),
			  					"cityid":$("#cityid").val(),
			  					"areaid":$("#areaid").val(),
			  					"search_key":$("#search_key").val()},
			  			success:function(data){
			  				//数据返回时
			  				$("#school_list").empty();
			  				var ele = '';
			  				app.laypage.render({
								elem : 'page',
								limit : data.pageSize,
								count : data.total//数据总数
								,
								jump : function(obj, first) {//点跳转触发
									if (!first) {
										layer.msg('第'
												+ obj.curr
												+ '页');
										var currentPage = obj.curr;//获取点击的页码 
										var limit = obj.limit;
										//window.location.href ="http://localhost:8080/kzych/university?page="+currentPage;
										$.ajax({
								  			type:"post",
								  			url:host_kzych+"university/dimListPage.do",
								  			data:{"provid":$("#provid").val(),
								  					"cityid":$("#cityid").val(),
								  					"areaid":$("#areaid").val(),
								  					"search_key":$("#search_key").val(),
								  					"pageNum":currentPage,
								  					"pageSize":limit
								  					},
								  			success:function(schoollist){
								  				var ele = '';
												var list = schoollist.list;

												//清空
												$(
														"#school_list")
														.empty();
												for ( var i in list) {
													   ele += "<div style='width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;' schoolid='" + list[i].id + "'> ";
								        		   	   ele += "<img  onmouseup='showScoolInfo("+JSON.stringify(list[i])+")' src='https://kzych.oss-cn-qingdao.aliyuncs.com/" + list[i].profile + "' style='width:160px;height:120px;float:left;'/>";
								    		           ele += "<lable style='float:left;'>" + list[i].name + "</lable></div>";

												}
												//加载
												$("#school_list").append(ele);
												$("#school_list div").on("click",function(){
				                  		       		  $("#main").hide();
				                  		      		  $("#detail").show();
				                  		      	   });
				                  		   
				                  		   		  $(".layui-tab i").on("click",function(){
				                  		   	 		  $("#main").show();
				                  		     		  $("#detail").hide();
				                  		   		  });
								  			}
								  					
									 });
									}
								}
							});
			  				var list = data.list;
			  				$("#school_list").empty();
							for ( var i in list) {
								   ele += "<div style='width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;' schoolid='" + list[i].id + "'> ";
			        		   	   ele += "<img  onmouseup='showScoolInfo("+JSON.stringify(list[i])+")' src='https://kzych.oss-cn-qingdao.aliyuncs.com/" + list[i].profile + "' style='width:160px;height:120px;float:left;'/>";
			    		           ele += "<lable style='float:left;'>" + list[i].name + "</lable></div>";
							}
							//加载
							$("#school_list").append(ele);
			  				$("#school_list div").on("click",
			  						function() {
			  							$("#main").hide();
			  							$("#detail").show();
			  						});

			  				$(".layui-tab i").on("click", function() {
			  					$("#main").show();
			  					$("#detail").hide();
			  				});
			  			},
						});
				    return false;
			});
		});
		
		
    	$.get(host_kzych+"university/schoolList.do",function(schoollist){
    		   var ele = '';
    		   function loadData(list){
    			   //清空
    			   $("#school_list").empty();
    			   for(var i in list){
    				   ele += "<div style='width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;' schoolid='" + list[i].id + "'> ";
        		   	   ele += "<img  onmouseup='showScoolInfo("+JSON.stringify(list[i])+")' src='https://kzych.oss-cn-qingdao.aliyuncs.com/" + list[i].profile + "' style='width:160px;height:120px;float:left;'/>";
    		           ele += "<lable style='float:left;'>" + list[i].name + "</lable></div>";
        		   	/*    ele += '<div style="width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;" schoolid="' + list[i].id + '"> ';
        		   	   ele += '<img  onmouseup="showScoolInfo('+JSON.stringify(list[i])+')" src="' + list[i].profile + '" style="width:160px;height:120px;float:left;"/>';
    		           ele += '<lable style="float:left;">' + list[i].name + '</lable></div>'; */
    		         
        		   }
    			   //加载
        		   $("#school_list").append(ele); 
    		   }
    		   app.laypage.render({
					    elem: 'page'
					    ,limit:schoollist.data.pageSize
						,count: schoollist.data.total//数据总数
					    ,jump: function(obj,first){
					      //console.log(obj);
					      /* if(first!=true){//是否首次进入页面  
                              var currentPage = obj.curr;//获取点击的页码 
                              
                              window.location.href ="http://localhost:8080/kzych/university/schoolList.do?pageNum="+currentPage;  
                          }   */
                          //console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                          //console.log(obj.limit); //得到每页显示的条数
                          if(!first){
					    	 layer.msg('第'+ obj.curr +'页');
					    	 var currentPage = obj.curr;//获取点击的页码 
					    	 var limit = obj.limit;
                             //window.location.href ="http://localhost:8080/kzych/university?page="+currentPage;
                             $.get(host_kzych+"/university/schoolList.do?pageNum="+currentPage+"&pageSize="+limit,function(schoollist){
                            	 var ele = '';
                            	 var list = schoollist.data.list;
                            	
                            	 //清空
                  			   $("#school_list").empty();
                  			   for(var i in list){
                  				 ele += "<div style='width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;' schoolid='" + list[i].id + "'> ";
                  		   	  	 ele += "<img  onmouseup='showScoolInfo("+JSON.stringify(list[i])+")' src='https://kzych.oss-cn-qingdao.aliyuncs.com/" + list[i].profile + "' style='width:160px;height:120px;float:left;'/>";
              		           	 ele += "<lable style='float:left;'>" + list[i].name + "</lable></div>";
                  		         
                      		   }
                  			   //加载
                      		 	  $("#school_list").append(ele); 
                  			   //显示单个数据
                      		   	  $("#school_list div").on("click",function(){
                  		       		  $("#main").hide();
                  		      		  $("#detail").show();
                  		      	   });
                  		   
                  		   		  $(".layui-tab i").on("click",function(){
                  		   	 		  $("#main").show();
                  		     		  $("#detail").hide();
                  		   		  });
                  		    
                  		    
                             });
                          }
					    }
					  });
			   var list = schoollist.data.list;
			   loadData(list);
    		  /*  for(var i in list){
    		   	   ele += '<div style="width:160px;margin:0 10px 20px 10px;float:left;cursor:pointer;" schoolid="' + list[i].id + '"> ';
    		   	   ele += '<img src="' + list[i].profile + '" style="width:160px;height:120px;float:left;"/>';
		         	 ele += '<lable style="float:left;">' + list[i].name + '</lable></div>';
		         
    		   }
    		   $("#school_list").append(ele); */
    		 //单击图片显示单个信息  隐藏其他学校图片
    		   $("#school_list div").on("click",function(){
    		       $("#main").hide();
    		       $("#detail").show();
    		   });
    		 //单击返回隐藏单个学校学校 显示其他学校图片
    		   $(".layui-tab i").on("click",function(){
    		   	   $("#main").show();
    		       $("#detail").hide();
    		   });
    		   
    		   
    	});
	});
	//给学校信息赋值
	function showScoolInfo(list){
		$("#school_Name").val(list.name);
		$("#school_Address").val(list.address);
		$("#school_License").attr("src","https://kzych.oss-cn-qingdao.aliyuncs.com/"+list.schoolLicense);
		$("#legal_person_Name").val(list.legalPersonName);
		$("#legal_person_Card").val(list.legalPersonCard);
		$("#legal_person_Phone").val(list.legalPersonPhone);
		$("#administrator_Account").val(list.administratorAccount);
		$("#administrator_Name").val(list.administratorName);
		$("#administrator_Phone").val(list.administratorPhone);
	}
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