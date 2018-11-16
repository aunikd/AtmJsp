<%@page import="com.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
	<style type="text/css">
		body {
		height: 100%;
		color: black;
	}
	</style>
</head>
<body>
<div class="bg" style="padding-left: 220px;">

<c:if test="${requestScope.display !=null and
 not empty requestScope.display}">
 <h1 style="padding-left: 300px;">All Users</h1><br>
<table border="4" cellpadding="3">
	<tr>
		<td>ATM number</td>
		<td>User Name</td>	
		<td>Password</td>
		<td>Balance</td>
		<td>Account Type</td>
	</tr>
	<c:forEach items="${requestScope.display}" var="e"> 		
	<tr>
		<td>${e.rno}</td>
		<td>${e.fname}</td>
		<td>${e.pass}</td>
		<td>${e.balance}</td>
		<td>${e.acctype}</td>
	</tr>
	</c:forEach>
</table>
<h4><a href="Home.jsp">Home</a></h4>
</c:if>

<%--
<table border="1" cellpadding="3">
<tr>
		<td>User Name</td>
		<td>Email</td>
		<td>Mobile Number</td>
		<td>Gender</td>
		<td>Account Type</td>
		<td>Password</td>
		<td>Balance</td>
</tr>
<%
Object o=request.getAttribute("usrList");
List l=(List)o;
	Iterator<User> itr=l.iterator();
	while(itr.hasNext())
	{
		User r=itr.next();%>
		<tr>
		<td><% r.getUname(); %></td>
		<td><% r.getEmail(); %></td>
		<td><% r.getNumber(); %></td>
		<td><% r.getGender(); %></td>
		<td><% r.getAcctype(); %></td>
		<td><% r.getPass(); %></td>
		<td><% r.getBalance(); %></td>
		</tr>
		</table>
		<%
	}
%>
 --%>
</div>
</body>
</html>