package org.hao.learn.test.person.dao;

import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.test.DataBaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jao on 2017/8/25.
 */
public class UserDaoTest extends DataBaseTest {
    @Autowired
    UserWriteDao userWriteDao;

    @Test
    public void insertUserTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setLoginName("admin");
        int result = userWriteDao.insertUser(userInfo);

        Assert.assertEquals(1, result);
    }
}
