package com.carbonara.karateboot.models;

import com.carbonara.karateboot.libs.UniqueKeyGenerator;
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
@Table(name="affiliations")
public class Affiliation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
     @Version
    private Integer version;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", nullable = false)
  private UserInfo user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
  private Club club;
    
     @Column(name="date")
  @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date date = new Date();
     
     @Column(name="journalDescription")
  @NotEmpty
  private String journalDescription;
     
     @Column(name="transactioncode")
  @NotEmpty
  private String transactionCode = UniqueKeyGenerator.getUniqueKey();
     
     @Column(name="amount")
  @NotNull
  private int amount;
     
     @Column(name="paid")
  @NotNull
  private int paid;
     
     @Column(name="balance")
  @NotNull
  private int balance;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
    
    public Integer getVersion() {return version;}

    public void setVersion(Integer version) {this.version = version;}
    
    public Club getClub() {return club;}

    public void setClub(Club club) {this.club = club;}
    
    public UserInfo getUser() {return user;}

    public void setUser(UserInfo user) {this.user = user;}
    
    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}
    
    public String getTransactionCode() {return transactionCode;}

    public void setTransactionCode(String transactionCode) {this.transactionCode = transactionCode;}
    
    public String getJournalDescription() {return journalDescription;}

    public void setJournalDescription(String journalDescription) {this.journalDescription = journalDescription;}
    
    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}
    
    public int getPaid() {return paid;}

    public void setPaid(int paid) {this.paid = paid;}
    
    public int getBalance() {return balance;}

    public void setBalance(int balance) {this.balance = balance;}
}
