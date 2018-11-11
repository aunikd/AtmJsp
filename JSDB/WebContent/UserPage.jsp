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
<title>User Info</title>
</head>
<body>
<form action="TransactionServlet">
		<table>
			<tr>
				<td>User Name</td>
				<td><%= request.getAttribute("myname") %>.
			</tr>
			<tr>
				<td>Reg No</td>
				<td><%= request.getAttribute("myno") %>.
			</tr>
			<tr>
				<td>User Balance</td>
				<td><%= request.getAttribute("mybal") %>.
			</tr>
			
			<tr>
			<td><button onclick="myFunction()">Withdraw Money</button>
			</td>
			</tr>
		</table>
		
		<script>
function myFunction() {
    var amount = prompt("Please enter amount", "XXXX");
    
}
</script>
		
		
		
	</form>
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