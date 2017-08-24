package com.ls.dao;

import com.ls.entity.User;

/**
 * Created by LS on 2017/8/21 12:30.
 * To Be or Not to Be
 */
public interface IUserDao {
    boolean addUser(User user);            //����û�
    User findUserByName(User user);       //ͨ���û������Ҹ��û�
    User findUserByPhone(User user);     //ͨ���ֻ��Ų��Ҹ��û�
    boolean isUserNameExist(User user);  //ע���ʱ���жϸ��û��Ƿ����
    boolean isUserPhoneExist(User user); //ע���ʱ���жϸ��ֻ����Ƿ����
}
