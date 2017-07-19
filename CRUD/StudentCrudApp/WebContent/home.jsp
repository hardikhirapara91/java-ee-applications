<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.hardik.javaee.crud.model.User"%>
<c:choose>
	<c:when test="${user eq null}">
		<%
			response.sendRedirect("Logout");
		%>
	</c:when>
	<c:otherwise>

		<!DOCTYPE html>
		<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>Student CRUD Application:: Dashboard</title>
<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin.css" rel="stylesheet">
</head>
<body id="page-top">

	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar static-top navbar-toggleable-md navbar-inverse bg-inverse">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarExample"
			aria-controls="navbarExample" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="sidebar-nav navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
						class="fa fa-fw fa-dashboard"></i> Dashboard</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i
						class="fa fa-fw fa-area-chart"></i> Students</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="Logout"><i
						class="fa fa-fw fa-sign-out"></i> Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="content-wrapper py-3">

		<div class="container-fluid">
			<div class="row">

				<div class="col-lg-8">

					<!-- Card Columns Example Social Feed -->
					<div class="card-columns">

						<!-- Example Social Card -->
						<div class="card mb-3">
							<hr class="my-0">
							<div class="card-block small bg-faded">
								<div class="media">
									<img class="d-flex mr-3" src="http://placehold.it/45x45" alt="">
									<div class="media-body">
										<h6 class="mt-0 mb-1">
											<a href="#">${user.getFirstName()} ${user.getLastName()}</a>
										</h6>
										<div>
											<span style="font-weight: bold;">ID:</span>
											${user.getId()}</div>
										<div>
											<span style="font-weight: bold;">USERNAME:</span>
											${user.getUsername()}</div>
										<div>
											<span style="font-weight: bold;">EMAIL:</span>
											${user.getEmail()}</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Example Tables Card -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Students List
					<span style="float:right;"><a href="Student?action=add">Add New Student</a></span>
					
				</div>
				<div class="card-block">
					<div class="table-responsive">
						<table class="table table-bordered" width="100%" id="dataTable"
							cellspacing="0">
							<thead>
								<tr>
									<th>ID</th>
									<th>Full Name</th>
									<th>Standard</th>
									<th>Division</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>ID</th>
									<th>Full Name</th>
									<th>Standard</th>
									<th>Division</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${students}" var="student">
								<tr>
									<td>${student.getRlno()}</td>
									<td>${student.getFirstName()} ${student.getLastName()}</td>
									<td>${student.getStandard()}</td>
									<td>${student.getDivision()}</td>
									<td>${student.getEmail()}</td>
									<td><a href="update_student.jsp?id=${student.getRlno()}&action=update">Update</a> - <a href="Student?id=${student.getRlno()}&action=delete">Delete</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-chevron-up"></i>
	</a>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/tether/tether.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/sb-admin.min.js"></script>

</body>
</html>

	</c:otherwise>
</c:choose>
