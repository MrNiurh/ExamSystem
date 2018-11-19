package com.ssm.sample.controller.teacher;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.teacher.TeacherFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherManageSummaryController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;
	/*
	 * 考中管理 >> 考试概况
	 */

	@RequestMapping(value = "/teacher_exam_detail")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_manage_summary");

		try {
			ServletContext application = request.getSession().getServletContext();

			PageData pd = this.getPageData();
			pd.put("testid", application.getAttribute("testid"));
			/*
			 * 查询学生总数
			 */
			List<PageData> list = this.teacherFacade.selectStudent(pd);
			String allStudent = list.get(0).getString("count(stuid)");
			mv.addObject("allStudent", allStudent);

			/*
			 * 查询登录学生数
			 */
			list = this.teacherFacade.selectLoginStudent(pd);
			String loginStudent = list.get(0).getString("count(stuid)");
			mv.addObject("loginStudent", loginStudent);

			/*
			 * 查询未登录学生数
			 */
			list = this.teacherFacade.selectNoLoginStudent(pd);
			String noLoginStudent = list.get(0).getString("count(stuid)");
			mv.addObject("noLoginStudent", noLoginStudent);

			/*
			 * 查询已提交学生数
			 */
			list = this.teacherFacade.selectSubmitStudent(pd);
			String submitStudent = list.get(0).getString("count(stuid)");
			mv.addObject("submitStudent", submitStudent);
			/*
			 * 查询未提交学生数
			 */
			list = this.teacherFacade.selectNoSubmitStudent(pd);
			String noSubmitStudent = list.get(0).getString("count(stuid)");
			mv.addObject("noSubmitStudent", noSubmitStudent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
}
