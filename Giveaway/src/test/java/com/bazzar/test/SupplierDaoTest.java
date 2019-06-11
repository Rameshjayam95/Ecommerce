package com.bazzar.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bazzar.DAO.SupplierDao;
import com.bazzar.model.Supplier;
public class SupplierDaoTest 
{
static SupplierDao supplierDAO;

@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.bazzar");
	context.refresh();
	supplierDAO=(SupplierDao)context.getBean("supplierDAO");
}
@Ignore
@Test
public void addsupplier(){
	{
    Supplier supplier=new Supplier();
    supplier.setSupplierId(2);
    supplier.setSupplierName("Manova");
    supplier.setSuppAddr("No:322 kh road CH-23");
    
    assertTrue("problem in Adding Supplier",supplierDAO.addsupplier(supplier));
	}
}
@Ignore
@Test
public void deletesupplier()
    {
	Supplier supplier=supplierDAO.getSupplier(2);
	assertTrue("problem in Deleting Supplier",supplierDAO.deletesupplier(supplier));
	}
@Ignore
@Test
public void updatesupplier()
{
	Supplier supplier=supplierDAO.getSupplier(3);
	supplier.setSuppAddr("No 45 SNK street Alwarpet");
	assertTrue("problem in Updating Supplier",supplierDAO.updatesupplier(supplier));
}
@Test
public void listSupplierTest()
{
	List<Supplier> supplierList=supplierDAO.listSupplier();
	assertTrue("Problem in Listing Supplier",supplierList.size()>0);
	for(Supplier supplier:supplierList)
	{
		System.out.print(supplier.getSupplierId()+"   ");
		System.out.println(supplier.getSupplierName()+"  ");
		
	}
	}
}
