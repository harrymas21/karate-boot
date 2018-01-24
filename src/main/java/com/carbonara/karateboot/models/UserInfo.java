package com.carbonara.karateboot.models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name="users")
public class UserInfo implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;
  
  @Column(name="username")
  @NotEmpty(message = "*Please provide your username")
  private String username;
  
  @Column(name="userrole")
  private String userRole;
  
  @Column(name = "password")
  @Length(min = 5, message = "*Your password must have at least 5 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;
  
  @Column(name="firstname")
  @NotEmpty(message = "*Please provide your firstname")
  private String firstname;
  
  @Column(name="lastname")
  @NotEmpty(message = "*Please provide your lastname")
  private String lastname;
  
  @Column(name = "email")
  @Email(message = "*Please provide a valid Email")
  @NotEmpty(message = "*Please provide an email")
  private String email;
  
  @Column(name="address")
  @NotEmpty(message = "*Please provide your address")
  private String address;
  
  @Column(name="phone")
  @NotEmpty(message = "*Please provide your phone-number")
  private String phone;
  
  @Column(name="enabled")	
  private short enabled;
  
  @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clubid", nullable = false)
  private Club club;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Blog> posts = new HashSet<Blog>();
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Comment> comments = new HashSet<Comment>();
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<EventRegister> registrations = new HashSet<EventRegister>();
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Affiliation> statements = new HashSet<Affiliation>();
  
  public int getId() {return id;}

  public void setId(int id) {this.id = id;}
  
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

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  public String getAddress() {return address;}

  public void setAddress(String address) {this.address = address;}

  public String getPhone() {return phone;}

  public void setPhone(String phone) {this.phone = phone;}
  
  public short getEnabled() {return enabled;}
  
  public void setEnabled(short enabled) {this.enabled = enabled;}
  
  public Club getClub(){ return club;}
  
  public void setClub(Club club){ this.club=club; }
  
  ///////////
  public UserInfo() {}
  
  public UserInfo(int id,String username,String firstname,String lastname,
          String userRole,String password,String email,String address,
          String phone,short enabled,Club club) {
          this.id = id;
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
