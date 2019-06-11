package com.bazzar.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bazzar.DAO.ProductDao;
import com.bazzar.model.Product;

public class ProductDaoTest 
{
static ProductDao productDAO;

@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.bazzar");
	context.refresh();
	productDAO=(ProductDao)context.getBean("productDAO");
}

@Test
public void addProduct()
{
Product product=new Product();

product.setProductName("TV");
product.setProductDesc("LCD tv");
product.setPrice(15000);
product.setCategoryId(1);
product.setSupplierId(1);
product.setStock(7800);


assertTrue("problem in Adding Product",productDAO.addProduct(product));
	
}
@Ignore
@Test
public void deleteProductTest()
{
	Product product=productDAO.getProduct(1);
	assertTrue("problem in Deleting Product",productDAO.deleteProduct(product));
}

@Ignore
@Test
public void updateProductTest()
{
	Product product=productDAO.getProduct(1);
	product.setPrice(4000);
	assertTrue("problem in Updating Product",productDAO.updateProduct(product));
}

@Test
public void listProductTest()
{
	List<Product> productList=productDAO.listProduct();
	
	assertTrue("Problem in Listing Product",productList.size()>0);
	
	for(Product product : productList)
	{
	System.out.print(product.getProductId()+"  ");
	System.out.print(product.getProductName()+"  ");
	System.out.println(product.getProductDesc()+"  ");
	System.out.println(product.getPrice()+" ");
	System.out.println(product.getStock());
	
	}
    }
}


