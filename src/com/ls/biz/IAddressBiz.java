package com.ls.biz;

import com.ls.entity.Address;
import com.ls.entity.Cinema;

import java.util.List;

/**
 * Created by LS on 2017/8/23 12:16.
 * To Be or Not to Be
 */
public interface IAddressBiz {
    Address addAddressInfo();
    boolean searchCinemaNameByAdress();
    boolean searchCinemaById(int id);
    boolean updateCinemaAddressById(int id);
}
