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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.*;

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

    @Test
    public void tsetQueryById() {
        given(this.userReadDao.queryById(anyLong()))
                .willReturn(null);
        UserServiceImpl.queryById(anyLong());
    }

    @Test
    public void testQueryAll() {
        given(this.userReadDao.queryTotal())
                .willReturn(2L);
        given(this.userReadDao.queryAll(isA(Limit.class)))
                .willReturn(null);
        PageInfo<UserInfo> pageInfo = new PageInfo<>();
        pageInfo.setPageIndex(1);
        pageInfo.setPageSize(5);

        UserServiceImpl.queryAll(1, 5);
    }

    @Test
    public void testAddUser() {
        given(this.userWriteDao.insertUser(any(UserInfo.class)))
                .willReturn(1);

        UserServiceImpl.add(null);

        thrown.expect(MyException.class);
        thrown.expectMessage("新增用户失败");
        given(this.userWriteDao.insertUser(any(UserInfo.class)))
                .willReturn(0);
        UserServiceImpl.add(null);
    }

    @Test
    public void testBatchAdd() {
        UserInfo       userInfo = new UserInfo();
        List<UserInfo> lis      = new ArrayList<>();
        lis.add(userInfo);
        given(this.userWriteDao.insertUser(userInfo))
                .willReturn(1);
        UserServiceImpl.batchAdd(lis);

        thrown.expect(MyException.class);
        thrown.expectMessage("批量增加用户失败");
        given(this.userWriteDao.insertUser(userInfo))
                .willReturn(0);
        UserServiceImpl.batchAdd(lis);
    }

    @Test
    public void testDeleteUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        given(this.userWriteDao.deleteUser(1L))
                .willReturn(1);
        UserServiceImpl.delete(userInfo);

        thrown.expect(MyException.class);
        thrown.expectMessage("删除用户失败");
        given(this.userWriteDao.deleteUser(1L))
                .willReturn(0);
        UserServiceImpl.delete(userInfo);
    }

    @Test
    public void testDeleteUser1() {
        thrown.expect(MyException.class);
        thrown.expectMessage("用户不能为空");
        UserServiceImpl.delete(null);
    }

    @Test
    public void testBatchDelete() {
        UserInfo       userInfo = new UserInfo();
        List<UserInfo> lis      = new ArrayList<>();
        lis.add(userInfo);

        given(this.userWriteDao.deleteUser(anyLong()))
                .willReturn(1);
        UserServiceImpl.batchDelete(lis);

        thrown.expect(MyException.class);
        thrown.expectMessage("批量删除用户失败");
        given(this.userWriteDao.deleteUser(anyLong()))
                .willReturn(0);
        UserServiceImpl.batchDelete(lis);
    }
}
