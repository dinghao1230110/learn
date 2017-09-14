package org.hao.learn.test.person.service;

import org.hao.learn.collection.PageInfo;
import org.hao.learn.person.dao.UserReadDao;
import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.service.UserServiceImpl;
import org.hao.learn.sql.SqlQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by Jao on 2017/8/25.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    UserServiceImpl UserServiceImpl;
    @MockBean
    UserReadDao     userReadDao;
    @MockBean
    UserWriteDao    userWriteDao;


    @Test
    public void testQueryByLoginName() {
        List<SqlQuery> sqlQueries = new ArrayList<>();
        given(this.userReadDao.queryTotalBy(null))
                .willReturn(2L);
//        given(this.userReadDao.queryBy(null, null))
//                .willReturn(null);
        PageInfo<UserInfo> pageInfo = UserServiceImpl.queryByLoginName("DingHao", 1, 1);

//        UserReadDao userReadDao = new MockUp<UserReadDao>() {
//            @Mock
//            long queryTotalBy(List<SqlQuery> sqlQueries) {
//                return 1;
//            }
//
//            @Mock
//            List<UserInfo> queryBy(List<SqlQuery> sqlQueries, Limit limit) {
//                Assert.assertEquals("DingHao", sqlQueries.get(0).getValue());
//                Assert.assertEquals(1, limit.getSize());
//                Assert.assertEquals(0, limit.getOffset());
//                Assert.assertEquals(1, limit.getPageIndex());
//                Assert.assertEquals(1, limit.getPageSize());
//
//                UserInfo       userInfo = new UserInfo();
//                List<UserInfo> list     = new ArrayList<>();
//                list.add(userInfo);
//
//                return list;
//            }
//        }.getMockInstance();
//        Deencapsulation.setField(UserServiceImpl, "userReadDao", userReadDao);
    }
}
