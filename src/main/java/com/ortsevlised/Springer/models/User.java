package com.ortsevlised.Springer.models;


public class User {

	public static final String EMAIL = "jdesilvestro@gmail.com";
	public static final String PASSWORD = "Password1";
	private String email;
	private String password;

	public User() {
		setEmail(EMAIL);
		setPassword(PASSWORD);
	}

	public User(String email, String password) {
		setEmail(email);
		setPassword(password);
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
