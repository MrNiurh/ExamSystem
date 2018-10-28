package com.ssm.sample.facade.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.base.user.UserService;
import com.ssm.sample.util.PageData;

@Service("UserFacade")
public class UserFacade extends BaseFacade {

	@Autowired
	private UserService userservice;

	/*
	 * 获得学生
	 */
	public List<PageData> getStudent(PageData pd) {
		List<PageData> list = this.userservice.getStudent(pd);
		return list;
	}

	/*
	 * 获得教师
	 */
	public List<PageData> getTeacher(PageData pd) {
		List<PageData> list = this.userservice.getTeacher(pd);
		return list;
	}

	/*
	 * 获得管理员
	 */
	public List<PageData> getAdmin(PageData pd) {
		List<PageData> list = this.userservice.getAdmin(pd);
		return list;
	}

}
