package com.hardik.javaee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB Util
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DbUtils {

	private Connection connection = null;

	/**
	 * Get DB Connection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
						PropertyUtil.getProperty("URL") + PropertyUtil.getProperty("DB_NAME"),
						PropertyUtil.getProperty("USERNAME"), PropertyUtil.getProperty("PASSWORD"));
				System.out.println("DB Connection Created Successfully...");
			} catch (SQLException | ClassNotFoundException ex) {
				System.out.println("ERROR: DB Connection: " + ex);
			}
		}

		return connection;
	}

	/**
	 * Close DB Connection
	 */
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				System.out.println("Exception while closing db connection: " + ex);
			}
		}
	}

}
