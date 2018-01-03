package com.sqlBuilder.builder.selectBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sqlBuilder.model.ISqlNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/3.
 */
public class Condition implements ISqlNode {
    private String conditionValue;
    private String nextLogic;
    private Condition nextCondition;
    public static String AND_LOGIC = "and";
    public static String or_LOGIC = "or";


    public Condition nextCondition(String logic, Condition condition) {
        if (this.equals(condition)) {
            return null;
        }
        this.nextLogic = logic;
        this.nextCondition = condition;
        return nextCondition;
    }

    @Override
    public String getSelfSql() {
        List<String> sqlList = Lists.newArrayList();

        sqlList.add(conditionValue);
        if (nextLogic != null) {
            sqlList.add(nextLogic);
            if (nextCondition != null) {
                sqlList.add(nextCondition.getSelfSql());

            }
        }

        return Joiner.on(' ').join(sqlList);
    }

    @Override
    public String toString() {
        return getSelfSql();
    }



    public Condition(String conditionValue) {
        this.conditionValue = conditionValue;
    }
}
