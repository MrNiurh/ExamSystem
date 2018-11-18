package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherExamController extends BaseController {
	/*
	 * 
	 * 教师主页面
	 */
	@RequestMapping({ "/" })
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam");
		return mv;
	}
}
