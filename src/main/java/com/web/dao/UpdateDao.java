package com.web.dao;

import java.sql.SQLException;

import com.web.model.UserLogin;

public interface UpdateDao {

	public boolean Delete(String id) throws SQLException;

	public boolean Edit(UserLogin id) throws SQLException;

	public UserLogin getUser(String id) throws SQLException;


}
	