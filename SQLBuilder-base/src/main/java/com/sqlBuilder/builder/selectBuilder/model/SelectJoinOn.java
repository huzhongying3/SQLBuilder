package com.sqlBuilder.builder.selectBuilder.model;

import com.sqlBuilder.model.ISqlNode;

/**
 * Created by lenovo on 2018/1/3.
 */
public class SelectJoinOn implements ISqlNode {

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


    @Override
    public String getSelfSql() {
        return null;
    }
}