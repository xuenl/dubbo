<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="zh-CN">
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户列表</title>
	 <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		 用户列表：
		 <div class="table-responsive">
			<table class="table table-hover table-bordered">
					<thead>
		                <tr>
		                    <th>姓名</th>
		                    <th>密码</th>
		                    <th>性别</th>
		                    <th>操作</th>
		                </tr>
		            </thead>
		            <tbody>
						<c:forEach items="${userList }" var="user">
						<tr>
							<td>${user.username }</td>
							<td>${user.password }</td>
							<td>${user.sex }</td>
							<td><a href="<%=request.getContextPath() %>/ ?id=${user.username}">修改</a></td>
						</tr>
						</c:forEach>
					</tbody>
			</table>
		</div>
		<ul class="pagination pagination-centered">
			  <li><a href="#">&laquo;</a></li>
			  <c:forEach items="${userList }" varStatus="status">
			  	<li><a href="#">
			  	${status.count } 
			  	</a></li>
			  </c:forEach>
			  <li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>
</body>
</html>