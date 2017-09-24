package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;
import org.hao.learn.person.domain.RoleInfo;

import java.util.List;

public interface RoleDataBaseService<T extends DomainAggregate> {
    long queryUserRole(long user_id);

    List<RoleInfo> queryRoleByUserId(long userId);
}
