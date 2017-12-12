package com.lse.spring.example.jta;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.*;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = TestConfig.class)
@Rollback(false)
@DirtiesContext
public class AccountDaoBaseTest {

    static final String ACCT1 = "9999887777";
    static final String ACCT2 = "9999887778";
    static final String ACCT3 = "9999887779";

    @Autowired
    AccountDao dao;

    Account acct1 = new DefaultAccount("Checking", ACCT1, 12.34);
    Account acct2 = new DefaultAccount("Savings", ACCT2, 1234.56);

    @Before
    public void setUp() throws Exception {
        dao.remove(ACCT1);
        dao.remove(ACCT2);
        dao.remove(ACCT3);
        dao.save(acct1);
        dao.save(acct2);
    }

    @After
    public void tearDown() throws Exception {
//		dao.remove(ACCT1);
//		dao.remove(ACCT2);
//		dao.remove(ACCT3);
    }

    public void fetchAccountTest() {
        Account found = dao.fetchAccount(ACCT1);
        Assert.assertEquals("found", ACCT1, found.getAccountNumber());
    }

    public void saveInsertTest() {
        Account found = dao.fetchAccount(ACCT3);
        Assert.assertNull("not found", found);

        Account account = new DefaultAccount("Savings", ACCT3, 4321.00);
        Account result = dao.save(account);
        Assert.assertNotNull("saved", result);

        found = dao.fetchAccount(ACCT3);
        Assert.assertNotNull("found", found);
        Assert.assertEquals("found", ACCT3, found.getAccountNumber());
    }

    public Account saveUpdateTest() {
        Account found = dao.fetchAccount(ACCT1);
        Assert.assertNotNull("found", found);
        DefaultAccount expected = new DefaultAccount(found);
        expected.setBalance(-100.0);
        dao.save(expected);

        Account actual = dao.fetchAccount(ACCT1);
        Assert.assertNotNull("saved", actual);
        Assert.assertEquals("changed balance",
                Double.valueOf(expected.getBalance()),
                Double.valueOf(actual.getBalance())
        );

        found = dao.fetchAccount(ACCT1);
        Assert.assertNotNull("found", found);
        Assert.assertEquals("found", ACCT1, found.getAccountNumber());
        return found;
    }

    public void removeTest() {
        Account removed = dao.remove(ACCT2);
        Assert.assertEquals("removed", ACCT2, removed.getAccountNumber());
        removed = dao.remove(ACCT2);
        Assert.assertNull("removed", removed);

    }

    public void countAllAccountsTest() {
        int actual = dao.countAllAccounts();
        Assert.assertTrue("count", actual >= 3);
    }

    public List<Account> acctTypeTest() {
        String acctType = "Savings";
        List<Account> list = dao.fetchAccountListByAcctType(acctType);
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        Assert.assertEquals(acctType, list.get(0).getType());
        return list;
    }

}
