package com.ls.dao;

import com.ls.entity.Admin;
import com.ls.entity.Movie;

import java.util.List;

/**
 * Created by LS on 2017/8/21 12:30.
 * To Be or Not to Be
 */
public interface IAdminDao {
    //查找管理员账户
    Admin findAdminByName(Admin admin);
}
