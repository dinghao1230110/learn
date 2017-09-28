package org.hao.learn.sql;

public class SqlUpdate {
    private String fieldName;
    private String sqlName;
    private Object value;
    private boolean isInclude = false;

    public SqlUpdate(String fieldName, String sqlName) {
        this.fieldName = fieldName;
        this.sqlName = sqlName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getSqlName() {
        return sqlName;
    }

    public Object getValue() {
        return value;
    }

    public SqlUpdate setValue(Object value) {
        this.value = value;
        return this;
    }

    public boolean isInclude() {
        return isInclude;
    }

    public SqlUpdate setInclude(boolean include) {
        isInclude = include;
        return this;
    }

    public void reset() {
        this.value = null;
        this.isInclude = false;
    }
}
