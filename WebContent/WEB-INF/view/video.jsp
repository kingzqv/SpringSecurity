<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="charset" content="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

	<title>Video</title>
	
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
	video<p>
    ${path}<p>
    ${filelist[0]}<p>
	<!-- <div></div> --> <!-- /container -->
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getContextPath()%>/statics/jquery/jquery-3.3.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/statics/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
