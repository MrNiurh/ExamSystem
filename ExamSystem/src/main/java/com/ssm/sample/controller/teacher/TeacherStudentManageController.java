package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherStudentManageController extends BaseController{
	
	/*
	 * 考中管理 >> 学生信息
	 */

	@RequestMapping(value = "/teacher_student_manage")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("teacher/teacher_manage_student");
		return mv;
	}
}
