<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'easy_first.jsp' starting page</title>
    
		<title>Basic Calendar - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/demo.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="day2/index.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>


  </head>
  
  <body>
    <div id="box" class="easyui-dialog" title="我是标题" style="width: 200px;height: 200px" >
    内容部分
    </div>
	<!-- js调用 -->
    <!-- <div id="box"  title="我是标题" style="width: 200px;height: 200px" > -->
    </div>
  </body>
</html>
