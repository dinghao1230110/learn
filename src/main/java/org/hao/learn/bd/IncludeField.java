package org.hao.learn.bd;

public class IncludeField {
    protected String fieldName;
    protected String sqlName;
    protected Object value;
    protected boolean isInclude = false;

    public IncludeField() {
    }

    public IncludeField(String fieldName, String sqlName, boolean isInclude) {
        this.fieldName = fieldName;
        this.sqlName = sqlName;
        this.isInclude = isInclude;
    }

    public boolean isInclude() {
        return isInclude;
    }

    public IncludeField setInclude(boolean include) {
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

    public IncludeField setValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return fieldName;
    }
}
