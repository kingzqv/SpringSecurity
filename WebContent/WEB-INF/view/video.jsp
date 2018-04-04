<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="charset" content="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签，
	width 属性控制设备的宽度。假设您的网站将被带有不同屏幕分辨率的设备浏览，那么将它设置为 device-width 可以确保它能正确呈现在不同设备上。
	initial-scale=1.0 确保网页加载时，以 1:1 的比例呈现，不会有任何的缩放。
	在移动设备浏览器上，通过为 viewport meta 标签添加 user-scalable=no 可以禁用其缩放（zooming）功能。
	通常情况下，maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能后，用户只能滚动屏幕，就能让您的网站看上去更像原生应用的感觉
	-->
	
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
	<title>Video</title>
	
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/statics/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/statics/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/statics/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
	    function getFold(param) {
	    	var token = $("meta[name='_csrf']").attr("content");  
	        var header = $("meta[name='_csrf_header']").attr("content");  
	        $.ajaxSetup({   
	        	beforeSend: function (xhr) {  
	            	xhr.setRequestHeader(header, token);  
	            }  
	        }); 
	    	
	        $.ajax({
	        	url:"http://localhost:8080/SpringSecurity/video",
	        	type:"post",
	        	data:{path:param},
	            contentType:"application/x-www-form-urlencoded",
	            //contentType:"application/json;charset=utf-8",
	            dataType:"text",
	            success:function(result) {
	            	var obj = JSON.parse(result); //由JSON字符串转换为JSON对象
	            	$("#links").html(' ');
	            	$("#videos").html(' ');
	            	for (var i in obj) {
	            		switch(obj[i].type)
	            		{
	            		    case "fold":
	            		        var links = "<a class='fold' style='border:1px solid;margin: 0px 5px' href='javascript:void(0);'>" + obj[i].name + "</a>";
	            		        $("#links").append(links);
	            		        break;
	            		    case "mp4":
	            		    	var videos = "<a class='mp4' style='border:1px solid;margin: 0px 5px' href='javascript:void(0);'>" + obj[i].name + "</a>";
	            		    	$("#videos").append(videos);
	            		        break;
	            		    default:
	            		    	alert("type:"+obj[i].type);
	            		}
	            	}
	            	
	            	$("a.fold").click(function() {
	            		$("#path").val($("#path").val()+'\\'+$(this).html());
	            		getFold($("#path").val());
	    	        	//alert($(this).html());
	    			});
	    	        
	    	        $("a.mp4").click(function() {
	    	        	$("video").attr("src","statics"+$("#path").val()+"\\"+$(this).html());//更新url
	    	        	//alert($("video").attr("src"));
	    			});
	            },
	            error:function(){
	            	alert("error");
	            }
	        });
	        
	        
	    }
    </script>
</head>
<body>
	<div class="container">
		<h2>video</h2>
		<label>path:</label>
	    <input type="text" id="path" value="\fold">
	    <button id="gf">getFold</button>
	    <p>
	    
	    <label>link:</label>
	    <div class="row">
	    <div id="links" class="col-md-12"></div>
	    </div>
	    
	    <label>video:</label>
	    <div class="row">
	    <div id="videos" class="col-md-12"></div>
	    </div>
	    
	    <label>player:</label>
		<div id="player">
			<video width="320" height="240" controls="controls"> 
				<!-- <source src="movie.ogg" type="video/ogg">  -->
				<source src="movie.mp4"	type="video/mp4"> 
				您的浏览器不支持 video 标签。 
			</video>
		</div>
	</div> <!-- /container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getContextPath()%>/statics/jquery/jquery-3.3.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/statics/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	  $("#gf").click(function(event) {
	    var param = $("#path").val();
	    //alert(param);
		getFold(param);
	  });
	</script>
</body>
</html>
