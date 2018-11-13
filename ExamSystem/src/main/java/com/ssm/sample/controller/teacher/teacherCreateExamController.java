package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })


public class teacherCreateExamController extends BaseController{

	/*
	 * 考前操作
	 */
	@RequestMapping(value = "/teacher_create_exam")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("teacher/teacher_exam_before");
		return mv;
	}
}
