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
		System.out.println("过滤器销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest) request;
		String path = requ.getServletContext().getContextPath();
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = requ.getSession(true);
		String loginPage = config.getInitParameter("loginPage");
		// 获取客户请求的页面
		String requestPath = requ.getServletPath();
		System.out.println(requestPath);
		if (session.getAttribute("identity") == null && !requestPath.endsWith(loginPage)) {
			res.sendRedirect(loginPage);

			// request.getRequestDispatcher(loginPage).forward(request,
			// response);
		} else {
			request.getRequestDispatcher("/teacher/").forward(request, response);
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("执行aaaaaaaaaaaaaaaaaaaaaaa");
		this.config = fConfig;
	}

}
