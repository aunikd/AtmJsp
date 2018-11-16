<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="bg">
	<center><div class="col-md-6" style="float:left; ">
	
	<form action="RegistrationServlet" method="post">
	<h5><a href="Home.jsp">Home</a></h5>
	<h1 style="color: white">Registration Form</h1>
	<table style="text-align: center;">
			<tr>
				<th>Atm Number  <i class="far fa-user"></i> : </th>
				<td><input type="text" class="form-control form-rounded" name="rno" maxlength="20" placeholder="Enter Card Number" required autofocus="autofocus"></td>
			</tr>
            
            <tr>
				<th>User Name  <i class="far fa-user"></i> : </th>
				<td><input type="text" class="form-control form-rounded" name="fname" maxlength="20" placeholder="Enter User Name" required autofocus="autofocus"></td>
			</tr>
			
			
			<tr>
				<th>Password  <i class="fas fa-lock-open"></i> : </th>
				<td><input type="password" class="form-control form-rounded" name="pass" minlength="8" maxlength="20" placeholder="Minimum 8 characters" required></td>
			</tr>
			<tr>
				<th>Balance : </th>
				<td><input type="number" class="form-control form-rounded" name="bal" placeholder="Minimum 1000" min="1000" max="10000" step="100" required></td>
			</tr>
			<tr>
				<th>City <i class="fas fa-city"></i> : </th>
				<td><select class="form-control form-rounded" name="acctype"required >
					<option value="Savings">Savings</option>
					<option value="Current">Current</option>
					
				</select></td> 
			</tr>
	</table>
		<input type="submit" name="submit" class="btn btn-success" style="border-radius: 10px; box-shadow: 0px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="reset" name="reset" class="btn btn-danger" style="border-radius: 10px; box-shadow: 0px;">
	</form>	
	<h6>Already a user? <a href="Login.jsp">Click Here!</a> to login</h6>
	</div>
</body>
</html>