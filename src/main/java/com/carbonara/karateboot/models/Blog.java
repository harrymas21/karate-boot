package com.carbonara.karateboot.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="blog")
public class Blog implements Serializable{
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;
    
    @Version
    private Integer version;
    
    @Column(name="title")
  @NotEmpty(message = "*Please provide blog title")
  private String title;
    
    @Column(name="body")
  @NotEmpty(message = "*Please provide blog post")
  private String body;
    
    @Column(name="date")
  @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date date = new Date();
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
  private UserInfo author;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "blogId")
    private Set<Comment> comments = new HashSet<Comment>();
    //getters and setters
  
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }
  
  public Integer getVersion() {return version;}

  public void setVersion(Integer version) {this.version = version;}

  public String getTitle() { return title; }

  public void setTitle(String title) { this.title = title; }
  
  public Date getDate(){return date;}
  
  public void setDate(Date date){ this.date = date; }
  
  public String getBody(){ return body;}
  
  public void setBody(String body){ this.body=body; }
  
  public UserInfo getAuthor(){ return author;}
  
  public void setAuthor(UserInfo author){ this.author=author; }
  
  public Set<Comment> getComments(){ return comments;}
  public Blog() {}
  
  public Blog(int id, String title, String body, UserInfo author) {
          this.id = id;
          this.title = title;
          this.body = body;
          this.author = author;
    }  
}