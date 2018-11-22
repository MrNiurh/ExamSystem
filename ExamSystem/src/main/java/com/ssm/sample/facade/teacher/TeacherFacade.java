package com.ssm.sample.facade.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.teacher.TeacherService;
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
	 * 删除通知
	 */
	public boolean deleteTestmsg(PageData pd) {
		return this.teacherService.deleteTestmsg(pd);
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
	public List<PageData> selectTeacherById(int id) {
		List<PageData> list = this.teacherService.selectTeacherById(id);
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
	
	public List<PageData> selectAllStudent(PageData pd){
		List<PageData> list = this.teacherService.selectAllStudent(pd);
		return list;
	}

	public List<PageData> selectNowTest() {
		// TODO Auto-generated method stub
		List<PageData> list = this.teacherService.selectNowTest();
		return list;
	}

}
