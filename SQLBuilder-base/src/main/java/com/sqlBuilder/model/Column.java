package com.sqlBuilder.model;

/**
 * Created by lenovo on 2018/1/3.
 */
public class Column implements ISqlNode {

    private String name;
    private String aliasName;

    public Column(String name) {
        this.name = name;
    }

    public Column(String name, String aliasName) {
        this.name = name;
        this.aliasName = aliasName;
    }


    @Override
    public String getSelfSql() {
        if (aliasName != null) {
            return name + " as " + aliasName;
        }
        return name;
    }

    @Override
    public String toString() {
        return getSelfSql();
    }
}
