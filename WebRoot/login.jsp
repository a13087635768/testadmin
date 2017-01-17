<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  	
    <title>后台管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet"  type="text/css" href="dist/css/Login.css" >
	<link  rel="stylesheet" type="text/css" href="dist/css/zui.min.css" >
	<script type="text/javascript" src="dist/js/zui.min.js"></script>
  </head>
  
  <body>   
   <section class="container">
    <div class="login">
      <h1>用户登录</h1>
     	 ${error}
      <form method="post" action="login_login">
        <p><input type="text" name="user.username"  placeholder="用户名"></p>
        <p><input type="password" name="user.password"  placeholder="密码"></p><br>
       	<button class="btn btn-block " type="submit">登陆</button>
      </form>
    </div>
  </section>
</body>   

</html>
