package com.ssm.sample.facade.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.student.StudentService;
import com.ssm.sample.util.PageData;

@Service("StudentFacade")
public class StudentFacade extends BaseFacade {

	@Autowired
	StudentService studentService;

	/*
	 * 更新ip
	 */
	public boolean updateStudentIp(PageData pd) {

		return this.studentService.updateStudentIp(pd);

	}

}
