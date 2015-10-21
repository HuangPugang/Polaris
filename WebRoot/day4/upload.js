	function ajaxUpload() {
		$.ajaxFileUpload({
			secureuri : false, //是否启用安全提交,默认为false
			dataType : 'text', //服务器返回的格式,可以是json或xml等
			type : "POST",
			url : "Form/fileUpload.do" + "?versionName="
					+ $("#versionName").val() + "&apkSize="
					+ $("#apkSize").val(),
			fileElementId : 'file',
			error : function(data) {
				alert("失败");
				dismissDialog();
			},
			success : function(data) {
				alert("成功");
				dismissDialog();
			}
		});
	}