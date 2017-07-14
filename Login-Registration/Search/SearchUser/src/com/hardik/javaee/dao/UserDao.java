package com.hardik.javaee.dao;

import java.util.List;

import com.hardik.javaee.bean.User;

/**
 * User DAO Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface UserDao {
	public List<User> searchUser(String username);
}
