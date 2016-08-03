<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
 商品列表：
<table width="100%" border=1>
<tr>
	<td>姓名</td>
	<td>密码</td>
	<td>性别</td>
	<td>操作</td>
</tr>
<c:forEach items="${userList }" var="user">
<tr>
	<td>${user.username }</td>
	<td>${user.password }</td>
	<td>${user.sex }</td>
	<td><a href="${pageContext.request.contextPath }/ ?id=${user.username}">修改</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>