package org.hao.learn.person.service;

import org.hao.learn.api.RoleDataBaseService;
import org.hao.learn.person.dao.RoleDao;
import org.hao.learn.person.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleDataBaseService<UserInfo> {
    @Autowired
    RoleDao roleDao;

    @Override
    public long queryUserRole(long user_id) {
        long roleId = roleDao.queryUserRole(user_id);
        return roleId;
    }
}
