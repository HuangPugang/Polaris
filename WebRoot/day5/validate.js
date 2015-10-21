	function validate() {
		$.ajaxFileUpload({
			secureuri : false, //是否启用安全提交,默认为false
			dataType : 'text', //服务器返回的格式,可以是json或xml等
			type : "POST",
			url : "Demo/validateName.do" + "?username="
					+ $("#username").val() + "&password="
					+ $("#password").val(),
			error : function(data) {
				alert("请求失败!");
			},
			success : function(data) {
				alert("成功!");
			}
		});
	}