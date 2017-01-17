<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    
    <title>管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link  rel="stylesheet" type="text/css" href="dist/css/zui.min.css" />
	
	<!-- 文本编辑器引入 -->
	<script type="text/javascript" src="dist\js\jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="dist\js\zui.min.js"> </script>

  </head>
  
  <body>
  <!-- 开启栅格 -->
  <div class="row">
  
  <!-- 顶部导航按钮 -->
<div id="top" class="col-md-12">
  <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
      <!-- 导航头部 -->
      <div class="navbar-header">   
        <!-- 品牌名称或logo -->
        <a class="navbar-brand" href="#">管理系统</a>
      </div>
      <!-- 导航项目 -->
      <div class="collapse navbar-collapse navbar-collapse-example">
        <!-- 一般导航项目 -->
        <ul class="nav navbar-nav">
          <li class=""><a href="login_zyyw">主要业务</a></li>
          <li class=""><a >典型客户</a></li>
          <li class=""><a >专利</a></li>
          <li class=""><a >说明文档</a></li>
        </ul>
      </div><!-- END .navbar-collapse -->
    </div>
  </nav>
</div>
<h1 style="text-align:center">上方选择修改的栏目</h1>
<!-- 栅格结束 -->
</div>

  </body>

  
</html>
