<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddUser</title>
</head>
<body>
	<sf:form method="post" modelAttribute="user">
		<table width="700" align="center" border="1">
			<tr>
				<td>用户名:</td>
				<td><sf:input path="username" />
					<sf:errors path="username" />
				</td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td><sf:password path="password" />
					<sf:errors path="password" />
				</td>
			</tr>
			<tr>
				<td>用户状态:</td>
				<td>
					<sf:input path="state" />
					<sf:errors path="state" />
				</td>
			</tr>
			<tr>
				<td>用户角色:</td>
				<td>
					<c:forEach varStatus="s" items="${roleList}" var="rl">
						<input type="checkbox" name="rs" value="${rl.role}" 
						<c:if test="${user.roles.contains(rl)}">checked</c:if>
						/>${rl.role}<br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>错误信息:</td>
				<td><sf:errors path="*" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="用户添加" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="../">back</a></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>