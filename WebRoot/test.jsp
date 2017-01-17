<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="dist\js\jquery-3.1.1.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
	$.ajax({ url: "xwget_allmenu.action",
		type:"post",
		data: {"menu":"主要业务"},
		success: function(data){
		alert(data)
   		alert(data.name)
  	}
		
		 })
	
	
	})
	
	
	/* 
	$(function(){
	$.ajax({ url: "menuajax_Onemenudelete.action",
		type:"post",
		data: {"menu":"hahahdsadsa2","root":"1"},
		
		 })
	
	
	}) */
	</script>

  </head>
  
  <body>
    
  </body>
</html>
