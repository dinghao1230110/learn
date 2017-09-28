package org.hao.learn.sql;

import java.util.ArrayList;
import java.util.List;

public class SqlQuery {
    private String sqlName;
    private SqlOperator operator = SqlOperator.EQ;
    private Object value;
    private List<Object> multiValue = new ArrayList<>();

    public SqlQuery(String sqlName) {
        this.sqlName = sqlName;
    }

    @Deprecated
    public SqlQuery(String sqlName, Object value) {
        this.sqlName = sqlName;
        this.value = value;
    }

    @Deprecated
    public SqlQuery(String sqlName, SqlOperator operator, Object value) {
        this.sqlName = sqlName;
        this.operator = operator;
        this.value = value;
    }

    @Deprecated
    public SqlQuery(String sqlName, SqlOperator operator, List<Object> multiValue) {
        this.sqlName = sqlName;
        this.operator = operator;
        this.multiValue = multiValue;
    }

    public String getSqlName() {
        return sqlName;
    }

    public SqlQuery setOperator(SqlOperator operator) {
        this.operator = operator;
        return this;
    }

    public SqlOperator getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }

    public SqlQuery setValue(Object value) {
        this.value = value;
        return this;
    }

    public List<Object> getMultiValue() {
        return multiValue;
    }

    public SqlQuery setMultiValue(List<Object> multiValue) {
        this.multiValue = multiValue;
        return this;
    }

    public void reset() {
        this.operator = SqlOperator.EQ;
        this.value = null;
        this.multiValue = new ArrayList<>();
    }
}
