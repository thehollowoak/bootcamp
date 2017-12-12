package com.lse.spring.example.jta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.*;

@Profile("jdbc")
@Repository
@Transactional
public class AccountDaoJdbc implements AccountDao {
    private static final String SQL_DELETE_ACCOUNT = "delete from ACCOUNT where acct_number=:acct";

    private static final String SQL_COUNT_ALL = "SELECT COUNT(1) FROM ACCOUNT";

    private static final String SQL_INSERT_ACCOUNT = "insert into ACCOUNT(acct_number,balance,acct_type,last_modified) values (:acct,:balance,:type,:now)";

    private static final String SQL_UPDATE_ACCOUNT = "update ACCOUNT set acct_number=:acct,balance=:balance,acct_type=:type,last_modified=:now where acct_number=:acct";

    private static final String SQL_FETCH_ACCOUNT = "select acct_number, balance, acct_type, last_modified from account where acct_number=:acct";

    private static final String SQL_FETCH_ACCOUNT_BY_ACCT_TYPE =
            "select acct_number, balance, acct_type, last_modified from account where acct_type=:acctType";

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate jdbc;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() {
        System.out.println("AccountDaoJdbc init");
        jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AccountDaoJdbc destroy");
    }

    public AccountDaoJdbc() {
    }

    private static class AccountMapper implements RowMapper<Account> {
        public Account mapRow(ResultSet rs, int row) throws SQLException {
            DefaultAccount obj = new DefaultAccount();
            obj.setAccount(rs.getString("acct_number"));
            obj.setBalance(rs.getDouble("balance"));
            obj.setType(rs.getString("acct_type"));
            obj.setLastModified(rs.getDate("last_modified"));
            return obj;
        }
    }

    ;
    private AccountMapper mapper = new AccountMapper();

    public Account fetchAccount(String accountNumber) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("acct", accountNumber);
        Account result = null;
        List<Account> list = jdbc.query(SQL_FETCH_ACCOUNT, parameters, mapper);
        if (list != null && list.size() > 0) {
            result = list.get(0);
        }
        return result;
    }

    public Integer countAllAccounts() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = jdbc.queryForObject(SQL_COUNT_ALL, map, Integer.class);
        return count;
    }

    public Account save(Account account) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("acct", account.getAccountNumber());
        parameters.put("type", account.getType());
        parameters.put("balance", account.getBalance());
        parameters.put("now", new Date());

        //do we update or insert?
        Account found = fetchAccount(account.getAccountNumber());
        if (found != null) {
            jdbc.update(SQL_UPDATE_ACCOUNT, parameters);
        } else {
            jdbc.update(SQL_INSERT_ACCOUNT, parameters);
        }
        //what if the change triggered an event, get the latest data
        found = fetchAccount(account.getAccountNumber());
        return found;
    }

    public Account remove(String accountNumber) {
        Account found = fetchAccount(accountNumber);
        if (found != null) {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("acct", accountNumber);
            jdbc.update(SQL_DELETE_ACCOUNT, parameters);
        }
        return found;
    }

    @Override
    public List<Account> fetchAccountListByAcctType(String acctType) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("acctType", acctType);
        List<Account> list = jdbc.query(SQL_FETCH_ACCOUNT_BY_ACCT_TYPE, parameters, mapper);
        return list;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{ class: ");
        sb.append(this.getClass().getCanonicalName());
        sb.append(",\n\t size: ").append(countAllAccounts());
        sb.append(" }\n");
        return sb.toString();
    }
}
