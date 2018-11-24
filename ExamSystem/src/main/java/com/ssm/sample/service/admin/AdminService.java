package com.ssm.sample.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.sample.service.base.BaseService;
import com.ssm.sample.util.PageData;

@Service("AdminService")
public class AdminService extends BaseService {

	public boolean insertTeacher(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.insert("admin.adminMapper.insertTeacher", pd);
		return result > 0;
	}

	public boolean deleteTeacherById(String pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.delete("admin.adminMapper.deleteTeacherById", pd);
		return result > 0;
	}

	public boolean updateTeacherById(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.update("admin.adminMapper.updateTeacherById", pd);
		return result > 0;
	}

	public boolean updateSystem(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.update("admin.adminMapper.updateSystem", pd);
		return result > 0;
	}

	public boolean updateTeacherpwd(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.update("admin.adminMapper.updateTeacherpwd", pd);
		return false;
	}

	public List<PageData> getAllTeacher(PageData pd) {
		// TODO Auto-generated method stub

		return this.sqlSessionTemplate.selectList("admin.adminMapper.getAllTeacher", pd);
	}

	public List<PageData> selectSystem() {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("admin.adminMapper.selectSystem");
	}

	public List<PageData> getTeacherById(String id) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("admin.adminMapper.getTeacherById", id);
		return list;
	}
	
	public boolean deleteStuentsAfter(String testid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("admin.adminMapper.deleteStuentsAfter", testid) > 0;
	}

	public boolean deleteTestAfter(String testid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("admin.adminMapper.deleteTestAfter", testid) > 0;
	}

	public boolean deleteUploadAfter(String testid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("admin.adminMapper.deleteUploadAfter", testid) > 0;
	}

	public boolean deleteInfosAfter() {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("admin.adminMapper.deleteInfosAfter") > 0;
	}

}
