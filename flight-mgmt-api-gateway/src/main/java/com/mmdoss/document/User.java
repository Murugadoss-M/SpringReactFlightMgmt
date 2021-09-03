package com.mmdoss.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	@Id
	private String username;
	private String password;
	private String email_id;
	public User() {
		super();
	}
	public User(String username, String password, String email_id) {
		super();
		this.username = username;
		this.password = password;
		this.email_id = email_id;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return String.format("User [username=%s, password=%s, email_id=%s]", username, password, email_id);
	}
	
}
