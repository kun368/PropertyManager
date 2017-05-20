package com.sdust.dao;

import com.sdust.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public class AdminUserRowMapper implements RowMapper<AdminUser> {
        @Override
        public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AdminUser adminUser = new AdminUser();
            adminUser.setAdminId(rs.getInt("adminId"));
            adminUser.setAdminName(rs.getString("adminName"));
            adminUser.setAdminPassword(rs.getString("adminPassword"));
            adminUser.setEmail(rs.getString("email"));
            return adminUser;
        }
    }
}
