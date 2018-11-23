package com.ssm.sample.facade.student;

import java.util.List;

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

	public List<PageData> selectTestById(String testid) {
		// TODO Auto-generated method stub
		List<PageData> list = this.studentService.selectTestById(testid);
		return list;
	}

	public boolean insertUploadFile(PageData pd) {
		// TODO Auto-generated method stub
		
		return this.studentService.insertUploadFile(pd);
	}

	public List<PageData> selectUploadFile(PageData pd) {
		// TODO Auto-generated method stub
		List<PageData> list = this.studentService.selectUploadFile(pd);
		return list;
	}

}
