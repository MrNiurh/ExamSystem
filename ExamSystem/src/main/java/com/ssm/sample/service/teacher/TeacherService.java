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
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectSubmitStudent", pd);
		return list;
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

	public boolean insertStudent(PageData pd) {
		// TODO Auto-generated method stub
		int result = this.sqlSessionTemplate.insert("teacher.teacherMapper.insertStudent", pd);
		return result > 0;
	}

	public List<PageData> selectTests() {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectTests");
		return list;
	}

	public List<PageData> selectTeacherById(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectTeacherById", pd);
		return list;
	}

	public List<PageData> noLoginStudent(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectNoLoginStudent", pd);
		return list;
	}

	public List<PageData> noSubmitStudent(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectNoSubmitStudent", pd);
		return list;
	}

	public List<PageData> selectAllStudent(PageData pd) {
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectAllStudent", pd);
		return list;
	}

	public List<PageData> selectNowTest() {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectNowTest");
		return list;
	}

	public List<PageData> selectTestById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectTestById", testid);
		return list;
	}

	public boolean updateTest(PageData pd) {
		// TODO Auto-generated method stub

		return this.sqlSessionTemplate.update("teacher.teacherMapper.updateTest", pd) > 0;
	}

	public List<PageData> selectAfterTest() {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectAfterTest");
		return list;
	}

	public boolean updateSignal(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("teacher.teacherMapper.updateSignal", pd) > 0;
	}

	public List<PageData> selectUploadById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectUploadById", testid);
		return list;
	}

	public boolean deleteStuentsAfter(String testid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteStuentsAfter", testid) > 0;
	}

	public boolean deleteTestAfter(String testid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteTestAfter", testid) > 0;
	}

	public boolean deleteUploadAfter(String testid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteUploadAfter", testid) > 0;
	}

	public boolean deleteInfosAfter() {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteInfosAfter") > 0;
	}

	public boolean updatePassword(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("teacher.teacherMapper.updatePassword", pd) > 0;
	}

	public List<PageData> selectTeacherById(int i) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectTeacherByInt", i);
		return list;
	}

	public boolean insertNotify(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("teacher.teacherMapper.insertNotify", pd) > 0;
	}

	public List<PageData> selectInfos() {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectInfos");
		return list;
	}

	public List<PageData> controllStudentByIp(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.controllStudentByIp", pd);
		return list;
	}

	public boolean deleteInfo(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteOneInfo", pd) > 0;
	}

	public boolean deleteOnrStuent(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("teacher.teacherMapper.deleteOnrStuent", pd) > 0;
	}

	public List<PageData> selectSystem() {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("teacher.teacherMapper.selectSystem");
		return list;
	}

}
