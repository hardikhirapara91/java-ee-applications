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

/**
 * AuthenticationFilter Servlet Filter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

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
			System.out.println("Unauthorized access request");
			res.sendRedirect("login.html");
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
		System.out.println("AuthenticationFilter destroyed.");
	}

}
