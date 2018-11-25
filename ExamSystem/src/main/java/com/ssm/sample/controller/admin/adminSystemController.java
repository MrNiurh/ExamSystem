package com.ssm.sample.controller.admin;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.admin.AdminFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/admin" })
public class adminSystemController extends BaseController {

	@Autowired
	AdminFacade adminFacade;

	/*
	 * 管理员 >> 系统配置页面
	 */
	@RequestMapping(value = "/system")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("admin/system");

		try {
			List<PageData> list = this.adminFacade.selectSystem();
			mv.addObject("system", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * 更新系统配置信息
	 */
	@ResponseBody
	@RequestMapping("/updateSystem")
	public Object updateSystem() {
		PageData pd = this.getPageData();
		System.out.println(pd);
		boolean b = false;
		try {
			b = this.adminFacade.updateSystem(pd);
			ServletContext application = request.getServletContext();
			application.setAttribute("clear", pd.getString("clear"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
}
