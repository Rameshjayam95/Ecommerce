package com.bazzar.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bazzar.DAO.CartDao;
import com.bazzar.model.Cart;

public class CartDaoTest 
{
    static CartDao cartDAO;
    @BeforeClass
    public static void executeFirst()
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.scan("com.bazzar");
    	context.refresh();
    	cartDAO=(CartDao)context.getBean("cartDAO");
    }
    @Ignore
    @Test
    public void addCart()
    {
    	Cart cart=new Cart();
    	cart.setProductName("test");
    	cart.setUsername("test1");
    	cart.setStatus("p");
    	
    	assertTrue("Problem in Adding Cart",cartDAO.addTOCart(cart));
    }
    @Ignore
    @Test
    public void deleteCartTest()
    {
    	Cart cart=cartDAO.getCartItem(1);
    	assertTrue("Problem in Deleting Cart",cartDAO.deleteItemFromCart(cart));
 
    }
    @Test
    public void updateCartTest()
    {
    	Cart cart=cartDAO.getCartItem(2);
    	cart.setProductName("tv");
    	
    	assertTrue("Problem in Updating Cart",cartDAO.updateCartItem(cart));
    }
	}
    
