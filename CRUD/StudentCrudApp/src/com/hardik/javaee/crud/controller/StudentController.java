package com.hardik.javaee.crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hardik.javaee.crud.model.Student;
import com.hardik.javaee.crud.service.StudentService;
import com.hardik.javaee.crud.service.StudentServiceImpl;

/**
 * Student Controller Servlet
 */
@WebServlet("/Student")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService studentService = new StudentServiceImpl();

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("add")) {
			response.sendRedirect("add_student.jsp");
		}
		if (action.equalsIgnoreCase("delete")) {
			String rlno = request.getParameter("id");
			if (rlno != null && !rlno.isEmpty()) {
				if (studentService.delete(Integer.parseInt(rlno))) {
					System.out.println("Student Deleted Successfully");
				} else {
					System.out.println("Error while deleting student.");
				}
			}
			session.setAttribute("students", studentService.getAllStudents());
			response.sendRedirect("home.jsp");
		}
	}

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String rlno = request.getParameter("rlno");

		Student student = new Student();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setStandard(request.getParameter("standard"));
		student.setDivision(request.getParameter("division"));
		student.setEmail(request.getParameter("email"));

		if (rlno != null && !rlno.isEmpty()) {
			student.setRlno(Integer.parseInt(rlno));
			if (studentService.update(student)) {
				session.setAttribute("result", "success");
				session.setAttribute("students", studentService.getAllStudents());
			} else {
				session.setAttribute("result", "failed");
			}
			response.sendRedirect("update_student.jsp?id=" + rlno + "&action=update");
		} else {
			Integer lastInsertedId = studentService.save(student);
			if (lastInsertedId > 0) {
				session.setAttribute("result", "success");
				session.setAttribute("students", studentService.getAllStudents());
			} else {
				session.setAttribute("result", "failed");
			}
			response.sendRedirect("add_student.jsp");
		}

	}

}
