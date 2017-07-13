package com.hardik.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hardik.javaee.bean.User;
import com.hardik.javaee.util.DbUtils;

/**
 * User DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class UserDaoImpl implements UserDao {

	private DbUtils dbUtils = new DbUtils();

	/**
	 * Validate User Login
	 */
	@Override
	public User validateUser(String username, String password) {
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
		} catch (SQLException ex) {
			System.out.println("Exception: " + ex);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				dbUtils.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			}
		}

		return user;
	}

	/**
	 * Save User
	 */
	@Override
	public User saveUser(User user) {
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
		} catch (SQLException ex) {
			System.out.println("Exception: " + ex);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				dbUtils.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			}
		}
		return user;
	}
}
