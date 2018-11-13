package com.ssm.sample.service.teacher;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.sample.service.base.BaseService;
import com.ssm.sample.util.PageData;

@Service("TeacherService")
public class TeacherService extends BaseService {

	/*
	 * 添加考试
	 */
	public boolean insertTest(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.insert("teacher.teacherMapper.insertTest", pd);
		return result > 0;
	}

	public boolean updateaddfile(PageData pd) {
		int result = this.sqlSessionTemplate.update("teacher.teacherMapper.updateaddfile", pd);
		return result > 0;
	}

	public List<PageData> selectStudent(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectStudent", pd);
	}

	public List<PageData> selectLoginStudent(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectLoginStudent", pd);
	}

	public List<PageData> selectSubmitStudent(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectSubmitStudent", pd);
	}

	public List<PageData> selectinfoStudent(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectinfoStudent", pd);
	}

	public List<PageData> selectStudentByIp(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectStudentByIp", pd);
	}

	public boolean insertTestmsg(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.insert("teacher.teacherMapper.insertTestmsg", pd);
		return result > 0;
	}

	public boolean deleteTestmsg(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteTestmsg", pd);
		return result > 0;
	}

	public boolean insertStudent(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.insert("teacher.teacherMapper.insertStudent", pd);
		return result > 0;
	}

}
