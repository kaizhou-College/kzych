
app = function(){

   	//var $;
   	var layer;
   	var tpl;
   	var upload;
   	var laypage;
   	var userProducts;
    var userRole;
    var userProducts = '';
    var userRole = '';
    var table;
    var element;
}

app.init = function(fn){
	 //alert(1);
	 layui.use(['form', 'laypage', 'layer','laytpl','upload','table'], function(){ 
		  app.form = layui.form;
	 	  app.table = layui.table;
	 	  app.$= layui.$ ;//重点处
	 	  if(typeof($) == "undefined"){
	       $ = app.$;
	 	  }   
	 	  app.getOpenedProduct();
	 	  app.getRole();
	 	  app.registerQuitEvent($);
	 	  app.laypage = layui.laypage;

	 	  app.layer = layui.layer;
	 	  app.tpl = layui.laytpl;
     
	 	  app.upload = layui.upload;
	 	  app.loadTopNav(app.$);
      if(typeof(fn) == 'function'){
      	  fn(app.$);
      }
       
   });
}

app.loadTopNav = function ($){
	  var nav_url = basePath+"admin/testdata/nav.json";
	  if(cur_mod == '我的学校'){
	       	nav_url =  basePath+'admin/testdata/myschool-nav.json';
	  }
	  
    
	  $.ajax({
            url: nav_url,
            type: "get",
            cache: false,
            dataType: "json",
            global: true,
            success: function (navlist) {
			    	  
			    	  var ele = '';
				  	  for(var i in navlist){
				  	   if(typeof(navlist[i].action) == "undefined" || navlist[i].action == ''){
				  	      	navlist[i].action = "javascript:;";
				  	   }
				  	   
				  	   ele = '<li class="layui-nav-item"><a href="' + navlist[i].action + '">' + navlist[i].name + '</a>';
				  	   
				  	   app.loadSideNav(navlist[i].name,navlist[i].side_nav,$);
				  	   if(typeof(navlist[i].children) == "object" && navlist[i].children.length > 0){
				  	   	     
				  	   	     var children = navlist[i].children;
				  	   	     
				  	   	     ele +=  '<dl class="layui-nav-child">';
				  	       	 for(var j in children){
				  	       	 	    
				  	       	 	    if(typeof(children[j].action) == "undefined" || children[j].action == ''){
				  	      	          children[j].action = "javascript:;";
				  	              }
				  	              
				  	       	 	    ele += '<dd><a href="'+ children[j].action + '">' + children[j].name +  '</a></dd>';
				  	       	 	    
				  	       	 	    app.loadSideNav(children[j].name,children[j].side_nav,$);
				  	       	 }
				  	       	 ele += '</dl>';
				  	   }
				  	   ele += '</li>';
				  	  	
				  	   //顶部导航如果只有一个菜单不显示
				  	   if(navlist.length > 1 ){
			            $("#top_nav_view" ).append(ele);
			         
			         }
               layui.use('element', function(){
								  var element = layui.element;
								  
								});
			        
			        }
			        
            },
            error:function(err){
            	 if(err.status == 200) alert(err.responseText);
				       else alert(err.statusText);
            }
        });

}

app.loadSideNav = function(mod_name,d,$){
	

	if(typeof(cur_mod) != 'undefined' && mod_name == cur_mod){
		  
		  
     //左侧导航区域（可配合layui已有的垂直导航） 
      var ele  = '<div class="layui-side-scroll">'
          ele += '<ul class="layui-nav layui-nav-tree"  lay-filter="test">'
       for(var i in d){
       	  
       	  var select_class = '';
       	  //判断是否为当前选中的菜单
//       	  alert(d[i].action);
//       	  alert(window.location.href);
       	  /*if(d[i].action != '' && window.location.href.indexOf(d[i].action ) != -1){
       	  	  select_class = 'layui-this';
       	  }*/
//       	alert();
//       	alert();
       	  //设置选中哪个选项
       	  if(d[i].action != ''&& window.location.href.indexOf("index.do")!=-1&& d[i].action.indexOf("index.do")!=-1){
       		  select_class = 'layui-this';
       	  }else if(d[i].action != ''&& window.location.href.indexOf("toSchoolAudit.do")!=-1&& d[i].action.indexOf("toSchoolAudit.do")!=-1){
       		  select_class = 'layui-this';
       	  }else if(d[i].action != ''&& window.location.href.indexOf("toSchoolNopass.do")!=-1&& d[i].action.indexOf("toSchoolNopass.do")!=-1){
       		  select_class = 'layui-this';
       	  }
       	  
       	  
          ele += '<li class="layui-nav-item layui-nav-itemed ' + select_class + '">';
          
          ele += '<a class="" href="' + d[i].action + '">' + d[i].name + '</a>';
          
          if(d[i].children.length >0 ){ 
          ele += '<dl class="layui-nav-child">';
          for(var j in d[i].children){
          	
          	var select_class = '';
          	//判断是否为当前选中的菜单
	       	  if(d[i].children[j].action != '' && window.location.href.indexOf(d[i].children[j].action) != -1){
	       	  	  select_class = 'layui-this';
	       	  }
          	 ele += '<dd class="'+ select_class +'"><a href="'+ d[i].children[j].action + '">' + d[i].children[j].name + '</a></dd>';
             
          }
      
          ele += '</dl>'
        }
        ele += '</li>';
       
       }
      ele += '</ul>';
      ele += '</div>';
      
      $("#side-nav" ).append(ele);
	}
	
}


