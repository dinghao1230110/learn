package org.hao.learn.person.domain;


import org.hao.learn.aggregate.DomainAggregate;

/**
 * Created by XizeTian on 2017-09-23 00:48:48.
 */
public class FunctionInfo implements DomainAggregate {
    private long    id;
    private String  name;
    private boolean isMenu;
    private long    parentId;
    private String  remark;

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

    public boolean getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(boolean isMenu) {
        this.isMenu = isMenu;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}