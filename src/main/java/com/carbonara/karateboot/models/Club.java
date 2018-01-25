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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="clubs")
public class Club implements Serializable{
     @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;
     
     @Version
    private Integer version;
     
     @Column(name="name")
  @NotEmpty(message = "*Please provide club name")
  private String name;
     
     @Column(name="location")
  @NotEmpty(message = "*Please provide location name")
  private String location;
     
     @Column(name="style")
  @NotEmpty(message = "*Please provide club style")
  private String style;
     
     @Column(name="county")
  @NotEmpty(message = "*Please provide county it resides in")
  private String county;
     
     @Column(name="nearestTown")
  @NotEmpty(message = "*Please provide event name")
  private String nearestTown;
     
     @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    private Set<Affiliation> statements = new HashSet<Affiliation>();
     
     @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    private Set<UserInfo> members = new HashSet<UserInfo>();
    
     //getters and setters
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }
  
  public Integer getVersion() {return version;}

  public void setVersion(Integer version) {this.version = version;}

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }
  
  public String getLocation(){ return location;}
  
  public void setLocation(String location){ this.location=location; }
  
  public String getStyle(){ return style;}
  
  public void setStyle(String style){ this.style=style; }
  
  public String getCounty(){ return county;}
  
  public void setCounty(String county){ this.county=county; }
  
  public String getNearestTown(){ return nearestTown;}
  
  public void setNearestTown(String nearestTown){ this.nearestTown=nearestTown; }
  
   public Club() {}
  
  public Club(int id, String name, String location, String style, String county, String nearestTown) {
      super();
          this.id = id;
          this.name = name;
          this.location = location;
          this.style = style;
          this.county = county;
          this.nearestTown = nearestTown;
    }  
}
