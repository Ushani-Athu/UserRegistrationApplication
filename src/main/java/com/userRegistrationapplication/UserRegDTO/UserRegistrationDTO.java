package com.userRegistrationapplication.UserRegDTO;

import javax.persistence.*;

/**
 *Class UserRegistrationDTO class
 * 
 * @author usatlk
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "Users")
public class UserRegistrationDTO {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    @Column(name = "first_Name", nullable = false, length = 20)
    private String firstName;
     
    @Column(name = "last_Name", nullable = false, length = 20)
    private String lastName;
    
    @Column(name = "userName", nullable = false, length = 20)
    private String userName;
  
   
}
