<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Htmlquery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="dist\js\jquery-3.1.1.min.js"></script>
	
<script type="text/javascript">
    $(function(){
   	 $.ajax({ url: "/admin/Htmlquery",
		type:"post",
		dataType:"json",
		data: {"menu":"主要业务","gethtml":"no"},
		success:function(data){
		for(s=0;s<=data.length;s++){
		alert("标题是"+data[s].onemenu)
		alert("内容为"+data[s].twomenu)
		}
		}
		 });
    
    })
    </script>
  </head>
  
  <body>
  <!--  包装页面 -->
    
  </body>
</html>
