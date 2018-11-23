package com.ssm.sample.service.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.sample.service.base.BaseService;
import com.ssm.sample.util.PageData;

@Service("StudentService")
public class StudentService extends BaseService {

	public boolean updateStudentIp(PageData pd) {
		int result = this.sqlSessionTemplate.update("student.studentMapper.updateStudentIp", pd);
		return result > 0;

	}

	public List<PageData> selectTestById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.sqlSessionTemplate.selectList("student.studentMapper.selectTestById", testid);
		return list;
	}

	public boolean insertUploadFile(PageData pd) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("student.studentMapper.insertUploadFile", pd) > 0;
	}

	public List<PageData> selectUploadFile(PageData pd) {
		List<PageData> list = this.sqlSessionTemplate.selectList("student.studentMapper.selectUploadFile", pd);
		// TODO Auto-generated method stub
		return list;
	}

}
