package com.hardik.javaee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hardik.javaee.bean.User;
import com.hardik.javaee.dao.UserDao;
import com.hardik.javaee.dao.UserDaoImpl;

/**
 * Registration Servlet
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));

		UserDao userDao = new UserDaoImpl();
		user = userDao.saveUser(user);
		session.setAttribute("user", user);

		if (user.getId() > 0) {
			response.sendRedirect("welcome.jsp");
		} else {
			session.setAttribute("error", "User registration failed. Please contact administrator.");
			response.sendRedirect("registration.jsp");
		}
	}

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("registration.jsp");
	}
}
