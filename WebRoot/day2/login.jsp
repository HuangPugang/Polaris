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
   <h2>Custom TextBox</h2>
	<p>This example shows how to custom a login form.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Login to system" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:10px">
			<input name="name" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>¼Ç×¡ÃÜÂë</span>
		</div>
		<div>
			<a href="Form/add2.do" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
				<span style="font-size:14px;">Login</span>
			</a>
		</div>
	</div>
  </body>
</html>
