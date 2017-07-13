package com.hardik.javaee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hardik.javaee.bean.User;
import com.hardik.javaee.dao.UserDaoImpl;

/**
 * Login Servlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		// Validate User
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.validateUser(request.getParameter("username"), request.getParameter("password"));

		if (user != null && user.getId() > 0) {
			session.setAttribute("user", user);
			response.sendRedirect("welcome.jsp");
		} else {
			session.setAttribute("error", "Invalid Credentials.");
			response.sendRedirect("index.jsp");
		}
	}

}
