package com.ssm.sample.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherManageNotifyController extends BaseController{
	
	/*
	 * 考中管理 >> 通知管理
	 * 
	 */

	@RequestMapping(value = "/teacher_notify")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("teacher/teacher_manage_notify");
		return mv;
	}
}
