package com.sqlBuilder.model;

/**
 * Created by lenovo on 2018/1/3.
 */
public class Condition implements ISqlNode {
    private String conditionValue;



    @Override
    public String getSelfSql() {
        return conditionValue;
    }

    @Override
    public String toString() {
        return getSelfSql();
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public Condition(String conditionValue) {
        this.conditionValue = conditionValue;
    }
}
