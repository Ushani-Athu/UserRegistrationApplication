package com.userRegistrationapplication.DbCrud;

import com.userRegistrationapplication.UserRegDTO.DatabaseHelper;
import com.userRegistrationapplication.UserRegDTO.UserRegistrationDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

/**
 * Contains methods to save and retrieve user details.
 *
 *
 * @author usatlk
 */
public class UserImpl extends User {

   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
   Statement stmt = null;
   
   public UserImpl() {
      DatabaseHelper c = DatabaseHelper.getInstance();
      conn = c.DBConnection();
   }

   /**
    * Creates a user with the specified details.
    *
    * @param user
    * @return
    */
   @Override
   public boolean CreateUser(UserRegistrationDTO user) {
      String qry = "INSERT INTO users(first_Name,\n"
              + "                      last_Name,\n"
              + "                      email,\n"
              + "                      password,\n"
              + "                      user_name) "
              + "VALUES(?,"
              + "?, "
              + "?, "
              + "?, "
              + "?)";
      try {
         String sha256hex = sha256Hex(user.getPassword());
         pst = conn.prepareStatement(qry);
         pst.setString(1, user.getFirstName());
         pst.setString(2, user.getLastName());
         pst.setString(3, user.getEmail());
         pst.setString(4, sha256hex);
         pst.setString(5, user.getUserName());
         pst.execute();
         return true;
      } catch (Exception ex) {
         System.out.println(ex.getMessage() + " Error");
         return false;
      } finally {
         try {
            if (pst != null) {
               pst.close();
            }
         } catch (Exception e) {
         }
      }
   }

   /**
    * Retrieve users with the specified name.
    *
    * @return all users
    */
   @Override
   public String getUserName() {
      if (isloggedIn) {
         String sql = "SELECT user_name, password FROM Users";

         try {
            pst = conn.prepareStatement(sql);
            stmt = conn.createStatement();
            //System.out.println("Connection to SQLite has been established.");
            ResultSet results = stmt.executeQuery("SELECT * FROM Users");
            while (results.next()) {
               System.out.print(results.getString("first_Name"));
               System.out.println(" " + results.getString("last_Name"));
            }
         } catch (SQLException ex) {
              Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);

         } finally {
            try {
               if (rs != null) {
                  rs.close();
               }
               if (pst != null) {
                  pst.close();
               }
            } catch (Exception e) {
            }
         }
      } else {
         System.out.println("\033[1;35m" + "Please Login to continue this operation");
      }
      return "ERROR";
   }

   /**
    * User Login with the specified username and password.
    *
    * @param userName
    * @param password
    * @return
    */
   @Override
   public boolean userLogin(String userName, String password) {
      String sql = "SELECT 1 FROM Users WHERE user_name = ? and password = ?";

      try {
         String sha256hex = sha256Hex(password);
         pst = conn.prepareStatement(sql);
         pst.setString(1, userName);
         pst.setString(2, sha256hex);
         rs = pst.executeQuery();
         if (rs.next()) {
            isloggedIn = true;
            System.out.println("\033[1;35m" + "Logged In as user " + userName);
         } else {
            isloggedIn = false;
            System.out.println("\033[1;35m" + "User name or passwrod is incorrect. Please try again!");
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);

      } finally {
         try {
            if (rs != null) {
               rs.close();
            }
            if (pst != null) {
               pst.close();
            }
         } catch (Exception e) {
         }
      }
      return false;
   }

}
