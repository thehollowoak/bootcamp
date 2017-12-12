package com.lse.spring.example.jta;

public interface AccountDao {
    Account fetchAccount(String accountNumber);

    Account save(Account account);

    Account remove(String accountNumber);

    int countAllAccounts();
}
