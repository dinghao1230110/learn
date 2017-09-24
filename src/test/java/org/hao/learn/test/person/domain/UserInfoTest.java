package org.hao.learn.test.person.domain;

import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import org.hao.learn.person.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserInfoTest {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoTest.class);

    /**
     * 如何断言呢?
     */
    @Test
    public void testVtor() {
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("");
        userInfo.setLastName("");
        userInfo.setPhone("19088888888");
        userInfo.setEmail("dinghao163.com");

        Vtor            vtor   = new Vtor();
        List<Violation> result = vtor.validate(userInfo);
        if (result != null) {
            for (Violation violation : result) {
                logger.info(violation.getCheck().getMessage());
            }
        }
        Assert.assertEquals(4,result.size());
    }
}
