package com.userRegistrationapplication.UserRegService;

import com.userRegistrationapplication.DbCrud.User;
import com.userRegistrationapplication.DbCrud.UserImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *Class ApplicationClass class
 * 
 * @author usatlk
 */
public class ApplicationClass {

   private static Connection conn;

   public static void main(String[] args) throws SQLException {
      User UserOp = new UserImpl();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int option = 0;
      while (option != 4) {
         System.out.println(" ");
         System.out.println("\033[1;34m" + ".------------------------------------------------.");
         System.out.println("\033[1;34m" + "|                   OPTIONS                      |");
         System.out.println("\033[1;34m" + ".------------------------------------------------.");
         System.out.println("\033[1;34m" + "| 1.User Login 2.User Registration 3.Users 4.Exit |");

         System.out.println("Enter your option");
         
         try {
            
            option = Integer.parseInt(br.readLine());  
            
            if (option < 1 || option > 4) {
               System.out.println("Error!"); 
            } else if (option == 1) {
               // User Login 
               UserLoginImpl.UserLogin();
            } else if (option == 2) {
               //User Registration
               UserRegistrationImpl.UserRegistration();
            } else if (option == 3) {
               //Display All users
               UserOp.getUserName();
            }

         } catch (IOException | NumberFormatException e) {
            System.out.println("\033[1;35m" + "Invalid Option -- You have not entered a number.");
         }
      }

   }
   
}
