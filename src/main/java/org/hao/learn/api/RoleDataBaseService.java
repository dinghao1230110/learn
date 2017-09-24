package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;

public interface RoleDataBaseService<T extends DomainAggregate> {
    long queryUserRole(long user_id);
}
