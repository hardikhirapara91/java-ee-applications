package com.hardik.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hardik.dao.LoginDao;
import com.hardik.model.LoginModel;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher requestDispatcher;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginModel model = new LoginModel();
		model.setUsername(username);
		model.setPassword(password);

		LoginDao loginDao = new LoginDao();
		if (loginDao.validate(model)) {
			request.setAttribute("loginmodel", model);
			requestDispatcher = request.getRequestDispatcher("welcome");
			requestDispatcher.forward(request, response);
		} else {
			out.println("Invalid username or password.");
			requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request, response);
		}
	}
}
