package com.ssm.sample.controller.student;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.student.StudentFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/student" })
public class StudentCheckController extends BaseController {

	@Autowired
	StudentFacade studentFacade;
	/*
	 * 查看提交
	 */

	@RequestMapping({ "/student_check" })
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("student/student_check");
		PageData pd = this.getPageData();
		ServletContext application = request.getSession().getServletContext();
		pd.put("stuid", session.getAttribute("stuid"));
		pd.put("testid", application.getAttribute("testid"));
		List<PageData> list = this.studentFacade.selectUploadFile(pd);
		mv.addObject("files", list);
		return mv;
	}

}
