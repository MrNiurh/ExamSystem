package com.ssm.sample.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/admin" })
public class adminController extends BaseController {
	@RequestMapping(value = "/")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("admin/admin");
		return mv;
	}
}
