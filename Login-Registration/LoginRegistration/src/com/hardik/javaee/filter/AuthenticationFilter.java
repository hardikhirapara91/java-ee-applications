package com.hardik.javaee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * AuthenticationFilter Servlet Filter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	static Logger logger = Logger.getLogger(AuthenticationFilter.class);

	/**
	 * Default constructor.
	 */
	public AuthenticationFilter() {
	}

	/**
	 * Init
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter initialized");
		PropertyConfigurator.configure(getClass().getResourceAsStream("/resources/log4j.properties"));
		logger.debug("Log4j properties configured successfully.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);

		if (session == null && !(uri.endsWith("jsp") || uri.endsWith("Login") || uri.endsWith("Register"))) {
			logger.error("Unauthorized access request");
			res.sendRedirect("index.jsp");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * Destroy
	 */
	@Override
	public void destroy() {
		logger.debug("AuthenticationFilter destroyed.");
	}

}
