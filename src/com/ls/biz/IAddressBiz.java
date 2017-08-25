package com.ls.biz;

import com.ls.entity.Address;
import com.ls.entity.Cinema;

import java.util.List;

/**
 * Created by LS on 2017/8/23 12:16.
 * To Be or Not to Be
 */
public interface IAddressBiz {
    //添加地址
    Address addAddressInfo();

    //通过地址查找区域该所有的影院
    List<Address> searchCinemaByAddress();

    boolean searchCinemaById(int id);

    boolean updateCinemaAddressById(int id);
}
