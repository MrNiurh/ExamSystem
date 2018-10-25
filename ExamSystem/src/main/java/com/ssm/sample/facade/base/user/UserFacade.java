package com.ssm.sample.facade.base.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.sample.facade.base.BaseFacade;
import com.ssm.sample.service.base.user.UserService;
import com.ssm.sample.util.PageData;

@Service("userFacade")
public class UserFacade extends BaseFacade{
	
	@Autowired
	private UserService userservice;
	
	public List<PageData> getTeacher(PageData pd){
		return userservice.getTeacher(pd);
	}

}
