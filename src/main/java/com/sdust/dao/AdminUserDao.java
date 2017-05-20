package com.sdust.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangzhengkun on 2017/5/20.
 */
@Repository
public class AdminUserDao {

    @Autowired
    private JdbcTemplate jdbc;

    public void test() {
        System.out.println("=========");
        SqlRowSet rowSet = jdbc.queryForRowSet("SELECT 1");
        System.out.println("=========");
    }
}
