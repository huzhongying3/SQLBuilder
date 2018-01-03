package com.sqlBuilder.builder.selectBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sqlBuilder.model.ISqlNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/3.
 */
public class SelectWhere implements ISqlNode {

    private Condition currentCondition;

    public SelectWhere(Condition currentCondition) {
        this.currentCondition = currentCondition;
    }

    @Override
    public String getSelfSql() {
        List<String> sqlList = Lists.newArrayList();
        sqlList.add("where");
        sqlList.add(currentCondition.getSelfSql());
        return Joiner.on(' ').join(sqlList);
    }
}
