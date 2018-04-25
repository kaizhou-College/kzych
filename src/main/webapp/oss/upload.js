
accessid = ''
accesskey = ''
host = ''
policyBase64 = ''
signature = ''
callbackbody = ''
filename = ''
key = ''
expire = 0
g_object_name = ''
g_object_name_type = ''
now = timestamp = Date.parse(new Date()) / 1000; 
_this='';
_selectfiles = '';
function send_request()
{
    var xmlhttp = null;
    if (window.XMLHttpRequest)
    {
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  
    if (xmlhttp!=null)
    {
        serverUrl = 'http://47.104.135.201:8080/oss/signature.do'
        xmlhttp.open( "GET", serverUrl, false );
        xmlhttp.send( null );
        return xmlhttp.responseText
    }
    else
    {
        alert("Your browser does not support XMLHTTP.");
    }
};

function check_object_radio() {
    var tt = document.getElementsByName('myradio');
    //如果要是没有选择  上传文件名字保持本地文件名字  的话就使用默认
    if(tt.length<=0){
    	g_object_name_type="local_name";
    }
    for (var i = 0; i < tt.length ; i++ )
    {
        if(tt[i].checked)
        {
            g_object_name_type = tt[i].value;
            break;
        }
    }
}

function get_signature()
{
    //可以判断当前expire是否超过了当前时间,如果超过了当前时间,就重新取一下.3s 做为缓冲
    now = timestamp = Date.parse(new Date()) / 1000; 
    if (expire < now + 3)
    {
        body = send_request()
        var obj = eval ("(" + body + ")");
        host = obj['host']
        policyBase64 = obj['policy']
        accessid = obj['accessid']
        signature = obj['signature']
        expire = parseInt(obj['expire'])
        callbackbody = obj['callback'] 
        key = obj['dir']
        return true;
    }
    return false;
}

function random_string(len) {
　　len = len || 32;
　　var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';   
　　var maxPos = chars.length;
　　var pwd = '';
　　for (i = 0; i < len; i++) {
    　　pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

function get_suffix(filename) {
    pos = filename.lastIndexOf('.')
    suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}

function calculate_object_name(filename)
{
    if (g_object_name_type == 'local_name')
    {
        g_object_name += "${filename}"
    }
    else if (g_object_name_type == 'random_name')
    {
        suffix = get_suffix(filename)
        g_object_name = key + random_string(10) + suffix
    }
    return ''
}

function get_uploaded_object_name(filename)
{
    if (g_object_name_type == 'local_name')
    {
        tmp_name = g_object_name
        tmp_name = tmp_name.replace("${filename}", filename);
        return tmp_name
    }
    else if(g_object_name_type == 'random_name')
    {
        return g_object_name
    }
}

function set_upload_param(up, filename, ret)
{
    if (ret == false)
    {
        ret = get_signature();
        
    }
    g_object_name = key;
    if (filename != '') {
        suffix = get_suffix(filename)
        calculate_object_name(filename)
    }
    new_multipart_params = {
        'key' : g_object_name,
        'policy': policyBase64,
        'OSSAccessKeyId': accessid, 
        'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
        'callback' : callbackbody,
        'signature': signature,
    };

    up.setOption({
        'url': host,
        'multipart_params': new_multipart_params
    });

    up.start();
}
var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'selectbackfiles', 
    //multi_selection: false,
	container: document.getElementById('container'),
	flash_swf_url : 'lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : 'lib/plupload-2.1.2/js/Moxie.xap',
    url : 'http://oss.aliyuncs.com',

    filters: {
        mime_types : [ //只允许上传图片和zip,rar文件
        { title : "Image files", extensions : "jpg,gif,png,bmp" }, 
        { title : "Zip files", extensions : "zip,rar" }
        ],
        max_file_size : '10mb', //最大只能上传10mb的文件
        prevent_duplicates : true //不允许选取重复文件
    },

	init: {
		PostInit: function() {
			alert(111);
			//document.getElementById('ossfile').innerHTML = '';
			document.getElementById('postbackfiles').onclick = function() {
			
	            set_upload_param(uploader, '', false);
	            _this=this;
	            return false;
			};
			document.getElementById('postpaperfiles').onclick = function() {
	            set_upload_param(uploader, '', false);
	            _this=this;
	            return false;
			};
			document.getElementById('selectbackfiles').onclick = function(){
				alert(1);
				uploader.browse_button = 'selectbackfiles';
				alert(uploader.browse_button);
				return false;
			};
			document.getElementById('selectpaperfiles').onclick = function(){
				alert(2);
				uploader.browse_button  = 'selectpaperfiles';
				return false;
			};
		},

		/*FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				
				document.getElementById('ossfile').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ')<b></b>'
				+'<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
				+'</div>';
			});
		},*/

		BeforeUpload: function(up, file) {
            check_object_radio();
            set_upload_param(up, file.name, true);
        },

		/*UploadProgress: function(up, file) {
			var d = document.getElementById(file.id);
			d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
            var prog = d.getElementsByTagName('div')[0];
			var progBar = prog.getElementsByTagName('div')[0]
			progBar.style.width= 2*file.percent+'px';
			progBar.setAttribute('aria-valuenow', file.percent);
		},*/

		FileUploaded: function(up, file, info) {
            if (info.status == 200)
            {
                //document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = 'upload to oss success, object name:' + get_uploaded_object_name(file.name);
            	alert(_this.innerHTML); 
            	alert("1="+get_uploaded_object_name(file.name)); 
            	
            		var p = _this.parentNode.children;
            		p[2].innerHTML="<img src='https://kzych.oss-cn-qingdao.aliyuncs.com/"+get_uploaded_object_name(file.name)+
            					   "' class='layui-upload-img'  id='start-img-view2' style='height:100px;'>"+
            					   "<p id='errText2'></p>"
            		p[3].setAttribute("value",get_uploaded_object_name(file.name));
            		//alert(p[2].innerHTML+"="+img.innerHTML);
            }
            else
            {
                //document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
            	alert(info.response);
            } 
		},

		Error: function(up, err) {
            if (err.code == -600) {
               // document.getElementById('console').appendChild(document.createTextNode("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小"));
            	alert("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小");
            }
            else if (err.code == -601) {
                //document.getElementById('console').appendChild(document.createTextNode("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型"));
                alert("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型");
            }
            else if (err.code == -602) {
                //document.getElementById('console').appendChild(document.createTextNode("\n这个文件已经上传过一遍了"));
                alert("\n这个文件已经上传过一遍了");
            }
            else 
            {
                //document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
                alert("\nError xml:" + err.response);
            }
		}
	}
});

var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : ['selectbackfiles','selectpaperfiles'], 
    //multi_selection: false,
	container: document.getElementById('container'),
	flash_swf_url : 'lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : 'lib/plupload-2.1.2/js/Moxie.xap',
    url : 'http://oss.aliyuncs.com',

    filters: {
        mime_types : [ //只允许上传图片和zip,rar文件
        { title : "Image files", extensions : "jpg,gif,png,bmp" }, 
        { title : "Zip files", extensions : "zip,rar" }
        ],
        max_file_size : '10mb', //最大只能上传10mb的文件
        prevent_duplicates : true //不允许选取重复文件
    },

	init: {
		PostInit: function() {
			//document.getElementById('ossfile').innerHTML = '';
			document.getElementById('postbackfiles').onclick = function() {
	            set_upload_param(uploader, '', false);
	            _this=this;
	            return false;
			};
			document.getElementById('postpaperfiles').onclick = function() {
	            set_upload_param(uploader, '', false);
	            _this=this;
	            return false;
			};
		},

		/*FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				
				document.getElementById('ossfile').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ')<b></b>'
				+'<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
				+'</div>';
			});
		},*/

		BeforeUpload: function(up, file) {
            check_object_radio();
            set_upload_param(up, file.name, true);
        },

		/*UploadProgress: function(up, file) {
			var d = document.getElementById(file.id);
			d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
            var prog = d.getElementsByTagName('div')[0];
			var progBar = prog.getElementsByTagName('div')[0]
			progBar.style.width= 2*file.percent+'px';
			progBar.setAttribute('aria-valuenow', file.percent);
		},*/

		FileUploaded: function(up, file, info) {
            if (info.status == 200)
            {
                //document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = 'upload to oss success, object name:' + get_uploaded_object_name(file.name);
            	//alert(_this.innerHTML); 
            	//alert("1="+get_uploaded_object_name(file.name)); 
            	
            		var p = _this.parentNode.children;
            		p[2].innerHTML="<img src='https://kzych.oss-cn-qingdao.aliyuncs.com/"+get_uploaded_object_name(file.name)+
            					   "' class='layui-upload-img'  id='start-img-view2' style='height:100px;'>"+
            					   "<p id='errText2'></p>"
            		p[3].setAttribute("value",get_uploaded_object_name(file.name));
            		//alert(p[2].innerHTML+"="+img.innerHTML);
            }
            else
            {
                //document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
            	alert(info.response);
            } 
		},

		Error: function(up, err) {
            if (err.code == -600) {
               // document.getElementById('console').appendChild(document.createTextNode("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小"));
            	alert("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小");
            }
            else if (err.code == -601) {
                //document.getElementById('console').appendChild(document.createTextNode("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型"));
                alert("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型");
            }
            else if (err.code == -602) {
                //document.getElementById('console').appendChild(document.createTextNode("\n这个文件已经上传过一遍了"));
                alert("\n这个文件已经上传过一遍了");
            }
            else 
            {
                //document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
                alert("\nError xml:" + err.response);
            }
		}
	}
});

uploader.init();
