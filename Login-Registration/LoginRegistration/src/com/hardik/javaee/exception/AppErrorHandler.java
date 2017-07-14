package com.hardik.javaee.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Application Error Handler
 * 
 * @author HARDIK HIRAPARA
 *
 */
@WebServlet("/AppErrorHandler")
public class AppErrorHandler extends HttpServlet {

	static Logger logger = Logger.getLogger(AppErrorHandler.class);
	private static final long serialVersionUID = 1L;

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processError(request, response);
	}

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processError(request, response);
	}

	/**
	 * Process Error
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.error("AppErrorHandler called while Exception occurred.");

		// Analyze the servlet exception
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

		if (servletName == null) {
			servletName = "Unknown";
		}
		if (requestUri == null) {
			requestUri = "Unknown";
		}

		// Set response content type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.write("<html><head><title>Exception/Error Details</title></head><body>");

		if (statusCode != 500) {
			out.write("<h3>Error Details</h3>");
			out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
			out.write("<strong>Requested URI</strong>:" + requestUri);
		} else {
			out.write("<h3>Exception Details</h3>");
			out.write("<ul><li>Servlet Name:" + servletName + "</li>");
			out.write("<li>Exception Name:" + throwable.getClass().getName() + "</li>");
			out.write("<li>Requested URI:" + requestUri + "</li>");
			out.write("<li>Exception Message:" + throwable.getMessage() + "</li>");
			out.write("</ul>");
		}

		out.write("<br><br>");
		out.write("<a href=\"index.jsp\">Login Page</a>");
		out.write("</body></html>");
	}
}
