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
private String CustomerID;
private String UserName;
private String Password;
public String getUserName() {
	return UserName;
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
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
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
String CustomerName;
String EmailId;
String address;
}
