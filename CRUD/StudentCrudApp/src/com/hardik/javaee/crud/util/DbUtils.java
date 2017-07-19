package com.hardik.javaee.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database Utils
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DbUtils {

	private static Connection connection;

	/**
	 * Return DB Connection
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		String URL = PropUtils.getProperty("URL");
		String DB_NAME = PropUtils.getProperty("DB_NAME");
		String USERNAME = PropUtils.getProperty("USERNAME");
		String PASSWORD = PropUtils.getProperty("PASSWORD");

		if (connection == null) {
			Class.forName(PropUtils.getProperty("JDBC_CLASS"));
			connection = DriverManager.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
		}

		return connection;
	}

	/**
	 * Close DB Connection
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
