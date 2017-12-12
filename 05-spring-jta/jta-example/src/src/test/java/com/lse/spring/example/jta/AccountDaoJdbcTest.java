package com.lse.spring.example.jta;

import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-test.xml")
@TransactionConfiguration(defaultRollback = false)
public class AccountDaoJdbcTest {

    private static final String ACCT1 = "9999887777";
    private static final String ACCT2 = "9999887778";
    private static final String ACCT3 = "9999887779";


    @Autowired
    private AccountDao dao;

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
        dao.remove(ACCT1);
        dao.remove(ACCT2);
        dao.remove(ACCT3);
    }

    @Test
    public void testFetchAccount() {
        Account found = dao.fetchAccount(ACCT1);
        Assert.assertEquals("found", ACCT1, found.getAccountNumber());
    }

    @Test
    public void testSaveInsert() {
        Account found = dao.fetchAccount(ACCT3);
        Assert.assertNull("not found", found);

        Account account = new DefaultAccount("Savings", ACCT3, 4321.00);
        Account result = dao.save(account);
        Assert.assertNotNull("saved", result);

        found = dao.fetchAccount(ACCT3);
        Assert.assertNotNull("found", found);
        Assert.assertEquals("found", ACCT3, found.getAccountNumber());
    }

    @Test
    public void testSaveUpdate() {
        Account found = dao.fetchAccount(ACCT1);
        Assert.assertNotNull("found", found);
        DefaultAccount expected = new DefaultAccount(found);
        expected.setBalance(-100.0);
        dao.save(expected);

        Account actual = dao.fetchAccount(ACCT1);
        Assert.assertNotNull("saved", actual);
        Assert.assertEquals("changed balance", expected.getBalance(), actual.getBalance());

        found = dao.fetchAccount(ACCT1);
        Assert.assertNotNull("found", found);
        Assert.assertEquals("found", ACCT1, found.getAccountNumber());
    }

    @Test
    public void testRemove() {
        Account removed = dao.remove(ACCT2);
        Assert.assertEquals("removed", ACCT2, removed.getAccountNumber());
        removed = dao.remove(ACCT2);
        Assert.assertNull("removed", removed);

    }

    @Test
    public void testCountAllAccounts() {
        int actual = dao.countAllAccounts();
        Assert.assertTrue("count", actual >= 3);
    }

}
