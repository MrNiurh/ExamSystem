package com.ssm.sample.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EnumUtil {
	@SuppressWarnings("rawtypes")
	public static List<PageData> getEnumList(Class<? extends Enum> enumClass) throws Exception {
		List<PageData> resultList = new ArrayList<PageData>();
		try {
			Method name = enumClass.getMethod("name"), getValue = enumClass.getMethod("getValue");

			Enum[] array = enumClass.getEnumConstants();
			for (Enum e : array) {
				PageData newMap = new PageData();
				newMap.put("name", name.invoke(e).toString());
				newMap.put("value", getValue.invoke(e).toString());
				resultList.add(newMap);
			}
		} catch (Exception e) {
		}
		return resultList;
	}
}
