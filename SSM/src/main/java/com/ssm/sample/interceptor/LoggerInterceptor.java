package com.ssm.sample.interceptor;

import org.aspectj.lang.JoinPoint;

import com.ssm.sample.util.Logger;

/**
 * 日志记录
 * 
 * @author Administrator
 *
 */
public class LoggerInterceptor {

	Logger logger = Logger.getLogger(LoggerInterceptor.class);

	public void beforeInvoke(JoinPoint jp) {
		String cls = jp.getTarget().getClass().getName();
		String mth = jp.getSignature().getName();
		logger.info(String.format(">>>Execution Begin:%s.%s", cls, mth));
	}

	public void afterInvoke(JoinPoint jp) {
		String cls = jp.getTarget().getClass().getName();
		String mth = jp.getSignature().getName();
		logger.info(String.format("<<<Execution End:%s.%s", cls, mth));
	}

	public void errorInvoke(JoinPoint jp) {
		String cls = jp.getTarget().getClass().getName();
		String mth = jp.getSignature().getName();
		logger.error(String.format("<<<Execution Error>>>%s.%s", cls, mth));
	}
}
