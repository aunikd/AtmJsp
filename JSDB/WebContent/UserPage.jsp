<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style type="text/css">
		body {
		    /* The image used */
		    background-image: url("image.jpg"); 
		    
		    /* Full height */
		    height: 100%; 
		
		    /* Center and scale the image nicely */
		    background-repeat: no-repeat;
		    background-size: cover;
		    
		    padding: 150px;
		    
		    padding-left: 150px;
		}
	</style>
</head>
<body>
	<div class="bg">
	<form action="TransactionServlet">
		<table style="text-align: center;">
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
			<td>Withdraw Money<input type="number" name="amount" placeholder="Enter Amount">
			<input type="hidden" name="mytno" value=<%=request.getAttribute("myno") %>>
			</td>
			<input type="submit" value="withdraw">
			</tr>
			</table><br>
			<%-- 
			<% request.setAttribute("mytno",request.getAttribute("myno"));
			RequestDispatcher rd = request.getRequestDispatcher("TransactionServlet");
			
			rd.forward(request, response); %> --%>
			
			
<!-- 			<input type="submit" name="withdraw" value="withdraw" class="btn btn-success" style="border-radius: 10px; box-shadow: 0px; margin-left: 100px;">
 -->	
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