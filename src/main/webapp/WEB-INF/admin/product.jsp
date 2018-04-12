<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>产品与服务</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  
  <link rel="stylesheet" href="${basePath}admin/css/layui.css?t=1515376178709"  media="all">
  <link rel="stylesheet" href="${basePath}admin/css/global.css?t=1515376178709"  media="all">
  <link href="${basePath}admin/css/simditor.css" rel="stylesheet">
  <style>
  	.layui-tab i:hover{cursor:pointer;}
  	.service-status{width:100%;text-align:center;height: 38px;line-height: 38px;padding: 0 18px;box-sizing: border-box;}
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
        <a href="javascript:void();">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          ${currentUser.username}
        </a>
        <!--
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
        -->
      </li>
      <li class="layui-nav-item quit"><a href="javascript:exit();">退出</a></li>
    </ul>
  </div>
  
 <div class="layui-side layui-bg-black" id="side-nav">
    
 </div>
 
 
 <div class="layui-body" id="main">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
	     
	     <blockquote class="layui-elem-quote">
	      油菜花网络平台致力于解决学生择校难但学校招生难、学生就业难但企业招人难、学校人才培养与企业用人需求不匹配的矛盾。
	      <br><br>要解决这些矛盾，需要您的共同参与。
	     </blockquote>
	     
			<div class="layui-row" style="margin-top:40px;">
			    <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="padding:16px 50px;box-sizing: border-box;background:#6fa028;color:#FFF;">
			      <div style="width:100%;text-align:center;margin: 20px 0;"><img src="${basePath}admin/images/zhaosheng.png" style="width:64px;"></img></div>
			      <div class="" style="height:200px;text-align:center;">
			      	 <h1 style='margin:10px 0;'>学校招生</h1>
			      	 <h3>帮助大中专院校解决招生难的问题，极大的增加学校的潜在生源并大幅降低招生成本。</h3>
			      </div>
			      <div class="service-status zhaosheng_service_status${currentUser.uuid}" style="" zhaosheng_service_status${currentUser.uuid}="0"><button class="layui-btn open-zhaosheng-service" style="width:120px;">开通</button></div>
			      <div class="service-status zhaosheng_service_status${currentUser.uuid}" style="display:none;" zhaosheng_service_status${currentUser.uuid}="1">等待审核中...</div>
			      <div class="service-status zhaosheng_service_status${currentUser.uuid}" style="display:none;" zhaosheng_service_status${currentUser.uuid}="2">已开通</div>
			      <div class="service-status zhaosheng_service_status${currentUser.uuid}" style="display:none;" zhaosheng_service_status${currentUser.uuid}="3">审核未通过<button class="layui-btn open-zhaosheng-service" style="width:120px;">查看原因&gt;&gt;</button></div>
			    </div>
			    
			    <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="padding:16px 50px;box-sizing: border-box;background:#3e8624;color:#FFF;">
			      <div style="width:100%;text-align:center;margin: 20px 0;"><img src="${basePath}admin/images/zhaopin.png" style="width:64px;"></img></div>
			      <div class="" style="height:200px;text-align:center;">
			      	 <h1 style='margin:10px 0;'>企业招聘</h1>
			      	 <h3>帮助企业精准找到它所需要的人才，降低企业在招聘上的时间成本、人力成本以及由于招聘不当而引起的人才使用成本。</h3>
			      </div>
			      <div class="service-status recruit_service_status${currentUser.uuid}" style="" recruit_service_status${currentUser.uuid}="0"><button  class="layui-btn open-recruit-service" style="width:120px;">开通</button></div>
			      <div class="service-status recruit_service_status${currentUser.uuid}" style="display:none;" recruit_service_status${currentUser.uuid}="1">等待审核中...</div>
			      <div class="service-status recruit_service_status${currentUser.uuid}" style="display:none;" recruit_service_status${currentUser.uuid}="2">已开通</div>
			      <div class="service-status recruit_service_status${currentUser.uuid}" style="display:none;" recruit_service_status${currentUser.uuid}="3">审核未通过<button  class="layui-btn open-recruit-service" style="width:120px;">查看原因&gt;&gt;</button></div>
			    </div>
			    
			    <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="padding:16px 50px;box-sizing: border-box;background:#206b0a;color:#FFF;">
			      <div style="width:100%;text-align:center;margin: 20px 0;"><img src="${basePath}admin/images/youcaihua.png" style="width:64px;"></img></div>
			      <div class="" style="height:200px;text-align:center;">
			      	 <h1 style='margin:10px 0;'>油菜园</h1>
			      	 <h3>通过图文或视频的形式贡献您的知识和智慧，让学子们更快更好的成长成为社会所需要的人才。</h3>
			      </div>
			      <div class="service-status ycy_service_status${currentUser.uuid}" style="" ycy_service_status${currentUser.uuid}="0"><button  class="layui-btn open-ycy-service" style="width:120px;">开通</button></div>
			      <div class="service-status ycy_service_status${currentUser.uuid}" style="display:none;" ycy_service_status${currentUser.uuid}="1">等待审核中...</div>
			      <div class="service-status ycy_service_status${currentUser.uuid}" style="display:none;" ycy_service_status${currentUser.uuid}="2">已开通</div>
			      <div class="service-status ycy_service_status${currentUser.uuid}" style="display:none;" ycy_service_status${currentUser.uuid}="3">审核未通过<button  class="layui-btn open-ycy-service" style="width:120px;">查看原因&gt;&gt;</button></div>
			    </div>
	     </div>
    </div>
   	  
 </div>
  <div class="layui-body" style = "display:none;" id="school_auth">
  	 
	  	  <div style="margin-bottom:15px;background:#eee;height:50px;line-height:50px;">
	  	      <i class="layui-icon back" style="cursor:pointer;z-index: 100;position: relative;font-size: 20px; color: #1E9FFF;float:left;margin:0 50px 0 20px;z-index:100;">&#xe65c;返回</i>
	  	      <h3 style="width:100%;text-align:center;">机构信息</h3>
	  	  </div>
	  	  
		   <div style="padding: 0 15px 15px 15px;">
		   	  <blockquote class="layui-elem-quote error-cause" style="color:#ff0000;display:none;">
		        <p>末通过原因：</p>
		        <p  id="checkedInfo">1.办学许可证验证失败。2.法人代表不正确。</p>
		      </blockquote>
	  	    <div class="layui-form">
			    		<div class="layui-form-item">
						    <label class="layui-form-label">机构名称:</label>
						    <div class="layui-input-block">
						      <input id="name_p" type="text" name="" value="请输入学校名称" autocomplete="off"  class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <div class="layui-inline">
						      <label class="layui-form-label">机构类型</label>
						      <div class="layui-input-inline">
						        <select id="universityType_p" name="interest" lay-filter="aihao">
							        <option value="0"></option>
							        <option value="1" >学校</option>
							        <option value="2" >企业</option>
							        <option value="3">事业单位</option>
							        <option value="4">政府机关</option>
							        <option value="5">社会团体</option>
							      </select>
						      </div>
						    </div>
						    <div class="layui-inline">
						      <!--只有选择学校才显示-->
						      <label class="layui-form-label">机构性质:</label>
						      <div class="layui-input-inline">
						        <select id="universityNature_p" name="interest" lay-filter="aihao">
							        <option value="0"></option>
							        <option value="1">公办</option>
							        <option value="2" >民办</option>
							        
							      </select>
						      </div>
						    </div>
						    <div class="layui-inline">
						      <!--只有选择学校类型才显示-->
						      <label class="layui-form-label">学校等级:</label>
						      <div class="layui-input-inline">
						        <select id="categoryid_p" name="interest">
							        <option value="0"></option>
							    </select>
						      </div>
						    </div>
						  </div>
			        
               <div class="layui-form-item">
						    <label class="layui-form-label">机构地址:</label>
						    <div class="layui-input-block">
						      <input id="address_p" type="text" name="" value="请输入学校地址" autocomplete="off"  class="layui-input">
						    </div>
						  </div>
						  
						   <div class="layui-form-item">
              	   <div class="layui-inline">
									    <label class="layui-form-label">机构封面图:</label>
									    <div class="layui-input-block">
									     
											  <div class="layui-upload">
												  <button type="button" class="layui-btn" id="start-img2">上传图片</button>
												  <div class="layui-upload-list">
												    <img class="layui-upload-img" id="start-img-view2" style="height:100px;">
												    <p id="errText2"></p>
												  </div>
												</div> 	
												<input type="hidden" name="schoolCoverimg" id="schoolCoverimg" value="">							   
										 </div>
							     </div>
							     
							     <div class="layui-inline">
							      	
							      	 <label class="layui-form-label">办学许可证/营业执照:</label>
									    <div class="layui-input-block">
									     
											  <div class="layui-upload">
												  <button type="button" class="layui-btn" id="start-img3">上传图片</button>
												  <div class="layui-upload-list">
												    <img class="layui-upload-img" id="start-img-view3" style="height:100px;">
												    <p id="errText3"></p>
												  </div>
												</div>
												<input type="hidden" name="schoolLicense" id="schoolLicense" value="">
									    </div>
							     </div>
							</div>
						  
						  
              
							
							<div class="layui-form-item">
						    <div class="layui-inline">
						      <label class="layui-form-label">法人姓名</label>
						      <div class="layui-input-inline">
						        <input id="legalPersonName_p" type="text" name="" value="请输入法人姓名" autocomplete="off"  class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <!--只有选择学校才显示-->
						      <label class="layui-form-label">法人身份证:</label>
						      <div class="layui-input-inline">
						        <input id="legalPersonCard_p" type="text" name="" value="请输入法人身份证" autocomplete="off"  class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <!--只有选择学校类型才显示-->
						      <label class="layui-form-label">法人电话:</label>
						      <div class="layui-input-inline">
						        <input id="legalPersonPhone_p" type="text" name="" value="请输入法人电话" autocomplete="off"  class="layui-input">
						      </div>
						    </div>
						  </div>
						  
						  
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">机构简介:</label>
						    <div class="layui-input-block">
						       <textarea id="detail" >请输入机构简历</textarea>
						    </div>
						  </div>
						  
						
						<hr class="layui-bg-green">

									  
				    <div class="layui-form-item" style="text-align:center;">
					    <button id="school-auth-ok" class="layui-btn" lay-submit="" lay-filter="demo2">申请开通</button>
			        
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

