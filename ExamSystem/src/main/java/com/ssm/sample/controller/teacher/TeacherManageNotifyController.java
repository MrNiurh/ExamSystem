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

@Controller
@RequestMapping({ "/teacher" })
public class TeacherManageNotifyController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;
	/*
	 * 考中管理 >> 通知管理
	 * 
	 */

	@RequestMapping(value = "/teacher_notify")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_manage_notify");
		try {
			List<PageData> list = this.teacherFacade.selectInfos();
			mv.addObject("infos", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("insertNotify")
	public Object insertNotify() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = "[" + df.format(new Date()) + "]";
		PageData pd = this.getPageData();
		String info = pd.getString("info");
		pd.put("info", date + info);
		boolean b = false;
		b = this.teacherFacade.insertNotify(pd);
		return b;
	}

	@ResponseBody
	@RequestMapping("deleteInfo")
	public Object deleteInfo() {

		PageData pd = this.getPageData();
		boolean b = false;
		b = this.teacherFacade.deleteInfo(pd);
		return b;
	}
}
