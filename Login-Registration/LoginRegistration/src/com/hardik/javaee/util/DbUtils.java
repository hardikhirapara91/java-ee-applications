package com.hardik.javaee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * DB Util
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DbUtils {

	static Logger logger = Logger.getLogger(DbUtils.class);
	private Connection connection = null;

	/**
	 * Get DB Connection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		logger.debug("Initializing db connection...");
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
						PropertyUtil.getProperty("URL") + PropertyUtil.getProperty("DB_NAME"),
						PropertyUtil.getProperty("USERNAME"), PropertyUtil.getProperty("PASSWORD"));
				logger.debug("DB Connection Created Successfully...");
			} catch (SQLException | ClassNotFoundException ex) {
				logger.error("Exception while initializing database connection: ", ex);
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
				logger.debug("Database connection closed successfully.");
			} catch (SQLException ex) {
				logger.error("Exception while closing db connection: ", ex);
			}
		}
	}

}
