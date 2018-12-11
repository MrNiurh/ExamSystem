package com.ssm.sample.controller.admin;

import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.admin.AdminFacade;
import com.ssm.sample.util.MD5;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/admin" })
public class adminController extends BaseController {

	@Autowired
	AdminFacade adminFacade;

	@RequestMapping({ "/" })
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("admin/admin");
		return mv;
	}

	/*
	 * 修改密码
	 */
	@ResponseBody
	@RequestMapping("/updatePassword")
	public Object updatePassword() {
		PageData pd = this.getPageData();
		System.out.println(pd);
		String oldPassword = pd.getString("oldpassword");
		String password = pd.getString("password");
		List<PageData> list = this.adminFacade.selectTeacherById(pd);
		System.out.println(list);
		String checkPassword = list.get(0).getString("password");
		if (!MD5.md5(oldPassword).equals(checkPassword)) {
			return "error";
		}

		pd.put("password", MD5.md5(password));
		System.out.println(pd);
		boolean b = false;
		b = this.adminFacade.updatePassword(pd);
		return b;
	}

	/*
	 * 退出登录
	 */
	@ResponseBody
	@RequestMapping("/exitAccount")
	public Object exitAccount() {

		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		
		return true;

	}
}
