package com.carbonara.karateboot.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comments")
public class Comment implements Serializable{
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
  private UserInfo author;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", nullable = false)
  private Blog blogId;
    
    @Column(name="comment")
  @NotEmpty(message = "*Please provide blog comment")
  private String body;
    
    @Column(name="date")
  @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date date = new Date();
    
    //getters and setters
  
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public UserInfo getAuthor() { return author; }

  public void setAuthor(UserInfo author) { this.author = author; }
  
  public Date getDate(){return date;}
  
  public void setDate(Date date){ this.date = date; }
  
  public Blog getBlogId(){ return blogId;}
  
  public void setBlogId(Blog blogId){ this.blogId=blogId; }
  
  public String getBody(){ return body;}
  
  public void setBody(String body){ this.body=body; }
  
}