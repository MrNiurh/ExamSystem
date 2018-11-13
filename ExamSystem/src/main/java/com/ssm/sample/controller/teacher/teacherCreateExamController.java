package com.ssm.sample.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.teacher.TeacherFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/teacher" })

public class teacherCreateExamController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;

	/*
	 * 考前操作
	 */
	@RequestMapping(value = "/teacher_create_exam")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam_before");
		return mv;
	}

	/*
	 * 添加考试
	 */
	@ResponseBody
	@RequestMapping("/insertTest")
	public Object insertTest() {
		PageData pd = this.getPageData();
		boolean b = false;
		try {
			b= this.teacherFacade.insertTest(pd);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

}