app.loadTopNav = function ($){
	  
	  var nav_url =  basePath+"admin/testdata/nav.json";
	  //异步请求看该用户是否管理员
	  $.ajax({
		    type:"post",//47.104.135.201
			url:host_kzych+"/user/isNotAdministrator.do",
			data:{"username":username},
			success:function(data){
				//如果要是用户没有登入的话这里就会跳往登入页面
				if(data.data==null||data.data==''){
					location=basePath+"front/login.do"
				}
				//判断该用户是否管理员 （0不是管理员1是管理员）
				if(data.data.userType==0){
					nav_url =  basePath+"admin/testdata/user-nav.json";
				}
				$.ajax({
		            url: nav_url,
		            type: "get",
		            cache: false,
		            dataType: "json",
		            global: true,
		            success: function (navlist) {
					    	  
					    	  var ele = '';
						  	  for(var i in navlist){
						  	   if(typeof(navlist[i].action) == "undefined" || navlist[i].action == ''){
						  	      	navlist[i].action = "javascript:;";
						  	   }
						  	   
						  	   //---------测试代码，正试写时写法不一样 begin ------------------
						  	   if(navlist[i].name == "招生" && getCookie("zhaosheng_service_status") != 2){
						  	   	    continue;
						  	   }
						  	   if(navlist[i].name == "招聘" && getCookie("recruit_service_status") != 2){
						  	   	    continue;
						  	   }
						  	   if(navlist[i].name == "油菜园" && getCookie("ycy_service_status") != 2){
						  	   	    continue;
						  	   }
						  	   
						  	   //---------测试代码，正试写时写法不一样  end ------------//
						  	   var select_class = '';
						  	   if(typeof(cur_mod) != 'undefined' && navlist[i].name == cur_mod){
						  	   	    select_class = 'layui-this';
						  	   }
						  	   ele = '<li class="layui-nav-item ' + select_class + '"><a href="' + navlist[i].action + '">' + navlist[i].name + '</a>';
						  	   
						  	   app.loadSideNav(navlist[i].name,navlist[i].side_nav,$);
						  	   if(typeof(navlist[i].children) == "object" && navlist[i].children.length > 0){
						  	   	     
						  	   	     var children = navlist[i].children;
						  	   	     
						  	   	     ele +=  '<dl class="layui-nav-child">';
						  	       	 for(var j in children){
						  	       	 	    
						  	       	 	    if(typeof(children[j].action) == "undefined" || children[j].action == ''){
						  	      	          children[j].action = "javascript:;";
						  	              }
						  	              
						  	       	 	    ele += '<dd><a href="'+ children[j].action + '">' + children[j].name +  '</a></dd>';
						  	       	 	    
						  	       	 	    app.loadSideNav(children[j].name,children[j].side_nav,$);
						  	       	 }
						  	       	 ele += '</dl>';
						  	   }
						  	   ele += '</li>';
						  	  	
						  	   //顶部导航如果只有一个菜单不显示
						  	   if(navlist.length > 1 ){
					            $("#top_nav_view" ).append(ele);
					         
					         }
					         
					         
				          if(typeof(app.element) == 'undefined'){
				          	 layui.use('element', function(){
									      app.element = layui.element;
									      app.element.init();
									  
									   });
				          		}
					        }
					        
		            },
		            error:function(err){
		            	 if(err.status == 200) alert(err.responseText);
						       else alert(err.statusText);
		            }
		        });
			},
			error:function(){
				alert("请求失败！！！");
			}
	  });
}

/*测试代码，用于原型设计中的业务逻辑处理*/


   app.registerQuitEvent = function($){
       	//测试代码
	    $(".quit").on("click",function(){
	    	
	      
				var exp = new Date();
				exp.setTime(exp.getTime() - 1);
				var cval=getCookie("token");
				if(cval!=null)
				document.cookie= "token" + "="+ '' +";expires="+exp.toGMTString() + ";path=/;";
				location.href = "/front";
				return false;
	
	    });	
   }

    //获取已开通的产品
   app.getOpenedProduct = function (){
    	
    
    	var arr,reg=new RegExp("(^| )"+"products" +"=([^;]*)(;|$)");
			if(arr=document.cookie.match(reg)){
			     app.userProducts = unescape(arr[2])
			 
			}
	
    }
    
    app.getRole = function (){
    	
    	 var arr,reg=new RegExp("(^| )"+"token" +"=([^;]*)(;|$)");
			 if(arr=document.cookie.match(reg)){
			     app.userRole = unescape(arr[2])
			 
			 }
			
    }
    //测试代码
    function getCookie(name)
		{
			var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
			if(arr=document.cookie.match(reg))
			return unescape(arr[2]);
			else
			return null;
		}
		
	

	  function setCookie(name,value,time)
		{
		var strsec = getsec(time);
		var exp = new Date();
		exp.setTime(exp.getTime() + strsec*1);
		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+ ";path=/;";
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

/*测试代码，用于原型设计中的业务逻辑处理*/