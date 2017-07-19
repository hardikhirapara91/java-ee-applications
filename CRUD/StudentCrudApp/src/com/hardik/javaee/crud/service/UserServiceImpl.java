package com.hardik.javaee.crud.service;

import java.sql.SQLException;

import com.hardik.javaee.crud.dao.UserDao;
import com.hardik.javaee.crud.dao.UserDaoImpl;
import com.hardik.javaee.crud.model.User;

/**
 * User Service Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		try {
			return userDao.login(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
