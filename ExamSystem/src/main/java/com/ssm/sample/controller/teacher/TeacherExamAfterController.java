package com.ssm.sample.controller.teacher;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ssm.sample.util.UtilDate;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherExamAfterController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;

	/*
	 * 考后操作
	 */
	@RequestMapping(value = "/teacher_afterexam")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam_after");

		try {
			List<PageData> list = this.teacherFacade.selectAfterTest();
			UtilDate date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < list.size(); i++) {
				// 添加教师名
				List<PageData> teacher = this.teacherFacade.selectTeacherById((int) list.get(i).get("tea_id"));
				list.get(i).put("teacherName", teacher.get(0).get("fullname"));
				// 时间格式化
				Date d = date.getDateTime(list.get(i).getString("starttime"));
				list.get(i).put("starttime", sdf.format(d));
			}
			mv.addObject("afterTests", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("/updateSignal")
	public Object updateSignal() {
		PageData pd = this.getPageData();
		ServletContext application = request.getSession().getServletContext();
		boolean b = false;
		try {
			b = this.teacherFacade.updateSignal(pd);
			if (b == true && pd.getString("test_signal").equals("1")) {
				List<PageData> list = this.teacherFacade.selectTestById(pd.getString("testid"));
				application.setAttribute("testid", pd.getString("testid"));
				application.setAttribute("appTestName", list.get(0).getString("testname"));
			}
			if (b == true && pd.getString("test_signal").equals("2")) {
				application.removeAttribute("testid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}
