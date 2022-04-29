package com.rakuten;
import java.util.Date;
public class Account {
    private String accountHolderName;
    private String address;
    private long balance;
    private Date createdDate; //import from java.util
    private TYPE accountType;
    private STATUS accountStatus;
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public TYPE getAccountType() {
        return accountType;
    }
    public void setAccountType(TYPE accountType) {
        this.accountType = accountType;
    }
    public STATUS getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(STATUS accountStatus) {
        this.accountStatus = accountStatus;
    }
//  @Override
//  public String toString() {
//      String accountInfo = String.format("Account Number:: %s\n Owner Name:: %s\n Address:: %s\n Balance:: %d\n Created Date:: %s\n Account Status:: %s\n Account Type:: %s", getAccountNumber(), getAccountHolderName(), getAddress(), getBalance(), getCreatedDate(), getAccountStatus(), getAccountType());
//      accountInfo += "\n------------------------------------\n";
//      return accountInfo;
//  }
    public long withdraw(long amount) {
        if(amount > this.getBalance()) {
            throw new IllegalArgumentException("Low Balance, the current balance is " + this.getBalance());
        }
        this.setBalance(this.getBalance() - amount);
        return this.getBalance();
    }
    public long deposit(long amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount should not be negative, the entered amount is " + amount);
        }
        this.setBalance( amount + this.getBalance() );
        return this.getBalance();
    }
}



