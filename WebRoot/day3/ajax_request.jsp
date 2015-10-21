<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ajax_request.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- 同步 -->
<script type="text/javascript">
	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET",
<%=basePath%>
	+ "/Form/ajax.do", true);
		xmlhttp.send();

	}
</script>
<!-- 异步 -->
<script type="text/javascript">
	function ajaxTest() {
		$.ajax({
			data : "name=" + $("#name").val(),
			type : "POST",
			url : "Form/ajaxtest.do",
			error : function(data) {
				alert("出错了！！:" + data);
			},
			success : function(data) {
				alert("success:成功了" + data);
				$("#result").innerHtml(data);
			}
		});
	}
</script>
<script type="text/javascript">
	function setshow() {

		$.ajax({
			type : "POST",
			url : "Form/ajaxtest3.do",
			data : "name=" + $("#name").val(),
			dataType : "json",
			success : function(data) {
				window.location.href = "day1/login_success.jsp";
				alert(data.success);
			},
			error : function() {
				alert("网络连接出错！");
			}
		});
	}
</script>

<script>
	var str;
	function aa() {
		str = document.getElementById("pswd").value;//把文本框值赋值给变量str
		alert(str);
	}
</script>
</head>
<body>
	<input type="text" name="name" id="name" />
	<input type="submit" value="登录" onclick="setshow();" />
	<input type="text" name="pswd" id="pswd" />
	<input type="submit" value="显示" onclick="aa();" />
	<div id="result"></div>
</body>
</html>
