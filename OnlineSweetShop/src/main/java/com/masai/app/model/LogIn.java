package com.masai.app.model;


import jakarta.annotation.Nonnull;


public class LogIn {

	@Nonnull
	private String  email;
	
	@Nonnull
	private String password;
	
	private String secret;

	public LogIn(String email, String password, String secret) {
		super();
		this.email = email;
		this.password = password;
		this.secret = secret;
	}

	public LogIn() {
		super();
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

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "LogIn [email=" + email + ", password=" + password + ", secret=" + secret + "]";
	}
	
	
	
}
