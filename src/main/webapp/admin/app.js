app = function(){

   	//var $;
   	var layer;
   	var tpl;
   	var upload;
   	var laypage;
}

app.init = function(fn){
	 //alert(1);
	 layui.use(['form', 'laypage', 'layer','laytpl','upload'], function(){ 
	  app.form = layui.form;
      app.$= layui.$ ;//重点处
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
       	  if(d[i].action != ''&& window.location.href.indexOf("index.do")!=-1&& d[i].action.indexOf("schoolList.do")!=-1){
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