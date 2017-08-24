package com.ls.dao.dbimpl;

import com.ls.dao.IAddressDao;
import com.ls.entity.Address;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/23 11:00.
 * To Be or Not to Be
 */
public class AddressDaoImpl extends BaseDao implements IAddressDao{
    @Override
    public Address addAddress(Address address) {
        List parms = new ArrayList();
        String sql = "insert into address(address_province,address_city,address_county,address_road)" +
                " values(?,?,?,?)";
        String sql2="select * from address where address_province=? AND address_city=? AND address_county=? AND address_road=?";
        parms.add(address.getAddressProvince());
        parms.add(address.getAddressCity());
        parms.add(address.getAddressCounty());
        parms.add(address.getAddressRoad());
        boolean isAdd = update(sql, parms);//增加影院是否成功
        if (isAdd){
            List<Address> list = query(sql2, parms, Address.class);
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean isAddressExist(Address address) {
        return false;
    }

    @Override
    public boolean updateAddress(Address address,int id) {
        List parms = new ArrayList();
        String sql = "update address set address_province=?,address_city=?,address_county=?,address_road=? where address.id=?";
        parms.add(address.getAddressProvince());
        parms.add(address.getAddressCity());
        parms.add(address.getAddressCounty());
        parms.add(address.getAddressRoad());
        parms.add(id);
        boolean isAdd = update(sql, parms);//增加影院是否成功
        return isAdd;
    }



    //查找一个区域的影院
    @Override
    public List<Address> searchAddress(Address address) {
        List parms = new ArrayList();
        //注意like后面的''使用
//        String sql = "select * from address where address_province like '%'?'%' AND address_city like '%'?'%' AND address_county like '%'?'%' AND address_road like '%'?'%' ";
        String sql = "select * from address where address_province=? AND address_city=? AND address_county=?";
        parms.add(address.getAddressProvince());
        parms.add(address.getAddressCity());
        parms.add(address.getAddressCounty());
//        parms.add(address.getAddressRoad());
        List<Address> list = query(sql, parms, Address.class);
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override
    public List<Address> searchAddressbyId(Address address) {
        List parms = new ArrayList();
        String sql="select * from address where id=?";
        parms.add(address.getId());
        List<Address> list = query(sql, parms, Address.class);
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override
    public List<Address> searchAllCinema() {
        return null;
    }
}
