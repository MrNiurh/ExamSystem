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

	public boolean deleteTeacherById(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.delete("admin.adminMapper.deleteTeacherById", pd);
		return result > 0;
	}

	public boolean updateTeacherById(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.update("admin.adminMapper", pd);
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

}
