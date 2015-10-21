<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'uploadapk.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<scirpt type="text/javascript" src="day5/validate.js"></scirpt>


</head>
<form id="brandAddForm" method="post" enctype="multipart/form-data">
      <table cellpadding="5">
        <tr>
          <td>用户名:</td>
          <td><input class="easyui-textbox" type="text" id="username" name="username" data-options="required:true" style="width:200px"></input></td>
        </tr>
        <tr>
        <tr>
         <tr>
          <td>密码:</td>
          <td><input class="easyui-textbox" type="password" id="password" name="password" data-options="required:true" style="width:200px"></input></td>
        </tr>
      </table>
		<input action="Form/add.do"type="submit" value="提交"  />
    </form>
<body>
	
</body>
</html>
