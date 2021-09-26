package com.userRegistrationapplication.DbCrud;

import com.userRegistrationapplication.UserRegDTO.UserRegistrationDTO;

/**
 *Class User class
 * 
 * @author usatlk
 */
public abstract class User {
   public static boolean isloggedIn = false;
   public abstract boolean CreateUser(UserRegistrationDTO user);
   public abstract String getUserName();
   public abstract boolean userLogin(String userName, String password);
}
