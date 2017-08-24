package com.ls.biz.impl;

import com.ls.biz.IAllEntityBiz;
import com.ls.dao.IAllEntityDao;
import com.ls.dao.dbimpl.AllEntityDaoImpl;
import com.ls.entity.AllEntity;

import java.util.List;

/**
 * Created by LS on 2017/8/23 14:41.
 * To Be or Not to Be
 */
public class AllEntityBizImpl implements IAllEntityBiz{

    IAllEntityDao allEntityDao;

    public AllEntityBizImpl() {
        allEntityDao=new AllEntityDaoImpl();
    }

    @Override
    public boolean searchCinemaNameAndAddress() {
        List<AllEntity> all = allEntityDao.searchAllCinema();
        if (all!=null){
            for (AllEntity allEntity : all) {
                System.out.println(allEntity);
            }
            return true;
        }
        System.out.println("暂无电影院信息");
        return false;
    }
}
