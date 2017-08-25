package com.ls.biz.impl;

import com.ls.biz.IAddressBiz;
import com.ls.dao.IAddressDao;
import com.ls.dao.ICinemaDao;
import com.ls.dao.dbimpl.AddressDaoImpl;
import com.ls.dao.dbimpl.CinemaDaoImpl;
import com.ls.entity.Address;
import com.ls.utils.Input;

import java.util.List;

/**
 * Created by LS on 2017/8/23 12:17.
 * To Be or Not to Be
 */
public class AddressBizImpl implements IAddressBiz{
    IAddressDao addressDao;
    ICinemaDao cinemaDao;

    public AddressBizImpl() {
        addressDao=new AddressDaoImpl();
        cinemaDao=new CinemaDaoImpl();
    }

    @Override
    public Address addAddressInfo() {
        Address address=input();
        Address addAddre1 = addressDao.addAddress(address);
        return addAddre1;
    }

    @Override
    public List<Address> searchCinemaByAddress() {
        Address address=new Address();
        System.out.println("请输入省");
        address.setAddressProvince(Input.getString());
        System.out.println("请输入市");
        address.setAddressCity(Input.getString());
        System.out.println("请输入县");
        address.setAddressCounty(Input.getString());
        List<Address> addresses = addressDao.searchAddress(address);
        if (addresses!=null) {
            return addresses;
        }
        return null;
    }

    @Override
    public boolean searchCinemaById(int id) {
        Address address=new Address();
        address.setId(id);
        List<Address> addresses = addressDao.searchAddressbyId(address);
        if (addresses!=null){
            System.out.println(addresses.get(0));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCinemaAddressById(int id) {
        Address address = input();
        boolean isUpdate = addressDao.updateAddress(address,id);
        return isUpdate;
    }

    public static Address input(){
        Address address=new Address();
        String province;
        String city;
        String county;
        String road;
        System.out.println("请输入省");
        province= Input.getString();
        address.setAddressProvince(province);
        System.out.println("请输入市");
        city=Input.getString();
        address.setAddressCity(city);
        System.out.println("请输入县");
        county=Input.getString();
        address.setAddressCounty(county);
        System.out.println("请输入街道");
        road=Input.getString();
        address.setAddressRoad(road);
        return address;
    }

}
