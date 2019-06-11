package com.bazzar.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bazzar.DAO.UserDao;
import com.bazzar.model.UserDetail;

public class UserDetailTest 
{
	static UserDao userDao;
	
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.bazzar");
	context.refresh();
	userDao=(UserDao)context.getBean("userDAO");
}
@Ignore
@Test
public void addUser() 
{
	UserDetail userdetail=new UserDetail();
	userdetail.setUserName("thulasi");
	userdetail.setPassword("475981");
	userdetail.setAddress("No.47 East Street Anna Nagar");
	userdetail.setEmailId("rameshjayam95@gmail.com");
	userdetail.setCustomerName("Rammee");
	assertTrue("Problem in adding UserDetail",userDao.addUser(userdetail));
}

@Test
public void updateUser()
{
	 UserDetail userdetail=userDao.getUser("2");
	 userdetail.setUserName("Srinath");
	 assertTrue("Problem in updating UserDetail",userDao.updateUser(userdetail));
}

}
