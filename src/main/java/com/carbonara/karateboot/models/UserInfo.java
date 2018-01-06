package com.carbonara.karateboot.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
  @Id
 @Column(name="id")
  private int id;
  @Column(name="username")
  private String username;
  @Column(name="user-role")
  private String userRole;
  @Column(name="password")
  private String password;
  @Column(name="firstname")
  private String firstname;
  @Column(name="lastname")
  private String lastname;
  @Column(name="email")
  private String email;
  @Column(name="address")
  private String address;
  @Column(name="phone")
  private String phone;
  @Column(name="enabled")	
  private short enabled;
  
  public int getId() {
  return id;
  }

  public void setId(int id) {
  this.id = id;
  }
  
  public String getUsername() {
  return username;
  }

  public void setUsername(String username) {
  this.username = username;
  }
  
  public String getRole() {
  return userRole;
  }

  public void setRole(String userRole) {
  this.userRole = userRole;
  }
  
  public String getPassword() {
  return password;
  }

  public void setPassword(String password) {
  this.password = password;
  }

  public String getFirstname() {
  return firstname;
  }

  public void setFirstname(String firstname) {
  this.firstname = firstname;
  }

  public String getLastname() {
  return lastname;
  }

  public void setLastname(String lastname) {
  this.lastname = lastname;
  }

  public String getEmail() {
  return email;
  }

  public void setEmail(String email) {
  this.email = email;
  }

  public String getAddress() {
  return address;
  }

  public void setAddress(String address) {
  this.address = address;
  }

  public String getPhone() {
  return phone;
  }

  public void setPhone(String phone) {
  this.phone = phone;
  }
  public short getEnabled() {
		return enabled;
	}
  public void setEnabled(short enabled) {
		this.enabled = enabled;
	}
}
