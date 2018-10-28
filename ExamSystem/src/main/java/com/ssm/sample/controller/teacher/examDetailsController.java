package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })
public class examDetailsController extends BaseController{

	@RequestMapping(value = "/teacher_exam_details")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("teacher/teacher_exam_mid");
		return mv;
	}
}
