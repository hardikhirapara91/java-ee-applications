package com.hardik.javaee.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Property Util
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class PropertyUtil {

	static Logger logger = Logger.getLogger(PropertyUtil.class);
	private static Properties prop = null;

	public PropertyUtil() {
		if (prop == null) {
			try {
				prop = new Properties();
				prop.load(PropertyUtil.class.getClassLoader().getResourceAsStream("resources/db.properties"));
				logger.debug("Property file loaded successfully.");
			} catch (IOException ex) {
				logger.error("IOException while loading property file: ", ex);
			}
		}
	}

	/**
	 * Get Property
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		new PropertyUtil();
		if (prop != null) {
			return prop.getProperty(key);
		}
		return null;
	}
}
