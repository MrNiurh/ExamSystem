package com.ssm.sample.facade.teacher;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.teacher.TeacherService;
import com.ssm.sample.util.GetCellValues;
import com.ssm.sample.util.PageData;

@Service("TeacherFacade")
public class TeacherFacade extends BaseFacade {

	@Autowired
	TeacherService teacherService;

	/*
	 * 添加考试
	 */
	public boolean insertTest(PageData pd) {
		return this.teacherService.insertTest(pd);
	}

	/*
	 * 添加试卷
	 */
	public boolean updateaddfile(PageData pd) {
		return this.teacherService.updateaddfile(pd);
	}

	/*
	 * 查询考试人数
	 */
	public List<PageData> selectStudent(PageData pd) {
		return this.teacherService.selectStudent(pd);
	}

	/*
	 * 查询登录人数
	 * 
	 */
	public List<PageData> selectLoginStudent(PageData pd) {
		return this.teacherService.selectLoginStudent(pd);
	}

	/*
	 * 查询提交答案的学生个数
	 * 
	 */
	public List<PageData> selectSubmitStudent(PageData pd) {
		List<PageData> list = this.teacherService.selectSubmitStudent(pd);
		return list;
	}

	/*
	 * 查找学生
	 */
	public List<PageData> selectinfoStudent(PageData pd) {
		return this.teacherService.selectinfoStudent(pd);
	}

	/*
	 * 
	 * 通过ip查找学生
	 */
	public List<PageData> selectStudentByIp(PageData pd) {
		return this.teacherService.selectStudentByIp(pd);
	}

	/*
	 * 添加通知
	 */
	public boolean insertTestmsg(PageData pd) {
		return this.teacherService.insertTestmsg(pd);
	}

	/*
	 * 添加学生
	 */
	public boolean insertStudent(PageData pd) {
		return this.teacherService.insertStudent(pd);
	}

	/*
	 * 查询所有考试
	 */
	public List<PageData> selectTests() {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectTests();
		return list;
	}

	/*
	 * 根据 id 查询教师
	 */
	public List<PageData> selectTeacherById(PageData pd) {
		List<PageData> list = this.teacherService.selectTeacherById(pd);
		return list;

	}

	/*
	 * 查询未登录学生
	 */
	public List<PageData> selectNoLoginStudent(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.noLoginStudent(pd);
		return list;
	}

	/*
	 * 查询未提交学生数
	 */
	public List<PageData> selectNoSubmitStudent(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.noSubmitStudent(pd);
		return list;
	}

	public List<PageData> selectAllStudent(PageData pd) {
		List<PageData> list = this.teacherService.selectAllStudent(pd);
		return list;
	}

	public List<PageData> selectNowTest() {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectNowTest();
		return list;
	}

	public List<PageData> selectTestById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectTestById(testid);
		return list;
	}

	/*
	 * 更新考试信息
	 */
	public boolean updateTest(PageData pd) {
		// TODO Auto-generated method stub
		return this.teacherService.updateTest(pd);
	}

	/*
	 * 查询考后
	 */
	public List<PageData> selectAfterTest() {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectAfterTest();
		return list;
	}

	/*
	 * 更新标志位
	 */
	public boolean updateSignal(PageData pd) {
		// TODO Auto-generated method stub
		return this.teacherService.updateSignal(pd);
	}

	/*
	 * excel 导入名单
	 */
	public Object readExcel(MultipartFile file, PageData pd) throws IOException {
		// TODO Auto-generated method stub
		String fileName = file.getOriginalFilename();
		Workbook workbook = null;
		String check = "";
		InputStream in = file.getInputStream();
		System.out.println(fileName);
		if (fileName.endsWith("xls")) {
			workbook = new HSSFWorkbook(in);
		} else if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(in);
		}
		String[] title = { "学号", "姓名", "班级" };
		if (workbook != null) {
			Sheet sheet = workbook.getSheetAt(0);
			// 获得当前sheet的开始行
			int firstRowNum = sheet.getFirstRowNum();
			// 获得当前sheet的结束行
			int lastRowNum = sheet.getLastRowNum();
			Row row = null;
			int firstCellNum = 0;
			int lastCellNum = 0;
			Cell cell = null;
			String value = "";
			row = sheet.getRow(firstRowNum);
			// 获得当前行的开始列
			firstCellNum = row.getFirstCellNum();
			// 获得当前行的列数
			lastCellNum = row.getPhysicalNumberOfCells();

			// 循环当前行
			for (int cellNum = firstCellNum; cellNum < lastCellNum + firstCellNum; cellNum++) {
				cell = row.getCell(cellNum);
				value = (String) GetCellValues.getCellValue(cell);
				if (title[cellNum].equals(value)) {
					check = "true";
				} else {
					check = "false";
					break;
				}
			}
			System.out.println(check);
			if (check.equals("true")) {
				// 循环除了第一行的所有行
				for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
					// 获得当前行
					row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 获得当前行的开始列
					firstCellNum = row.getFirstCellNum();
					// 获得当前行的列数
					lastCellNum = row.getPhysicalNumberOfCells();
					// 循环当前行
					for (int cellNum = firstCellNum; cellNum < lastCellNum + firstCellNum; cellNum++) {
						cell = row.getCell(cellNum);
						value = (String) GetCellValues.getCellValue(cell);
						if (pd != null) {
							switch (cellNum) {
							case 0:
								pd.put("stuid", value);
								break;
							case 1:
								pd.put("stuname", value);
								break;
							case 2:
								pd.put("stuclass", value);
								break;
							default:
								break;
							}
						}

					}
					boolean b = this.teacherService.insertStudent(pd);
				}
			}

		}
		return check;

		// TODO: handle exception
	}

	public List<PageData> selectUploadById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectUploadById(testid);
		return list;
	}

	/*
	 * 删除学生信息
	 */
	public boolean deleteStuentsAfter(String testid) {
		return this.teacherService.deleteStuentsAfter(testid);
	}

	/*
	 * 删除文件信息
	 */
	public boolean deleteUploadAfter(String testid) {
		return this.teacherService.deleteUploadAfter(testid);
	}

	/*
	 * 删除通知信息
	 */
	public boolean deleteInfosAfter() {
		return this.teacherService.deleteInfosAfter();
	}

	/*
	 * 删除考试信息
	 */
	public boolean deleteTestAfter(String testid) {
		return this.teacherService.deleteTestAfter(testid);
	}

	public boolean updatePassword(PageData pd) {
		return this.teacherService.updatePassword(pd);

	}

	public List<PageData> selectTeacherById(int i) {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectTeacherById(i);
		return list;
	}

	public boolean insertNotify(PageData pd) {
		// TODO Auto-generated method stub
		return this.teacherService.insertNotify(pd);
	}

	public List<PageData> selectInfos() {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectInfos();
		return list;
	}

	public List<PageData> controllStudentByIp(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.controllStudentByIp(pd);
		return list;
	}

	public boolean deleteInfo(PageData pd) {
		// TODO Auto-generated method stub
		return this.teacherService.deleteInfo(pd);
	}

	public boolean deleteOnrStuent(PageData pd) {
		// TODO Auto-generated method stub
		return this.teacherService.deleteOnrStuent(pd);
	}

	public List<PageData> selectSystem() {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectSystem();
		return list;
	}

}
