<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/demo.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="day2/index.js"></script>
	<script type="text/javascript" src="easyui/easyui-lang0zh_CN.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

  </head>
  
  <body>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="Register" style="width:400px;padding:30px 60px">
		<div style="margin-bottom:20px">
			<div>Email:</div>
			<input class="easyui-textbox" data-options="prompt:'Enter a email address...',validType:'email'" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<div>First Name:</div>
			<input class="easyui-textbox" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<div>Last Name:</div>
			<input class="easyui-textbox" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<div>Company:</div>
			<input class="easyui-textbox" style="width:100%;height:32px">
		</div>
		
		<div>
			<a href="#add.do" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">Register</a>
		</div>
	</div>
	
	  <form action="Form/add2.do" id="ff" method="post">  
    <div>  
        <label for="name">Name:</label>  
        <input class="easyui-textbox" type="text" name="name" data-options="required:true" />  
    </div>  
    <div>  
        <label for="email">Email:</label>  
        <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />  
    </div>
    
    <input type="submit" value="Ìá½»"/>
</form> 
  </body>
</html>
