package com.web.model;

public class UserLogin {
	
	private String userName;
	private String userPasswd;
	private String userEmail;
	private String country;
	private char gender;
	private int id;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCountry() {
		return country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	@Override
	public String toString() {
		return "UserLogin [userName=" + userName + ", userPasswd=" + userPasswd + "]";
	}
	
}
