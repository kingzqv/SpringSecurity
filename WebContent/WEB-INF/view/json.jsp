<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<title>json</title>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getContextPath()%>/statics/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div>
		<label>ID:</label>
		<input type="text" id="id" name="id">
		<label>ROLE:</label>
		<input type="text" id="role" name="role">
		<label>NOTE:</label>
		<input type="text" id="note" name="note">
	</div>
	<br>
	<button onclick="sendJson()">json数据交互测试</button>
	<script type="text/javascript">
	    function sendJson() {
	    	var token = $("meta[name='_csrf']").attr("content");  
	        var header = $("meta[name='_csrf_header']").attr("content");  
	        $.ajaxSetup({   
	        	beforeSend: function (xhr) {  
	            	xhr.setRequestHeader(header, token);  
	            }  
	        }); 
	    	
	    	var para = { 
	    			"id": $("#id").val(), 
	    			"role": $("#role").val(), 
	    			"note":$("#note").val()
	    	};
	    	
	        $.ajax({
	        	url:"http://localhost:8080/SpringSecurity/json",
	        	type:"post",
	            data:JSON.stringify(para),
	            contentType:"application/json;charset=utf-8",
	            dataType:"json",
	            success:function(result) {
	                alert("id:"+result.id + ",role:" + result.role+",note:"+result.note);
	            },
	            error:function(){
	            	alert("error");
	            }
	        });
	    }
	</script>
</body>
</html>