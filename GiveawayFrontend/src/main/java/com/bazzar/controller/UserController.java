package com.bazzar.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bazzar.DAO.UserDao;
import com.bazzar.model.UserDetail;


@Controller
public class UserController 
{
    @Autowired
    UserDao userDAO;
    
    @RequestMapping("/registration")
    public String Register (@RequestParam("FirstName")String FirstName,@RequestParam("LastName")String LastName,@RequestParam("UserName")String UserName,@RequestParam("Password")String Password,Model m)
    {
    	UserDetail userdetails=new UserDetail();
    	userdetails.setFirstName(FirstName);
    	userdetails.setLastName(LastName);
    	userdetails.setUserName(UserName);
    	
    	userdetails.setPassword(Password);
    	
    	userDAO.addUser(userdetails);
    	
    	return "Register";
    }
	@RequestMapping("/login_success")
	public String loginSuccessPage (HttpSession session,Model m)
	{
		System.out.println("I am in login Success");
		
		String page="";
		boolean loggedIn=false;
		
		//**This object will contain the loggedin user detail like username and role.
		SecurityContext secontext=SecurityContextHolder.getContext();
		Authentication authentication=secontext.getAuthentication();
		
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="adminhome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				page="userhome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				
			}
		}
		return "ProductPage";
	}
}
