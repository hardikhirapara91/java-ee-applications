package com.hardik.javaee.crud.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Property Utils
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class PropUtils {

	private static Properties properties;

	/**
	 * Initialize Properties
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Properties initializeProperty() throws IOException {
		if (properties == null) {
			properties = new Properties();
			properties.load(PropUtils.class.getClassLoader().getResourceAsStream("resources/db.properties"));
		}
		return properties;
	}

	/**
	 * Return Properties Value
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		try {
			properties = initializeProperty();
		} catch (IOException ex) {
			System.out.println(ex);
		}

		if (properties != null) {
			return (String) properties.get(key);
		}
		return null;
	}
}
