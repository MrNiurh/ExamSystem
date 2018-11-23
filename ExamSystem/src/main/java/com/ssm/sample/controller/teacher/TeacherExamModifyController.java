package com.ssm.sample.controller.teacher;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.annotations.Param;
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mv.addObject("editTest", list.get(0));
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
	 * @ResponseBody
	 * 
	 * @RequestMapping("/teacherUpload") public String upload(MultipartFile file,
	 * HttpServletRequest request) throws IOException {
	 * 
	 * String uploadFileName = ""; // 上传的文件名 String fieldName = ""; //
	 * 表单字段元素的name属性值 PrintWriter out = response.getWriter();// 获取out对象 //
	 * 请求信息中的内容是否是multipart类型 boolean isMultipart =
	 * ServletFileUpload.isMultipartContent(request); // 上传文件的存储路径（服务器文件系统上的绝对文件路径）
	 * ServletContext uploadFilePath = request.getSession().getServletContext(); //
	 * 创建临时文件目录路径 String path = uploadFilePath.getRealPath("/upload") + "/"; File
	 * tempPatchFile = new File(path); if (!tempPatchFile.exists()) // 判断文件或目录是否存在
	 * tempPatchFile.mkdirs(); // 创建指定的目录，包括所有必需但不存在的父目录 if (isMultipart) {
	 * DiskFileItemFactory factory = new DiskFileItemFactory(); // 设置缓冲区大小4kb
	 * factory.setSizeThreshold(4096); // 设置上传文件用到临时文件存放路径
	 * factory.setRepository(tempPatchFile); ServletFileUpload upload = new
	 * ServletFileUpload(factory); // 设置单个文件的最大限制 upload.setSizeMax(1024 * 30); try
	 * { // 解析form表单中所有文件 List<FileItem> items = upload.parseRequest(request);
	 * Iterator<FileItem> iter = items.iterator(); while (iter.hasNext()) { //
	 * 依次处理每个文件 FileItem item = (FileItem) iter.next(); if (!item.isFormField()) {
	 * // 文件表单字段 String fileName = item.getName(); // 通过Arrays类的asList()方法创建固定长度的集合
	 * // List<String> filType = Arrays.asList("gif", "bmp", "jpg"); String ext =
	 * fileName.substring(fileName.lastIndexOf(".") + 1); // if
	 * (!filType.contains(ext)) // 判断文件类型是否在允许范围内 //
	 * out.print("上传失败，文件类型只能是gif、bmp、jpg"); // else { if (fileName != null &&
	 * !fileName.equals("")) { File fullFile = new File(item.getName()); File
	 * saveFile = new File(path, fullFile.getName()); item.write(saveFile);
	 * uploadFileName = fullFile.getName(); out.print("上传成功后的文件名是：" + uploadFileName
	 * + "，文件大小是：" + item.getSize() + "bytes!");
	 * 
	 * // } } } } } catch (FileUploadBase.SizeLimitExceededException ex) {
	 * out.print("上传失败，文件太大，单个文件的最大限制是：" + upload.getSizeMax() + "bytes!"); } catch
	 * (Exception e) { e.printStackTrace(); } } return path; }
	 */
}
