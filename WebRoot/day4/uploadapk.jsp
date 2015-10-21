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
<script type="text/javascript" src="day4/dialog.js"></script>
<script type="text/javascript" src="day4/upload.js"></script>
<!-- 异步 -->
<script type="text/javascript">
	
</script>

</head>

<body>
	<div style="margin:20px 0;"></div>

	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="showDilog()">添加</a>

	<div id="dlg" class="easyui-dialog" title="添加文件" closed="true"
		style="width:400px;height:300px;padding:10px" data-options="
				buttons: [{
					text:'上传',
					iconCls:'icon-ok',
					handler:function(){
						ajaxUpload();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						dismissDialog();
					}
				}]
			" >
		<div style="margin-bottom:20px">
			<div>版本号:</div>
			<input id="versionName" name="versionName" class="easyui-textbox"
				style="width:100%">
		</div>
		<div style="margin-bottom:20px">
			<div>大小:</div>
			<input id="apkSize" name="apkSize" class="easyui-textbox"
				style="width:100%">
		</div>
		<div style="margin-bottom:20px">
			<div>选择要上传的apk:</div>
			<input id="file" type="file" name="file" style="width:100%">
		</div>
		
	</div>
</body>
</html>
