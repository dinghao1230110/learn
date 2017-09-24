package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hao.learn.person.domain.RoleInfo;
import org.hao.learn.person.domain.UserRole;

import java.util.List;

@Mapper
public interface RoleDao {
    long queryUserRole(long id);

    List<UserRole> queryUserRoleByUserId(@Param("userId") long userId);

    List<RoleInfo> queryRoleById(@Param("ids") List<Long> ids);
}
