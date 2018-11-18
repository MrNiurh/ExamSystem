package com.ssm.sample.controller.teacher;

import java.util.List;

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
		try {
			List<PageData> list = this.teacherFacade.selectTests();
			for (int i = 0; i < list.size(); i++) {
				List<PageData> teacher = this.teacherFacade.selectTeacherById((int)list.get(i).get("tea_id"));
				list.get(i).put("teacherName", teacher.get(0).get("fullname"));
			}
			
			mv.addObject("tests", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			System.out.println(pd);
			b = this.teacherFacade.insertTest(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;

	}

}
