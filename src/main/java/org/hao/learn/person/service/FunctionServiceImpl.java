package org.hao.learn.person.service;

import org.hao.learn.api.FunctionDataBaseService;
import org.hao.learn.person.dao.FunctionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FunctionServiceImpl implements FunctionDataBaseService {
    List<Long>        functionIdList     = new ArrayList<>();
    Map<Long, String> getFunctionNameMap = new HashMap<>();
    @Autowired
    FunctionDao functionDao;

    @Override
    public List<Long> queryFunction(long role_id) {
        List<Long> functionIds = functionDao.queryFunction(role_id);
        for (Long functionId : functionIds) {
            functionIdList.add(functionId);
        }
        return functionIds;
    }

    @Override
    public String queryFunctionName(long functionId) {
        String functionName = functionDao.queryFunctionName(functionId);
        return functionName;
    }
}
