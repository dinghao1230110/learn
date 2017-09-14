package org.hao.learn.sql;

import java.util.List;

public class SqlQuery {
    protected String sqlName;
    protected SqlOperator operator = SqlOperator.EQ;
    protected Object value;
    protected List<Object> multiValue;

    public SqlQuery(String sqlName, Object value) {
        this.sqlName = sqlName;
        this.value = value;
    }

    public SqlQuery(String sqlName, SqlOperator operator, Object value) {
        this.sqlName = sqlName;
        this.operator = operator;
        this.value = value;
    }

    public SqlQuery(String sqlName, SqlOperator operator, List<Object> multiValue) {
        this.sqlName = sqlName;
        this.operator = operator;
        this.multiValue = multiValue;
    }

    public String getSqlName() {
        return sqlName;
    }

    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }

    public SqlOperator getOperator() {
        return operator;
    }

    public void setOperator(SqlOperator operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<Object> getMultiValue() {
        return multiValue;
    }

    public void setMultiValue(List<Object> multiValue) {
        this.multiValue = multiValue;
    }
}
