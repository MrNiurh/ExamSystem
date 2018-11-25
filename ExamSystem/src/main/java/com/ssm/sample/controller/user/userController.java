package com.ssm.sample.controller.user;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.admin.AdminFacade;
import com.ssm.sample.facade.student.StudentFacade;
import com.ssm.sample.facade.teacher.TeacherFacade;
import com.ssm.sample.facade.user.UserFacade;
import com.ssm.sample.util.MD5;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/main" })
public class userController extends BaseController {

	@Autowired
	UserFacade userFacade;
	@Autowired
	StudentFacade studentFacade;
	@Autowired
	TeacherFacade teacherFacade;
	@Autowired
	AdminFacade adminFacade;

	@RequestMapping({ "/login" })
	public ModelAndView home() throws IOException {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login/login");

		try {
			List<PageData> list = this.teacherFacade.selectNowTest();
			List<PageData> system = this.adminFacade.selectSystem();
			// 考试
			if (list != null) {
				String id = list.get(0).getString("testid");
				ServletContext application = request.getSession().getServletContext();
				application.setAttribute("testid", list.get(0).getString("testid"));
				application.setAttribute("RunTest", list);
				application.setAttribute("clear", system.get(0).getString("clear"));

				String ip = InetAddress.getLocalHost().getHostAddress().toString();
				System.out.println("ipppppp" + ip);
				PageData pd = this.getPageData();
				pd.put("testid", id);
				pd.put("ip", ip);
				List<PageData> student = this.teacherFacade.controllStudentByIp(pd);
				if (student != null) {
					System.out.println(student + "stuaaaa");
					session.setAttribute("fullname", student.get(0).getString("stuname"));
					session.setAttribute("identity", "student");
					session.setAttribute("stuid", student.get(0).get("stuid"));
					// mv.setViewName("student/student");
					String path = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + path + "/";
					System.out.println(basePath);
					response.sendRedirect(basePath + "student/");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				session.setAttribute("fullname", student.get(0).getString("stuname"));
				session.setAttribute("identity", "student");
				session.setAttribute("stuid", student.get(0).get("stuid"));
			} else {

				map.put("check", "false");
			}

			try {
				/*
				 * 插入 ip
				 */
				ServletContext application = request.getSession().getServletContext();
				String ip = InetAddress.getLocalHost().getHostAddress().toString();
				pd.put("stuid", student.get(0).getString("stuid"));
				pd.put("testid", application.getAttribute("testid"));
				pd.put("ip", ip);
				this.studentFacade.updateStudentIp(pd);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
				session.setAttribute("checkPassword", teacher.get(0).getString("password"));
				// 在 session 内存储登录状态
				session.setAttribute("identity", "teacher");
				session.setAttribute("teacher_id", teacher.get(0).getString("id"));
				session.setAttribute("ifadmin", teacher.get(0).getString("admin"));

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
		Map<String, String> map = new HashMap<String, String>();
		List<PageData> admin = new ArrayList<>();
		List<PageData> count = this.adminFacade.selectAdminCount();
		System.out.println(count);
		String num = count.get(0).getString("count(id)");
		System.out.println(pd);
		if (num.equals("0")) {
			String name = pd.getString("a_password");
			String password = pd.getString("a_name");
			if (name.equals("admin") && password.equals("admin")) {
				map.put("check", "true");
				session.setAttribute("fullname", "admin");
				session.setAttribute("identity", "admin");
			}

		} else {
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
		}
		return map;
	}

}