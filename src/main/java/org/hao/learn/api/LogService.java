package org.hao.learn.api;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LogService {
    void addSuccessLog(String key, Object primaryParameter, String remark) throws JsonProcessingException;

    void addFailureLog(String key, Object primaryParameter, String remark) throws JsonProcessingException;
}
