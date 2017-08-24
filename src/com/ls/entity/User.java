package com.ls.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 9:57.
 * To Be or Not to Be
 */
public class User implements Serializable{
    private int id;
    private String userName;       //用户名
    private String userPassword;   //用户密码
    private String userPhone;      //用户手机号
    private int userScore;         //积分
    private Timestamp userCreateDate;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public Timestamp getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Timestamp userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userScore=" + userScore +
                ", userCreateDate=" + userCreateDate +
                '}';
    }
}
