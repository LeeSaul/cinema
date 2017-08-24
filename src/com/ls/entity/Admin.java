package com.ls.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 9:57.
 * To Be or Not to Be
 */
public class Admin implements Serializable{
    private int id;
    private String adminName;
    private String adminPassword;
    private String  adminStatus="true";  //管理员状态 true正常  false不可登录
    private Timestamp adminLoginDate;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public Timestamp getAdminLoginDate() {
        return adminLoginDate;
    }

    public void setAdminLoginDate(Timestamp adminLoginDate) {
        this.adminLoginDate = adminLoginDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminStatus=" + adminStatus +
                ", adminLoginDate=" + adminLoginDate +
                '}';
    }
}
