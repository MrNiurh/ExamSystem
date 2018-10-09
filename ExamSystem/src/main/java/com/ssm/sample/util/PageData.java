package com.ssm.sample.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("rawtypes")
public class PageData extends HashMap implements Map {

	private static final long serialVersionUID = 1L;

	Map<Object, Object> map = null;
	HttpServletRequest request;
	public static void main(String[] args) {
		PageData pageData = new PageData();
		List<PageData> list = new ArrayList<>();
		PageData a=new PageData();
		a.put("key", "asdas");
		list.add(a);
//		list.add("asdas1");
//		list.add("asdas2");
		pageData.put("list", list);
		pageData.put("222", "23232");
		System.err.println(pageData);
	}
	public PageData(HttpServletRequest request) {
		this.request = request;
		Map properties = request.getParameterMap();
		Map<Object, Object> returnMap = new HashMap<Object, Object>();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				value = "";
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value += values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		map = returnMap;
	}

	public PageData() {
		map = new HashMap<Object, Object>();
	}

	public Object get(Object key) {
		Object obj = null;
		if (map.get(key) instanceof Object[]) {
			Object[] arr = (Object[]) map.get(key);
			obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}

	/**
	 * 以安全转换方式获取键值，如果找不到键则返回的值为空
	 * 
	 * @param key
	 * @return
	 */
	public String getString(Object key) {
		Object obj = get(key);
		return obj == null ? "" : obj.toString();
	}
	
	/**
	 * 以安全转换方式获取键值，如果找不到键则返回的值为null
	 */
	public String getStringNull(Object key) {
		Object obj = get(key);
		return obj == null ? null : obj.toString();
	}

	/**
	 * 添加键值对
	 */
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}
	
	
	/**
	 * 移除键
	 */
	public Object remove(Object key) {
		return map.remove(key);
	}
	
	/**
	 * 清空
	 */
	public void clear() {
		map.clear();
	}

	/**
	 * 是否包含键
	 */
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public Map<Object,Object> getMap(){
		return map;
	}

	/**
	 * 是否包含值
	 */
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public Set entrySet() {
		return map.entrySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set<Object> keySet() {
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		map.putAll(t);
	}

	public int size() {
		return map.size();
	}

	public Collection<Object> values() {
		return map.values();
	}

	/**
	 * 适用jdk8的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void forEach(BiConsumer action) {
		this.map.forEach(action);
	}
}
