package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.model.UserLogin;


public class LoginImpl implements LoginDAO{

	@SuppressWarnings("null")
	@Override
	public UserLogin LoginImpl(String userName, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		UserLogin user = null;
		try {
		ResultSet rs = null;
		//Connection connection ;//= DBConnect.getConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		 //connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/wordcount","root","root");
		  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wordcount","root","root");
		
		StringBuilder queryString = new StringBuilder();
		queryString.append("select user_name,user_password from tbl_user");
		queryString.append(" WHERE user_name ='"+userName+"'");
		queryString.append(" and user_password ='"+password+"'");
		System.out.println("quary :"+queryString);
			stmt = connection.prepareStatement(queryString.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new UserLogin();
				user.setUserName(rs.getString(1));
				user.setUserPasswd(rs.getString(2));
		}
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			stmt.close();
		}
		//System.out.println("User Name :"+user.getUserName());
		//System.out.println("Password :"+user.getUserPasswd());
		return user;
}

	@Override
	public ArrayList<UserLogin> getAllData() throws SQLException {
		
		ArrayList<UserLogin> userData=new ArrayList<>();
		Connection connection = null;
		PreparedStatement stmt = null;
		UserLogin user = null;
		try {
		ResultSet rs = null;
		 connection= DBConnect.getConnection();
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/wordcount","root","root");
		//connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wordcount","root","root");
		
		StringBuilder queryString = new StringBuilder();
		queryString.append("select user_name,user_password,user_email,country,user_id from tbl_user");
		System.out.println("quary :"+queryString);
			stmt = connection.prepareStatement(queryString.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new UserLogin();
				user.setUserName(rs.getString(1));
				user.setUserPasswd(rs.getString(2));
				user.setUserEmail(rs.getString(3));
				user.setCountry(rs.getString(4));
				//user.setGender(rs.getCharacterStream(rs.getString(5)));
				user.setId(rs.getInt(5));
				
				userData.add(user);
		}
			} catch (Exception e) {
				
			e.printStackTrace();
			
		} finally {
			
			connection.close();
			
			stmt.close();
		}
		return userData;
	}
}
