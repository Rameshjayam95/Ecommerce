package com.bazzar.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.bazzar.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserImplement implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;

	
	public boolean addUser(UserDetail userdetail) {
		try
		{
		sessionFactory.getCurrentSession().save(userdetail);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean updateUser(UserDetail userdetail) {
		try
		{
		sessionFactory.getCurrentSession().update(userdetail);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public UserDetail getUser(String UserName) {
		Session session=sessionFactory.openSession();
		UserDetail user =session.get(UserDetail.class, UserName);
		session.close();
		return user;
	}

}
