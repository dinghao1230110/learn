package org.hao.learn.test.person.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hao.learn.person.dao.LogDao;
import org.hao.learn.person.domain.LogInfo;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.service.LogServiceImpl;
import org.hao.learn.test.ServiceBaseTest;
import org.hao.learn.utils.SnowflakeUtil;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;

public class LogServiceTest extends ServiceBaseTest {
    @InjectMocks
    LogServiceImpl logService;
    @Mock
    LogDao         logDao;

    @Test
    public void testAddLog() throws JsonProcessingException {
        given(this.logDao.insertLog(isA(LogInfo.class)))
                .willReturn(1);

        UserInfo userInfo = new UserInfo();
        userInfo.setId(SnowflakeUtil.next());
        userInfo.setLoginName("DingHao");

        logService.addSuccessLog("key", userInfo, "remark");
    }
}
