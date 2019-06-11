package com.bazzar.DAO;

import com.bazzar.model.UserDetail;

public interface UserDao 
{
   public boolean addUser(UserDetail userdetail);
   public boolean updateUser(UserDetail userdetail);
   public UserDetail getUser(String UserName);
}
