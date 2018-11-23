package com.ssm.sample.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class StudentipFilter
 */
public class StudentipFilter implements Filter {
	private FilterConfig config;
	
    /**
     * Default constructor. 
     */
    public StudentipFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = requ.getServletContext().getContextPath();
		String ip = InetAddress.getLocalHost().getHostAddress().toString();
		//通过ip查询表记录，存在record,跳转到student界面
		 String record="111";

		
		System.out.println(ip);
		
		chain.doFilter(request, response);
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}

}
