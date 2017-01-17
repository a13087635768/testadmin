<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.admin.menu.entity.TMenu" %>
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
	<link rel="stylesheet" type="text/css" href="wangEditor-2.1.22/dist/css/wangEditor.min.css">
	<link rel="stylesheet" type="text/css" href="wangEditor-2.1.22/static/highlightjs/dark.css">
	<script type="text/javascript" src="dist\js\jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="wangEditor-2.1.22/src/js/wangEditor.js"></script>
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
          <li class=""><a href="/admin/zyyw">主要业务</a></li>
          <li class=""><a >典型客户</a></li>
          <li class=""><a >专利</a></li>
          <li class=""><a >说明文档</a></li>
        </ul>
      </div><!-- END .navbar-collapse -->
    </div>
  </nav>
</div>
<!-- 侧边栏和新闻div 方便不跳转页面进行转换 -->
<div>
<!-- 侧栏显示 栏目的选项 -->
<div class="col-md-2">
	<nav class="menu" data-toggle="menu" style="width: 200px">

  <button class="btn"  data-toggle="modal" data-target="#myModal"><i class="icon-cloud-upload"></i>栏目管理</button>
  <ul class="nav nav-primary">
 
 	<c:forEach  items="${allmenu.TColumes}" var="a">
 		
 		 <li class="nav-parent">
      	<a href="javascript:;"></i>${a.CName}</a>
      	<ul class="nav">
		<c:forEach items="${a.TSoncolumes}" var="m">
		<li><a onclick="bt(this)">${m.SName}</a></li>
		</c:forEach>	

       
      </ul>
    </li>

 	</c:forEach>
    
    </ul>
</nav>

</div>
<!-- 内容显示区域 -->
<div class="col-md-10">
	<form action="">
	<!-- 新闻标题 -->
	<div class="col-md-3 col-md-offset-4" style="text-align:center;">
	<div><h1>主要业务</h1></div>
	<div><h3 id="bt">新闻标题</h3></div>
	</div>
	<!-- 内容 -->
	<div class="col-md-12">
	<div id="editor" style="height:400px;max-height:500px;">
	<p>初始化的内容</p>
	</div>
	<button id="btn1">保存内容</button>
	
	</div>
	</form>
<!-- 新闻结束 -->
</div>
<!-- 侧栏和新闻结束 -->
</div>
<!-- 栅格结束 -->
</div>


<!-- 弹出框 -->


<div class="modal fade" id="myModal">
  <div class="modal-dialog  " style="width: 1200px">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
        <h3 style="text-align:center" class="modal-title">菜单管理 </h3>
        <!-- 暂时不开放新增 -->
         <button class="btn" type="button" data-toggle="modal" data-target="#yjlm">新建一级菜单</button> 
      </div>
      <div class="modal-body">
        	<!-- 显示的内容 -->

        	
        	<!--  -->
        	<table class="table table-borderless">

        	<tbody>
        	<tr>
        	<td style="text-align:center">栏目标题</td>
        	<td style="text-align:center">栏目内容..........</td>
        	</tr>
        		<c:forEach items="${allmenu.TColumes}" var="a">
				      
        			
        	<tr name="${a.CName}">
        	<td> <input class="form-control"  ondblclick="update(this)" onblur="ovupdate(this)" type="text" placeholder="此文本框只读双击修改"  value="${a.CName}" readonly></td>
	        	<c:forEach items="${a.TSoncolumes}" var="m">
				<td><input name="${a.CName}" class="form-control" root="2" ondblclick="update(this)" onblur="ovupdate(this)" type="text" placeholder="删除成功" value="${m.SName}" readonly></td>
				</c:forEach>	
			<td><input name="${a.CName}" class="form-control" ondblclick="update(this)" onblur="insert(this)" type="text" placeholder="增加字段"  readonly></td>
        	</tr>
        	
        	</c:forEach>
        	</tbody>
        	</table>
        	<!-- over -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>


<!-- 新增一级栏目 -->


<div class="modal fade" id="yjlm">
  <div class="modal-dialog  " style="width: 300px">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
        <h3 style="text-align:center" class="modal-title">一级菜单添加 </h3>
        
      </div>
      <div class="modal-body">
        	<!-- 显示的内容 -->
        	请输入标题名称<input class="form-control" type="text" placeholder="标题名称" id="newonemenu"><br>
        	请输二级栏目(多个栏目同时添加请用,隔开)<input class="form-control" type="text" placeholder="栏目内容" id="newtwomenu"><br>
        	<!-- over -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="oneinsert()">保存</button>
      </div>
    </div>
  </div>
