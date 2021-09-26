/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userRegistrationapplication.UserRegService;

import com.userRegistrationapplication.DbCrud.User;
import com.userRegistrationapplication.DbCrud.UserImpl;
import com.userRegistrationapplication.UserRegDTO.UserRegistrationDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class UserRegistrationImpl class
 *
 * @author usatlk
 */
public class UserRegistrationImpl {

   static UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();

   public static void UserRegistration() {

      try {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.print(" Enter firstName => ");
         String firstName = br.readLine();
         userRegistrationDTO.setFirstName(firstName);

         System.out.print(" Enter lastName => ");
         String lastName = br.readLine();
         userRegistrationDTO.setLastName(lastName);

         System.out.print(" Enter userName => ");
         String userName = br.readLine();
         userRegistrationDTO.setUserName(userName);

         System.out.print(" Enter password => ");
         String password = br.readLine();
         userRegistrationDTO.setPassword(password);

         System.out.print(" Enter emailId => ");
         String emailId = br.readLine();
         userRegistrationDTO.setEmail(emailId);

         User UserOp = new UserImpl();
         UserOp.CreateUser(userRegistrationDTO);
         System.out.println("\033[1;35m" + userRegistrationDTO.getFirstName() + ", User Registration Successful! Please Login");
      } catch (Exception e) {
         System.out.println("\033[1;35m" + "Invalid input");
      }
   }

}
