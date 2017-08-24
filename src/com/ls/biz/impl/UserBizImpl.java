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
            System.out.println("ע��ɹ�");
        }
        return isUserRegister;
    }

    @Override
    public boolean userLoginByName() {
        User user=new User();
        String name=null;
        String password=null;
        System.out.println("�������û���");
        name=Input.getString();
        user.setUserName(name);
        System.out.println("����������");
        password=Input.getString();
        user.setUserPassword(password);
        System.out.println(user);
        User loginUser = userDaoImpl.findUserByName(user);
        if (loginUser!=null){
            System.out.println("��¼�ɹ�");
            return true;
        }
        return false;
    }

    @Override
    public boolean userLoginByPhone() {
        User user=new User();
        String phone=null;
        String password=null;
        System.out.println("�������ֻ���");
        phone=Input.getString();
        user.setUserPhone(phone);
        System.out.println("����������");
        password=Input.getString();
        user.setUserPassword(password);
        System.out.println(user);
        User loginUser = userDaoImpl.findUserByPhone(user);
        if (loginUser!=null){
            System.out.println("��¼�ɹ�");
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
                System.out.println("�������û���");
                name=Input.getString();
                if (name.trim().length()>=4){
                    break;
                }
                System.out.println("������û�������");
            }
            user.setUserName(name);
            boolean userNameExist = userDaoImpl.isUserNameExist(user);
            //userNameExist true ���ڸ��û� false �����ڸ��û�,����ע��
            if (!userNameExist){
                break;
            }
            System.out.println("�Ѵ��ڸ��û�");
        }
        while (true){
            System.out.println("����������");
            password=Input.getString();
            if (password.trim().length()>=4){
                break;
            }
            System.out.println("������������");
        }
        user.setUserPassword(password);
        while (true) {
            while (true){
                System.out.println("�������ֻ���");
                phone=Input.getString();
                if (phone.trim().length()==11){
                    break;
                }
                System.out.println("�ֻ���λ������");
            }
            user.setUserPhone(phone);
            boolean userPhoneExist = userDaoImpl.isUserPhoneExist(user);
            //userNameExist true �ֻ����Ѿ���ע�� false ���ֻ���δ��ע��
            if (!userPhoneExist){
                break;
            }
            System.out.println("�ֻ����ѱ�ע��");
        }
        return user;
    }
}
