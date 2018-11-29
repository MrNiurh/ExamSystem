package com.ssm.sample.controller.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.teacher.TeacherFacade;
import com.ssm.sample.util.PageData;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherStudentimportController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;
	/*
	 * 考中管理 >> 通知管理
	 * 
	 */

	@RequestMapping(value = "/import_student")
	public ModelAndView home(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam_import");
		PageData pd = this.getPageData();
		String testid = (String) session.getAttribute("import");
		pd.put("testid", testid);
		//System.out.println(pd);
		List<PageData> system = this.teacherFacade.selectSystem();
		int page_record = 30;
		try {
			String a = system.get(0).getString("page_record");
			page_record = Integer.valueOf(a).intValue();
			String b = "";
			int record = 0;
			try {
				b = (String) session.getAttribute("page_record");
				record = Integer.valueOf(b).intValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				record = (int) session.getAttribute("page_record");
				e.printStackTrace();
			}

			if (record > 0) {
				// System.out.println("hhhh");
				page_record = record;
				//System.out.println(page_record + "true");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageHelper.startPage(pn, page_record);
		List<PageData> list = this.teacherFacade.selectAllStudent(pd);
		// System.out.println(list);
		PageInfo page = new PageInfo(list);
		session.setAttribute("page_record", page_record);
		mv.addObject("students", page);
		// System.out.println(page);
		// mv.addObject("students", list);
		//System.out.println(page_record + "real");
		return mv;
	}

	/*
	 * 插入学生
	 */
	@ResponseBody
	@RequestMapping("/editInsertStudent")
	public Object insertStudent() {
		PageData pd = this.getPageData();
		boolean b = false;
		try {
			b = this.teacherFacade.insertStudent(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@ResponseBody
	@RequestMapping("/page_record")
	public Object page_record() throws Exception {
		PageData pd = this.getPageData();
		int page_record = Integer.valueOf(pd.getString("page_record")).intValue();
		if (page_record > 0) {
			session.setAttribute("page_record", pd.getString("page_record"));
			//System.out.println("do");
		}
		return true;
	}

	/*
	 * 插入学生
	 */
	@ResponseBody
	@RequestMapping("/deleteOnrStuent")
	public Object deleteOnrStuent() {
		PageData pd = this.getPageData();
		String testid = (String) session.getAttribute("import");
		pd.put("testid", testid);
		boolean b = false;
		try {
			b = this.teacherFacade.deleteOnrStuent(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

}