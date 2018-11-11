<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<link rel="stylesheet" type="text/css" href="Style.css">

<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div id="main" align="center">
<h1 class="bg-primary">Enter your registration details below</h1>
<form action="LoginServlet">
<input type="text" name="rno" placeholder="Enter Registration Number">
<br>
<input type="text" name="pass" placeholder="Enter Password">
<br>
<input type="submit" value="Login">
<a href="ForgotPass.jsp" class="btn btn-info">Forgot Password?</a><br>
<>
</form>
</div>
	<%!String str=null; %>
	<%
		if(!session.isNew())
		{
			str=(String)session.getAttribute("msg");
			out.print(str);
			session.invalidate();
		}
	%>
</body>
</html>