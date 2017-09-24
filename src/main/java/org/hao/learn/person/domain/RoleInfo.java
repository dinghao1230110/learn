package org.hao.learn.person.domain;


import org.hao.learn.aggregate.DomainAggregate;

/**
 * Created by XizeTian on 2017-09-23 00:48:03.
 */
public class RoleInfo implements DomainAggregate {
    private long   id;
    private String name;
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}