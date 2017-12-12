package com.lse.spring.example.jta;

public interface Bank {
    String BEAN_NAME = "jpmc";

    String getBankName();

    double getAccountBalance(String accountNumber);

    double creditAccount(String accountNumber, double amount);

    double debitAccount(String accountNumber, double amount);

    void transfer(String fromAccountNumber, String toAccountNumber, double amount);
}
