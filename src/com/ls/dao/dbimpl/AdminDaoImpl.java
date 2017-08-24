package com.ls.dao.dbimpl;

import com.ls.dao.IAdminDao;
import com.ls.entity.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/21 12:31.
 * To Be or Not to Be
 */
public class AdminDaoImpl extends BaseDao implements IAdminDao {
    @Override
    public Admin findAdminByName(Admin admin) {
        List parms = new ArrayList();
        String sql = "select * from admin where admin_name=? AND admin_password=?";
        parms.add(admin.getAdminName());
        parms.add(admin.getAdminPassword());
        List<Admin> list = query(sql, parms, Admin.class);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }
}
