package com.ssm.sample.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/admin" })
public class editTeacherController extends BaseController {
	@RequestMapping(value = "/edit_teacher")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("admin/edit_teacher");
		return mv;
	}
}
