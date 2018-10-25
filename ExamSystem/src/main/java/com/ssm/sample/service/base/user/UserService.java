package com.ssm.sample.service.base.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.sample.service.base.BaseService;
import com.ssm.sample.util.PageData;

@Service("userService")
public class UserService extends BaseService {

	public List<PageData> getTeacher(PageData pd) {
		return this.sqlSessionTemplate.selectList("user.userMapper.getTeacher");
	}
}
