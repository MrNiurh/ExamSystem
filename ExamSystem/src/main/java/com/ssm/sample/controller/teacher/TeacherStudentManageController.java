package com.ssm.sample.controller.teacher;

import java.util.List;

import javax.servlet.ServletContext;

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
public class TeacherStudentManageController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;
	/*
	 * 考中管理 >> 学生信息
	 */

	@RequestMapping(value = "/teacher_student_manage")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_manage_student");
		return mv;
	}

	/*
	 * 插入学生
	 */
	@ResponseBody
	@RequestMapping("/insertStudent")
	public Object insertStudent() {
		PageData pd = this.getPageData();
		boolean b = false;
		System.out.println(pd);
		ServletContext application = request.getSession().getServletContext();

		try {
			pd.put("testid", application.getAttribute("testid"));
			b = this.teacherFacade.insertStudent(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	/*
	 * 查询所有学生
	 */
	@ResponseBody
	@RequestMapping("/selectAllStudent")
	public Object selectAllStudent() {
		PageData pd = this.getPageData();
		List<PageData> list = null;
		ServletContext application = request.getSession().getServletContext();

		try {
			pd.put("testid", application.getAttribute("testid"));
			list = this.teacherFacade.selectAllStudent(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
