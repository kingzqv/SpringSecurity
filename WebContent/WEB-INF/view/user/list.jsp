<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
</head>
<body>
user=<%=request.getAttribute("user")%><br/>
json=<%=request.getAttribute("json")%><br/>
	<table border="1" width="600">
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>状态</th>
			<th>角色</th>
			<th>是否删除</th>
			<th>是否修改</th>
		</tr>
		<c:forEach items="${user}" var="ls">
			<tr>
				<td align="center">${ls.id }</td>
				<td align="center">${ls.username }</td>
				<td align="center">${ls.password }</td>
				<td align="center">${ls.state }</td>
				<td align="center">
					<c:forEach items="${ls.roles}" var="rl">
						${rl.role }
					</c:forEach>
				</td>
				<td><a href="delete/${ls.id }">删除</a></td>
				<td><a href="update/${ls.id }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>