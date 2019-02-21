package com.bkav.portal.portlet.topic.memcached.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MemcachedUtil {
	
	public static String getPropertyValue(String filePatch, String key) {
		try {
			File f = new File(filePatch);
			if (f.exists()) {
				Properties pro = new Properties();
				FileInputStream in = new FileInputStream(f);
				pro.load(in);

				String p = pro.getProperty(key);
				return p;
			} else {
				System.out.println("File not found!");
				return null;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
}
