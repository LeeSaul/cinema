package com.ls.dao;

import com.ls.entity.Address;

import java.util.List;

/**
 * Created by LS on 2017/8/23 11:00.
 * To Be or Not to Be
 */
public interface IAddressDao {
    //增加影院地址
    Address addAddress(Address address);

    //通过某一个地址查看附近所有的影院
    List<Address> searchAddress(Address address);

    List<Address> searchAddressbyId(Address address);
    //更新影院信息
    boolean updateAddress(Address address,int id);

    //查看该影院是否已经存在
    boolean isAddressExist(Address address);

    //查看所有影院信息
    List<Address> searchAllCinema();
}
