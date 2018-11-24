package com.ssm.sample.util;

import java.io.File;

public class DeleteFolderUtil {
	/*
	 * 删除文件夹下所有内容
	 */
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}

}
