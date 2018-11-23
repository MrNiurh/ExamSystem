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
}
