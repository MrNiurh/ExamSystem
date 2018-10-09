package com.ssm.sample.util;

import java.util.UUID;

/**
 * 唯一标识字符串
 * 
 * @author Administrator
 *
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}
