<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<h2>用户列表</h2>

	<table border="1">
		<tr>
			<!--      <td>photo</td> -->
			<td>id</td>
			<td>name</td>
			<td>age</td>
			<td>操作</td>
		</tr>


		<c:forEach items="${personList }" var="p">

			<tr>
				<%--  <td><img src="${pageContext.request.contextPath}"/></td> --%>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.age}</td>
				<td><a
					href="${pageContext.request.contextPath}/person/delete.do?delId=${p.id}">删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>
	${personList }
</body>
</html>
