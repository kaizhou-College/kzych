<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
        <meta name="renderer" content="webkit">  
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">  
        <meta name="apple-mobile-web-app-status-bar-style" content="black">  
        <meta name="apple-mobile-web-app-capable" content="yes">  
        <meta name="format-detection" content="telephone=no">  
        <link rel="stylesheet" href="/kzych/admin/css/layui.css" />
    </head>  
    <body>  
        <div class="layui-form">  
            <div class="layui-input-inline">  
                <select name="province" lay-filter="province" class="province">  
                    <option value="">请选择省</option>  
                </select>  
            </div>  
            <div class="layui-input-inline">  
                <select name="city" lay-filter="city" disabled>  
                    <option value="">请选择市</option>  
                </select>  
            </div>  
            <div class="layui-input-inline">  
                <select name="area" lay-filter="area" disabled>  
                    <option value="">请选择县/区</option>  
                </select>  
            </div>  
        </div>  
    </body>  
	<script src="/kzych/admin/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/kzych/admin/address.js"></script>  
    <script type="text/javascript">  
        layui.config({  
            base : "../../../js/" //address.js的路径  
        }).use([ 'layer', 'jquery', "address" ], function() {  
            var layer = layui.layer, $ = layui.jquery, address = layui.address();  
        });  
        
    </script>  
<html>