package com.ssm.sample.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.admin.AdminFacade;
import com.ssm.sample.util.DeleteFolderUtil;
import com.ssm.sample.util.PageData;
import com.ssm.sample.util.UtilDate;

@Controller
@RequestMapping({ "/admin" })
public class adminCleanController extends BaseController {

	@Autowired
	AdminFacade adminFacade;

	@RequestMapping(value = "/admin_clean")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("admin/exam_clean");

		try {
			List<PageData> list = this.adminFacade.selectAfterTest();
			System.out.println(list);
			UtilDate date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < list.size(); i++) {
				// 添加教师名
				PageData pd = this.getPageData();
				pd.put("id", list.get(i).get("tea_id"));
				List<PageData> teacher = this.adminFacade.selectTeacherById(pd);
				System.out.println(teacher);
				if (teacher != null) {
					list.get(i).put("teacherName", teacher.get(0).get("fullname"));
					// 时间格式化
					Date d = date.getDateTime(list.get(i).getString("starttime"));
					list.get(i).put("starttime", sdf.format(d));
				}

			}
			mv.addObject("afterTests", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * 考试状态位改变
	 */
	@ResponseBody
	@RequestMapping("/updateSignal")
	public Object updateSignal() {
		PageData pd = this.getPageData();
		ServletContext application = request.getSession().getServletContext();
		boolean b = false;
		try {
			b = this.adminFacade.updateSignal(pd);

			// 清理考试
			if (b == true && pd.getString("test_signal").equals("4")) {
				List<PageData> list = this.adminFacade.selectTestById(pd.getString("testid"));

				// 删除 文件
				String testName = list.get(0).getString("testname");
				String excelName = testName + ".xls";
				String zipName = testName + ".zip";
				String sourcePath = request.getSession().getServletContext().getRealPath("/") + "ExamSystem/"
						+ testName;
				String excelPath = request.getSession().getServletContext().getRealPath("/") + "ExamSystem/"
						+ excelName;
				String zipPath = request.getSession().getServletContext().getRealPath("/") + "ExamSystem/" + zipName;
				File sourceFile = new File(sourcePath);
				File excelFile = new File(excelPath);
				File zipFile = new File(zipPath);
				if (sourceFile.exists()) {
					// 删除文件夹下所有文件
					System.out.println(sourcePath);
					DeleteFolderUtil.deleteFile(sourceFile);
				}

				if (excelFile.exists() && excelFile.isFile()) {
					excelFile.delete();
				}
				if (zipFile.exists() && zipFile.isFile()) {
					zipFile.delete();
				}
			}
			// 删除考试
			if (b == true && pd.getString("test_signal").equals("5")) {
				String testid = pd.getString("testid");
				this.adminFacade.deleteUploadAfter(testid);
				this.adminFacade.deleteStuentsAfter(testid);
				this.adminFacade.deleteTestAfter(testid);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}
