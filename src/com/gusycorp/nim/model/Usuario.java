package com.gusycorp.nim.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean emailVerified;
	private String email;
	
	public Usuario (final String username, final String password, final boolean emailVerified, final String email)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.emailVerified=this.emailVerified;
		this.setEmail(email);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEmailVerified(){
		return emailVerified;
	}
}
