<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String loginError = (String) session.getAttribute("login_error");
	if(loginError==null) {loginError="";}
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student CRUD Application:: Login/Registration</title>
	
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
		    
		    <!-- Login -->
	    	<form class="login-form" action="Login" method="post">
	    		<div class="form-heading">Login</div>
	    		<div style="color:red;"><%= loginError %></div>
	      		<input type="text" name="username" placeholder="Username" required="required" autofocus="autofocus"/>
	      		<input type="password" name="password" placeholder="Password" required="required"/>
	      		<button type="submit">login</button>
	      		<p class="message">Not registered? <a href="#">Create an account</a></p>
	    	</form>
	    	
		    <!-- Registration -->
		    <form class="register-form" action="Register" method="post">
		    	<div class="form-heading">Register</div>
				<input type="text" placeholder="name"/>
		      	<input type="password" placeholder="password"/>
		      	<input type="text" placeholder="email address"/>
		      	<button>create</button>
		      	<p class="message">Already registered? <a href="#">Sign In</a></p>
		    </form>
	  	</div>
	</div>
	
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/script.js"></script>
</body>
</html>