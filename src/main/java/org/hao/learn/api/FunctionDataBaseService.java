package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;
import org.hao.learn.person.domain.FunctionInfo;
import org.hao.learn.person.domain.RoleInfo;

import java.util.List;
import java.util.Map;

public interface FunctionDataBaseService<T extends DomainAggregate> {
    List<Long> queryFunction(long role_id);

    String queryFunctionName(long functionId);

    Map<Long, FunctionInfo> queryFunctionByRole(List<RoleInfo> roleId);

    FunctionInfo queryFunctionById(long functionId);

    void refreshFunction();
}
