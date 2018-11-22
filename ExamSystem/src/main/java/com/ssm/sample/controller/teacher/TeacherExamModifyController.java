package com.ssm.sample.controller.teacher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
public class TeacherExamModifyController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;
	/*
	 * 考前 >> 考试编辑
	 * 
	 */

	@RequestMapping(value = "/teacher_modify")
	public ModelAndView home(@Param("testid") String testid) {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam_modify");

		List<PageData> list = null;
		try {
			list = this.teacherFacade.selectTestById(testid);
			UtilDate date = null;
			Date d = date.getDateTime(list.get(0).getString("starttime"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			list.get(0).put("starttime", sdf.format(d));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mv.addObject("editTest", list.get(0));
		return mv;
	}

	/*
	 * 更新考试信息
	 */
	@ResponseBody
	@RequestMapping("/updateTest")
	public Object updateTest() {
		boolean b = false;
		PageData pd = this.getPageData();
		try {
			b = this.teacherFacade.updateTest(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return b;
	}
}
