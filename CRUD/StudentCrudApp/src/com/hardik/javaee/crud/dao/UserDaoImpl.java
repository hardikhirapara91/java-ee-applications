package com.hardik.javaee.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hardik.javaee.crud.model.User;
import com.hardik.javaee.crud.util.DbUtils;

/**
 * User DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * LOGIN
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public User login(User user) throws ClassNotFoundException, SQLException {
		Connection connection = DbUtils.getConnection();
		String query = "SELECT * FROM `user` WHERE `username`=? AND `password`=?";

		if (connection != null) {

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setEmail(resultSet.getString("email"));
			}
			resultSet.close();
			statement.close();
		}

		return user;
	}

}
