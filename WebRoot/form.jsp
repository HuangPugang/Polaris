<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>用户信息</h1>
<form action="Form/add.do" method="post">
	账号：<input type="text"  name="username"/><br/>
	密码：<input type="text"  name="password"/><br/>
	<input type="submit" value="提交" />
</form>
<!-- 调用java方法 -->
Hello! The time is now <%= new java.util.Date() %> <br/>
${username1}


<TABLE BORDER=1> 
<% for ( int i = 0; i < 5; i++ ) { %> 
<TR> 
<TD>Number</TD> 
<TD><%= i+1 %></TD> 
</TR> 
<% } %> 

</TABLE> 
</body>
</html>