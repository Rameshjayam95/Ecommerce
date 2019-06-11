package com.bazzar.test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bazzar.DAO.CategoryDao;
import com.bazzar.model.Category;


public class CategoryDaoTest 
{
	
	static CategoryDao categoryDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.bazzar");
		context.refresh();
		
		categoryDao=(CategoryDao)context.getBean("categoryDAO");
	}
	@Test
	public void addCategoryDaoTest()
	{
		Category category=new Category();
	    category.setCategoryNames("Casual Shoes");
	    category.setCategoryDesc("Shirt collar");
	    assertTrue("problem in Adding Category",categoryDao.addCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDao.getCategory(4);
		assertTrue("problem in Deleting Category",categoryDao.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDao.getCategory(5);
		category.setCategoryNames("Perfumes");
		assertTrue("Problem in Updating Category",categoryDao.updateCategory(category));
	}
	@Ignore
	@Test
	public void listCategoryTest()
	{
		List<Category> categoryList=categoryDao.listCategories();
		
		assertTrue("Problem in Listing Categories",categoryList.size()>0);
		
		for(Category category:categoryList)
		{
		System.out.print(category.getCategoryId()+":::");
		System.out.print(category.getCategoryNames()+":::");
		System.out.println(category.getCategoryDesc());
		}
	}
}

