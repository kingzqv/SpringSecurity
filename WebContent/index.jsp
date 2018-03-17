<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>username : <sec:authentication property="name"/></h2>
<h2><a href="hello">Hello World</a></h2>
<h2><a href="spring">Spring</a></h2>
<h2><a href="json">Json</a></h2>
<h2><a href="error">error test</a></h2>
<h2><a href="user/list">User List</a></h2>
<h2><a href="user/add">User Add</a></h2>
<h2><a href="video">Video</a></h2>
<form action="logout" method="post">
<input type="submit" value="Logout" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