//用户名称
var username ="${currentUser.username}";
//用户的id（用于开通）
var uuid="${currentUser.uuid}";
	
//该用户不通过的原因
var checkedInfo="初始值";
//该用户的状态（PublicStatus）
var status="${publicStatus}";
var host="${host}";
var basePath = "${basePath}";
var userLIst="${User_list}";
	cur_mod="个人中心";
	//测试代码
	function init_page($){
		//判断该用户是否开通过学校
		//如果开通过但没有通过的话  那还是需要把你本来填写的值给放进去的
		alert(userLIst+"-="+userLIst.id);
		
		//页面已加载时就需要查询该用户有没有开通学校的原因（通过用户id查询学校）
		$.ajax({
  			type:"get",
  			url:host+"/university/schoolByUserIdList.do",
  			data:{"userId":uuid},
  			success:function(data){
  				checkedInfo=data;
  				$("#checkedInfo").html(checkedInfo);//放入未通过原因
  			},
  			error:function(){
  				alert("请求失败");
  			}		
		});
		
		//通过ajax来给学校等级（下拉框加上值）
		$.ajax({
  			type:"get",
  			url:host+"/university/categoryList.do",
  			success:function(data){
  				var html_category=$("#category_id");
  				for(var i=0;i<data.length;i++){
  					$("#categoryid_p").append("<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>");
  				}
  				//由于这个jsp是先加载页面然后再渲染接着才开始追加$("#category_id") 里面的<optiin> 所以需要重新渲染一次
  				  layui.use(['layer', 'form'], function(){
  				  var layer = layui.layer
  				    ,form = layui.form;
  					form.render('select');
  				});
  			},
  			error:function(){
  				alert("请求失败");
  			}		
		});
		var a=getCookie("zhaosheng_service_status"+uuid);
		  var zhaosheng_service_status = getCookie("zhaosheng_service_status"+uuid); //
		  var recruit_service_status = getCookie("recruit_service_status"+uuid);
		  var ycy_service_status = getCookie("ycy_service_status"+uuid);
		//判断该用户有没有开通过学校（status==0表示没有开通）1:开通中 2 开通通过 3开通失败
		if(status=="0"){
			zhaosheng_service_status = 0;
		}else if(status=="1"){
			zhaosheng_service_status=1;
		}else if(status=="2"){
			zhaosheng_service_status=2;
		}else if(status=="3"){
			zhaosheng_service_status=3;
		}
		 //招生
		  if(zhaosheng_service_status == null&&checkedInfo=="初始值"){
		  	 zhaosheng_service_status = 0;
		  }
		  if(zhaosheng_service_status == 3 ){ 
			  $(".error-cause").show();//显示末通过原因
		  } 
		  //招骋
		  if(typeof(recruit_service_status) == 'undefined' || recruit_service_status == null ){
		  	 recruit_service_status = 0;
		  }
		  //油菜园
		  if(ycy_service_status == null ){
		  	 ycy_service_status = 0;
		  }
		//设置按钮的隐藏和显示（开通状态那些按钮）
		$(".zhaosheng_service_status"+uuid+"").hide();
		$("[zhaosheng_service_status"+uuid+"='" + zhaosheng_service_status + "']").show();
		$(".recruit_service_status").hide();
		$("[recruit_service_status"+uuid+"='" + recruit_service_status + "']").show();
		$(".ycy_service_status").hide();
		$("[ycy_service_status"+uuid+"='" + ycy_service_status + "']").show();
		}
		  
	app.init(function($){
	  
	  init_page($);//测试代码
		$(".open-zhaosheng-service").on("click",function(){
		   $("#main").hide();
		   $("#school_auth").show();
		   
		});
		
		$(".open-recruit-service").on("click",function(){
			   setCookie("recruit_service_status"+uuid,"2","d1"); //这是测试代码，正试逻辑要删除。状态：0表示没有开通，1表示开通中，2表示已开通，3表示被拒决
			   location.reload();
		});
		
		$(".open-ycy-service").on("click",function(){
			   setCookie("ycy_service_status"+uuid,"2","d1"); //这是测试代码，正试逻辑要删除。状态：0表示没有开通，1表示开通中，2表示已开通，3表示被拒决
			   location.reload();
		});
		
		$(".back").on("click",function(){
			 $(".layui-body").hide();
			 $("#main").show();
		    	
		});
		
		$("#school-auth-ok").on("click",function(){
			  // 通过ajax提交
			  
			  
    		var isNotPass=0;
			
			//验证  机构信息	
			//机构名称
			if($("#name_p").val().trim().length>0&&$("#name_p").val()!="请输入学校名称"){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请输入学校名称");
    		}
			//机构类型
			if($("#universityType_p").val()>0){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请选择机构类型");
    		}
			//机构性质
			if($("#universityNature_p").val()>0){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请选择机构性质");
    		}
			//学校等级
			if($("#categoryid_p").val()>0){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请选择学校等级");
    		}
			//机构地址
			if($("#address_p").val().trim().length>0&&$("#address_p").val()!="请输入学校地址"){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请输入机构地址");
    		}
			//封面图片 $("#schoolCoverimg")
			if($("#schoolCoverimg").val().trim().length>0){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请上传封面图片");
    		}
			//办学许可证  $("#schoolLicense")
			if($("#schoolLicense").val().trim().length>0){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请上传办学许可证");
    		}
			//法人姓名 $("#legalPersonName_p").val()
			if($("#legalPersonName_p").val().trim().length>0&&$("#legalPersonName_p").val()!="请输入法人姓名"){
				isNotPass=isNotPass+1
    		}else{
    			alert("亲请输入法人姓名");
    		}
			//法人身份证$("#legalPersonCard_p").val()
  		 	var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; //15位的身份证
  		  	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X|x)$/;//18位  身份证的正则表达式
			  	if(isIDCard2.test($("#legalPersonCard_p").val())||isIDCard1.test($("#default_1"))){
			  		isNotPass=isNotPass+1;
			  	}else{
				  	alert("亲请输入正确的身份证号");
			  	}
			//法人电话$("#legalPersonPhone_p").val()
			var phone=/^1[3|4|5|8][0-9]\d{4,8}$/; //移动电话的标准格式 11位
		  	if(phone.test($("#legalPersonPhone_p").val())){
		  		isNotPass=isNotPass+1;
		  	}else{
			  	alert("亲请输入正确的电话号");
		  	}
			//机构简历$("#detail").val()
			if($("#detail").val().trim().length>0&&$("#detail").val()!="请输入机构简历"){
				isNotPass=isNotPass+1;
		  	}else{
			  	alert("亲请输入机构简历");
		  	}
			//isNot如果等于11 那么说明客户填的信息符合条件
			if(isNotPass==11){
				$.ajax({
	  				type:"post",
	  				url:host+"/university/universityAdd.do",
	  				data:{"name":$("#name_p").val(),"universityType":$("#universityType_p").val(),
	  					"universityNature":$("#universityNature_p").val(),"categoryid":$("#categoryid_p").val(),
	  					"address":$("#address_p").val(),"legalPersonName":$("#legalPersonName_p").val(),
	  					"legalPersonCard":$("#legalPersonCard_p").val(),"legalPersonPhone":$("#legalPersonPhone_p").val(),
	  					"introduction":$("#detail").val(),"userId":uuid,"schoolCoverimg":$("#schoolCoverimg").val(),
	  					"schoolLicense":$("#schoolLicense").val()},
	  				success:function(data){
	  					alert("请求成功");
	  					alert(data);
	  					setCookie("zhaosheng_service_status"+uuid,"1","d1"); //这是测试代码，正试逻辑要删除。状态：0表示没有开通，1表示开通中，2表示已开通，3表示被拒决
	  					location.reload();
	  				},
	  				error:function(){
	  					alert("请求失败");
	  				}		
				});
			}
		});
		
		
		var uploadInst1 = app.upload.render({
		    elem: '#start-img2'
		    ,url: host+'/university/save1.do'
		    ,field: 'upload_file'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#start-img-view2').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
		      //如果上传失败
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		      //上传成功
				$("#schoolCoverimg").val(res.data.uri);
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var errText1 = $('#errText2');
		      errText1.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
		      errText1.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
     });
     
     var uploadInst2 = app.upload.render({
		    elem: '#start-img3'
		    ,url: host+'/university/save1.do'
			,field: 'upload_file'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#start-img-view3').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
		      //如果上传失败
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		      //上传成功
		      $("#schoolLicense").val(res.data.uri);
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var errText1 = $('#errText3');
		      errText1.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
		      errText1.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
     });
     
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