<%@page language="java" pageEncoding="utf-8" %>
<!-- 引入jstl核心标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>显示用户信息</title>
	<style type="text/css">
		table,td{
			border: 1px solid;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<table>
		<thead><tr>
			<td>id</td><td>姓名</td><td>日期</td><th>工资</th>		
		</tr></thead>
		<tbody>
		<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.userId}</td><td>${user.userName}</td><td>${user.userBirthday}</td><td>${user.userSalary}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>