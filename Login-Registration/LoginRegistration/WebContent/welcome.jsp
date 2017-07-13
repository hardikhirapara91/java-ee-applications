<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.hardik.javaee.bean.User" %>
<% User user = (User) session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JavaEE Login Application</title>
	
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link href="css/signin.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
	  	<h2>User Data</h2>
	  	<p><a href="Logout" style="text-decoration:none;">Logout</a></p>            
	  	
	  	<% if(user != null){ %>
	  	<table class="table table-hover">
		    <tbody>
		    	<tr>
					<td>ID</td>
					<td><%= user.getId() %></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><%= user.getUsername() %></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><%= user.getFirstName() %></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><%= user.getLastName() %></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><%= user.getEmail() %></td>
				</tr>
			</tbody>
		</table>
		<% } else { response.sendRedirect("Login"); } %>
	</div>
</body>
</html>