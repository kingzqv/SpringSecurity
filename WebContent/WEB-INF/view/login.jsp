<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
${error} ${msg}
<form method="post">
用户名:<input type="text" id="username" name="usr" /><br/>
密码:<input type="password" id="password" name="pwd" /><br/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="submit" id="submit" value="mylogin" />
</form>
</body>
</html>