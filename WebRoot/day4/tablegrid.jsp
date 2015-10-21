<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../easyui/demo.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Basic DataGrid</h2>
	<div style="margin:20px 0;"></div>

	<table class="easyui-datagrid" title="Basic DataGrid"
		style="width:700px;height:250px"
		data-options="singleSelect:true,collapsible:true,url:'../Form/getJson.do',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:80">ID</th>
				<th data-options="field:'name',width:100">姓名</th>
				<th data-options="field:'age',width:60,align:'center'">年龄</th>
			</tr>
		</thead>
	</table>

</body>
</html>