package com.ssm.sample.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.student.StudentFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/student" })
public class StudentController extends BaseController {

	@Autowired
	StudentFacade studentFacade;

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

	@ResponseBody
	@RequestMapping("/updateStudentIp")
	public Object updateStudentIp() {
		PageData pd = this.getPageData();
		boolean b =false;
		try {
			b=this.studentFacade.updateStudentIp(pd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}