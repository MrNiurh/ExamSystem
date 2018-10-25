package com.ssm.sample.controller.login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
@Controller

public class loginController extends BaseController{

	@RequestMapping({ "/login" })
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("exclude/login");
		return mv;
	}
}