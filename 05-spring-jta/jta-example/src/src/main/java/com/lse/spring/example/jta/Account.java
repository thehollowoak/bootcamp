package com.lse.spring.example.jta;


public interface Account {
    String getType();

    String getAccountNumber();

    double getBalance();

    double credit(double amount);

    double debit(double amount);
}
