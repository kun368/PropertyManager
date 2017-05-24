package com.sdust.dao;

import com.sdust.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangzhengkun on 2017/5/20.
 */
@Repository
public class AdminUserDao {

    @Autowired
    private JdbcTemplate jdbc;

    public AdminUser findUser(String username,String password) {
        List<AdminUser> query = jdbc.query("SELECT * FROM adminUser WHERE adminName = ? AND adminPassword = ?",
                new AdminUserRowMapper(), username,password);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<AdminUser> allUser()
    {
        List<AdminUser> query=jdbc.query("SELECT * FROM  adminUser",new AdminUserRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addUser(String username, String password, String email) {
        jdbc.update("INSERT INTO adminuser(adminName, adminPassword, email) VALUE (?, ?, ?)",
                username, password, email);
    }

    public void modifyPassword(String username, String newPassword) {
        jdbc.update("UPDATE adminuser SET adminPassword = ? WHERE adminName = ?",
                newPassword, username);
    }

    public void modifyEmail(String username, String newEmail) {
        jdbc.update("UPDATE adminuser SET email = ? WHERE adminName = ?",
                newEmail, username);
    }

    public class AdminUserRowMapper implements RowMapper<AdminUser> {
        @Override
        public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AdminUser adminUser = new AdminUser();
            adminUser.setAdminId(rs.getInt("adminId"));
            adminUser.setAdminName(rs.getString("adminName"));
            adminUser.setAdminPassword(rs.getString("adminPassword"));
            adminUser.setEmail(rs.getString("email"));
            adminUser.setUserType(rs.getInt("userType"));
            return adminUser;
        }
    }
}
