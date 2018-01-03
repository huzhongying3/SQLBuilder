package com.sqlBuilder.builder.selectBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sqlBuilder.model.Column;
import com.sqlBuilder.model.ISqlNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/1/3.
 */
class SelectColumnList extends ArrayList<Column> implements ISqlNode {
    private SelectFrom selectFrom;


    public SelectFrom from(String tableName) {
        return from(tableName, null);
    }

    public SelectFrom from(String tableName, String aliasName) {
        SelectFrom selectFrom = new SelectFrom(tableName, aliasName);
        this.selectFrom = selectFrom;
        return selectFrom;
    }


    @Override
    public String getSelfSql() {
        List<String> sqlList = Lists.newArrayList();
        String join = Joiner.on(',').join(this);
        sqlList.add(join);
        sqlList.add(selectFrom.getSelfSql());
        return Joiner.on(' ').join(sqlList);
    }
}
