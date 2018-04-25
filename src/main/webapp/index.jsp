<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<link rel="stylesheet" href="oss/css/oss.css"  media="all">
</head>
<body>
	<h2>Hello World!</h2>
	springmvc上传文件
	<form name=theform>
	<input type="radio" name="myradio" value="local_name" checked=true/> 上传文件名字保持本地文件名字
	<input type="radio" name="myradio" value="random_name" /> 上传文件名字是随机文件名, 后缀保留
	</form>
	
	<h4>您所选择的文件列表：</h4>
	<div id="ossfile">你的浏览器不支持flash,Silverlight或者HTML5！</div>
	
	<br/>
	
	<div id="container">
		<button id="selectfiles"  class='btn'>选择文件</button>
		<button id="postfiles"  class='btn'>开始上传</button>
		
		<img id="img_01" src="111">
	</div>
	
	<pre id="console"></pre>

	富文本图片上传文件
	<form name="form2"
		action="/kzych/manage/product/richtext_img_upload.do" method="post"
		enctype="multipart/form-data">
		<input type="file" name="upload_file" />
		<input type="submit" value="富文本图片上传文件" />
	</form>
</body>
<script type="text/javascript"
	src="oss/lib/plupload-2.1.2/js/plupload.full.min.js"></script>
<script type="text/javascript" src="oss/upload.js">
</script>
</html>
