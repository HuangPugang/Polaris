<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="${pageContext.request.contextPath}/ui/jjn/js/clock.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/ui/jjn/js/jquery.autocomplete.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/jjn/css/jquery.autocomplete.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ui/jjn/js/datagrid-groupview.js"></script>
  
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/ui/jjn/js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/ui/jjn/js/easyui-lang-zh_CN.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/ui/jjn/themes/icon.css" type="text/css"></link>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/ui/jjn/themes/metro-blue/easyui.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/jjn/js/jquery-1.8.3.min.js"></script>

  </head>
  	<style type="text/css">
			
		ul{
			list-style:none;
		}
		a{
			width: 300px;
			height: 50px;
			font-size: 18px;
		}
		span{
		font-size: 25px;
		
		}
	</style>
  <body style="background-image: url('ui/jjn/images/images(11).jpg');">
 	<ul style="margin-left:900px; margin-top: 100px;">
 		<li><a href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="window.location.href='http://192.168.1.103:8080/KingHIS/LogIn.jsp';"><span>花都医疗门诊模块<br>黄强</span></a></li>
 		<li>&nbsp;</li>
 		<li><a href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="window.location.href='http://192.168.1.98:8080/His_System/LogIn.jsp';"><span>花都医疗医生手术模块<br>李江</span></a></li>
 		<li>&nbsp;</li>
 		<li><a href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="window.location.href='http://192.168.1.123:8080/His_System/ui/hy/login/LogIn.jsp';"><span>花都医疗药库模块<br>胡毅</span></a></li>
 		<li>&nbsp;</li>
 		<li><a href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="window.location.href='http://192.168.1.222:8080/HIS/ui/zh/LoginIn.jsp';"><span>花都医疗护士模块<br>张豪</span></a></li>
 		
 	
 		<li>&nbsp;</li>
 		<li><a href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="window.location.href='http://192.168.1.111:8080/HIS/LogIn.jsp';"><span>花都医疗住院模块<br>江继南</span></a></li>
 		<li>&nbsp;</li>
 	</ul>
  </body>
</html>
