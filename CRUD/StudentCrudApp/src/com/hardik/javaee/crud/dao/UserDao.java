package com.hardik.javaee.crud.dao;

import java.sql.SQLException;

import com.hardik.javaee.crud.model.User;

/**
 * User DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface UserDao {

	public User login(User user) throws ClassNotFoundException, SQLException;
}
