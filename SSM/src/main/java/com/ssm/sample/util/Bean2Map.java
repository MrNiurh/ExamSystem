package com.ssm.sample.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bean2Map<T> {

	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Bean --> Map : 利用Introspector和PropertyDescriptor 将Bean --> Map
	 * 
	 * @param obj
	 * @return
	 */
	public Map<String, Object> convert(Object obj, boolean ignoreCase) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);
					if (ignoreCase) {
						map.put(key.toUpperCase(), value);// Key大写
					} else {
						map.put(key, value);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return map;
	}

	/**
	 * 转换成pagedata
	 * 
	 * @param obj
	 * @param ignoreCase
	 * @return
	 */
	public PageData convert2PageData(Object obj, boolean ignoreCase) {
		if (obj == null) {
			return null;
		}
		PageData result = new PageData();
		Map<String, Object> mp = this.convert(obj, ignoreCase);
		result.putAll(mp);
		return result;

	}

	/**
	 * 
	 * @param objList
	 * @param ignoreCase
	 * @return
	 */
	public List<PageData> convert2PageDataList(List<T> objList, boolean ignoreCase) {
		List<PageData> resultList = new ArrayList<>();
		objList.forEach((Object obj) -> {
			PageData pd = convert2PageData(obj, true);
			resultList.add(pd);
		});
		return resultList;
	}

}
