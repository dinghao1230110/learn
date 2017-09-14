package org.hao.learn.test.person.service;

import org.hao.learn.collection.PageInfo;
import org.hao.learn.database.Limit;
import org.hao.learn.exception.MyException;
import org.hao.learn.person.dao.UserReadDao;
import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.service.UserServiceImpl;
import org.hao.learn.sql.SqlQuery;
import org.hao.learn.test.ServiceBaseTest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.isA;

/**
 * Created by Jao on 2017/8/25.
 */
public class UserServiceImplTest extends ServiceBaseTest {
    @InjectMocks
    UserServiceImpl UserServiceImpl;
    @Mock
    UserReadDao     userReadDao;
    @Mock
    UserWriteDao    userWriteDao;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testQueryByLoginName() {
        //region 正常执行
        given(this.userReadDao.queryTotalBy(anyListOf(SqlQuery.class)))
                .willReturn(2L);
        given(this.userReadDao.queryBy(anyListOf(SqlQuery.class), isA(Limit.class)))
                .willReturn(null);
        PageInfo<UserInfo> pageInfo = UserServiceImpl.queryByLoginName("...", 1, 10);

        Assert.assertEquals(2, pageInfo.getTotal());
        Assert.assertEquals(1, pageInfo.getPageIndex());
        Assert.assertEquals(10, pageInfo.getPageSize());
        //endregion

        //region 是否可以得到预期的MyException异常
        thrown.expect(MyException.class);
        thrown.expectMessage("登录名不能为空");
        UserServiceImpl.queryByLoginName(null, 1, 10);
        //endregion
    }
}
