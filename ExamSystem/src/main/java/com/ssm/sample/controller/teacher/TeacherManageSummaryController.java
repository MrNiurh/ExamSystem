package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherManageSummaryController extends BaseController{
	
	/*
	 * 考中管理 >> 考试概况
	 */

	@RequestMapping(value = "/teacher_exam_detail")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("teacher/teacher_manage_summary");
		return mv;
	}
}
