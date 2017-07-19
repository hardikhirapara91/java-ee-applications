package com.hardik.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hardik.bean.Student;
import com.hardik.dao.StudentDao;
import com.hardik.dao.StudentDaoImpl;
import com.hardik.util.DBConnection;
import com.hardik.util.DateUtil;

/**
 * Student Controller
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String VIEW_STUDENTS = "students.jsp";
	private final String ADD_UPDATE = "student.jsp";

	private StudentDao studentDao = null;

	public StudentController() {
		studentDao = new StudentDaoImpl();
	}

	/**
	 * GET
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		String action = request.getParameter("action");
		String view = VIEW_STUDENTS;

		if (action != null && action.equalsIgnoreCase("add")) {
			session.removeAttribute("student");
			view = ADD_UPDATE;
		} else if (action != null && action.equalsIgnoreCase("update")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Student student = studentDao.getStudentById(id);
			session.setAttribute("student", student);
			view = ADD_UPDATE;
		} else if (action != null && action.equalsIgnoreCase("delete")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			studentDao.deleteStudent(id);
			session.setAttribute("students", studentDao.getStudents());
			view = VIEW_STUDENTS;
		} else if (action != null && action.equalsIgnoreCase("deleteall")) {
			System.out.println("delete-all");
		} else if (action == null || action.equalsIgnoreCase("")) {
			List<Student> students = studentDao.getStudents();
			session.setAttribute("students", students);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * POST
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = null;

		Student student = new Student();
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setEmail(request.getParameter("email"));
		student.setDob(DateUtil.convertStringToDate(request.getParameter("dob")));

		String id = request.getParameter("id");

		if (id == null) {

			if (studentDao.addStudent(student)) {
				out.println("<font color='green'>Student registread sucessfully.</font>");
			} else {
				out.println("<font color='red'>Student is not added.</font>");
			}

			dispatcher = request.getRequestDispatcher(ADD_UPDATE);

		} else {
			student.setId(Integer.parseInt(id));
			if (!studentDao.updateStudent(student)) {
				System.out.println("Student not updated.");
			}

			session.setAttribute("students", studentDao.getStudents());
			dispatcher = request.getRequestDispatcher(VIEW_STUDENTS);
		}

		dispatcher.include(request, response);
	}

	@Override
	public void destroy() {
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			DBConnection.releaseConnection();
			System.out.println("Connection closed successfully.");
		}
		super.destroy();
	}
}
