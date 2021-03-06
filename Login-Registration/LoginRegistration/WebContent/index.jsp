<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	String error = (String) session.getAttribute("error");
	if(error == null){error="";}
	session.invalidate();
%>

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
		<form class="form-signin" action="Login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
		  	<h3 class="error"><%= error %></h3>
		  	
		  	<label for="inputEmail" class="sr-only">Username</label>
		  	<input type="text" name="username" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
		  
		  	<label for="inputPassword" class="sr-only">Password</label>
		  	<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
		  	
		  	<div class="checkbox">
		    	<label><input type="checkbox" value="remember-me"> Remember me</label>
		  	</div>
		  	
		  	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		  	<br>
		  	<a class="btn btn-block" href="registration.jsp">Register</a>
		</form>
	</div> <!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  	<script src="js/ie10-viewport-bug-workaround.js"></script>
  	
</body>
</html>
