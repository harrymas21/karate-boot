package com.carbonara.karateboot.dtos;

public class CommentDTO{
    private int blogId; 
    private String body;
    
    // standard getters and setters
  public int getBlogId() {return blogId;}

  public void setBlogId(int blogId) {this.blogId = blogId;}
  
  public String getBody() {return body;}

  public void setBody(String body) {this.body = body;}
} 