</div>

  </body>
<script type="text/javascript">

//设置获取li的值显示在BT里
var value;
	tempflag = false;



    var editor = new wangEditor('editor');
       editor.config.uploadImgUrl = 'upload.action';

   

  

    // 隐藏掉插入网络图片功能。该配置，只有在你正确配置了图片上传功能之后才可用。
    editor.config.hideLinkImg = true;

     editor.create();

    $('#btn1').click(function () {
        // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
        

        // 获取编辑器纯文本内容
        var text = editor.$txt.text();

        // 获取格式化后的纯文本
        var formatText = editor.$txt.formatText();
        //发送文本到后台
        $.ajax({ url: "xwhtml_update.action",
		type:"post",
		data:{"name":$("#bt").text(),"value":html},
		 });
        
    });
    
   //设置后台图片的名字- 
    editor.config.uploadImgFileName = "file";
   
   
   
  /* 点击垂直菜单的函数 */
   
   
    function bt(a){
		value =$(a).text();
		$("#bt").text(value);

		$.ajax({ url: "xwget_select.action",
		type:"post",
		dataType:"html",
		data: {"name":value},
		success:function(data){
				
		editor.$txt.html(data)
		}
		 });
		 
	}
    /* 一级菜单添加 */
   function oneinsert(){
   		$.ajax({ url: "menuajax_Onemenuinsert.action",
		type:"post",
		data:{"menu":"主要业务","column":$("#newtwomenu").val(),"root":"2"},
		 });
    
    }
   
   
    
    
    
   /* 双击输入框执行的方法 开启修改*/
   	function update(vo) {
		$(vo).removeAttr("readonly")
		temp = true;
		
	}    
    function ovupdate(ov) {
    
    if(temp==true){
    temp = false;
    $(ov).attr("readonly", "readonly");
    //松开的时候调用接口进行修改删除   为空是删除
    //name值为一级栏目名字  value为删除的字段
     var menu= $(ov).attr("name");
   var value= $(ov).attr("value");
   var value2=$(ov).val();
   alert($(ov).attr("menu"))
	if($(ov).attr("menu")==1){
	if($(ov).val()==""||$(ov).val()==null){
	//删除
		$.ajax({ url: "menuajax_Onemenudelete.action",
		type:"post",
		dataType:"html",
		data: {"column":$(ov).attr("value"),"root":"2"},
		 });
	}else{
	alert($(ov).attr("value"))
	alert($(ov).val())
		$.ajax({ url: "menuajax_Onemenuupdate.action",
		type:"post",
		dataType:"html",
		data: {"column":$(ov).attr("value"),"newvalue":$(ov).val(),"root":"2"},
		
		 });
	
	}
	
	
	
	}else{	
    	if($(ov).val()==""||$(ov).attr("value")==null){
    		//删除
    		alert("删除")
    		$.ajax({ url: "menuajax_Onemenudelete.action",
		type:"post",
		dataType:"html",
		data: {"soncolumn":$(ov).attr("value"),"root":"3"},
		
		 });
    		
    	}else{
    		//修改
    	$.ajax({ url: "menuajax_Onemenuupdate.action",
		type:"post",
		dataType:"html",
		data: {"soncolumn":$(ov).attr("value"),"newvalue":$(ov).val(),"root":"3"},
		
		 });
    	}
    	
    	}
    	
    	
    	}
    	
    }
    
    function insert(ov){
    if(temp==true){
    	temp=false
       $(ov).attr("readonly", "readonly");
    //name值为一级栏目名字  value为增加的字段
   var menu= $(ov).attr("name");
   var value= $(ov).attr("value");
   var value2=$(ov).val();
   alert(menu)
   alert(value2)
   if(value2!=null||value2!=""){
   $.ajax({ url: "menuajax_Onemenuinsert.action",
		type:"post",
		data:{"column":$(ov).attr("name"),"soncolumn":$(ov).val(),"root":"3"},
		 });
   }

    }
    }
    
</script>
  
</html>
