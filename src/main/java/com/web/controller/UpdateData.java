package com.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.dao.LoginImpl;
import com.web.dao.UpdateDao;
import com.web.dao.UpdateDaoImpl;
import com.web.model.UserLogin;

@Controller
public class UpdateData {

	@RequestMapping("/delete")
	public String Delete(HttpServletRequest req, Model model) {
		
		String id=req.getParameter("id");
		UpdateDao delete=new UpdateDaoImpl();
		try {
			delete.Delete(id);
			LoginImpl loginUser=new LoginImpl();
			 ArrayList<UserLogin> userData= loginUser.getAllData();
				model.addAttribute("userData", userData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
@RequestMapping("/edit")
public String Edit(HttpServletRequest req,Model model) {
		
		String id=req.getParameter("id");
		System.out.println("Id :"+id);
		UpdateDao edit=new UpdateDaoImpl();
		try {
			UserLogin user= edit.getUser(id);
				model.addAttribute("userData", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "edit";
	}


@RequestMapping("/update")
public String Update(HttpServletRequest req,Model model) {
	System.out.println(" I am in update");
		UserLogin updateUser=new UserLogin();
		//updateUser.setId(Integer.parseInt(req.getParameter("id")));
		String id=req.getParameter("id");
		updateUser.setId(Integer.parseInt(id));
		updateUser.setUserName(req.getParameter("name"));
		updateUser.setUserPasswd(req.getParameter("password"));
		updateUser.setUserEmail(req.getParameter("userEmail"));
		updateUser.setCountry(req.getParameter("country"));
		System.out.println(updateUser.getUserName());
		System.out.println(updateUser.getUserPasswd());
		System.out.println(updateUser.getUserEmail());
		System.out.println(updateUser.getCountry());
		System.out.println(updateUser.getId());
		
		//System.out.println("Id :"+id);
		UpdateDao edit=new UpdateDaoImpl();
		LoginImpl loginUser=new LoginImpl();
		
		try {
			 if( edit.Edit(updateUser)) {
				 model.addAttribute("msg", "Profile Update successufully");
			 }else {
				 model.addAttribute("msg", "Profile Not Update");
			 }
			 ArrayList<UserLogin> userData= loginUser.getAllData();
			 model.addAttribute("userData", userData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "home";
	}

}
