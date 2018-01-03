package com.sqlBuilder.builder.selectBuilder.model;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sqlBuilder.model.ISqlNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/3.
 */
public class SelectJoin implements ISqlNode {


    private String tableName;
    private String aliasName;
    private String joinType;
    private SelectJoinOn on;


    private SelectJoinOn on() {
        this.on = new SelectJoinOn();
        return on;
    }


    public SelectJoin(String joinType, String tableName, String aliasName) {
        this.tableName = tableName;
        this.joinType = joinType;
        this.aliasName = aliasName;
    }

    @Override
    public String getSelfSql() {
        List<String> sqlList = Lists.newArrayList();
        sqlList.add(joinType);
        sqlList.add(tableName);
        if (aliasName != null) {
            sqlList.add("as");
            sqlList.add(aliasName);
        }
        sqlList.add(on.getSelfSql());
        return Joiner.on(' ').join(sqlList);
    }
}
