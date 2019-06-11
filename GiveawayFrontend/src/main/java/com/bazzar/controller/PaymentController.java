package com.bazzar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazzar.DAO.CartDao;
import com.bazzar.DAO.ProductDao;
import com.bazzar.model.Cart;

@Controller
public class PaymentController 
{
	@Autowired
	CartDao cartDAO; 
	
	@Autowired
	ProductDao productDAO;
	
	@RequestMapping(value="/Payment")
	public String Payment(Model m,HttpSession session)
	{
		
		List<Cart>cartList=cartDAO.listCartItems();
		m.addAttribute("cartList",cartList);

		
		return "Payment";
	}
	@RequestMapping(value="/Pay")
	public String Pay(Model m)
	{
		
		List<Cart>cartList=cartDAO.listCartItems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		return "Receipt";
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
}
