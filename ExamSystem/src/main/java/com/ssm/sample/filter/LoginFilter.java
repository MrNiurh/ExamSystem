package com.ssm.sample.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig config;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest) request;
		String path = requ.getServletContext().getContextPath();
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = requ.getSession(true);
		// 获取登录界面地址
		String loginPage = requ.getServletContext().getContextPath() + config.getInitParameter("loginPage");
		// 获取客户请求的页面
		String requestPath = requ.getServletPath();
		if (session.getAttribute("identity") == null && !requestPath.endsWith(loginPage)) {
			res.sendRedirect(loginPage);
		} else {
			if (session.getAttribute("identity").equals("admin")) {
				request.getRequestDispatcher(requestPath).forward(request, response);
			}
			if (session.getAttribute("identity").equals("teacher")) {
				request.getRequestDispatcher(requestPath).forward(request, response);
			}
			if (session.getAttribute("identity").equals("student")) {
				request.getRequestDispatcher(requestPath).forward(request, response);
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

		this.config = fConfig;
	}

}
