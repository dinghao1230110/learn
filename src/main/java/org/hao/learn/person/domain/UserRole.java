package org.hao.learn.person.domain;


/**
 * Created by XizeTian on 2017-09-23 00:49:45.
 */
public class UserRole {
    private long userId;
    private long roleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}