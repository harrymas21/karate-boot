package com.carbonara.karateboot.dtos;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class DateAndVarDTO {
    @NotNull(message = "*Please provide the start date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    
    @NotNull(message = "*Please provide the end date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    
    @NotEmpty(message = "*This is required")
    private String var;
    
    // standard getters and setters
  public Date getStartDate() {return startDate;}

  public void setStartDate(Date startDate) {this.startDate = startDate;}
  
  public Date getEndDate() {return endDate;}

  public void setEndDate(Date endDate) {this.endDate = endDate;}
  
  public String getVar(){return var;}
  
  public void setVar(String var){this.var = var;}
  
  public DateAndVarDTO(){};
  
  public DateAndVarDTO(Date start, Date end, String var){
  this.startDate = start;
  this.endDate = end;
  this.var = var;
  };
}
