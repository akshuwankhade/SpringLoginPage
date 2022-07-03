package com.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.UserLogin;
import com.web.model.UserRegDTO;
import com.web.service.UserService;

@Controller
public class UserRegistrationController {

	@Autowired
	UserService service;
	
	@RequestMapping("/registration")
	public ModelAndView register (){
		return new ModelAndView ("register","objReg", new UserRegDTO());
	}
	/*@ModelAttribute("countryList")
	public Map<String,String> countries(){
		
		// Get countries from DB
		Map<String,String> map=new HashMap<String, String>();
		map.put("Ind","India");
		map.put("SI","Singapore");
		map.put("Ch","China");
		map.put("USA","United State");
		
		return map;
		
	}*/
	
	@RequestMapping("/ProcessRegistration")
	public ModelAndView ProcessReg (@ModelAttribute("objReg") UserRegDTO user){
		
		if(service.registerUser(user)) {
			return new ModelAndView ("login","objUser", new UserLogin());
		}
		return new ModelAndView ("register","objReg", new UserRegDTO ("Registration faild"));
	}
}
