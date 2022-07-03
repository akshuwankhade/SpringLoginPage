package com.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.web.model.UserLogin;

public interface LoginDAO  {

	public UserLogin LoginImpl(String  userName, String password) throws SQLException;
	
	public ArrayList<UserLogin> getAllData() throws SQLException;
}
 