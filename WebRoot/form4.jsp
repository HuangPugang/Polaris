<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<h1>用户信息</h1>
<form action="Form/add4.do" method="post">
	账号：<input type="text"  name="username"/><br/>
	密码：<input type="text"  name="password"/><br/>
	<input type="submit" value="提交" />
	
	${userId}----${userName}
</form>
</body>
</html>