package org.hao.learn.person.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hao.learn.api.LogService;
import org.hao.learn.exception.MyException;
import org.hao.learn.person.dao.LogDao;
import org.hao.learn.person.domain.LogInfo;
import org.hao.learn.utils.SnowflakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    public void addSuccessLog(String key, Object primaryParameter, String remark) throws JsonProcessingException {
        this.addLog(true, key, primaryParameter, remark);
    }

    @Override
    public void addFailureLog(String key, Object primaryParameter, String remark) throws JsonProcessingException {
        this.addLog(false, key, primaryParameter, remark);
    }

    private void addLog(boolean success, String key, Object primaryParameter, String remark) throws JsonProcessingException {
        String objectMapper = null;
        if (primaryParameter != null) {
            objectMapper = new ObjectMapper().writeValueAsString(primaryParameter);
        }

        LogInfo logInfo = new LogInfo();
        logInfo.setId(SnowflakeUtil.next());
        logInfo.setKey(key);
        logInfo.setSuccess(success);
        logInfo.setPrimaryParameter(objectMapper);
        logInfo.setRemark(remark);

        int result = logDao.insertLog(logInfo);

        if (result != 1) {
            throw new MyException("插入日志失败[" + logInfo.toString() + "]");
        }
    }
}
