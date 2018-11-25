package com.ssm.sample.facade.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.admin.AdminService;
import com.ssm.sample.util.PageData;

@Service("AdminFacade")
public class AdminFacade extends BaseFacade {

	@Autowired
	AdminService adminService;

	/*
	 * 查询所有教师
	 */
	public List<PageData> getAllTeacher(PageData pd) {
		return this.adminService.getAllTeacher(pd);
	}

	/*
	 * 添加教师
	 */
	public boolean insertTeacher(PageData pd) {
		return this.adminService.insertTeacher(pd);
	}

	/*
	 * 通过 id 删除教师
	 */
	public boolean deleteTeacherById(String pd) {
		return this.adminService.deleteTeacherById(pd);
	}

	/*
	 * 更新教师信息
	 */
	public boolean updateTeacherById(PageData pd) {
		return this.adminService.updateTeacherById(pd);
	}

	public List<PageData> selectSystem() {
		return this.adminService.selectSystem();
	}

	/*
	 * 更新系统配置信息
	 */
	public boolean updateSystem(PageData pd) {
		return this.adminService.updateSystem(pd);
	}

	/*
	 * 重置密码
	 */
	public boolean updateTeacherpwd(PageData pd) {
		return this.adminService.updateTeacherpwd(pd);
	}

	public List<PageData> getTeacherById(String id) {
		// TODO Auto-generated method stub
		List<PageData> list = this.adminService.getTeacherById(id);
		return list;
	}

	/*
	 * 删除学生信息
	 */
	public boolean deleteStuentsAfter(String testid) {
		return this.adminService.deleteStuentsAfter(testid);
	}

	/*
	 * 删除文件信息
	 */
	public boolean deleteUploadAfter(String testid) {
		return this.adminService.deleteUploadAfter(testid);
	}

	/*
	 * 删除通知信息
	 */
	public boolean deleteInfosAfter() {
		return this.adminService.deleteInfosAfter();
	}

	/*
	 * 删除考试信息
	 */
	public boolean deleteTestAfter(String testid) {
		return this.adminService.deleteTestAfter(testid);
	}

	public List<PageData> selectAfterTest() {
		// TODO Auto-generated method stub
		List<PageData> list = this.adminService.selectAfterTest();
		return list;
	}

	public List<PageData> selectTeacherById(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.adminService.selectTeacherById(pd);
		return list;
	}

	public boolean updateSignal(PageData pd) {
		// TODO Auto-generated method stub
		return this.adminService.updateSignal(pd);
	}

	public List<PageData> selectTestById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.adminService.selectTestById(testid);
		return list;
	}

	public boolean updatePassword(PageData pd) {
		return this.adminService.updatePassword(pd);
	}

}
