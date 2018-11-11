<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Registration</title>
</head>
<body>

<div id="main" align="center">
<h1 class="bg-primary">Enter your registration details below</h1>
<br>
<form action="RegistrationServlet" method="post">

<input type="text" name="rno" class="form-control" placeholder="Enter Registration Number" required>
<br>

<input type="text" name="fname" class="form-control" placeholder="Enter First Name" required>
<br>


<input type="password" name="pass" class="form-control" placeholder="Enter Password" required>
<br>


<input type="text" name="bal" class="form-control" placeholder="Enter Account Balance" required>
<br><br>

<input type="submit" value="Register" >

</form>
</div>
</body>
</html>