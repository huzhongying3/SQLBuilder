package com.sqlBuilder.builder.selectBuilder.model;

import com.sqlBuilder.model.Condition;
import com.sqlBuilder.model.ISqlNode;
import java.util.ArrayList;

/**
 * Created by lenovo on 2018/1/3.
 */
public class SelectConditionList extends ArrayList<Condition> implements ISqlNode {
    @Override
    public String getSelfSql() {
        return null;
    }
}
