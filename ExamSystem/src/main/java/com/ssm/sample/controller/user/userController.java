package com.ssm.sample.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.user.UserFacade;
import com.ssm.sample.util.MD5;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/main" })
public class userController extends BaseController {

	@Autowired
	UserFacade userFacade;

	@RequestMapping({ "/login" })
	public ModelAndView home() throws IOException {
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
		pd.getString("");

		List<PageData> student = new ArrayList<>();

		Map<String, String> map = new HashMap<String, String>();
		try {
			student = this.userFacade.getStudent(pd);
			if (student.size() != 0) {
				map.put("check", "true");
				session.setAttribute("fullname", student.get(0).getString("stuname"));
				session.setAttribute("identity", "student");
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
			String t_password = MD5.md5(pd.getString("t_password"));
			pd.put("t_password", t_password);
			// 判断是否有结果
			teacher = this.userFacade.getTeacher(pd);
			
			if (teacher.size() != 0) {
				// 有返回结果
				map.put("check", "true");
				// 在 session 内储存姓名
				session.setAttribute("fullname", teacher.get(0).getString("fullname"));
				// 在 session 内存储登录状态
				session.setAttribute("identity", "teacher");
				session.setAttribute("teacher_id", teacher.get(0).getString("id"));
			} else {
				// 无返回结果
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
			String a_password = MD5.md5(pd.getString("a_password"));
			pd.put("a_password", a_password);
			admin = this.userFacade.getAdmin(pd);
			if (admin.size() != 0) {
				map.put("check", "true");
				session.setAttribute("fullname", admin.get(0).getString("fullname"));
				session.setAttribute("identity", "admin");
			} else {
				map.put("check", "false");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}