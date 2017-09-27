package org.hao.learn.person.domain;

public class LogInfo {
    private long    id;
    private String  key;
    private boolean success;
    private String  primaryParameter;
    private String  remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getPrimaryParameter() {
        return primaryParameter;
    }

    public void setPrimaryParameter(String primaryParameter) {
        this.primaryParameter = primaryParameter;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", primaryParameter='" + primaryParameter + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
