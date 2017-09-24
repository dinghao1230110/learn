package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;

import java.util.List;
import java.util.Map;

public interface FunctionDataBaseService<T extends DomainAggregate> {
    List<Long> queryFunction(long role_id);

   String queryFunctionName(long functionId);
}
