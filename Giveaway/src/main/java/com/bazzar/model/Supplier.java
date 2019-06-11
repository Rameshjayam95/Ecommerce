package com.bazzar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Supplier 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int supplierId;
private String supplierName;
private String suppAddr;

public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public String getSuppAddr() {
	return suppAddr;
}
public void setSuppAddr(String suppAddr) {
	this.suppAddr = suppAddr;
}


}
