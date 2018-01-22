package com.carbonara.karateboot.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="eventregister")
public class EventRegister implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;
  
  @Column(name="category")
  @NotEmpty(message = "*Please enter category")
  private String category;
  
  @Column(name="result")
  @NotEmpty
  private String result;
    
  @Column(name="points")
  @NotNull
  private int points;
  
  @Column(name="date")
  @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date date = new Date();
  
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
  private UserInfo user;
  
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventid", nullable = false)
  private Event event;
  
  public int getId() {return id;}

  public void setId(int id) {this.id = id;}
  
  public String getCategory() {return category;}

  public void setCategory(String category) {this.category = category;}
  
  public String getResult() {return result;}

  public void setResult(String result) {this.result = result;}
  
  public int getPoints() {return points;}

  public void setPoints(int points) {this.points = points;}
  
  public Date getDate(){return date;}
  
  public void setDate(Date date){ this.date = date; }
  
  public UserInfo getUser() {return user;}
  
  public void setUser(UserInfo user) { this.user = user; }
  
  public Event getEvent() {return event;}
  
  public void setEvent(Event event) { this.event = event; }
}
