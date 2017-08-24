package com.ls.biz.impl;

import com.ls.biz.IAddressBiz;
import com.ls.biz.ICinemaBiz;
import com.ls.dao.ICinemaDao;
import com.ls.dao.dbimpl.CinemaDaoImpl;
import com.ls.entity.Address;
import com.ls.entity.Cinema;
import com.ls.utils.Input;

import java.util.List;

/**
 * Created by LS on 2017/8/23 11:28.
 * To Be or Not to Be
 */
public class CinemaBizImpl implements ICinemaBiz{
    ICinemaDao cinemaDao;
    IAddressBiz addressBiz;

    public CinemaBizImpl() {
        cinemaDao=new CinemaDaoImpl();
        addressBiz=new AddressBizImpl();
    }

    @Override
    public boolean addCinemaInfo() {
        Cinema cinema=new Cinema();
        Address address;
        boolean isCinemaAdd=false;  //是否添加成功
        System.out.println("请输入影院名");
        cinema.setCinemaName(Input.getString());
        address=addressBiz.addAddressInfo();
        if (address!=null){
            cinema.setAddressId(address.getId());
            isCinemaAdd=cinemaDao.addCinema(cinema);
            System.out.println(address);
        }
        return isCinemaAdd;
    }

    @Override
    public boolean searchCinemaInfoByName() {
        Cinema cinema=new Cinema();
        System.out.println("请输入要查找的影院名");
        String name=Input.getString();
        cinema.setCinemaName(name);
        List<Cinema> cinemas = cinemaDao.searchCinemaByName(cinema);
        if (cinemas!=null) {
            for (Cinema cinema1 : cinemas) {
//                System.out.println(cinema1);
                addressBiz.searchCinemaById(cinema1.getAddressId());
            }
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateCinemaInfoById() {
        Cinema cinema=new Cinema();
        System.out.println("请输入影院id");
        int id=Input.getInteger();
        System.out.println("请输入修改后的影院名");
        cinema.setCinemaName(Input.getString());
        boolean b = cinemaDao.updateCinemaById(cinema, id);
        if (b){
            int address_id=cinemaDao.searchCinemaById(id).getAddressId();
            boolean isUpdate = addressBiz.updateCinemaAddressById(address_id);
            return isUpdate;
        }
        return false;
    }
}
