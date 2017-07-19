package com.hardik.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Database Connection
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DBConnection {

	private static Connection connection = null;

	/**
	 * Get DB Connection
	 * 
	 * @return Connection Object
	 */
	public static Connection getConnection() {

		Properties properties = new Properties();
		InputStream is = DBConnection.class.getClassLoader()
				.getResourceAsStream("resources/db.properties");
		try {
			properties.load(is);

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			if (connection == null) {
				try {
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user,
							password);
					System.out.println("Connection created successfully.");
				} catch (ClassNotFoundException e) {
					System.out.println("Exception: " + e.getMessage());
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Connection not created.");
				}

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return connection;
	}

	/**
	 * Close DB Connection
	 */
	public static void releaseConnection() {
		Connection connection = DBConnection.getConnection();

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
