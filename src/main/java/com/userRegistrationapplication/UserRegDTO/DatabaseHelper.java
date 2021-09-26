package com.userRegistrationapplication.UserRegDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class DatabaseHelper class
 *
 * @author usatlk
 */
public class DatabaseHelper {

   private static DatabaseHelper instance = new DatabaseHelper();

   static Connection conn;

   private DatabaseHelper() {
      try {
         String url = "jdbc:sqlite:src//User_Registration.db";
         conn = DriverManager.getConnection(url);
         System.out.println("Db Connection ok" + conn);
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
      }
   }

   public static DatabaseHelper getInstance() {

      return instance;
   }

   public static Connection DBConnection() {

      try {
         if (conn == null) {
            instance = new DatabaseHelper();
         }
         return conn;
      } catch (Exception e) {
         System.out.println(e.getMessage());
         return null;
      }
   }
}
