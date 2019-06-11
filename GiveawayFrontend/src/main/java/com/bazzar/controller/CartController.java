package com.bazzar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bazzar.DAO.CartDao;
import com.bazzar.DAO.ProductDao;
import com.bazzar.model.Cart;
import com.bazzar.model.Product;

@Controller
public class CartController
{
	@Autowired
	CartDao cartDAO;
	
	@Autowired
	ProductDao productDAO;
	
	@RequestMapping(value="/addToCart/{productId}")
	public String showcart(@PathVariable("productId")int productId,Model m,HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
        String username=(String)session.getAttribute("username");
		
		Cart cart=new Cart();
		cart.setProductId(product.getProductId());
		
		cart.setProductName(product.getProductName());
		cart.setPrice(product.getPrice());
		cart.setUsername(username);
		cart.setStatus("np");
		
		cartDAO.addTOCart(cart);
		List<Cart>cartList=cartDAO.listCartItems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		return "Cart";		
		}
	@RequestMapping("/updatecart/{cartItemId}")
	public String updatecart1(@PathVariable("cartItemId")int cartId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCartItem(cartId);
		cart.setQuantity(quantity);
		cartDAO.updateCartItem(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart>cartList=cartDAO.listCartItems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		System.out.println(cartId);
		return "Cart";
		
	}
	
	public int grandtotal (List<Cart> listCartItems)
{
		int count=0, grandtotal=0;
		while(count<listCartItems.size())
		{
			grandtotal=grandtotal+listCartItems.get(count).getQuantity()*listCartItems.get(count).getPrice();
			count++;
		}
		return grandtotal;
}
	@RequestMapping(value="/Removecart/{cartItemId}")
	public String remove(@PathVariable("cartItemId")int cartId,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCartItem(cartId);
		cartDAO.deleteItemFromCart(cart);
		
		String username=(String)session.getAttribute("useername");
		List<Cart>cartList=cartDAO.listCartItems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		return "Cart";
		
	}
	@RequestMapping(value="/orderconfirm")
	public String show(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart>cartList=cartDAO.listCartItems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		return "orderconfirm";
	}

}