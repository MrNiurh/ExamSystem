package com.ssm.sample.controller.student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;

@Controller
@RequestMapping({ "/student" })
public class StudentController  extends BaseController {
	/*
	 * 
	 * 学生主页面
	 */
	@RequestMapping({ "/" })
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("student/student");
		return mv;
	}
}