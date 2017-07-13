package com.hardik.dao;

import com.hardik.model.LoginModel;

/**
 * Login DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class LoginDao {

	/**
	 * Validate
	 * 
	 * @param model
	 * @return
	 */
	public boolean validate(LoginModel model) {
		if (model.getUsername().equalsIgnoreCase("admin") && model.getPassword().equals("admin@123")) {
			return true;
		}

		return false;
	}
}
