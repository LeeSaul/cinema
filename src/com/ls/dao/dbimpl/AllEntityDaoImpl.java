package com.ls.dao.dbimpl;

import com.ls.dao.IAllEntityDao;
import com.ls.entity.AllEntity;

import java.util.List;

/**
 * Created by LS on 2017/8/23 15:05.
 * To Be or Not to Be
 */
public class AllEntityDaoImpl extends BaseDao implements IAllEntityDao{

    //查找所有的电影信息  影院表和地址表
    @Override
    public List<AllEntity> searchAllCinema() {
        String sql = " select cinema.cinema_name,address.* from address,cinema  where address.id=cinema.address_id";
        List<AllEntity> list = query(sql, null, AllEntity.class);
        if (list != null) {
            return list;
        }
        return null;
    }
}
