package com.carbonara.karateboot.dtos;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class DateDTO {
    @NotNull(message = "*Please provide the start date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @NotNull(message = "*Please provide the end date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    
    // standard getters and setters
  public Date getStartDate() {return startDate;}

  public void setStartDate(Date startDate) {this.startDate = startDate;}
  
  public Date getEndDate() {return endDate;}

  public void setEndDate(Date endDate) {this.endDate = endDate;}
}
