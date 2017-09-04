package org.hao.learn.test.person.dao;

import org.hao.learn.database.Limit;
import org.hao.learn.person.dao.UserReadDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.test.DataBaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserReadDaoTest extends DataBaseTest {
    @Autowired
    UserReadDao userReadDao;

    @Test
    public void testQueryById() {
        UserInfo userInfo = userReadDao.queryById(6308316580291813376L);

        Assert.assertEquals("Hao", userInfo.getLoginName());
    }

    @Test
    public void testQueryAll() {
        Limit limit = new Limit(1, 0);

        List<UserInfo> lst = userReadDao.queryAll(limit);

        Assert.assertEquals("Hao", lst.get(0).getLoginName());
        Assert.assertEquals(1, lst.size());
    }

    @Test
    public void testQueryBy() {
        Limit limit = new Limit(1, 0);

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("Ding");
        userInfo.setLastName("Hao");
        userInfo.setEmail("dinghao@");
        userInfo.setPhone("30");
        userInfo.setLoginName("H");
        userInfo.setLastLoginIp("168.1");
        userInfo.setStatus((byte) 1);

        List<UserInfo> lst = userReadDao.queryBy(userInfo, limit);

        Assert.assertEquals("Hao", lst.get(0).getLoginName());
        Assert.assertEquals(1, lst.size());
    }
}
