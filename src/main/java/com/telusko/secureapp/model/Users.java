package com.telusko.secureapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
@Id	
private long id;
private String username;
private String password;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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

	
}
