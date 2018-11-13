package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })
public class NoExamController extends BaseController{
	
	/*
	 * 考中管理 >> 没有进行中的考试
	 */

	@RequestMapping(value = "/teacher_exam_mid")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("teacher/teacher_exam_mid");
		return mv;
	}
}
