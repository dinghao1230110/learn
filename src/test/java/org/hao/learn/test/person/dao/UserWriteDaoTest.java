package org.hao.learn.test.person.dao;

import jodd.datetime.JDateTime;
import org.hao.learn.bd.IncludeField;
import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.test.DataBaseTest;
import org.hao.learn.utils.SnowflakeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Jao on 2017/8/25.
 */
public class UserWriteDaoTest extends DataBaseTest {
    @Autowired
    UserWriteDao userWriteDao;

    @Test
    public void testInsertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(SnowflakeUtil.next());
        userInfo.setLoginName("admin");
        int result = userWriteDao.insertUser(userInfo);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testUpdateUser() {
        UserInfoMate userInfoMate = new UserInfoMate();
        Map<String, IncludeField> includeStatusMap = userInfoMate.generateNotIncludeMap();
        includeStatusMap.get(userInfoMate.EMAIL_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue("dinghao@163.com");
        includeStatusMap.get(userInfoMate.FIRST_NAME_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue("丁");
        includeStatusMap.get(userInfoMate.LAST_NAME_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue("浩");
        includeStatusMap.get(userInfoMate.LAST_LOGIN_DATE_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue(new JDateTime());

        UserInfo userInfo = new UserInfo();
        userInfo.setId(6308316580291813376L);

        int result = userWriteDao.updateUser(userInfo, userInfoMate.generateNotIncludeList());

        Assert.assertEquals(1, result);
    }

    @Test
    public void testDeleteUser(){
        int result =  userWriteDao.deleteUser(6308316580291813376L);

        Assert.assertEquals(1, result);
    }
}
