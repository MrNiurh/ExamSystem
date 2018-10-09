package com.ssm.sample.controller.base;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.entity.Page;
import com.ssm.sample.util.Logger;
import com.ssm.sample.util.PageData;

public class BaseController {
	@Resource(name = "globalConf")
	protected Properties globalConf;

	protected Logger logger = Logger.getLogger(this.getClass());

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	@ModelAttribute
	protected void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	/**
	 * 寰楀埌PageData
	 */
	protected PageData getPageData() {
		return new PageData(this.getRequest());
	}

	/**
	 * 寰楀埌ModelAndView
	 */
	/**
	 * @return
	 */
	protected ModelAndView getModelAndView() {
		ModelAndView mv = new ModelAndView();
		/*System.out.println("session"+session);*/
		if(session.getAttribute("nickName")==null || session.getAttribute("nickName").equals("")) {
			mv.addObject("name", "游客");
			mv.addObject("isLogin",false);
		}
		else {
			mv.addObject("name", session.getAttribute("nickName"));
			mv.addObject("isLogin",true);
			/*mv.addObject("name", "游客998");*/
		}
		Calendar c = Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		if(hour>5&&hour<12) {
			mv.addObject("time", "上午好!");
		}else {
			if(hour>=12&&hour<19) {
				mv.addObject("time", "下午好!");
			}else {
				mv.addObject("time", "晚上好!");
			}
		}
		return mv;
	}

	/**
	 * 寰楀埌request瀵硅薄
	 */
	protected HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * 寰楀埌response瀵硅薄
	 */
	protected HttpServletResponse Response() {
		return response;
	}

	/**
	 * 寰楀埌鍒嗛〉鍒楄〃鐨勪俊鎭�
	 */
	protected Page getPage() {
		return new Page();
	}

	protected static void logBefore(Logger logger, String interfaceName) {
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}

	protected static void logAfter(Logger logger) {
		logger.info("end");
		logger.info("");
	}

	protected void forward(String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getRequest().getRequestDispatcher(url);
		dispatcher.forward(this.request, this.response);
	}
}
