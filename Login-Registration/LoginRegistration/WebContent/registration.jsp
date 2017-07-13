<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.hardik.javaee.bean.User"%>
<%
	String error = (String) session.getAttribute("error");
	if(error == null){error="";}
		
	User user = (User) session.getAttribute("user");
	if(user == null){
		user = new User("","","","");
	}
	session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
	<title>Register</title>
	<link rel="icon" href="img/favicon.ico">
	
	<!-- Website CSS style -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/register.css">

	<!-- Website Font style -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
	
	<!-- External JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>	
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
               <div class="panel-title text-center">
               		<h1 class="title">Registration</h1>
               		<hr />
               		<h3 style="font-size:15px;color:red;"><%= error %></h3>
               		<div id="availibility" style="font-size:15px;"></div>
               	</div>
            </div>
            
            <!-- Registration Form --> 
			<div class="main-login main-center" id="regForm">
				<form class="form-horizontal" id="form" method="post" action="Registration">
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">First Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control" name="firstName" id="name"  placeholder="Enter your First Name" value="<%= user.getFirstName() %>" required autofocus/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Last Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control" name="lastName" id="name"  placeholder="Enter your Last Name" value="<%= user.getLastName() %>" required/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your Email</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
								<input type="email" class="form-control" name="email" id="email"  placeholder="Enter your Email" value="<%= user.getEmail() %>" required/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
								<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username" value="<%= user.getUsername() %>" required/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password" required/>
							</div>
						</div>
					</div>
					<div class="form-group ">
						<button type="submit" id="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
					</div>
					<div class="login-register">
			            <a href="index.jsp">Login</a>
			         </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>