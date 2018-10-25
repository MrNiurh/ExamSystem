package com.ssm.sample.service.base;

import java.util.Properties;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.ssm.sample.util.Logger;

public class BaseService {
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;
	
	@Resource(name = "globalConf")
	protected Properties globalConf;
}
