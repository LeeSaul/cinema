package com.ls.dao.dbimpl;

import com.ls.dao.IUserDao;
import com.ls.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/21 12:31.
 * To Be or Not to Be
 */
public class UserDaoImpl extends BaseDao implements IUserDao{
    @Override
    public boolean addUser(User user) {
        List parms=new ArrayList();
        String sql="insert into user(user_name,user_password,user_phone)" +
                " values(?,?,?)";
        parms.add(user.getUserName());
        parms.add(user.getUserPassword());
        parms.add(user.getUserPhone());
        boolean isAdd = update(sql, parms);//增加用户是否成功
        return isAdd;
    }

    @Override
    public User findUserByName(User user) {
        List parms=new ArrayList();
        String sql="select * from user where user_name=? AND user_password=?";
        parms.add(user.getUserName());
        parms.add(user.getUserPassword());
        List<User> list = query(sql, parms,User.class);
        if (list!=null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findUserByPhone(User user) {
        List parms=new ArrayList();
        String sql="select * from user where user_phone=? AND user_password=?";
        parms.add(user.getUserPhone());
        parms.add(user.getUserPassword());
        List<User> list = query(sql, parms,User.class);
        if (list!=null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean isUserNameExist(User user) {
        List parms=new ArrayList();
        String sql="select * from user where user_name=?";
        parms.add(user.getUserName());
        List<User> list = query(sql, parms,User.class);
        //true 存在该用户名
        if (list!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserPhoneExist(User user) {
        List parms=new ArrayList();
        String sql="select * from user where user_phone=?";
        parms.add(user.getUserPhone());
        List<User> list = query(sql, parms,User.class);
        //true 存在该手机号
        if (list!=null){
            return true;
        }
        return false;
    }
}
