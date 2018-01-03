package com.sqlBuilder.builder.selectBuilder.model;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sqlBuilder.model.ISqlNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/3.
 */
class SelectFrom implements ISqlNode {
    private String aliasName;
    private String tableName;
    private SelectWhere where;
    private SelectJoin join;


    public SelectWhere where() {
        this.where = new SelectWhere();
        return where;
    }

    public SelectJoin leftJoin(String tableName) {
        return leftJoin(tableName, null);
    }


    public SelectJoin rightJoin(String tableName) {
        return rightJoin(tableName, null);

    }

    public SelectJoin innerJoin(String tableName) {
        return innerJoin(tableName, null);

    }

    public SelectJoin leftJoin(String tableName, String aliasName) {
        this.join = new SelectJoin("left join", tableName, aliasName);
        return join;
    }

    public SelectJoin rightJoin(String tableName, String aliasName) {
        this.join = new SelectJoin("right join", tableName, aliasName);
        return join;
    }

    public SelectJoin innerJoin(String tableName, String aliasName) {
        this.join = new SelectJoin("inner join", tableName, aliasName);
        return join;
    }



    SelectFrom(String tableName, String aliasName) {
        this.tableName = tableName;
        this.aliasName = aliasName;
    }


    @Override
    public String getSelfSql() {
        List<String> sqlList = Lists.newArrayList();
        sqlList.add("from");

        sqlList.add(tableName);
        if (aliasName != null) {
            sqlList.add("as");
            sqlList.add(aliasName);

        }
        if (where != null) {
            sqlList.add(where.getSelfSql());
        } else if (join != null) {
            sqlList.add(join.getSelfSql());
        }

        return Joiner.on(' ').join(sqlList);
    }
}
