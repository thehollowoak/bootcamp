package com.lse.spring.example.jta;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Rollback(false)
@ActiveProfiles("jdbc")
public class AccountDaoJdbcTest extends AccountDaoBaseTest {


    @Test
    public void testFetchAccount() {
        super.fetchAccountTest();
    }

    @Test
    public void testSaveInsert() {
        super.saveInsertTest();
    }

    @Test
    public void testSaveUpdate() {
        Account found = super.saveUpdateTest();
        Assert.assertNotNull(found);
        Assert.assertNotNull(found.getLastModified());
    }

    @Test
    public void testRemove() {
        super.removeTest();

    }

    @Test
    public void testCountAllAccounts() {
        super.countAllAccountsTest();
    }

    @Test
    public void testAcctType() {
        List<Account> list = super.acctTypeTest();
        Assert.assertNotNull(list);
        Assert.assertNotNull(list.get(0).getLastModified());
    }

}
