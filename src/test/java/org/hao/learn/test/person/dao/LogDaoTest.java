package org.hao.learn.test.person.dao;

import org.hao.learn.person.dao.LogDao;
import org.hao.learn.person.domain.LogInfo;
import org.hao.learn.test.DataBaseTest;
import org.hao.learn.utils.SnowflakeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LogDaoTest extends DataBaseTest {
    @Autowired
    LogDao logDao;

    /**
     * 自增ID获取方式:
     * https://stackoverflow.com/questions/18507508/mybatis-how-to-get-the-auto-generated-key-of-an-insert-mysql
     * http://blog.csdn.net/isea533/article/details/21153791
     *
     * 插入的时候有3中id方式
     * 1. uuid
     * 2. 分布式 id
     * 3. 自增式 id
     */
    @Test
    public void testInsertLog() {
        LogInfo logInfo = new LogInfo();
        logInfo.setId(SnowflakeUtil.next());
        logInfo.setKey("TEST LOG");
        logInfo.setSuccess(true);
        logInfo.setPrimaryParameter("{}");
        logInfo.setRemark("REMARK");

        int result = logDao.insertLog(logInfo);

        Assert.assertEquals(1, result);
    }
}
