package com.lse.spring.example.jta;

import java.util.List;

public interface AccountDao {
    Account fetchAccount(String accountNumber);

    Account save(Account account);

    Account remove(String accountNumber);

    Integer countAllAccounts();

    List<Account> fetchAccountListByAcctType(String acctType);

//	void audit(String action, String accountNumber, double amount);
//	List<Audit> findAudits(String accountNumber, DateTime startTime, DateTime endTime);

}
