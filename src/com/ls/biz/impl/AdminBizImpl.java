package com.ls.biz.impl;

import com.ls.biz.IAdminBiz;
import com.ls.dao.IAdminDao;
import com.ls.dao.dbimpl.AdminDaoImpl;
import com.ls.entity.Admin;
import com.ls.utils.Input;

/**
 * Created by LS on 2017/8/21 16:51.
 * To Be or Not to Be
 */
public class AdminBizImpl implements IAdminBiz{
    Admin admin=null;
    IAdminDao adminDao=null;
    public AdminBizImpl() {
        admin=new Admin();
        adminDao=new AdminDaoImpl();
    }

    @Override
    public boolean adminLogin() {
        Admin admin=new Admin();
        System.out.println("请输入管理员账号");
        admin.setAdminName(Input.getString());
        System.out.println("请输入管理员密码");
        admin.setAdminPassword(Input.getString());
        Admin loginAdmin = adminDao.findAdminByName(admin);
        if (loginAdmin!=null){
            System.out.println("登录成功");
            return true;
        }
        return false;
    }
}
