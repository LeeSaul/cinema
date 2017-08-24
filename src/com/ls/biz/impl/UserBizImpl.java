package com.ls.biz.impl;

import com.ls.biz.IUserBiz;
import com.ls.dao.IUserDao;
import com.ls.dao.dbimpl.UserDaoImpl;
import com.ls.entity.User;
import com.ls.utils.Input;

/**
 * Created by LS on 2017/8/21 14:08.
 * To Be or Not to Be
 */
public class UserBizImpl implements IUserBiz{
    IUserDao userDaoImpl=null;
    User user;
    public UserBizImpl() {
        userDaoImpl=new UserDaoImpl();
    }

    @Override
    public boolean userRegister() {
        User user = input();
        boolean isUserRegister = userDaoImpl.addUser(user);
        if (isUserRegister){
            System.out.println("注册成功");
        }
        return isUserRegister;
    }

    @Override
    public boolean userLoginByName() {
        User user=new User();
        String name=null;
        String password=null;
        System.out.println("请输入用户名");
        name=Input.getString();
        user.setUserName(name);
        System.out.println("请输入密码");
        password=Input.getString();
        user.setUserPassword(password);
        System.out.println(user);
        User loginUser = userDaoImpl.findUserByName(user);
        if (loginUser!=null){
            System.out.println("登录成功");
            return true;
        }
        return false;
    }

    @Override
    public boolean userLoginByPhone() {
        User user=new User();
        String phone=null;
        String password=null;
        System.out.println("请输入手机号");
        phone=Input.getString();
        user.setUserPhone(phone);
        System.out.println("请输入密码");
        password=Input.getString();
        user.setUserPassword(password);
        System.out.println(user);
        User loginUser = userDaoImpl.findUserByPhone(user);
        if (loginUser!=null){
            System.out.println("登录成功");
            return true;
        }
        return false;
    }

    public User input(){
        User user=new User();
        String name=null;
        String password=null;
        String phone=null;
        while (true) {
            while (true){
                System.out.println("请输入用户名");
                name=Input.getString();
                if (name.trim().length()>=4){
                    break;
                }
                System.out.println("输入的用户名过短");
            }
            user.setUserName(name);
            boolean userNameExist = userDaoImpl.isUserNameExist(user);
            //userNameExist true 存在该用户 false 不存在该用户,可以注册
            if (!userNameExist){
                break;
            }
            System.out.println("已存在该用户");
        }
        while (true){
            System.out.println("请输入密码");
            password=Input.getString();
            if (password.trim().length()>=4){
                break;
            }
            System.out.println("输入的密码过短");
        }
        user.setUserPassword(password);
        while (true) {
            while (true){
                System.out.println("请输入手机号");
                phone=Input.getString();
                if (phone.trim().length()==11){
                    break;
                }
                System.out.println("手机号位数不对");
            }
            user.setUserPhone(phone);
            boolean userPhoneExist = userDaoImpl.isUserPhoneExist(user);
            //userNameExist true 手机号已经被注册 false 该手机号未被注册
            if (!userPhoneExist){
                break;
            }
            System.out.println("手机号已被注册");
        }
        return user;
    }
}
