package com.hardik.javaee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hardik.javaee.bean.User;
import com.hardik.javaee.dao.UserDao;
import com.hardik.javaee.dao.UserDaoImpl;

/**
 * Search Servlet
 */
@WebServlet("/Search")
public class Search extends HttpServlet {

	static Logger logger = Logger.getLogger(Search.class);
	private static final long serialVersionUID = 1L;

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("Searching user in database...");
		HttpSession session = request.getSession(true);

		// Validate User
		UserDao userDaoImpl = new UserDaoImpl();
		List<User> users = userDaoImpl.searchUser(request.getParameter("username"));
		logger.debug("Users searched successfully and found " + users.size() + " users.");
		session.setAttribute("users", users);
		session.setAttribute("searchString", request.getParameter("username"));
		response.sendRedirect("index.jsp");
	}

}
