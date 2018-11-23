package com.ssm.sample.controller.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
public class editTeacherController extends BaseController {

	@Autowired
	AdminFacade adminFacade;

	/*
	 * 管理员 >> 教师管理页面
	 */
	@RequestMapping(value = "/edit_teacher")
	public ModelAndView home(@Param("id") String id) {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("admin/edit_teacher");

		try {
			List<PageData> list = this.adminFacade.getTeacherById(id);
			mv.addObject("editTeacher", list.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * 添加教师
	 */
	@ResponseBody
	@RequestMapping("/insertTeacher")
	public Object insertTeacher() {
		PageData pd = this.getPageData();
		pd.put("t_password", MD5.md5(pd.getString("t_password")));
		boolean b = false;
		try {
			b = this.adminFacade.insertTeacher(pd);
		} catch (Exception e) {
		}
		return b;
	}

	/*
	 * 通过 id 删除教师
	 */
	@ResponseBody
	@RequestMapping("/deleteTeacherById")
	public Object deleteTeacherById(@Param("id") String id) {
		boolean b = false;
		try {
			b = this.adminFacade.deleteTeacherById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	/*
	 * 更新教师信息
	 */
	@ResponseBody
	@RequestMapping("/updateTeacherById")
	public Object updateTeacherById() {
		PageData pd = this.getPageData();
		if (pd.getString("password") == null || pd.getString("password").equals("")) {
			List<PageData> list = this.adminFacade.getTeacherById(pd.getString("id"));
			pd.put("password", list.get(0).getString("password"));
		} else {
			String str = pd.getString("password");
			pd.put("password", MD5.md5(str));
		}

		boolean b = false;
		try {
			b = this.adminFacade.updateTeacherById(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

}
