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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event implements Serializable{
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;
    
    @Version
    private Integer version;
    
    @Column(name="name")
  @NotEmpty(message = "*Please provide event name")
  private String name;
    
    @Column(name="date")
  @NotNull(message = "*Please provide event date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date date;
    
    @Column(name="location")
  @NotEmpty(message = "*Please provide event location")
  private String location;
    
    @Column(name="type")
  @NotEmpty(message = "*Please provide event type")
  private String type;
    
    @Column(name="cost")
  @NotNull(message = "*Please provide event cost(Kshs.)")
  private int cost;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private Set<EventRegister> registrations = new HashSet<EventRegister>();
  
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }
  
  public Integer getVersion() {return version;}

  public void setVersion(Integer version) {this.version = version;}
    
  public String getName() { return name; }

  public void setName(String name) { this.name = name; }
  
  public Date getDate(){return date;}
  
  public void setDate(Date date){ this.date = date; }
  
  public String getLocation(){ return location;}
  
  public void setLocation(String location){ this.location=location; }
  
  public String getType(){ return type;}
  
  public void setType(String type){ this.type=type; }
  
  public int getCost(){ return cost;}
  
  public void setCost(int cost){ this.cost=cost; }
}
