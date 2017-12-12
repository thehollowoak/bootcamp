package com.lse.spring.example.jta;


import java.util.Date;

public interface Account {
    String getType();

    String getAccountNumber();

    double getBalance();

    Date getLastModified();

    double credit(double amount);

    double debit(double amount);

}
