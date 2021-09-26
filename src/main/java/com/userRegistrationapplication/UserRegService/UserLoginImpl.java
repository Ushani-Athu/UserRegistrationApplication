package com.userRegistrationapplication.UserRegService;

import com.userRegistrationapplication.DbCrud.User;
import com.userRegistrationapplication.DbCrud.UserImpl;
import com.userRegistrationapplication.UserRegDTO.UserRegistrationDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class UserLoginImpl class
 *
 * @author usatlk
 */
public class UserLoginImpl {

   static UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();

   public static void UserLogin() {

      try {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("Enter user name => ");
         String userName = br.readLine();
         userRegistrationDTO.setUserName(userName);

         System.out.print("Enter password => ");
         String password = br.readLine();
         userRegistrationDTO.setPassword(password);

         User UserOp = new UserImpl();
         UserOp.userLogin(userName, password);
      } catch (IOException ex) {
         System.out.println("\033[1;35m" + "Invalid input");
      }

   }

}
