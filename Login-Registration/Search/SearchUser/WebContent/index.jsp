<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
    <meta name="description" content="JavaEE Login Application">
    <meta name="author" content="Hardik Hirapara">
    <link rel="icon" href="img/favicon.ico">

    <title>JavaEE Login Application</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<form class="form-signin" action="Search" method="post">
			<h2 class="form-signin-heading">Search User</h2>
		  	<label for="inputEmail" class="sr-only">Search User:</label>
		  	<input type="text" name="username" class="form-control" placeholder="First-Last Name, Username or Email" value="${searchString}" required autofocus><br>
		  	<button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
		</form>
	</div> <!-- /container -->
	
	<!-- Search Results -->
	<div class="container">
  		<h2>Search Results</h2>
              
  		<table class="table table-striped">
	    	<thead>
	      		<tr>
	        		<th>ID</th>
	        		<th>Username</th>
	        		<th>First Name</th>
	        		<th>Last Name</th>
	        		<th>Email</th>
	      		</tr>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${users}" var="user">
	      		<tr>
	        		<td>${user.id}</td>
	        		<td>${user.username}</td>
	        		<td>${user.firstName}</td>
	        		<td>${user.lastName}</td>
	        		<td>${user.email}</td>
	      		</tr>
	      		</c:forEach>
	    	</tbody>
		</table>
	</div>
	<% session.invalidate(); %>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  	<script src="js/ie10-viewport-bug-workaround.js"></script>
  	
</body>
</html>
