<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Student : Student Management Application</title>
</head>
<body>
	<h3>Student Registration</h3>
	<br>
	
	<form action="Student.do" method="post" style="border:1px solid lightgreen;width:50%;">
		<table>
			<c:if test="${not empty student}">
			<tr>
				<td>Student Id</td>
				<td>
					<span>${student.id}</span>
					<input type="hidden" name="id" value="${student.id}"></td>
			</tr>
			</c:if>		
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" value="${student.firstName}" required autofocus></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"  value="${student.lastName}" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email"  value="${student.email}" required></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob"  value="${student.dob}" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<c:choose>
						<c:when test="${not empty student}">
							<input type="submit" value="Update">
						</c:when>
						<c:otherwise>
							<input type="submit">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form>
	<br>
	<a href="Student.do">View All Students</a>
</body>
</html>