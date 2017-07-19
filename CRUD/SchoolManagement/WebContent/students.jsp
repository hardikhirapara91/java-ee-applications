<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Students List : Student Management Application</title>
</head>
<body>
	<h3>Student Lists</h3>
	<br>
	<table border="1" width="50%" bgcolor="lightgreen">
		<tr>
			<td align="center">ID</td>
			<td>Full Name</td>
			<td>Last Name</td>
			<td>Date of Birth</td>
			<td>Email</td>
			<td colspan="2" align="center">Action</td>
		</tr>
		<c:forEach var="student" items="${students}">
		<tr>
			<td><c:out value="${student.id}"/></td>
			<td><c:out value="${student.firstName}"/></td>
			<td><c:out value="${student.lastName}"/></td>
			<td><c:out value="${student.dob}"/></td>
			<td><c:out value="${student.email}"/></td>
			
			<td>
				<a href="Student.do?action=update&id=${student.id}">Update</a>
			</td>
			<td>
				<a href="Student.do?action=delete&id=${student.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<a href="Student.do?action=add">Add New Student</a>
</body>
</html>