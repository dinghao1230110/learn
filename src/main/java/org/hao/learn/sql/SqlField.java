package org.hao.learn.sql;

public class SqlField {
    protected String fieldName;
    protected String sqlName;
    protected Object value;
    protected boolean isInclude = false;

    public SqlField() {
    }

    public SqlField(String fieldName, String sqlName, boolean isInclude) {
        this.fieldName = fieldName;
        this.sqlName = sqlName;
        this.isInclude = isInclude;
    }

    public boolean isInclude() {
        return isInclude;
    }

    public SqlField setInclude(boolean include) {
        isInclude = include;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSqlName() {
        return sqlName;
    }

    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }

    public Object getValue() {
        return value;
    }

    public SqlField setValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return fieldName;
    }
}
