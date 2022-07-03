package com.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.LoginImpl;
import com.web.model.UserLogin;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String login(@ModelAttribute("objUser") UserLogin user) {
		// UserLogin objUser=new UserLogin();
		// m.addAttribute("objUser", new UserLogin());
		return "login";
	}

	// public String home(@RequestParam("userName") String UserName,
	// @RequestParam("userPasswd") String UserPasswd, Model model) {
	@RequestMapping("/Login-panel")
	public String home(@ModelAttribute("objUser") UserLogin login, Model model, @RequestParam("action") String click) {

		System.out.println(click);
		if (click.equalsIgnoreCase("login")) {
			
			LoginImpl loginUser=new LoginImpl();
			try {
				UserLogin user=loginUser.LoginImpl(login.getUserName(), login.getUserPasswd());
				if (!(user==null)) {
					 ArrayList<UserLogin> userData= loginUser.getAllData();
					model.addAttribute("userData", userData);
					model.addAttribute("msg", "Update profile !!");
					return "home";
				} else {
					model.addAttribute("msg", "Invalid Login id or password!!");
					return "login";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// redirect to registration page
		} else if (click.equalsIgnoreCase("register now")) {
			return "redirect:/registration";
		}
		return "login";
	}
}
