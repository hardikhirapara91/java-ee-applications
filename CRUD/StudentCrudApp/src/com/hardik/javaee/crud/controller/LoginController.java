package com.hardik.javaee.crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hardik.javaee.crud.model.User;
import com.hardik.javaee.crud.service.StudentService;
import com.hardik.javaee.crud.service.StudentServiceImpl;
import com.hardik.javaee.crud.service.UserService;
import com.hardik.javaee.crud.service.UserServiceImpl;
import com.hardik.javaee.crud.util.StringUtils;

/**
 * Login Controller
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	private StudentService studentService = new StudentServiceImpl();

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(StringUtils.MD5(request.getParameter("password")));
		user = userService.login(user);

		if (user.getId() > 0) {
			session.setAttribute("user", user);
			session.setAttribute("students", studentService.getAllStudents());
			response.sendRedirect("home.jsp");
		} else {
			session.setAttribute("login_error", "Invalid Credentials...");
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
}
