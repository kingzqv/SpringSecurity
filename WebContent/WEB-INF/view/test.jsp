<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
    <sf:form modelAttribute="user" method="post">
        用户名:<sf:input path="username"/><sf:errors path="username"/>
        <br>
        密码:<sf:input path="password"/><sf:errors path="password"/>
        <br>
        <input type="submit" value="提交">
    </sf:form>
</body>
</html>