<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ͼƬ�ϴ�Ԥ��</title>
<script>
	function PreviewImage(imgFile) {
		var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
		if (!pattern.test(imgFile.value)) {
			alert("ϵͳ��֧��jpg/jpeg/png/gif/bmp��ʽ����Ƭ��");
			imgFile.focus();
		} else {
			var path;
			if (document.all)//IE 
			{
				imgFile.select();
				path = document.selection.createRange().text;
				document.getElementById("imgPreview").innerHTML = "";
				document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
						+ path + "\")";//ʹ���˾�Ч�� 
			} else//FF 
			{
				path = URL.createObjectURL(imgFile.files[0]);
				document.getElementById("imgPreview").innerHTML = "<img src='"+path+"' style='width:100px; height:100px;'/>";
			}
		}
	}
</script>
</head>
<body>
	<center>
		<input type="file" onchange='PreviewImage(this)' />
		<div id="imgPreview" style='width:100px; height:100px;'>
			<img src=""  />
		</div>
	</center>
</body>
</html>
