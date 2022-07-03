package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.model.UserLogin;

public class UpdateDaoImpl implements UpdateDao{

	public boolean Delete(String id) throws SQLException {
		
		Connection connection = null;
		Statement stmt;
		 connection= DBConnect.getConnection();
		StringBuilder queryString = new StringBuilder();
		queryString.append("Delete from tbl_user Where user_id="+id);
		System.out.println("query :"+queryString);
			//Statement st = connection.createStatement();
		stmt = connection.prepareStatement(queryString.toString());

		//int rs = stmt.execu
		
		PreparedStatement pst=connection.prepareStatement("Delete from tbl_user Where user_id="+id);
		
		int rs=pst.executeUpdate();
		if(rs>0) {
			
			return true;
	
	}
		return false;
}

	@Override
	public boolean Edit(UserLogin editUser) throws SQLException {
		
			//UserLogin editUser = null;
			Connection connection = null;
			PreparedStatement pst;
			connection= DBConnect.getConnection();
			StringBuilder queryString = new StringBuilder();
			//queryString.append("Update tbl_user set Where user_id="+id+" and user_name ="+getUser(id));
			//queryString.append("Update tbl_user set Where user_id="+id+",user_name="+userName+",user_email,user_password,country,gender");
			queryString.append("update tbl_user set ");
			queryString.append(" user_name=?,user_email=?,user_password=?,country=?");
			queryString.append(" where user_id=?;");
			System.out.println("query :"+queryString);
			//Statement st = connection.createStatement();
			pst = connection.prepareStatement(queryString.toString());

			//int rs = stmt.execu
			
			pst.setString(1,editUser.getUserName());
			pst.setString(2,editUser.getUserEmail());
			pst.setString(3,editUser.getUserPasswd());
			pst.setString(4,editUser.getCountry());
			pst.setInt(5,editUser.getId());

			int rs=pst.executeUpdate();
			if(rs>0) {
				
				return true;
		
		}
			return false;	}

	@Override
	public UserLogin getUser(String id) throws SQLException {
		int userId=Integer.parseInt(id);
		Connection connection = null;
		PreparedStatement stmt = null;
		UserLogin user = null;
		try {
		ResultSet rs = null;
		connection= DBConnect.getConnection();
		/*Class.forName("com.mysql.cj.jdbc.Driver");
		 //connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/wordcount","root","root");
		  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wordcount","root","root");
		*/
		StringBuilder queryString = new StringBuilder();
		queryString.append("select user_id,user_name,user_email,user_password,country,gender from tbl_user");
		queryString.append(" WHERE user_id ="+userId);
		System.out.println("quary :"+queryString);
			stmt = connection.prepareStatement(queryString.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new UserLogin();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserEmail(rs.getString(3));
				user.setUserPasswd(rs.getString(4));
				user.setCountry(rs.getString(5));
			//	user.setGender(rs.getString(6));
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
}