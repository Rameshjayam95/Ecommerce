package com.bazzar.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.model.Cart;
import com.bazzar.model.Category;

@Repository("cartDAO")
@Transactional
public class CartImplement implements CartDao 
{
	@Autowired
	SessionFactory sessionFactory;
	@Override

	public boolean addTOCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().save(cart);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteItemFromCart(Cart cart) {
		try
	    {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	    }
	    catch(Exception e)
	    {
		return false;
	}
	}

	@Override
	public boolean updateCartItem(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Cart getCartItem(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	@Override
	public List<Cart> listCartItems() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");

		List<Cart> cartListItem=query.list();
		session.close();
		return cartListItem;
	}
   
}


