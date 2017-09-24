package org.hao.learn.person.service;

import org.hao.learn.api.FunctionDataBaseService;
import org.hao.learn.person.dao.FunctionDao;
import org.hao.learn.person.domain.FunctionInfo;
import org.hao.learn.person.domain.RoleFunction;
import org.hao.learn.person.domain.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FunctionServiceImpl implements FunctionDataBaseService<FunctionInfo> {
    private static final Map<Long, FunctionInfo> FUNCTION_INFO_MAP = new HashMap<>();

    @Autowired
    FunctionDao functionDao;

    @Override
    public List<Long> queryFunction(long role_id) {
        List<Long> functionIds = functionDao.queryFunction(role_id);
        return functionIds;
    }

    /**
     * ignore
     *
     * @param functionId
     * @return
     */
    @Override
    public String queryFunctionName(long functionId) {
        String functionName = functionDao.queryFunctionName(functionId);
        return functionName;
    }

    /**
     * 根据角色获取functions
     *
     * @param roles
     * @return
     */
    @Override
    public Map<Long, FunctionInfo> queryFunctionByRole(List<RoleInfo> roles) {
        Map<Long, FunctionInfo> functions = new HashMap<>();

        if (roles.size() > 0) {
            List<RoleFunction> lst = functionDao.queryFunctionByRole(roles);
            for (RoleFunction roleFunction : lst) {
                FunctionInfo functionInfo = this.queryFunctionById(roleFunction.getFunctionId());
                if (functionInfo != null) {
                    functions.put(functionInfo.getId(), functionInfo);
                }
            }
        }

        return functions;
    }

    /**
     * 根据ID获取缓存中的function
     *
     * @param functionId
     * @return
     */
    @Override
    public FunctionInfo queryFunctionById(long functionId) {
        FunctionInfo functionInfo = null;
        if (FUNCTION_INFO_MAP.containsKey(functionId)) {
            functionInfo = FUNCTION_INFO_MAP.get(functionId);
        }
        return functionInfo;
    }

    /**
     * 刷新 Function 缓存
     */
    public void refreshFunction() {
        FUNCTION_INFO_MAP.clear();
        List<FunctionInfo> functions = functionDao.queryAllFunction();
        for (FunctionInfo function : functions) {
            FUNCTION_INFO_MAP.put(function.getId(), function);
        }
    }
}
