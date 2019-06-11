package com.bazzar.DAO;

import java.util.List;

import com.bazzar.model.Cart;

public interface CartDao 
{
public boolean addTOCart (Cart cart);
public boolean deleteItemFromCart(Cart cart);
public boolean updateCartItem(Cart cart);
public Cart getCartItem(int cartId);
public List<Cart> listCartItems();

}
