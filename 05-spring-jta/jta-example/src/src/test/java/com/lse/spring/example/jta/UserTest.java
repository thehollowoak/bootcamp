package com.lse.spring.example.jta;

import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


/**
 * Unit test for simple User.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-test.xml")
@TransactionConfiguration(defaultRollback = false)
public class UserTest {

    @Autowired(required = true)
    private User user;

    @Autowired
    private AccountDao dao;

    @Value("${my.account.balance}")
    private double initialBalance;

    @Before
    public void setup() {
        Account found = dao.fetchAccount(user.getCheckingAccountNumber());
        if (found != null) {
            DefaultAccount account = new DefaultAccount(found);
            account.setBalance(0.0);
            dao.save(account);
        }
    }

    @After
    public void teardown() {
    }

    @Test
    public void testCheckingAccount() {
        double takeOut = 20.0;
        double initialDeposit = 100.0;
        double nextDeposit = 1000000.0;

        double balance = user.depositToChecking(initialDeposit);
        System.out.println("starting balance: " + balance);

        balance = user.depositToChecking(nextDeposit);
        double expected = nextDeposit + initialDeposit;
        Assert.assertEquals("initial balance", expected, balance);

        System.out.println("  withdrawing $" + takeOut + " dollars");
        balance = user.withdrawFromChecking(takeOut);
        System.out.println("ending balance: " + balance);

        Assert.assertEquals("new balance", (expected - takeOut), balance);

        System.out.println("object tree: " + user);
    }

    @Test
    public void testTransfer() {
        double balance = user.depositToChecking(100.00);
        Assert.assertTrue("above 10", balance > 10.0);

        double checking = user.checkingBalance();
        double savings = user.savingsBalance();

        Assert.assertTrue("above 10", checking > 10.0);
        Assert.assertTrue("above zero", savings > 0.0);

        double transfer = 10.00;
        user.transferFromCheckingToSavings(transfer);

        double checkingAfter = user.checkingBalance();
        double savingsAfter = user.savingsBalance();

        Assert.assertEquals("transfer", checking - transfer, checkingAfter);
        Assert.assertEquals("transfer", savings + transfer, savingsAfter);

        System.out.println("object tree: " + user);
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }
}
