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
   <div style="margin:10px 0 20px 0">
        <span>Select Icon Align: </span>
        <select onchange="$('#tt').textbox({iconAlign:this.value})">
            <option value="right">Right</option>
            <option value="left">Left</option>
        </select>
        
        <input id="tt" class="easyui-textbox" style="width:400px" data-options="
			prompt: 'Input something here!',
			iconWidth: 22,
			icons: [{
				iconCls:'icon-add',
				handler: function(e){
					$(e.data.target).textbox('setValue', 'Something added!');
				}
			},{
				iconCls:'icon-remove',
				handler: function(e){
					$(e.data.target).textbox('clear');
				}
			},{
				iconCls:'icon-search',
				handler: function(e){
					var v = $(e.data.target).textbox('getValue');
					alert('The inputed value is ' + (v ? v : 'empty'));
				}
			}]
			">
    </div>
  </body>
</html>
