package com.ssm.sample.controller.teacher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
import com.ssm.sample.facade.teacher.TeacherFacade;
import com.ssm.sample.util.DeleteFolderUtil;
import com.ssm.sample.util.PageData;
import com.ssm.sample.util.UtilDate;
import com.ssm.sample.util.ZipUtil;

@Controller
@RequestMapping({ "/teacher" })
public class TeacherExamAfterController extends BaseController {

	@Autowired
	TeacherFacade teacherFacade;

	/*
	 * 考后操作
	 */
	@RequestMapping(value = "/teacher_afterexam")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacher_exam_after");

		try {
			List<PageData> list = this.teacherFacade.selectAfterTest();
			UtilDate date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < list.size(); i++) {
				// 添加教师名
				PageData pd = this.getPageData();
				pd.put("id", list.get(i).get("tea_id"));
				List<PageData> teacher = this.teacherFacade.selectTeacherById(pd);
				list.get(i).put("teacherName", teacher.get(0).get("fullname"));
				// 时间格式化
				Date d = date.getDateTime(list.get(i).getString("starttime"));
				list.get(i).put("starttime", sdf.format(d));
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
			b = this.teacherFacade.updateSignal(pd);
			// 开始考试
			if (b == true && pd.getString("test_signal").equals("1")) {
				List<PageData> list = this.teacherFacade.selectTestById(pd.getString("testid"));
				application.setAttribute("testid", pd.getString("testid"));
				application.setAttribute("appTestName", list.get(0).getString("testname"));
				application.setAttribute("RunTest", list);
			}
			// 结束考试
			if (b == true && pd.getString("test_signal").equals("2")) {
				application.removeAttribute("testid");
				application.removeAttribute("appTestName");
				application.removeAttribute("RunTest");
				application.removeAttribute("clear");
				this.teacherFacade.deleteInfosAfter();
			}
			// 清理考试
			if (b == true && pd.getString("test_signal").equals("4")) {
				List<PageData> list = this.teacherFacade.selectTestById(pd.getString("testid"));

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
				this.teacherFacade.deleteUploadAfter(testid);
				this.teacherFacade.deleteStuentsAfter(testid);
				this.teacherFacade.deleteTestAfter(testid);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	/*
	 * excel 导出提交信息
	 */
	@ResponseBody
	@RequestMapping("/excelExport")
	public void excelExport(HttpServletRequest request, HttpServletRequest reponse) throws IOException {
		PageData pd = this.getPageData();
		System.out.println(pd);
		String testid = pd.getString("testid");
		List<PageData> test = this.teacherFacade.selectTestById(testid);
		List<PageData> list = this.teacherFacade.selectUploadById(testid);
		System.out.println(list);
		String[] title = { "学号", "提交时间", "文件名", "文件大小" };
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		for (int i = 1; i < list.size(); i++) {
			HSSFRow nextrow = sheet.createRow(i);
			HSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue(list.get(i).getString("stuid"));
			cell2 = nextrow.createCell(1);
			cell2.setCellValue(list.get(i).getString("fileuptime"));
			cell2 = nextrow.createCell(2);
			cell2.setCellValue(list.get(i).getString("filename"));
			cell2 = nextrow.createCell(3);
			cell2.setCellValue(list.get(i).getString("filesize"));
		}
		String fileName = test.get(0).getString("testname") + ".xls";
		System.out.println(fileName);
		String path = request.getSession().getServletContext().getRealPath("/") + "ExamSystem/" + fileName;
		File file = new File(path);
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.addHeader("content-disposition", "attachment;filename=" + fileName);
		FileUtils.copyFile(file, response.getOutputStream());

	}

	@ResponseBody
	@RequestMapping("/downZip")
	public void downZip(HttpServletRequest request, HttpServletRequest reponse) throws IOException {

		PageData pd = this.getPageData();
		//response.setContentType("application/x-msdownload;");
		// System.out.println(pd);
		String testid = pd.getString("testid");
		System.out.println(testid);
		List<PageData> list = new ArrayList<PageData>();
		if (this.teacherFacade.selectTestById(testid) != null) {
			// 归档考试
			pd.put("test_signal", "3");
			this.teacherFacade.updateSignal(pd);
			list = this.teacherFacade.selectTestById(testid);
		}

		if (list != null) {

			try {

				String testName = list.get(0).getString("testname");
				String sourcePath = request.getServletContext().getRealPath("/") + "ExamSystem/" + testName;
				System.out.println(sourcePath);
				String zipName = testName + ".zip";
				zipName = new String(zipName.getBytes(), "ISO8859-1");
				System.out.println(zipName);
				String zipPath = request.getServletContext().getRealPath("/") + "ExamSystem/" + zipName;
				File file = new File(sourcePath);// 要被压缩的文件夹
				File zipFile = new File(zipPath);
				ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
				if (file.isDirectory()) {
					File[] files = file.listFiles();
					for (File fileSec : files) {
						ZipUtil.recursionZip(zipOut, fileSec, "");
					}
				}
				zipOut.close();

				if (zipFile != null) {
					System.out.println("文件的名字：" + zipName);
					response.addHeader("content-disposition", "attachment;filename=" + zipName);
					FileUtils.copyFile(zipFile, response.getOutputStream());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
