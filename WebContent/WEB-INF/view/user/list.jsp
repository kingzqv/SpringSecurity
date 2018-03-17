<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="charset" content="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

	<title>UserList</title>

	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/statics/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/statics/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/statics/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%-- <a href="<%=request.getContextPath()%>/statics/bootstrap/3.3.7/css/bootstrap.min.css">test</a><br /> --%>
	<%-- user=<%=request.getAttribute("user")%><br />  --%>
	<%-- json=<%=request.getAttribute("json")%><br /> --%>
	
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
				<td align="center"><c:forEach items="${ls.roles}" var="rl">
						${rl.role }
					</c:forEach></td>
				<td><a href="delete/${ls.id }">删除</a></td>
				<td><a href="update/${ls.id }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath()%>/statics/jquery/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/statics/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>