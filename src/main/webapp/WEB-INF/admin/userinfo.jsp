<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>用户基本资料</title>
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
        
      </li>
      <li class="layui-nav-item quit"><a href="javascript:void(0);">退出</a></li>
    </ul>
  </div>
  
 <div class="layui-side layui-bg-black" id="side-nav">
    
 </div>
 
 
 <div class="layui-body" id="main">
    <!-- 内容主体区域 -->
    
  
     	
   	  <div class="layui-tab" style="margin-left:20px;">
   	  	
			  <ul class="layui-tab-title" >
			    <li class="layui-this">个人基本信息</li>
			   
			    <li>机构基本信息</li>
			    
			   

			  </ul>
			  <div class="layui-tab-content">
			    <div class="layui-tab-item layui-show">
			    <form  class="layui-form" id="form1" action="/user/userinfoByKeyUpdate.do" method="get"> 
			    	<!-- <form  class="layui-form" id="form1" action="/kzych/user/userinfoByKeyUpdate.do" method="get"> -->
			    	 <input type="hidden" name="uuid" value="${currentUser.uuid}">
			        <div class="layui-form-item">
						    <label class="layui-form-label">用户名:</label>
						    <div class="layui-input-block">
						      <input type="text" id="username" name="username"  value="${currentUser.username }" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
							    <label class="layui-form-label">头像:</label>
							    <div class="layui-input-block">
							     
									  <div class="layui-upload">
										  <button type="button" class="layui-btn" id="start-img1">上传图片</button>
										  <div class="layui-upload-list">
										    <img class="layui-upload-img" id="start-img-view1" style="height:100px;">
										    <p id="errText1"></p>
										  </div>
										</div> 
							    </div>
							</div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">真实姓名:</label>
						    <div class="layui-input-block">
						      <input type="text" id="realName" name="realName" value="${currentUser.realName}" autocomplete="off"  class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">电话:</label>
						    <div class="layui-input-block">
						      <input type="text" id="cellphone" name="cellphone" value="${currentUser.cellphone }" autocomplete="off"  class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">身份证:</label>
						    <div class="layui-input-block">
						      <input type="text"  id="default_1" name="idcard" value="只有在用户报读大中专学校和找工作、社会实践时才会要求填写" autocomplete="off"  class="layui-input default">
						    </div>
						  </div>
						  <div class="layui-form-item">
						  	
						    <label class="layui-form-label">毕业或就读学校:</label>
						    <div class="layui-input-block">
						      <input type="text"  id="default_2" name="school" value="只有在用户报读大中专学校和找工作、社会实践时才会要求填写" autocomplete="off"  class="layui-input default">
						    </div>
						  </div>
						  <div class="layui-form-item">
						  	
						    <label class="layui-form-label">家庭地址:</label>
						    <div class="layui-input-block">
						      <input type="text"  id="default_3" name="originPlace" value="只有在用户报读大中专学校和找工作、社会实践时才会要求填写" autocomplete="off"  class="layui-input default">
						    </div>
						  </div>
						  
						
						<hr class="layui-bg-green">

									  
				    <div class="layui-form-item" style="text-align:center;">
					    <button class="layui-btn" lay-submit="" lay-filter="demo1">修改</button>
			        
					  </div>
								 
								  
						</form>
			    </div>
			    <div class="layui-tab-item">
			    	<form class="layui-form" action="/university/schoolByUserIdUpdate.do">
			    		<div class="layui-form-item">
						    <label class="layui-form-label">机构名称:</label>
						    <div class="layui-input-block">
						      <input type="hidden" name="id" value="${User_list.id}">
						      <input type="text" name="" value="${User_list.name}" autocomplete="off" disabled class="layui-input">
						    </div>
						  </div>
						  
						  <div class="layui-form-item">
						    <div class="layui-inline">
						      <label class="layui-form-label">机构类型</label>
						      <div class="layui-input-inline">
						        <select name="universityType" lay-filter="aihao" id="universityType_seelct_01">
							        <option value="0"></option>
							        <option value="1">学校</option>
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
						        <select name="universityNature" lay-filter="aihao" id="universityNature_seelct_02">
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
						        <select name="categoryid" lay-filter="aihao" id="categoryid_seelct_03">
							        <option value="0"></option>
							        <option value="1">本科</option>
							        <option value="2" >大专</option>
							        <option value="3" >中专</option>
							        <option value="4" >培训学校</option>
							      </select>
						      </div>
						    </div>
						  </div>
			        
               <div class="layui-form-item">
						    <label class="layui-form-label">机构地址:</label>
						    <div class="layui-input-block">
						      <input type="text" name="address" value="${User_list.address}" autocomplete="off"  class="layui-input">
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
									    </div>
							     </div>
							</div>
						  
						  
              
							
							<div class="layui-form-item">
						    <div class="layui-inline">
						      <label class="layui-form-label">法人姓名</label>
						      <div class="layui-input-inline">
						        <input type="text" name="legalPersonName" value="${User_list.legalPersonName}" autocomplete="off"  class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <!--只有选择学校才显示-->
						      <label class="layui-form-label">法人身份证:</label>
						      <div class="layui-input-inline">
						        <input type="text" name="legalPersonCard" value="${User_list.legalPersonCard}" autocomplete="off"  class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <!--只有选择学校类型才显示-->
						      <label class="layui-form-label">法人电话:</label>
						      <div class="layui-input-inline">
						        <input type="text" name="legalPersonPhone" value="${User_list.legalPersonPhone}" autocomplete="off"  class="layui-input">
						      </div>
						    </div>
						  </div>
						  
						  
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">机构简介:</label>
						    <div class="layui-input-block">
						       <textarea id="detail" name="introduction" >${User_list.introduction}</textarea>
						    </div>
						  </div>
						
						<hr class="layui-bg-green">

									  
				    <div class="layui-form-item" style="text-align:center;">
					    <button class="layui-btn" lay-submit="" lay-filter="demo2">修改</button>
			        
					  </div>
								 
								  
						</form>
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

