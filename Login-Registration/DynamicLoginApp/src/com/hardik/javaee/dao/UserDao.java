package com.hardik.javaee.dao;

import com.hardik.javaee.bean.User;

/**
 * User DAO Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface UserDao {
	public User validateUser(String username, String password);
}
