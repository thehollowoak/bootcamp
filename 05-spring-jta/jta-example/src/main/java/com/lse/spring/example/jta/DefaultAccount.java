package com.lse.spring.example.jta;


import javax.validation.constraints.*;
import java.util.Date;


public class DefaultAccount implements Account {
    @NotNull
    private String type;

    @NotNull
    @Size(max = 10, min = 10)
    private String accountNumber;

    @Min(25)
    private double balance;

    private Date lastModified;

    public DefaultAccount() {
    }

    public DefaultAccount(String type, String accountNumber, double balance) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public DefaultAccount(Account account) {
        this.type = account.getType();
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccount(String account) {
        this.accountNumber = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double credit(double amount) {
        balance += amount;
        return balance;
    }

    public double debit(double amount) {
        balance -= amount;
        return balance;
    }

    @Override
    public String toString() {
        return "DefaultAccount [type=" + type + ", accountNumber=" + accountNumber + ", balance=" + balance
                + ", lastModified=" + lastModified + "]";
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
