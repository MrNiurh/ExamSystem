package com.ssm.sample.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class Map2Bean<T> {

	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
	 * 
	 * @param map
	 * @param obj
	 * @return
	 */
	public T convert(final Map<String, Object> paramMap, Class<T> cls, boolean ignoreCase) {
		T obj = null;
		try {
			obj = cls.newInstance();
			// 20161122忽略下划线,全部大写
			HashMap<String, Object> map = new HashMap<String, Object>();
			paramMap.forEach((key, value) -> {
				map.put(key.toUpperCase().replaceAll("_", ""), value);
			});
			BeanInfo beanInfo = Introspector.getBeanInfo(cls);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				// 忽略大小写要全部大写 //20161122忽略下划线
				String beanKey = ignoreCase ? property.getName().toUpperCase().replaceAll("_", "") : property.getName().replaceAll("_", "");
				// 对于BigDecimal的单独处理
				if (property.getPropertyType().toString().equals("class java.math.BigDecimal")) {
					Object value = map.get(beanKey);
					if (value == null)
						value = 0;
					BigDecimal big_value = new BigDecimal(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, big_value);
					// 对于Integer的单独处理
				} else if (property.getPropertyType().toString().equals("class java.lang.Integer")) {
					Object value = map.get(beanKey);
					if (value == null)
						value = 0;
					Integer i_value = new Integer(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, i_value);
					// 对于Short的单独处理
				} else if (property.getPropertyType().toString().equals("class java.lang.Short")) {
					Object value = map.get(beanKey);
					if (value == null)
						value = 0;
					Short s_value = new Short(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, s_value);
					// 对于Date的单独处理
				} else if (property.getPropertyType().toString().equals("class java.util.Date")) {
					Object value = map.get(beanKey);
					if (value == null) {
						value = "1970.01.01";
					}
					// 对map中data类型做处理
					Date d_value = (value instanceof java.util.Date) ? (java.util.Date) value : new SimpleDateFormat("yyyy.MM.dd").parse(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, d_value);
				} else {
					Object value = null;
					if (map.containsKey(beanKey)) {
						value = map.get(beanKey);
						// 得到property对应的setter方法
						Method setter = property.getWriteMethod();
						setter.invoke(obj, value);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return obj;

	}

	/**
	 * Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
	 * 
	 * @param map
	 * @param obj
	 * @return
	 */
	public T convert(final Map<String, Object> paramMap, Class<T> cls, boolean ignoreCase, boolean ignoreNotExists) {

		T obj = null;
		try {
			obj = cls.newInstance();

			// 20161122忽略下划线,全部大写
			HashMap<String, Object> map = new HashMap<String, Object>();
			paramMap.forEach((key, value) -> {
				map.put(key.toUpperCase().replaceAll("_", ""), value);
			});

			BeanInfo beanInfo = Introspector.getBeanInfo(cls);

			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				// 忽略大小写要全部大写 //20161122忽略下划线
				String beanKey = ignoreCase ? property.getName().toUpperCase().replaceAll("_", "") : property.getName().replaceAll("_", "");

				String beanType = property.getPropertyType().toString();

				Object value = null;
				Method setter = property.getWriteMethod();

				try {
					System.out.println(beanKey);
					if (beanKey.equals("CONTRACTID")) {
						System.out.println(beanKey);
					}

					boolean isNeedSet = true;
					if (map.containsKey(beanKey)) {
						value = map.get(beanKey);
						// 空值处理
						if (value == null) {
							if (ignoreNotExists) {// 忽略不存在
								// do nothing
								isNeedSet = false;
							} else if (value instanceof String && StringUtils.isEmpty(value)) {
								isNeedSet = true;
								value = "";
							} else {
								// 设值
								isNeedSet = true;
								value = null;
							}
						} else {
							isNeedSet = true;
						}
					} else {
						isNeedSet = false;
					}

					// 对于BigDecimal的单独处理
					if (beanType.equals("class java.math.BigDecimal")) {

						if (isNeedSet) {
							value = map.get(beanKey);
							setter.invoke(obj, StringUtils.isEmpty(value) ? null : new BigDecimal(value.toString()));
						} else if (ignoreNotExists) {
							// donoting
						}
					} else if (beanType.equals("class java.lang.Integer")) {
						if (isNeedSet) {
							value = map.get(beanKey);
							setter.invoke(obj, StringUtils.isEmpty(value) ? null : new Integer(value.toString()));
						} else if (ignoreNotExists) {
							// donoting
						}
					} else if (beanType.equals("class java.lang.Short")) {
						if (isNeedSet) {
							value = map.get(beanKey);
							setter.invoke(obj, StringUtils.isEmpty(value) ? null : new Short(value.toString()));
						} else if (ignoreNotExists) {
							// donoting
						}

						// 对于Date的单独处理
					} else if (beanType.equals("class java.util.Date")) {
						if (isNeedSet) {
							setter.invoke(obj, ((value == null) || (value instanceof java.util.Date)) ? value : new SimpleDateFormat("yyyy.MM.dd").parse(value.toString()));
						} else if (ignoreNotExists) {
							// donoting
						}

						// String
					} else if (beanType.equals("class java.lang.String")) {
						if (isNeedSet) {
							setter.invoke(obj, StringUtils.isEmpty(value) ? "" : value.toString());
						} else if (ignoreNotExists) {
							// donoting
						}

					} else {
						if (isNeedSet) {
							setter.invoke(obj, value);
						} else if (ignoreNotExists) {// 忽略不存在
							// donoting
						}
					}
				} catch (Exception ex) {
					logger.error("beanKey:" + beanKey);
					logger.error(ex.toString(), ex);
					throw ex;
				}
			}

		} catch (

		Exception e) {
			logger.error(e.toString(), e);
		}
		return obj;
	}

	public T convert2String(final Map<String, Object> paramMap, Class<T> cls, boolean ignoreCase) {

		T obj = null;
		try {
			obj = cls.newInstance();
			// 20161122忽略下划线,全部大写
			HashMap<String, Object> map = new HashMap<String, Object>();
			paramMap.forEach((key, value) -> {
				map.put(key.toUpperCase().replaceAll("_", ""), value);
			});

			BeanInfo beanInfo = Introspector.getBeanInfo(cls);

			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				// 忽略大小写要全部大写 //20161122忽略下划线
				String beanKey = ignoreCase ? property.getName().toUpperCase().replaceAll("_", "") : property.getName().replaceAll("_", "");

				// 对于BigDecimal的单独处理
				if (property.getPropertyType().toString().equals("class java.math.BigDecimal")) {
					Object value = map.get(beanKey);
					if (value == null)
						value = 0;
					BigDecimal big_value = new BigDecimal(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, big_value.toString());

					// 对于Integer的单独处理
				} else if (property.getPropertyType().toString().equals("class java.lang.Integer")) {
					Object value = map.get(beanKey);
					if (value == null)
						value = 0;
					Integer i_value = new Integer(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, i_value.toString());

					// 对于Short的单独处理
				} else if (property.getPropertyType().toString().equals("class java.lang.Short")) {
					Object value = map.get(beanKey);
					if (value == null)
						value = 0;
					Short s_value = new Short(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, s_value.toString());

					// 对于Date的单独处理
				} else if (property.getPropertyType().toString().equals("class java.util.Date")) {
					Object value = map.get(beanKey);
					if (value == null) {
						value = "1970-01-01";
					}
					// 对map中data类型做处理
					Date d_value = (value instanceof java.util.Date) ? (java.util.Date) value : new SimpleDateFormat("yyyyMMdd").parse(value.toString());
					Method setter = property.getWriteMethod();
					setter.invoke(obj, d_value.toString());

				} else {
					Object value = null;
					if (map.containsKey(beanKey)) {
						value = map.get(beanKey);
						if (value == null) {
							value = "";
						}
						// 得到property对应的setter方法
						Method setter = property.getWriteMethod();
						setter.invoke(obj, value.toString());
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return obj;
	}
}
