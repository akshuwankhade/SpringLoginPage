package com.web.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.model.UserRegDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public int registerUser(UserRegDTO u) {
		
		String sql="insert into tbl_user(user_name,user_email,user_password,gender,country) values (?,?,?,?,?)";
		
		try {
			return jdbc.update(sql, u.getUserName(),u.getUserEmail(),u.getPassword(),u.getGender()+"",u.getCountry());
		}
		catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		//return 0;
	}
	
}
