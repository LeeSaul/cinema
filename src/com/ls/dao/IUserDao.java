package com.ls.dao;

import com.ls.entity.User;

/**
 * Created by LS on 2017/8/21 12:30.
 * To Be or Not to Be
 */
public interface IUserDao {
    boolean addUser(User user);            //添加用户
    User findUserByName(User user);       //通过用户名查找该用户
    User findUserByPhone(User user);     //通过手机号查找该用户
    boolean isUserNameExist(User user);  //注册的时候判断该用户是否存在
    boolean isUserPhoneExist(User user); //注册的时候判断该手机号是否存在
}
