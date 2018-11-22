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
public class TeacherUnlockStudentController extends BaseController {

	@Autowired
	TeacherFacade teacherFacede;
	/*
	 * 考中管理 >> 解除锁定
	 * 
	 */

	@RequestMapping(value = "/teacher_unlock_student")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_manage_unlock");
		return mv;
	}

	/*
	 * 根据 学号，姓名，班级 查询学生
	 */
	@ResponseBody
	@RequestMapping("/selectInfoStudent")
	public Object selectInfoStudent() {
		PageData pd = this.getPageData();
		ServletContext application = request.getSession().getServletContext();
		pd.put("testid", application.getAttribute("testid"));
		System.out.println(pd);
		List<PageData> list = null;
		try {
			list = this.teacherFacede.selectinfoStudent(pd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 根据 ip 查询学生
	 */
	@ResponseBody
	@RequestMapping("/selectStudentByIp")
	public Object selectStudentByIp() {
		PageData pd = this.getPageData();
		ServletContext application = request.getSession().getServletContext();
		pd.put("testid", application.getAttribute("testid"));
		System.out.println(pd);
		List<PageData> list = null;
		try {
			list = this.teacherFacede.selectStudentByIp(pd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
