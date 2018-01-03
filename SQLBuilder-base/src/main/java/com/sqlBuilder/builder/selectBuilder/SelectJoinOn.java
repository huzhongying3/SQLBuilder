package com.sqlBuilder.builder.selectBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sqlBuilder.model.ISqlNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/3.
 */
public class SelectJoinOn implements ISqlNode {

    private SelectWhere where;
    private SelectJoin join;


    private Condition currentCondition;

    public SelectJoinOn(Condition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public SelectJoinOn() {
    }

    public SelectWhere where(Condition condition) {
        this.where = new SelectWhere(condition);
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
        List<String> sqlList = Lists.newArrayList();
        sqlList.add("on");
        if (currentCondition != null) {
            sqlList.add(currentCondition.getSelfSql());

        }
        if (where != null) {
            sqlList.add(where.getSelfSql());
        } else if (join != null) {
            sqlList.add(join.getSelfSql());
        }
        return Joiner.on(' ').join(sqlList);
    }
}
