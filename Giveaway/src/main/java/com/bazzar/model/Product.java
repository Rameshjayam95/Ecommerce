package com.bazzar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
private String productName;
private String productDesc;
private int price;
private int stock;

public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
private int categoryId;
private int supplierId;

@Transient
MultipartFile pimage;

public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDesc() {
	return productDesc;
}
public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


}
