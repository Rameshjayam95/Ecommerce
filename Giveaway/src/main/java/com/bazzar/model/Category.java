package com.bazzar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int CategoryId;
private String CategoryNames;
private String CategoryDesc;


public String getCategoryNames() {
	return CategoryNames;
}
public void setCategoryNames(String categoryNames) {
	CategoryNames = categoryNames;
}
public int getCategoryId() {
	return CategoryId;
}
public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}
public String getCategoryDesc() {
	return CategoryDesc;
}
public void setCategoryDesc(String categoryDesc) {
	CategoryDesc = categoryDesc;
}

}
