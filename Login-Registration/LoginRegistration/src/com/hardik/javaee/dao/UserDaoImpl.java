package com.hardik.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.hardik.javaee.bean.User;
import com.hardik.javaee.util.DbUtils;

/**
 * User DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class UserDaoImpl implements UserDao {

	static Logger logger = Logger.getLogger(UserDaoImpl.class);
	private DbUtils dbUtils = new DbUtils();

	/**
	 * Validate User Login
	 */
	@Override
	public User validateUser(String username, String password) {
		logger.debug("Validating User with credentials.");

		User user = new User();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM `user` WHERE `username`=? AND `password`=?";

		try {
			connection = dbUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setUsername(username);
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
			}
			logger.debug("User validated successfully.");
		} catch (SQLException ex) {
			logger.error("Exception while validating user: ", ex);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				dbUtils.closeConnection();
				logger.debug("Closed successfully ResultSet, PreparedStatement & DbConnection.");
			} catch (SQLException ex) {
				logger.error("Exception while closing ResultSet, PreparedStatement & DbConnection: ", ex);
			}
		}

		return user;
	}

	/**
	 * Save User
	 */
	@Override
	public User saveUser(User user) {
		logger.debug("Saving user in database...");

		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO `user`(`username`,`password`,`firstName`,`lastName`,`email`) VALUES(?,?,?,?,?)";

		try {
			connection = dbUtils.getConnection();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());

			if (statement.executeUpdate() > 0) {
				// Get Generated Keys
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet != null && resultSet.next()) {
					user.setId(resultSet.getInt(1));
				}
			}
			logger.debug("User saved successfully in database.");
		} catch (SQLException ex) {
			logger.error("Exception while saving user to database: ", ex);
		} finally {
			try {
				if (statement != null) {
					statement.close();
					logger.debug("PreparedStatement closed successfully.");
				}
				dbUtils.closeConnection();
			} catch (SQLException ex) {
				logger.error("Exception while closing DbConnection or PreparedStatment: ", ex);
			}
		}
		return user;
	}
}
