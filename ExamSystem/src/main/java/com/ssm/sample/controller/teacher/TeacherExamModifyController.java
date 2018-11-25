package com.ssm.sample.controller.teacher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.page.PageAutoDialect;
import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.teacher.TeacherFacade;
import com.ssm.sample.util.PageData;
import com.ssm.sample.util.UtilDate;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherExamModifyController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;
	/*
	 * 考前 >> 考试编辑
	 * 
	 */

	@RequestMapping(value = "/teacher_modify")
	public ModelAndView home(@Param("testid") String testid) {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam_modify");

		List<PageData> list = null;
		try {
			list = this.teacherFacade.selectTestById(testid);
			UtilDate date = null;
			Date d = date.getDateTime(list.get(0).getString("starttime"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			list.get(0).put("starttime", sdf.format(d));
			PageData pd = this.getPageData();
			pd.put("testid", testid);
			List<PageData> stu = this.teacherFacade.selectStudent(pd);
			String allStudent = stu.get(0).getString("count(stuid)");
			mv.addObject("allStudent", allStudent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mv.addObject("editTest", list.get(0));
		session.setAttribute("editTest", list.get(0));
		session.setAttribute("import", list.get(0).getString("testid"));
		return mv;
	}

	/*
	 * 更新考试信息
	 */
	@ResponseBody
	@RequestMapping("/updateTest")
	public Object updateTest() {
		boolean b = false;
		PageData pd = this.getPageData();
		try {
			b = this.teacherFacade.updateTest(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return b;
	}

	@ResponseBody
	@RequestMapping("/teacherUpload")
	public String upload(MultipartFile file, HttpServletRequest request, HttpServletRequest reponse)
			throws IOException {
		PageData pd = this.getPageData();

		// 根据考试 id 获取考试信息
		String testid = pd.getString("testid");
		List<PageData> list = this.teacherFacade.selectTestById(testid);

		// 保存路径为考试名
		String path = request.getSession().getServletContext()
				.getRealPath("/ExamSystem/" + list.get(0).getString("testname"));
		System.out.println("path>>" + path);

		String fileName = file.getOriginalFilename();
		// 将文件名加入到数据库
		pd.put("submit", fileName);
		this.teacherFacade.updateaddfile(pd);
		System.out.println("fileName>>" + fileName);

		File dir = new File(path, fileName);
		System.out.println("dir.exists()>>" + dir.exists());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		System.out.println("dir.exists()>>" + dir.exists());
//		MultipartFile自带的解析方法
		file.transferTo(dir);

		return "ok";
	}

	/*
	 * excel 导入名单
	 */
	@ResponseBody
	@RequestMapping("/excelUpload")
	public Object excelUpload(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletRequest reponse)
			throws IOException {
		PageData pd = this.getPageData();
		System.out.println(pd);
		String check = (String) this.teacherFacade.readExcel(file, pd);
		return check;
	}

	@ResponseBody
	@RequestMapping("/downTest")
	private void down(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 根据考试 id 获取考试信息
		// list = this.studentFacade.selectTestById(testid);
		PageData pd = this.getPageData();
		System.out.println(pd);
		String testid = pd.getString("testid");
		String testname = pd.getString("testname");
		String submit = pd.getString("submit");
		if (testname != null) {
			String path = request.getServletContext().getRealPath("/") + "ExamSystem/" + testname + "/";
			System.out.println(path);
			String fileName = submit;
			System.out.println(path + fileName);
			File file = new File(path + fileName);
			// File file = new
			// File("E:\\EclipseWorkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Exam_SSM\\测试5\\test.xlsx");
			System.out.println(file);
			if (file != null) {
				System.out.println("文件的名字：" + fileName);
				response.addHeader("content-disposition", "attachment;filename=" + fileName);
				FileUtils.copyFile(file, response.getOutputStream());
			}
		}
	}

}
