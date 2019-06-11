package com.bazzar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping(value="/login")
	public String ShowLoginpage()
	{
		System.out.println("Inside login controller()");
		return "Login";
	}
	
	@RequestMapping(value="/register")
	 public String ShowRegisterpage()
	{
		return"Register";
	}
}
