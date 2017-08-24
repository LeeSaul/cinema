package com.ls.dao.dbimpl;

import com.ls.dao.IAddressDao;
import com.ls.dao.ICinemaDao;
import com.ls.entity.Cinema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/23 9:16.
 * To Be or Not to Be
 */
public class CinemaDaoImpl extends BaseDao implements ICinemaDao{
    IAddressDao addressDao;

    public CinemaDaoImpl() {
        addressDao=new AddressDaoImpl();
    }

    @Override
    public boolean addCinema(Cinema cinema) {
        List parms = new ArrayList();
        String sql = "insert into cinema(address_id,cinema_name)" +
                " values(?,?)";
        parms.add(cinema.getAddressId());
        parms.add(cinema.getCinemaName());
        boolean isUpdate = update(sql, parms);
        return isUpdate;
    }

    //通过地址查找电影院名字
    @Override
    public Cinema searchCinemaNameByAddress(Cinema cinema) {
        List parms = new ArrayList();
        String sql = "select * from cinema where address_id=?";
        parms.add(cinema.getAddressId());
        List<Cinema> list = query(sql, parms, Cinema.class);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }


    //*************多余****
    public Cinema searchCinemaById(Cinema cinema) {
        List parms = new ArrayList();
        String sql = "select * from cinema where id=?";
        parms.add(cinema.getAddressId());
        List<Cinema> list = query(sql, parms, Cinema.class);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Cinema> searchCinemaByName(Cinema cinema) {
        List parms = new ArrayList();
        String sql = "select * from cinema where cinema_name=?";
        parms.add(cinema.getCinemaName());
        List<Cinema> list = query(sql, parms, Cinema.class);
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override
    public boolean updateCinemaById(Cinema cinema,int id) {
        List parms = new ArrayList();
        String sql = "update cinema set cinema_name=? where id=?";
        parms.add(cinema.getCinemaName());
        parms.add(id);
        boolean isUpdate = update(sql, parms);
        return isUpdate;
    }

    @Override
    public Cinema searchCinemaById(int id) {
        List parms = new ArrayList();
        String sql = "select * from cinema where id=?";
        parms.add(id);
        List<Cinema> list = query(sql, parms, Cinema.class);
        if (list!=null){
            return list.get(0);
        }
        return null;
    }
}
