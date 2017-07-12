<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JavaEE Login Application</title>
</head>
<body>
	<h1>JavaEE Login Application</h1>
	
	<form action="login" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" required/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
