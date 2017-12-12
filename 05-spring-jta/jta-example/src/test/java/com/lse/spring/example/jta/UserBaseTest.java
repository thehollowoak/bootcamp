package com.lse.spring.example.jta;

import org.joda.time.DateTime;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.ContextConfiguration;


/**
 * Unit test for simple User.
 */

@ContextConfiguration(classes = TestConfig.class)
@DirtiesContext
@Rollback(false)
public class UserBaseTest {

    @Autowired(required = true)
    private User user;

    @Autowired
    private AccountDao dao;

    @Value("${my.account.balance}")
    private Double initialBalance;

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

    public void checkingAccountTest() {
        Double takeOut = 20.0;
        Double initialDeposit = 100.0;
        Double nextDeposit = 1000000.0;

        Double balance = user.depositToChecking(initialDeposit);
        System.out.println("+++ starting balance: " + balance);

        balance = user.depositToChecking(nextDeposit);
        Double expected = nextDeposit + initialDeposit;
        Assert.assertEquals("initial balance",
                expected, balance
        );

        System.out.println("+++ withdrawing $" + takeOut + " dollars");
        balance = user.withdrawFromChecking(takeOut);
        System.out.println("+++ ending balance: " + balance);

        Assert.assertEquals("new balance",
                Double.valueOf(expected - takeOut),
                balance);

        System.out.println("+++ object tree: " + user);
    }

    public void transferTest() {
        DateTime startTime = new DateTime();  //must be before transactions !!!

        Double balance = user.depositToChecking(100.00);
        Assert.assertTrue("above 10", balance > 10.0);

        Double checking = user.checkingBalance();
        Double savings = user.savingsBalance();

        Assert.assertTrue("above 10", checking > 10.0);
        Assert.assertTrue("above zero", savings > 0.0);

        Double transfer = 10.00;
        user.transferFromCheckingToSavings(transfer);

        Double checkingAfter = user.checkingBalance();
        Double savingsAfter = user.savingsBalance();

        Assert.assertEquals("transfer", Double.valueOf(checking - transfer), checkingAfter);
        Assert.assertEquals("transfer", Double.valueOf(savings + transfer), savingsAfter);

        System.out.println("object tree: " + user);

        DateTime endTime = startTime.plusSeconds(10);

//        List<Audit> auditList = dao.findAudits(user.getCheckingAccountNumber(), startTime, endTime);
//        System.out.println("auditList="+auditList);
//        Assert.assertNotNull(auditList);
//        Assert.assertTrue(auditList.size()>0);
//        Audit item = auditList.get(0);
//        Assert.assertEquals(user.getCheckingAccountNumber(), item.getAccountNumber());
//        Assert.assertTrue("start on or after",item.getEventTime().isAfter(startTime) || item.getEventTime().isEqual(startTime));
//        Assert.assertTrue("end on or before",item.getEventTime().isBefore(endTime) || item.getEventTime().isEqual(endTime));
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }
}
