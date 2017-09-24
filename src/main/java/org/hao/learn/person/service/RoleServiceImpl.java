package org.hao.learn.person.service;

import org.hao.learn.api.RoleDataBaseService;
import org.hao.learn.person.dao.RoleDao;
import org.hao.learn.person.domain.RoleInfo;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleDataBaseService<RoleInfo> {
    @Autowired
    RoleDao roleDao;

    @Override
    public long queryUserRole(long user_id) {
        long roleId = roleDao.queryUserRole(user_id);
        return roleId;
    }

    public List<RoleInfo> queryRoleByUserId(long userId) {
        List<UserRole> userRoles = roleDao.queryUserRoleByUserId(userId);
        List<Long>     ids       = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            ids.add(userRole.getRoleId());
        }

        List<RoleInfo> roles;
        if (ids.size() > 0) {
            roles = roleDao.queryRoleById(ids);
        } else {
            roles = new ArrayList<>();
        }
        return roles;
    }
}
