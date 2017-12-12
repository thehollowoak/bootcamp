package com.lse.spring.example.jta;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Unit test for simple User.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc")
public class UserJdbcTest extends UserBaseTest {

    @Test
    public void testCheckingAccount() {
        super.checkingAccountTest();
    }

    @Test
    public void testTransfer() {
        super.transferTest();
    }
}
