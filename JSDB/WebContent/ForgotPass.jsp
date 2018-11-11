<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="ForgotServlet" method="post">
        <h2 class="text-center">Forgot password</h2>       
        <div class="form-group">
            <input type="text" class="form-control" name="rno" placeholder="Enter RNO" required="required">
        </div>
        <%= request.getAttribute("mypass") %>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Send</button>
        </div>
    </form>
</body>
</html>