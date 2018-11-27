package com.ssm.sample.controller.teacher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
			UtilDate date = null;
			PageData pd = this.getPageData();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			for (int i = 0; i < list.size(); i++) {
				// 添加教师名
				pd.put("id", list.get(i).get("tea_id"));
				List<PageData> teacher = this.teacherFacade.selectTeacherById(pd);
				list.get(i).put("teacherName", teacher.get(0).get("fullname"));
				// 时间格式化
				Date d = date.getDateTime(list.get(i).getString("starttime"));
				list.get(i).put("starttime", sdf.format(d));
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
		System.out.println("run");
		System.out.println(pd);
		try {
			System.out.println(pd);
			b = this.teacherFacade.insertTest(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;

	}

}
