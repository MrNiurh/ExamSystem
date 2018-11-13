package com.ssm.sample.service.student;

import org.springframework.stereotype.Service;

import com.ssm.sample.service.base.BaseService;
import com.ssm.sample.util.PageData;

@Service("StudentService")
public class StudentService extends BaseService {

	public boolean updateStudentIp(PageData pd) {
		int result = this.sqlSessionTemplate.update("student.studentMapper.updateStudentIp", pd);
		return result > 0;

	}

}
