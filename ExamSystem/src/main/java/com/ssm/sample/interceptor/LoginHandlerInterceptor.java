package com.ssm.sample.interceptor;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssm.sample.util.Const;
import com.ssm.sample.util.UuidUtil;

/**
 * 
 * 类名称：LoginHandlerInterceptor.java <br>
 * 类描述：是否登录验证，根据是否有session
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
	protected Logger logger = Logger.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();

		request.setAttribute("uuid", UuidUtil.get32UUID());

		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		Properties globalConf = (Properties) webApplicationContext.getBean("globalConf");
		request.setAttribute("sysname", globalConf.getProperty("global.SystemName"));
		// 验证用户
		if ("/".equals(path) || path.matches(Const.NO_INTERCEPTOR_PATH)) {
			return true;
		} else {
			// Subject currentUser = SecurityUtils.getSubject();//
			// shiro管理的session
			// Session session = currentUser.getSession();
			/*
			 * User user = (User) session.getAttribute(Const.SESSION_USER); if
			 * (user == null) { response.sendRedirect(request.getContextPath() +
			 * Const.LOGOUT); return false; }
			 */
			return true;
		}
	}
}
