package com.hardik.javaee.crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logout Controller
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
