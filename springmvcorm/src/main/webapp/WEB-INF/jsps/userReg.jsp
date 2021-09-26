<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#id").change(function() {
		$.ajax({
			
				url:'validateEmail',
				data:{id:$("#id").val()},
				success:function(responseText){
					$("#errorMessage").text(responseText);
					if(responseText!=""){
						$("#id").focus();
					}
				}
		});
		});
	});
</script>
</head>
<body>
	<form action="registerUser" method="post">
		<pre>
Id: <input type="text" name="id" id="id" /><span id="errorMessage"></span>
Name: <input type="text" name="name" />
Email: <input type="text" name="email" />
<input type="submit" name="register" />
</pre>

	</form>
	</br> ${result }

</body>
</html>