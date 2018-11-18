package com.ssm.sample.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.admin.AdminFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/admin" })
public class teacherManagerController extends BaseController {
	@Autowired
	AdminFacade adminFacade;

	@RequestMapping(value = "/teacher_manager")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		try {
			//查询所有教师
			List<PageData> list = this.adminFacade.getAllTeacher(pd);
			mv.addObject("teachers", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mv.setViewName("admin/add_teacher");
		return mv;
	}
}
