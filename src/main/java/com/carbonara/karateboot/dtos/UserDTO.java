
package com.carbonara.karateboot.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {
    
  @NotEmpty(message = "*Please provide your username")
  private String username;
  
  private String userRole = "ROLE_USER";
  
  @Length(min = 5, message = "*Your password must have at least 5 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;
  

  @NotEmpty(message = "*Please provide your firstname")
  private String firstname;
  

  @NotEmpty(message = "*Please provide your lastname")
  private String lastname;

  @Email(message = "*Please provide a valid Email")
  @NotEmpty(message = "*Please provide an email")
  private String email;
  

  @NotEmpty(message = "*Please provide your address")
  private String address;
  
  @NotEmpty(message = "*Please provide your belt rank")
  private String rank;
  

  @NotEmpty(message = "*Please provide your phone-number")
  private String phone;


  @NotEmpty(message = "*Please provide your phone-number")
  private String club;
  
  private short enabled = 1;
  
  //setters and getters
  public String getUsername() {return username;}

  public void setUsername(String username) {this.username = username;}
  
  public String getRole() {return userRole;}

  public void setRole(String userRole) {this.userRole = userRole;}
  
  public String getPassword() {return password;}

  public void setPassword(String password) {this.password = password;}

  public String getFirstname() {return firstname;}

  public void setFirstname(String firstname) {this.firstname = firstname;}

  public String getLastname() {return lastname;}

  public void setLastname(String lastname) {this.lastname = lastname;}
  
  public String getRank() {return rank;}

  public void setRank(String rank) {this.rank = rank;}

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  public String getAddress() {return address;}

  public void setAddress(String address) {this.address = address;}

  public String getPhone() {return phone;}

  public void setPhone(String phone) {this.phone = phone;}
  
  public short getEnabled() {return enabled;}
  
  public void setEnabled(short enabled) {this.enabled = enabled;}
  
  public String getClub(){ return club;}
  
  public void setClub(String club){ this.club=club; }
  
  public UserDTO() {}
  
  public UserDTO(int id,String username,String firstname,String lastname,
          String userRole,String password,String email,String address,
          String phone,short enabled,String club) {
          this.username = username;
          this.firstname = firstname;
          this.lastname = lastname;
          this.userRole = userRole;
          this.password = password;
          this.email = email;
          this.address = address;
          this.phone = phone;
          this.enabled = enabled;
          this.club = club;
    }  
}
