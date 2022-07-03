package com.web.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.web.dao.UserDAO;
import com.web.dao.UserDAOImpl;
import com.web.model.UserRegDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO repo;
	
	public boolean registerUser(UserRegDTO user) {
		
		return repo.registerUser(user) > 0 ? true : false;
	

	}

	
}
