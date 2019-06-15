package com.bazzar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetail
{
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int UserID;
private String FirstName;
private String LastName;
private String Role;
private String UserName;
private String Password;
public String getUserName() {
	return UserName;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
String EmailId;
String address;
}
