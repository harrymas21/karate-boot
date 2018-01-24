package com.carbonara.karateboot.dtos;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class AffiliationDTO {
    @NotEmpty(message = "*This field is required")
    private String clubName;
    
    @NotEmpty(message = "*This field is required")
    private String journalDescription;
    
    @NotNull(message = "*This field is required")
    private int amount;
    
    @NotNull(message = "*This field is required")
    private int paid;
    
    public String getClubName(){return clubName;}
    
    public void setClubName(String clubName){this.clubName = clubName;}
    
    public String getJournalDescription(){return journalDescription;}
    
    public void setJournalDescription(String journalDescription){this.journalDescription = journalDescription;}
    
    public int getAmount(){return amount;}
    
    public void setAmount(int amount){this.amount = amount;}
    
    public int getPaid(){return paid;}
    
    public void setPaid(int paid){this.paid = paid;}
    
    public int getBalance(){return amount-paid;}
}
