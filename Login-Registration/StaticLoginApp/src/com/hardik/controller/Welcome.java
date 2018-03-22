package com.hardik.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hardik.model.LoginModel;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		LoginModel model = (LoginModel) request.getAttribute("loginmodel");
		
		out.println("Welcome: " + model.getUsername());
	}
}
