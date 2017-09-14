package org.hao.learn.test.person.dao;

import jodd.datetime.JDateTime;
import org.hao.learn.database.Limit;
import org.hao.learn.person.dao.UserReadDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.sql.SqlOperator;
import org.hao.learn.sql.SqlQuery;
import org.hao.learn.test.DataBaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

        //region 单值情况，在SQL中用的是 like, =, &, <>
        List<SqlQuery> sqlQueries = new ArrayList<SqlQuery>();
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_FIRST_NAME_FIELD, SqlOperator.LIKE, userInfo.getFirstName()));
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_LAST_NAME_FIELD, SqlOperator.EQ, userInfo.getLastName()));
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_STATUS_FIELD, SqlOperator.AND, userInfo.getStatus()));
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_PHONE_FIELD, SqlOperator.NEQ, userInfo.getPhone()));
        //endregion

        //region 多值情况，在SQL中用的是IN
        List<Object> inValue = new ArrayList<>();
        inValue.add("dinghao@163.com");
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_EMAIL_FIELD, SqlOperator.IN, inValue));
        //endregion

        //region 数字范围查询，在SQL中用的是 SQL_STATUS_FIELD >= 1 and SQL_STATUS_FIELD <= 1
        List<Object> betweenValue = new ArrayList<>();
        betweenValue.add(1);
        betweenValue.add(1);
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_STATUS_FIELD, SqlOperator.BETWEEN, betweenValue));
        //endregion

        //region 日期范围查询，在SQL中用的是 LAST_LOGIN_DATE >= '2017-09-04' and LAST_LOGIN_DATE <= '2017-09-05'
        List<Object> betweenValue1 = new ArrayList<>();
        betweenValue1.add(new JDateTime("2017-09-04"));
        betweenValue1.add(new JDateTime("2017-09-05"));
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_LAST_LOGIN_DATE_FIELD, SqlOperator.BETWEEN, betweenValue1));
        //endregion

        List<UserInfo> lst = userReadDao.queryBy(sqlQueries, limit);

        Assert.assertEquals("Hao", lst.get(0).getLoginName());
        Assert.assertEquals(1, lst.size());
    }
}
