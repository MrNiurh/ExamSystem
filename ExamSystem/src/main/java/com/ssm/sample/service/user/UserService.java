package com.ssm.sample.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.sample.service.base.BaseService;
import com.ssm.sample.util.PageData;

@Service("UserService")
public class UserService extends BaseService {

	/*
	 * 学生
	 */
	public List<PageData> getStudent(PageData pd) {
		return this.sqlSessionTemplate.selectList("user.userMapper.getStudent", pd);
	}

	/*
	 * 教师
	 */
	public List<PageData> getTeacher(PageData pd) {
		return this.sqlSessionTemplate.selectList("user.userMapper.getTeacher", pd);
	}

	/*
	 * 管理员
	 */
	public List<PageData> getAdmin(PageData pd) {
		return this.sqlSessionTemplate.selectList("user.userMapper.getAdmin", pd);
	}
}
