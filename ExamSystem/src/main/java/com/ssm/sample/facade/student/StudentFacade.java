package com.ssm.sample.facade.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.student.StudentService;
import com.ssm.sample.util.PageData;

public class StudentFacade extends BaseFacade {

	@Autowired
	StudentService studentService;

	public boolean updateStudentIp(PageData pd) {

		return this.studentService.updateStudentIp(pd);

	}

}
