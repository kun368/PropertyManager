package com.sdust.model;

/**
 * Created by Administrator on 2017/5/20.
 */
public class AdminUser {
    private int adminId;
    private String adminName;
    private  String adminPassword;
    private  String email;

    public int getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}