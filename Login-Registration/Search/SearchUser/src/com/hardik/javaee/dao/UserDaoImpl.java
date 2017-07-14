package com.hardik.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<User> searchUser(String searchString) {
		logger.debug("Searching User in Database...");

		List<User> users = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM `user` WHERE (`username` LIKE ?) OR (`firstName` LIKE ?) OR (`lastName` LIKE ?) OR (`email` LIKE ?)";

		try {
			connection = dbUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + searchString + "%");
			statement.setString(2, "%" + searchString + "%");
			statement.setString(3, "%" + searchString + "%");
			statement.setString(4, "%" + searchString + "%");

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				users.add(user);
			}
		} catch (SQLException ex) {
			logger.error("Exception while searching user: ", ex);
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

		return users;
	}
}
