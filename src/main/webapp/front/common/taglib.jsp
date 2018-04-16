<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);//47.104.135.201
request.setAttribute("host","http://47.104.135.201:8080/kzych/");
%>
    