package com.ssm.sample.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.user.UserFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/main" })
public class userController extends BaseController {

	@Autowired
	UserFacade userFacade;

	@RequestMapping({ "/login" })
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login/login");
		return mv;
	}

	/*
	 * 学生登录
	 */
	@ResponseBody
	@RequestMapping({ "/s_login" })
	public Object s_Login() {
		PageData pd = this.getPageData();

		List<PageData> student = new ArrayList<>();

		Map<String, String> map = new HashMap<String, String>();
		try {
			student = this.userFacade.getStudent(pd);
			if (student.size() != 0) {
				map.put("check", "true");
			} else {
				map.put("check", "false");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * 教师登录
	 */
	@ResponseBody
	@RequestMapping({ "/t_login" })
	public Object t_Login() {
		// 从界面获取数据
		PageData pd = this.getPageData();
		List<PageData> teacher = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 获取查询结果
			teacher = this.userFacade.getTeacher(pd);
			session.setAttribute("fullname", teacher.get(0).getString("fullname"));

			// 判断是否有结果
			if (teacher.size() != 0) {
				map.put("check", "true");
			} else {
				map.put("check", "false");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回查询结果
		return map;
	}

	/*
	 * 管理员登录
	 */
	@ResponseBody
	@RequestMapping({ "/a_login" })
	public Object a_Login() {
		PageData pd = this.getPageData();

		List<PageData> admin = new ArrayList<>();

		Map<String, String> map = new HashMap<String, String>();
		try {
			admin = this.userFacade.getAdmin(pd);
			session.setAttribute("fullname", admin.get(0).getString("fullname"));
			if (admin.size() != 0) {
				map.put("check", "true");
			} else {
				map.put("check", "false");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}