var basePath = "${basePath}";
var host="${host}";
	cur_mod="个人中心";
	
	app.init(function($){
			var uploadInst = app.upload.render({
		    elem: '#start-img1'
		    ,url: '/upload/'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#start-img-view1').attr('src', result); //图片链接（base64）
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
     
     		var uploadInst1 = app.upload.render({
		    elem: '#start-img2'
		    ,url: '/upload/'
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
		    ,url: '/upload/'
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
        
        
        
        
        
        //身份证  毕业  家庭住址  的输入框 中的默认值
		var info="只有在用户报读大中专学校和找工作、社会实践时才会要求填写";
      //身份证
      	var idcrad="${currentUser.idcard}";
      	//学校
      	var school="${currentUser.school}";
      	//家庭住址
      	var originPlace="${currentUser.originPlace}";
      	
      	layui.use('form', function(){
        	  var form = layui.form;
        	  form.on('submit(demo1)', function(data){
        		return true;
        	    }); 
        	    form.on('submit(demo2)', function(data){
        	    	alert($("#"));
            		return true;
            	    });
        });
      	
      	//设置下拉框的默认值
      	//机构类型 
      	var universityType=$("#universityType_seelct_01").html().split("<option value=\"");
      //机构性质
      	var universityNature=$("#universityNature_seelct_02").html().split("<option value=\"");
      //学校等级
      	var categoryname=$("#categoryid_seelct_03").html().split("<option value=\"");
      //机构类型的设置默认值
      	settingsSelected(universityType,"${User_list.universityType}","universityType_seelct_01");
      //机构性质设置默认值
      	settingsSelected(universityNature,"${User_list.universityNature}","universityNature_seelct_02");
      //学校等级的设置默认值 
      	settingsSelected(categoryname,"${User_list.categoryid}","categoryid_seelct_03");
      	function settingsSelected(list,id,select_id){
      		for(var i=1;i<list.length;i++){
          		if(list[i].substring(0,1)==id){
          			$("#"+select_id+" option[value="+(i-1)+"]").attr("selected","selected");
          		}
          	}
      	}
      	
    	layui.use('form', function(){
    		var form = layui.form;
    		//由于设置了下拉框的初始值所以需要重新渲染一次select
    	    form.render('select');
    	});
      	
      	
      	//身份证的输入框 
      	if(idcrad.length>0){
      		$("#default_1").val(idcrad);
      		$("#default_1").blur(function(){
    			if($.trim($("#default_1").val()).length==0){
    				$("#default_1").val(idcrad);
    			}
    		});
      	}else{
      		$("#default_1").val(info);
      		$("#default_1").focus(function(){
    			if($("#default_1").val()==info){
    				$("#default_1").val("");
    			}
    		});
      		$("#default_1").blur(function(){
    			if($.trim($("#default_1").val()).length==0){
    				$("#default_1").val(info);
    			}
    		});
      	}
      	//学校的输入框
      	if(school.length>0){
      		$("#default_2").val(school);
      		$("#default_2").blur(function(){
    			if($.trim($("#default_2").val()).length==0){
    				$("#default_2").val(school);
    			}
    		});
      	}else{
      		$("#default_2").val(info);
      		$("#default_2").focus(function(){
    			if($("#default_2").val()==info){
    				$("#default_2").val("");
    			}
    		});
      		$("#default_2").blur(function(){
    			if($.trim($("#default_2").val()).length==0){
    				$("#default_2").val(info);
    			}
    		});
      	}
      	//家庭住址的输入框
      	if(originPlace.length>0){
      		$("#default_3").val(originPlace);
      		$("#default_3").blur(function(){
    			if($.trim($("#default_3").val()).length==0){
    				$("#default_3").val(originPlace);
    			}
    		});
      	}else{
      		$("#default_3").val(info);
      		$("#default_3").focus(function(){
    			if($("#default_3").val()==info){
    				$("#default_3").val("");
    			}
    		});
      		$("#default_3").blur(function(){
    			if($.trim($("#default_3").val()).length==0){
    				$("#default_3").val(info);
    			}
    		});
      	}
	});

	
</script>